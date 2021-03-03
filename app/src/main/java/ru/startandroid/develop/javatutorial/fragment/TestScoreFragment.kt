package ru.startandroid.develop.javatutorial.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_bookmark.*
import kotlinx.android.synthetic.main.fragment_test_score.*
import ru.startandroid.develop.javatutorial.R
import ru.startandroid.develop.javatutorial.adapter.ScoreAdapter
import ru.startandroid.develop.javatutorial.bd.DatabaseNew
import ru.startandroid.develop.javatutorial.bd.DatabaseRepository
import ru.startandroid.develop.javatutorial.bd.MyViewModel
import ru.startandroid.develop.javatutorial.bd.MyViewModelFactory


class TestScoreFragment : Fragment() {

    lateinit var viewModel: MyViewModel
    lateinit var myAdapter: ScoreAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? =  inflater.inflate(R.layout.fragment_test_score, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val repository = DatabaseRepository(DatabaseNew(requireContext()))
        val viewModelFactory = MyViewModelFactory(repository)
        viewModel =
            ViewModelProvider(requireActivity(), viewModelFactory).get(MyViewModel::class.java)

        viewModel.getSavedScores().observe(viewLifecycleOwner) {
            myAdapter.differ.submitList(it)
        }


        setupRV()



        val itemTouchHelperCallback = object : ItemTouchHelper.SimpleCallback(
            ItemTouchHelper.UP or ItemTouchHelper.DOWN,
            ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT
        ) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return true
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val position = viewHolder.adapterPosition
                val score = myAdapter.differ.currentList[position]
                viewModel.deleteScore(score)
                Toast.makeText(requireContext(), "Successfully delete score", Toast.LENGTH_SHORT)
                    .show()
            }
        }

        ItemTouchHelper(itemTouchHelperCallback).apply {
            attachToRecyclerView(recycler_score)
        }
    }






    private fun setupRV() {
        myAdapter = ScoreAdapter()
        myAdapter.notifyDataSetChanged()
        recycler_score.apply {
            adapter = myAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }
}