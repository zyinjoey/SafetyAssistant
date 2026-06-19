package com.example.safetyassistant.activities

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.safetyassistant.databinding.ItemEmergencyContactBinding
import com.example.safetyassistant.models.EmergencyContact

class EmergencyContactAdapter(
    private val onCallClick: (EmergencyContact) -> Unit,
    private val onDeleteClick: (EmergencyContact) -> Unit
) : RecyclerView.Adapter<EmergencyContactAdapter.ViewHolder>() {

    private var contacts: List<EmergencyContact> = emptyList()

    fun setContacts(list: List<EmergencyContact>) {
        contacts = list
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
