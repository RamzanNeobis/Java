package ru.startandroid.develop.javatutorial.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_home.*
import ru.startandroid.develop.javatutorial.R
import ru.startandroid.develop.javatutorial.adapter.ChapterAdapter
import ru.startandroid.develop.javatutorial.model.Chapter


class HomeFragment : Fragment(), ChapterAdapter.OnChapterClickListener {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_home, container, false)



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val chapters = mutableListOf<Chapter>()
        chapters.add(Chapter(1,"Структура программы", R.drawable.jm))
        chapters.add(Chapter(2,"Переменные и константы", R.drawable.jmtwo))
        chapters.add(Chapter(3,"Типы данных", R.drawable.jmthree))
        chapters.add(Chapter(4,"Консольный ввод/вывод в Java", R.drawable.jmfour))
        chapters.add(Chapter(5,"Арифметические операции", R.drawable.javafive))
        chapters.add(Chapter(6,"Поразрядные операции", R.drawable.jmsix))
        chapters.add(Chapter(7,"Условные выражения", R.drawable.jmseven))
        chapters.add(Chapter(8,"Операции присваивания и приоритет операций", R.drawable.jmeight))
        chapters.add(Chapter(9,"Преобразования базовых типов данных", R.drawable.jmnine))
        chapters.add(Chapter(10,"Условные конструкции", R.drawable.jmten))
        chapters.add(Chapter(11,"Циклы", R.drawable.jmeleven))
        chapters.add(Chapter(12,"Массивы", R.drawable.jmtwelve))
        chapters.add(Chapter(13,"Методы", R.drawable.jmthirteen))
        chapters.add(Chapter(14,"Параметры методов", R.drawable.jmfourteen))





        recycler_view.apply {
            layoutManager = GridLayoutManager(requireContext(),2, GridLayoutManager.VERTICAL,false)
            adapter = ChapterAdapter(chapters, this@HomeFragment)
        }
    }

    override fun onItemClick(chapter: Chapter, position: Int) {
        if(chapter.id == 1 ) {
            chapter.let{
                val directions = HomeFragmentDirections.actionHomeFragmentToChapterFragment(chapter.id)
                findNavController().navigate(directions)
            }

        }
        else if(chapter.id == 2){
            val directions = HomeFragmentDirections.actionHomeFragmentToChapterFragment(chapter.id)
            findNavController().navigate(directions)
        }
        else if(chapter.id == 3){
            val directions = HomeFragmentDirections.actionHomeFragmentToChapterFragment(chapter.id)
            findNavController().navigate(directions)
        }
        else if(chapter.id == 4){
            val directions = HomeFragmentDirections.actionHomeFragmentToChapterFragment(chapter.id)
            findNavController().navigate(directions)
        }
        else if(chapter.id == 5){
            val directions = HomeFragmentDirections.actionHomeFragmentToChapterFragment(chapter.id)
            findNavController().navigate(directions)
        }
        else if(chapter.id == 6){
            val directions = HomeFragmentDirections.actionHomeFragmentToChapterFragment(chapter.id)
            findNavController().navigate(directions)
        }
        else if(chapter.id == 7){
            val directions = HomeFragmentDirections.actionHomeFragmentToChapterFragment(chapter.id)
            findNavController().navigate(directions)
        }
        else if(chapter.id == 8){
            val directions = HomeFragmentDirections.actionHomeFragmentToChapterFragment(chapter.id)
            findNavController().navigate(directions)
        }
        else if(chapter.id == 9){
            val directions = HomeFragmentDirections.actionHomeFragmentToChapterFragment(chapter.id)
            findNavController().navigate(directions)
        }
        else if(chapter.id == 10){
            val directions = HomeFragmentDirections.actionHomeFragmentToChapterFragment(chapter.id)
            findNavController().navigate(directions)
        }
        else if(chapter.id == 11){
            val directions = HomeFragmentDirections.actionHomeFragmentToChapterFragment(chapter.id)
            findNavController().navigate(directions)
        }
        else if(chapter.id == 12){
            val directions = HomeFragmentDirections.actionHomeFragmentToChapterFragment(chapter.id)
            findNavController().navigate(directions)
        }
        else if(chapter.id == 13){
            val directions = HomeFragmentDirections.actionHomeFragmentToChapterFragment(chapter.id)
            findNavController().navigate(directions)
        }
        else if(chapter.id == 14){
            val directions = HomeFragmentDirections.actionHomeFragmentToChapterFragment(chapter.id)
            findNavController().navigate(directions)
        }
    }


}