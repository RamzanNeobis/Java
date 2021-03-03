package ru.startandroid.develop.javatutorial.fragment

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Typeface
import android.graphics.drawable.AdaptiveIconDrawable
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.compose.runtime.currentComposer
import androidx.compose.ui.graphics.Color
import androidx.core.content.ContextCompat
import androidx.core.view.isInvisible
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.authorization.view.*
import kotlinx.android.synthetic.main.fragment_take_the_test.*
import org.w3c.dom.Text
import ru.startandroid.develop.javatutorial.R
import ru.startandroid.develop.javatutorial.model.Question
import javax.crypto.Cipher


class TakeTheTestFragment : Fragment(), View.OnClickListener {

    private var mCurrentPosition: Int = 1
    private var mQuestionList: ArrayList<Question>? = null
    private var mSelectedOptionPosition: Int = 0
    private var mCorrectAnswer: Int = 0
    private var testId: Int? = null
    private var nameTest: String? = null

    private val args: TakeTheTestFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_take_the_test, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        testId = args.testId
        nameTest = args.nameTest
        if (testId == 1) {
            mQuestionList = Constants.getQuestion()
            setQuestion()
            tv_option_one.setOnClickListener(this)
            tv_option_two.setOnClickListener(this)
            tv_option_three.setOnClickListener(this)

            btn_submit.setOnClickListener(this)


        } else if (testId == 2) {
           mQuestionList = Constants.getQuestionTwo()
            setQuestion()
            tv_option_one.setOnClickListener(this)
            tv_option_two.setOnClickListener(this)
            tv_option_three.setOnClickListener(this)

            btn_submit.setOnClickListener(this)
        }else if(testId == 3){
            mQuestionList = Constants.getQuestionThree()
            setQuestion()
            tv_option_one.setOnClickListener(this)
            tv_option_two.setOnClickListener(this)
            tv_option_three.setOnClickListener(this)

            btn_submit.setOnClickListener(this)
        }
    }


    private fun setQuestion() {

        val question = mQuestionList!![mCurrentPosition - 1]

        defaultOptionView()

        if (mCurrentPosition == mQuestionList!!.size){
            btn_submit.text = "FINISH"
        }else{
            btn_submit.text = "ВЫБРАТЬ"
        }
        progressBar.progress = mCurrentPosition
        tv_progress.text = "$mCurrentPosition" + "/" + progressBar.max

        tv_question.text = question!!.question
        iv_image.setImageResource(question.image)
        tv_option_one.text = question.optionOne
        tv_option_two.text = question.optionTwo
        tv_option_three.text = question.optionThree
    }


    @SuppressLint("ResourceAsColor")
    private fun defaultOptionView() {
        val options = ArrayList<TextView>()
        options.add(0, tv_option_one)
        options.add(1, tv_option_two)
        options.add(2, tv_option_three)

        for (option in options) {
            option.setTextColor(R.color.special_color)
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                requireContext(), R.drawable.default_option_border_bg
            )
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.tv_option_one -> {
                selectedOptionView(tv_option_one, 1)
            }
            R.id.tv_option_two -> {
                selectedOptionView(tv_option_two, 2)
            }
            R.id.tv_option_three -> {
                selectedOptionView(tv_option_three, 3)
            }
            R.id.btn_submit -> {
                if (mSelectedOptionPosition == 0) {
                    mCurrentPosition++

                    when {
                        mCurrentPosition <= mQuestionList!!.size -> {
                            setQuestion()
                        }
                        else -> {
                            val directions = TakeTheTestFragmentDirections.actionTakeTheTestFragmentToResultFragment(testId.toString(),mCorrectAnswer, mQuestionList!!.size, nameTest.toString())
                            findNavController().navigate(directions)
                        }
                    }
                }else{
                    val question = mQuestionList?.get(mCurrentPosition -1)
                    if(question!!.correctAnswer != mSelectedOptionPosition){
                        answerView(mSelectedOptionPosition, R.drawable.wrong_option_border_bg)
                    }else{
                        mCorrectAnswer++
                    }
                    answerView(question.correctAnswer, R.drawable.correct_option_border_bg)

                    if(mCurrentPosition == mQuestionList!!.size){
                        btn_submit.text = "FINISH"
                    }else{
                        btn_submit.text = "GO TO NEXT QUESTION"
                    }
                    mSelectedOptionPosition = 0
                }
            }


        }
    }


    private fun answerView(answer: Int, drawableView: Int) {
        when (answer) {
            1 -> {
                tv_option_one.background = ContextCompat.getDrawable(
                    requireContext(), drawableView
                )
            }
            2 -> {
                tv_option_two.background = ContextCompat.getDrawable(
                    requireContext(), drawableView
                )
            }
            3 -> {
                tv_option_three.background = ContextCompat.getDrawable(
                    requireContext(), drawableView
                )
            }
        }
    }


    @SuppressLint("ResourceAsColor")
    private fun selectedOptionView(tv: TextView, selectedOptionNum: Int) {
        defaultOptionView()
        mSelectedOptionPosition = selectedOptionNum

        tv.setTextColor(R.color.special_color_two)
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            requireContext(), R.drawable.selected_option_border_bg
        )
    }


}