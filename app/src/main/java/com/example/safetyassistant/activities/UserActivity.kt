package com.example.safetyassistant.activities

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.safetyassistant.R
import com.example.safetyassistant.databinding.ActivityUserBinding
import com.example.safetyassistant.databinding.DialogEditUserBinding
import com.example.safetyassistant.databinding.ItemEmergencyContactBinding
import com.example.safetyassistant.models.EmergencyContact
import com.example.safetyassistant.utils.DataManager

class UserActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUserBinding
    private lateinit var contactAdapter: EmergencyContactAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
        loadUserData()
    }

    private fun initView() {
        binding.toolbar.setNavigationOnClickListener {
            finish()
        }

        binding.btnEditUser.setOnClickListener {
            showEditUserDialog()
        }

        binding.btnAddContact.setOnClickListener {
            showAddContactDialog()
        }

        // 紧急联系人列表
        contactAdapter = EmergencyContactAdapter(
            onCallClick = { contact ->
                makeCall(contact.phoneNumber)
            },
            onDeleteClick = { contact ->
                deleteContact(contact)
            }
        )
        binding.rvContacts.layoutManager = LinearLayoutManager(this)
        binding.rvContacts.adapter = contactAdapter
    }

    private fun loadUserData() {
        val user = DataManager.getUser() ?: return

        binding.tvNickname.text = user.nickname
        binding.tvPhoneNumber.text = user.getMaskedPhoneNumber()
        binding.tvSecurityLevel.text = user.getSecurityLevelText()
        binding.tvSecurityLevel.setTextColor(
            when (user.securityLevel) {
                1 -> getColor(R.color.level_low)
                2 -> getColor(R.color.level_medium)
                else -> getColor(R.color.level_high)
            }
        )

        // 显示紧急联系人
        contactAdapter.setContacts(user.emergencyContacts)
    }

    private fun showEditUserDialog() {
        val user = DataManager.getUser() ?: return
        val dialogBinding = DialogEditUserBinding.inflate(LayoutInflater.from(this))

        dialogBinding.etNickname.setText(user.nickname)
        dialogBinding.etPhone.setText(user.phoneNumber)

        AlertDialog.Builder(this)
            .setTitle(R.string.edit_profile)
            .setView(dialogBinding.root)
            .setPositiveButton(R.string.save) { _, _ ->
                val nickname = dialogBinding.etNickname.text.toString().trim()
                val phone = dialogBinding.etPhone.text.toString().trim()

                if (nickname.isNotEmpty() && phone.isNotEmpty()) {
                    user.nickname = nickname
                    user.phoneNumber = phone
                    DataManager.saveUser(user)
                    loadUserData()
                    Toast.makeText(this, R.string.success, Toast.LENGTH_SHORT).show()
                }
            }
            .setNegativeButton(R.string.cancel, null)
            .show()
    }

    private fun showAddContactDialog() {
        val dialogBinding = DialogEditUserBinding.inflate(LayoutInflater.from(this))

        dialogBinding.tilNickname.hint = "联系人姓名"
        dialogBinding.tilPhone.hint = "联系人电话"

        AlertDialog.Builder(this)
            .setTitle(R.string.emergency_contact)
            .setView(dialogBinding.root)
            .setPositiveButton(R.string.save) { _, _ ->
                val name = dialogBinding.etNickname.text.toString().trim()
                val phone = dialogBinding.etPhone.text.toString().trim()

                if (name.isNotEmpty() && phone.isNotEmpty()) {
                    val user = DataManager.getUser() ?: return@setPositiveButton
                    val contact = EmergencyContact(
                        id = java.util.UUID.randomUUID().toString(),
                        name = name,
                        phoneNumber = phone,
                        relationship = "朋友"
                    )
                    val updatedContacts = user.emergencyContacts.toMutableList()
                    updatedContacts.add(contact)
                    DataManager.saveUser(user.copy(emergencyContacts = updatedContacts))
                    loadUserData()
                    Toast.makeText(this, R.string.success, Toast.LENGTH_SHORT).show()
                }
            }
            .setNegativeButton(R.string.cancel, null)
            .show()
    }

    private fun deleteContact(contact: EmergencyContact) {
        val user = DataManager.getUser() ?: return

        AlertDialog.Builder(this)
            .setTitle(R.string.delete)
            .setMessage("确定删除联系人 ${contact.name} 吗？")
            .setPositiveButton(R.string.confirm) { _, _ ->
                val updatedContacts = user.emergencyContacts.filter { it.id != contact.id }
                DataManager.saveUser(user.copy(emergencyContacts = updatedContacts))
                loadUserData()
            }
            .setNegativeButton(R.string.cancel, null)
            .show()
    }

    private fun makeCall(phoneNumber: String) {
        val intent = Intent(Intent.ACTION_DIAL).apply {
            data = Uri.parse("tel:$phoneNumber")
        }
        startActivity(intent)
    }

    /**
     * 紧急联系人适配器
     */
    inner class EmergencyContactAdapter(
        private val onCallClick: (EmergencyContact) -> Unit,
        private val onDeleteClick: (EmergencyContact) -> Unit
    ) : RecyclerView.Adapter<EmergencyContactAdapter.ViewHolder>() {

        private var contacts: List<EmergencyContact> = emptyList()

        fun setContacts(newContacts: List<EmergencyContact>) {
            contacts = newContacts
            notifyDataSetChanged()
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val binding = ItemEmergencyContactBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
            return ViewHolder(binding)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.bind(contacts[position])
        }

        override fun getItemCount() = contacts.size

        inner class ViewHolder(
            private val binding: ItemEmergencyContactBinding
        ) : RecyclerView.ViewHolder(binding.root) {

            fun bind(contact: EmergencyContact) {
                binding.tvName.text = contact.name
                binding.tvPhone.text = contact.phoneNumber
                binding.tvRelationship.text = contact.relationship

                binding.btnCall.setOnClickListener {
                    onCallClick(contact)
                }

                binding.btnDelete.setOnClickListener {
                    onDeleteClick(contact)
                }
            }
        }
    }
}