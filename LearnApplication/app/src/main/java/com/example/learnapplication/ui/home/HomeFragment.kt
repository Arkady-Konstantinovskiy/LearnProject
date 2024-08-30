package com.example.learnapplication.ui.home

import android.content.DialogInterface.OnClickListener
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.learnapplication.Film
import androidx.lifecycle.viewModelScope
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.learnapplication.FilmListRecyclerAdapter
import com.example.learnapplication.MainActivity
import com.example.learnapplication.R
import com.example.learnapplication.TopSpacingItemDecoration
import com.example.learnapplication.databinding.FragmentHomeBinding
import com.example.learnapplication.ui.details.DetailsFragment
import com.google.android.material.snackbar.Snackbar

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var filmsAdapter: FilmListRecyclerAdapter
    private val filmsDataBase = listOf(
        Film("The Godfather", R.drawable.p_5, "The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son."),
        Film("The Dark Knight", R.drawable.p_6, "When the menace known as the Joker wreaks havoc and chaos on the people of Gotham, Batman must accept one of the greatest psychological and physical tests of his ability to fight injustice."),
        Film("Pulp Fiction", R.drawable.p_7, "The lives of two mob hitmen, a boxer, a gangster and his wife, and a pair of diner bandits intertwine in four tales of violence and redemption."),
        Film("Inception", R.drawable.p_8, "A thief who steals corporate secrets through the use of dream-sharing technology is given the inverse task of planting an idea into the mind of a C.E.O."),
        Film("Hamilton", R.drawable.p_9, "The real life of one of America's foremost founding fathers and first Secretary of the Treasury, Alexander Hamilton. Captured live on Broadway from the Richard Rodgers Theater with the original Broadway cast."),
        Film("Gisaengchung", R.drawable.p_10, "Greed and class discrimination threaten the newly formed symbiotic relationship between the wealthy Park family and the destitute Kim clan."),
        Film("Interstellar", R.drawable.p_11, "A team of explorers travel through a wormhole in space in an attempt to ensure humanity's survival.")
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
//        val homeViewModel =
//            ViewModelProvider(this).get(HomeViewModel::class.java)
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecyckler()

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initRecyckler() {
        binding.mainRecycler.apply {
            filmsAdapter =
                FilmListRecyclerAdapter(object : FilmListRecyclerAdapter.OnItemClickListener {
                    override fun click(film: Film) {
//                        Вариант с использованием Navigate
                        val bundle = Bundle()
                        bundle.putParcelable("film", film)
//                      заменить nav_details на action когда доделаю верстку других экранов
                        (activity as MainActivity).findNavController(R.id.nav_host_fragment_content_main).navigate(R.id.nav_details, bundle)

//                        Стандартный вариант с FragmentManager
//                        (activity as MainActivity).launchDetailsFragment(film)
                    }
                })
            //Присваиваем адаптер
            adapter = filmsAdapter
            //Присвои layoutmanager
            layoutManager = LinearLayoutManager(requireContext())
            //Применяем декоратор для отступов
            val decorator = TopSpacingItemDecoration(12)
            addItemDecoration(decorator)
        }
        //Кладем нашу БД в RV
        filmsAdapter.addItems(filmsDataBase)
    }
}

