//package ru.startandroid.develop.javatutorial.adapter
//
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.TextView
//import androidx.recyclerview.widget.RecyclerView
//import kotlinx.android.synthetic.main.test_question_item.view.*
//import ru.startandroid.develop.javatutorial.R
//import ru.startandroid.develop.javatutorial.model.Question
//
//class QuestionAdapter(private val question: List<Question>, var clickListener: OnQuestionClickListener) :
//    RecyclerView.Adapter<QuestionAdapter.QuestionViewHolder>() {
//
//
//
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionViewHolder {
//        val itemView =
//            LayoutInflater.from(parent.context).inflate(R.layout.test_question_item, parent, false)
//        return QuestionViewHolder(itemView)
//    }
//
//    override fun getItemCount(): Int {
//       return question.size
//    }
//
//    override fun onBindViewHolder(holder: QuestionViewHolder, position: Int) {
//        holder.initialize(question.get(position), clickListener)
//    }
//
//
//    class QuestionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        private val testQuestion: TextView = itemView.questionTest
//        private val firstQuestion: TextView = itemView.radioButtonOne
//        private val secondQuestion: TextView = itemView.radioButtonTwo
//        private val thirdQuestion: TextView = itemView.radioButtonThree
//
//
//        fun initialize(item: Question, action: OnQuestionClickListener){
//            firstQuestion.text = item.secondOption
//            secondQuestion.text = item.firstOption
//            thirdQuestion.text = item.thirdOption
//
//            itemView.setOnClickListener{
//                action.onItemClick(item, adapterPosition)
//            }
//        }
//    }
//
//
//
//
//    interface OnQuestionClickListener{
//
//        fun onItemClick(question:Question, position: Int)
//    }
//
//
//
//
//}