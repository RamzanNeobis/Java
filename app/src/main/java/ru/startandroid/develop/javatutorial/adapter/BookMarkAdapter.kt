package ru.startandroid.develop.javatutorial.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.bookmark_item.view.*
import ru.startandroid.develop.javatutorial.R

import ru.startandroid.develop.javatutorial.model.Chapter

class BookMarkAdapter:RecyclerView.Adapter<BookMarkAdapter.MyViewHolder>() {

    private var onItemClickListener: ((Chapter) -> Unit)? = null

    fun setOnItemClickListener(listener: (Chapter) -> Unit) {
        onItemClickListener = listener
    }


    private val differCallback = object : DiffUtil.ItemCallback<Chapter>() {
        override fun areItemsTheSame(oldItem: Chapter, newItem: Chapter): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Chapter, newItem: Chapter): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, differCallback)

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.bookmark_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val chapter = differ.currentList[position]
        holder.itemView.apply {
            name_bookmark.text = chapter.nameChapter
            number_bookmark.text = chapter.id.toString()
            setOnClickListener {
                onItemClickListener?.let { it(chapter) }
            }
        }


    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }


    interface OnBookmarkClickListener{

        fun onItemClick(chapterTwo: Chapter, position: Int)
    }


}