package ru.startandroid.develop.javatutorial.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.bookmark_item.view.*
import kotlinx.android.synthetic.main.fragment_bookmark.*
import kotlinx.android.synthetic.main.score_item.view.*
import ru.startandroid.develop.javatutorial.R
import ru.startandroid.develop.javatutorial.model.Chapter
import ru.startandroid.develop.javatutorial.model.TestScore

class ScoreAdapter : RecyclerView.Adapter<ScoreAdapter.ScoreViewHolder>() {

    private var onItemClickListener: ((TestScore) -> Unit)? = null

    fun setOnItemClickListener(listener: (TestScore) -> Unit) {
        onItemClickListener = listener
    }

    private val differCallback = object : DiffUtil.ItemCallback<TestScore>() {
        override fun areItemsTheSame(oldItem: TestScore, newItem: TestScore): Boolean {
            return oldItem.scoreId == newItem.scoreId
        }

        override fun areContentsTheSame(oldItem: TestScore, newItem: TestScore): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, differCallback)


    inner class ScoreViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScoreViewHolder {
        return ScoreViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.score_item, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: ScoreViewHolder, position: Int) {
        val score = differ.currentList[position]
        holder.itemView.apply {
            name_score.text = score.nameScore
            score_test.text = score.totalScore.toString()+"     "+"из"
            totalScore.text = score.correctAnswer.toString()
            setOnClickListener {
                onItemClickListener?.let { it(score) }
            }
        }
    }








}