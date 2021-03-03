package ru.startandroid.develop.javatutorial.fragment
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_bookmark.*
import androidx.recyclerview.widget.LinearLayoutManager
import ru.startandroid.develop.javatutorial.bd.DatabaseNew
import ru.startandroid.develop.javatutorial.bd.DatabaseRepository
import ru.startandroid.develop.javatutorial.bd.MyViewModel
import ru.startandroid.develop.javatutorial.bd.MyViewModelFactory
import ru.startandroid.develop.javatutorial.R
import ru.startandroid.develop.javatutorial.adapter.BookMarkAdapter


class BookmarkFragment : Fragment() {
    lateinit var viewModel: MyViewModel
    lateinit var myAdapter: BookMarkAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_bookmark, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val repository = DatabaseRepository(DatabaseNew(requireContext()))
        val viewModelFactory = MyViewModelFactory(repository)
        viewModel =
            ViewModelProvider(requireActivity(), viewModelFactory).get(MyViewModel::class.java)

        viewModel.getSavedChapters().observe(viewLifecycleOwner) {
            myAdapter.differ.submitList(it)
        }


        setupRV()
        myAdapter.setOnItemClickListener {
            val chapterId = it.id
            if(chapterId == 1) {
                val directions = BookmarkFragmentDirections.actionBookmarkFragmentToChapterFragment(chapterId)
                findNavController().navigate(directions)

            }
            else if(chapterId == 2){
                Toast.makeText(requireContext(), "eto 2", Toast.LENGTH_SHORT).show()
            }

        }

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
                val chapter = myAdapter.differ.currentList[position]
                viewModel.deleteChapter(chapter)
                Toast.makeText(requireContext(), "Successfully delete chapter", Toast.LENGTH_SHORT)
                    .show()
            }
        }

        ItemTouchHelper(itemTouchHelperCallback).apply {
            attachToRecyclerView(recycler_chapter)
        }

    }

    private fun setupRV() {
        myAdapter = BookMarkAdapter()
        recycler_chapter.apply {
            adapter = myAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }





}





