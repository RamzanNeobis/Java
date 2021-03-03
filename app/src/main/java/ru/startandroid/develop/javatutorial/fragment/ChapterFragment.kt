package ru.startandroid.develop.javatutorial.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.fragment_chapter.*
import ru.startandroid.develop.javatutorial.bd.MyViewModel
import ru.startandroid.develop.javatutorial.R
import ru.startandroid.develop.javatutorial.bd.DatabaseNew
import ru.startandroid.develop.javatutorial.bd.DatabaseRepository
import ru.startandroid.develop.javatutorial.bd.MyViewModelFactory
import ru.startandroid.develop.javatutorial.model.Chapter


class ChapterFragment : Fragment() {

    lateinit var viewModel: MyViewModel
    private val nameChapterOne = "Структура программы"
    private val nameChapterTwo = "Переменные и константы"

    private val args: ChapterFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_chapter, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val repository = DatabaseRepository(DatabaseNew(requireContext()))
        val viewModelFactory = MyViewModelFactory(repository)
        viewModel = ViewModelProvider(requireActivity(), viewModelFactory).get(MyViewModel::class.java)
        val id = args.chapterId
        if(id== 1) {
            pdfView.fromAsset("javaone.pdf")
                .load()
            add_bookmark.setOnClickListener {
                val chapter = Chapter(id, "Структура Программы",R.drawable.java)
                viewModel.saveChapter(chapter)
                Toast.makeText(requireContext(), "Закладка добавлена", Toast.LENGTH_SHORT).show()
            }
        }
        else if (id == 2){
            pdfView.fromAsset("javaone.pdf")
                .load()
            add_bookmark.setOnClickListener {
                val chapter = Chapter(id, "Переменные и константы",R.drawable.java )
                viewModel.saveChapter(chapter)
                Toast.makeText(requireContext(), "Закладка добавлена", Toast.LENGTH_SHORT).show()
            }
        }
        else if (id == 3){
            pdfView.fromAsset("javaone.pdf")
                .load()
            add_bookmark.setOnClickListener {
                val chapter = Chapter(id, "Типы данных",R.drawable.java)
                viewModel.saveChapter(chapter)
                Toast.makeText(requireContext(), "Закладка добавлена", Toast.LENGTH_SHORT).show()
            }
        }
        else if (id == 4){
            pdfView.fromAsset("javaone.pdf")
                .load()
            add_bookmark.setOnClickListener {
                val chapter = Chapter(id, "Консольный ввод/вывод в Java",R.drawable.java)
                viewModel.saveChapter(chapter)
                Toast.makeText(requireContext(), "Закладка добавлена", Toast.LENGTH_SHORT).show()
            }
        }
        else if (id == 5){
            pdfView.fromAsset("javaone.pdf")
                .load()
            add_bookmark.setOnClickListener {
                val chapter = Chapter(id, "Арифметические операции",R.drawable.java)
                viewModel.saveChapter(chapter)
                Toast.makeText(requireContext(), "Закладка добавлена", Toast.LENGTH_SHORT).show()
            }
        }
        else if (id == 6){
            pdfView.fromAsset("javaone.pdf")
                .load()
            add_bookmark.setOnClickListener {
                val chapter = Chapter(id, "Поразрядные операции",R.drawable.java)
                viewModel.saveChapter(chapter)
                Toast.makeText(requireContext(), "Закладка добавлена", Toast.LENGTH_SHORT).show()
            }
        }
        else if (id == 7){
            pdfView.fromAsset("javaone.pdf")
                .load()
            add_bookmark.setOnClickListener {
                val chapter = Chapter(id, "Типы данных",R.drawable.java)
                viewModel.saveChapter(chapter)
                Toast.makeText(requireContext(), "Условные выражения", Toast.LENGTH_SHORT).show()
            }
        }
        else if (id == 8){
            pdfView.fromAsset("javaone.pdf")
                .load()
            add_bookmark.setOnClickListener {
                val chapter = Chapter(id, "Операции присваивания и приоритет операций",R.drawable.java)
                viewModel.saveChapter(chapter)
                Toast.makeText(requireContext(), "Закладка добавлена", Toast.LENGTH_SHORT).show()
            }
        }
        else if (id == 9){
            pdfView.fromAsset("javaone.pdf")
                .load()
            add_bookmark.setOnClickListener {
                val chapter = Chapter(id, "Преобразования базовых типов данных",R.drawable.java)
                viewModel.saveChapter(chapter)
                Toast.makeText(requireContext(), "Закладка добавлена", Toast.LENGTH_SHORT).show()
            }
        }
        else if (id == 10){
            pdfView.fromAsset("javaone.pdf")
                .load()
            add_bookmark.setOnClickListener {
                val chapter = Chapter(id, "Условные конструкции",R.drawable.java)
                viewModel.saveChapter(chapter)
                Toast.makeText(requireContext(), "Закладка добавлена", Toast.LENGTH_SHORT).show()
            }
        }
        else if (id == 11){
            pdfView.fromAsset("javaone.pdf")
                .load()
            add_bookmark.setOnClickListener {
                val chapter = Chapter(id, "Циклы",R.drawable.java)
                viewModel.saveChapter(chapter)
                Toast.makeText(requireContext(), "Закладка добавлена", Toast.LENGTH_SHORT).show()
            }
        }
        else if (id == 12){
            pdfView.fromAsset("javaone.pdf")
                .load()
            add_bookmark.setOnClickListener {
                val chapter = Chapter(id, "Массивы",R.drawable.java)
                viewModel.saveChapter(chapter)
                Toast.makeText(requireContext(), "Закладка добавлена", Toast.LENGTH_SHORT).show()
            }
        }
        else if (id == 13){
            pdfView.fromAsset("javaone.pdf")
                .load()
            add_bookmark.setOnClickListener {
                val chapter = Chapter(id, "Методы",R.drawable.java)
                viewModel.saveChapter(chapter)
                Toast.makeText(requireContext(), "Закладка добавлена", Toast.LENGTH_SHORT).show()
            }
        }
        else if (id == 14){
            pdfView.fromAsset("javaone.pdf")
                .load()
            add_bookmark.setOnClickListener {
                val chapter = Chapter(id, "Типы данных",R.drawable.java)
                viewModel.saveChapter(chapter)
                Toast.makeText(requireContext(), "Параметры методов", Toast.LENGTH_SHORT).show()
            }
        }
    }
}