package ru.startandroid.develop.javatutorial.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.test_name_item.view.*
import ru.startandroid.develop.javatutorial.R
import ru.startandroid.develop.javatutorial.model.Test

class TestAdapter (private val test: List<Test>, private var clickListener: OnTestClickListener) :
    RecyclerView.Adapter<TestAdapter.TestViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):TestViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.test_name_item, parent, false)
        return TestViewHolder(itemView)
    }

    override fun getItemCount(): Int {
       return test.size
    }

    override fun onBindViewHolder(holder: TestViewHolder, position: Int) {
        holder.initialize(test.get(position), clickListener)
    }

    class TestViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameTest: TextView = itemView.name_test
        private val numberTest: TextView = itemView.number_test


        fun initialize(item: Test, action: OnTestClickListener){
            numberTest.text = item.id.toString()
            nameTest.text = item.nameTest

            itemView.setOnClickListener{
                action.onItemClick(item, adapterPosition)
            }
        }
    }

    interface OnTestClickListener{

        fun onItemClick(test: Test, position: Int)
    }




}