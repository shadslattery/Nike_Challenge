package com.smartherd.nikechallenge.adapters

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.smartherd.nikechallenge.R
import com.smartherd.nikechallenge.model.Definition
import com.smartherd.nikechallenge.utils.inflate
import kotlinx.android.synthetic.main.list_item.view.*

class UrbanAdapter : RecyclerView.Adapter<UrbanAdapter.UrbanAdapterViewHolder>() {

    private var definitions: MutableList<Definition> = mutableListOf()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): UrbanAdapterViewHolder = UrbanAdapterViewHolder(parent.inflate(R.layout.list_item))

    override fun getItemCount(): Int = definitions.size

    override fun onBindViewHolder(holder: UrbanAdapterViewHolder, position: Int) =
        holder.loadData(definitions[position])

    fun loadDefinitions(newDefinitions: List<Definition>) {
        definitions.clear()
        definitions.addAll(newDefinitions)
        notifyDataSetChanged()
    }

    inner class UrbanAdapterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun loadData(definition: Definition) =
            with(itemView) {
                tvWord.text = definition.word
                tvExample.text = definition.example
            }
    }

}
