package com.smartherd.nikechallenge.adapters

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.RecyclerView
import com.smartherd.nikechallenge.R
import com.smartherd.nikechallenge.model.Definition
import com.smartherd.nikechallenge.utils.inflate
import kotlinx.android.synthetic.main.activity_main.view.*


class UrbanAdapter(var userList: ArrayList<Definition>) :
    RecyclerView.Adapter<UrbanAdapter.UrbanAdaperViewHolder>() {

    lateinit var context: Context
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): UrbanAdaperViewHolder {
        context = parent.context
        return UrbanAdaperViewHolder(parent.inflate(R.layout.list_item))
    }

    override fun getItemCount(): Int = userList.size


    override fun onBindViewHolder(holder: UrbanAdaperViewHolder, position: Int) =
        holder.setUpData(position)

    inner class UrbanAdaperViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun setUpData(position: Int) {
            val user_text: EditText = itemView.ed_Text
            val search: Button = itemView.btn_Search
            val recycleview: RecyclerView = itemView.recycle
        }
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
