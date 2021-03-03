package ru.startandroid.develop.javatutorial.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageSwitcher
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.authorization.view.*
import kotlinx.android.synthetic.main.chapter_item.view.*
import ru.startandroid.develop.javatutorial.R
import ru.startandroid.develop.javatutorial.model.Chapter

class ChapterAdapter(private val chapters: List<Chapter> , var clickListener: OnChapterClickListener) :
    RecyclerView.Adapter<ChapterAdapter.ChapterViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChapterViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.chapter_item, parent, false)
        return ChapterViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return chapters.size
    }

    override fun onBindViewHolder(holder: ChapterViewHolder, position: Int) {
//        holder.nameChapter.text = chapters[position].nameChapter
        holder.initialize(chapters.get(position), clickListener)
    }

    class ChapterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameChapter: TextView = itemView.name_chapter_id
        private val imageChapter: ImageView = itemView.image_chapter


        fun initialize(item: Chapter, action: OnChapterClickListener){
            nameChapter.text = item.nameChapter
            imageChapter.setImageResource(item.imageChapter)

            itemView.setOnClickListener{
                action.onItemClick(item, adapterPosition)
            }
        }
    }


    interface OnChapterClickListener{

        fun onItemClick(chapter: Chapter, position: Int)
    }
}


