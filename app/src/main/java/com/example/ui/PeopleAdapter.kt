package com.example.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ui.databinding.PeopleItemBinding

class PeopleAdapter: RecyclerView.Adapter<PeopleAdapter.PeopleHolder>() {
    val peopleList = ArrayList<People>()

    class PeopleHolder(item: View) : RecyclerView.ViewHolder(item) {
        val binding = PeopleItemBinding.bind(item)
        fun bind(people: People) = with(binding) {
            imageView3.setImageResource(people.imageId)
            tvTitle.text = people.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PeopleHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.people_item, parent, false)
        return PeopleHolder(view)
    }

    override fun onBindViewHolder(holder: PeopleHolder, position: Int) {
        holder.bind(peopleList[position])
    }


    override fun getItemCount(): Int {
        return peopleList.size
    }

    fun addPeople(people: People){
        peopleList.add(people)
        notifyDataSetChanged()
    }
}
