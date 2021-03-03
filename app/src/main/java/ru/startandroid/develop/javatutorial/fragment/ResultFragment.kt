package ru.startandroid.develop.javatutorial.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.fragment_result.*
import ru.startandroid.develop.javatutorial.R
import ru.startandroid.develop.javatutorial.bd.DatabaseNew
import ru.startandroid.develop.javatutorial.bd.DatabaseRepository
import ru.startandroid.develop.javatutorial.bd.MyViewModel
import ru.startandroid.develop.javatutorial.bd.MyViewModelFactory
import ru.startandroid.develop.javatutorial.model.TestScore


class ResultFragment : Fragment() {

    lateinit var viewModel: MyViewModel
    private val args: ResultFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_result, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        tv_score.text = "Ваша оценка ${args.totalQuestions} из ${args.scoreTest}"
        tv_congratulations.text = "  Поздравляем\nс завершением\n        \"Теста\""

        btn_finish.setOnClickListener {
            val repository = DatabaseRepository(DatabaseNew(requireContext()))
            val viewModelFactory = MyViewModelFactory(repository)
            viewModel = ViewModelProvider(requireActivity(), viewModelFactory).get(MyViewModel::class.java)
            val score = TestScore(args.idResult.toInt(), args.nameTest, args.totalQuestions, args.scoreTest)
            viewModel.saveScore(score)
            Toast. makeText(requireContext(), "Тест успешно завершен, оценки можете посмотреть в разделе Результаты теста",Toast .LENGTH_SHORT).show()
            val directions = ResultFragmentDirections.actionResultFragmentToTestFragment()
            findNavController().navigate(directions)

        }


    }
}