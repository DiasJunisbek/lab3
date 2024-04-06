package com.example.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import com.example.ui.databinding.ActivityViewsBinding

class views : AppCompatActivity() {
    lateinit var binding: ActivityViewsBinding
    private val adapter = PeopleAdapter()
    private val imageIdList = listOf(
        R.drawable.views1,
        R.drawable.views2,
        R.drawable.views3,
        R.drawable.views4,
        R.drawable.views5,
    )
    private var index = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()

    }

    private fun init(){
        binding.apply {
            rcView.layoutManager = GridLayoutManager(this@views,3)
            rcView.adapter = adapter
            buttonAdd.setOnClickListener{
                if(index >4) index = 0
                val people = People(imageIdList[index], "friend $index")
                adapter.addPeople(people)
                index++
            }
        }
    }
    fun onClickGoBack(view: View){

        val i = Intent(this, MainActivity::class.java )
        startActivity(i)
    }
}