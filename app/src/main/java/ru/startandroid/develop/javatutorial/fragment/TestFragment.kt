package ru.startandroid.develop.javatutorial.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_test.*
import ru.startandroid.develop.javatutorial.R
import ru.startandroid.develop.javatutorial.adapter.TestAdapter
import ru.startandroid.develop.javatutorial.model.Chapter
import ru.startandroid.develop.javatutorial.model.Test


class TestFragment : Fragment(), TestAdapter.OnTestClickListener {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_test, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val test = mutableListOf<Test>()
        test.add(Test(1,"  Пройти тест по теме:\n \"Структура программы\"" ))
        test.add(Test(2,"  Пройти тест по теме:\n \"Переменные и константы\""))
        test.add(Test(3,"  Пройти тест по теме:\n \"Типы данных\""))
        test.add(Test(4,"  Пройти тест по теме:\n \"Консольный ввод/вывод в Java\""))
        test.add(Test(5,"  Пройти тест по теме:\n \"Арифметические операции\""))
        test.add(Test(6,"  Пройти тест по теме:\n \"Поразрядные операции\""))
        test.add(Test(7,"  Пройти тест по теме:\n \"Условные выражения\""))
        test.add(Test(8,"  Пройти тест по теме:\n \"Операции присваивания и приоритет операций\""))
        test.add(Test(9,"  Пройти тест по теме:\n \"Преобразования базовых типов данных\""))
        test.add(Test(10,"  Пройти тест по теме:\n \"Условные конструкции\""))
        test.add(Test(11,"  Пройти тест по теме:\n \"Циклы\""))
        test.add(Test(12,"  Пройти тест по теме:\n \"Массивы\""))
        test.add(Test(13,"  Пройти тест по теме:\n \"Методы\""))
        test.add(Test(14,"  Пройти тест по теме:\n \"Параметры методов\""))



        recycler_test.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = TestAdapter(test, this@TestFragment)
        }
    }

    override fun onItemClick(test: Test, position: Int) {
        if(test.id == 1){
            val directions = TestFragmentDirections.actionTestFragmentToTakeTheTestFragment(test.id, "Структура программы")
            findNavController().navigate(directions)
        }
        else if(test.id == 2){
            val directions = TestFragmentDirections.actionTestFragmentToTakeTheTestFragment(test.id, "Переменные и константы")
            findNavController().navigate(directions)
        }
        else if(test.id == 3){
            val directions = TestFragmentDirections.actionTestFragmentToTakeTheTestFragment(test.id, "Типы Данных")
            findNavController().navigate(directions)
        }
    }
}