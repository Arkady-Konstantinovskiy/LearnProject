package com.example.learnapplication.ui.details

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.learnapplication.Film
import com.example.learnapplication.R
import com.example.learnapplication.databinding.FragmentDetailsBinding
import com.example.learnapplication.databinding.FragmentHomeBinding

class DetailsFragment : Fragment() {
    private var _binding: FragmentDetailsBinding? = null
    private val binding get() = _binding!!
    private lateinit var film: Film

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setFilmsDetails()

        binding.detailsFabShare.setOnClickListener {
            //Создаем интент
            val intent = Intent()
            //Укзываем action с которым он запускается
            intent.action = Intent.ACTION_SEND
            //Кладем данные о нашем фильме
            intent.putExtra(
                Intent.EXTRA_TEXT,
                "Check out this film: ${film.title} \n\n ${film.description}"
            )
            //УКазываем MIME тип, чтобы система знала, какое приложения предложить
            intent.type = "text/plain"
            //Запускаем наше активити
            startActivity(Intent.createChooser(intent, "Share To:"))
        }
    }

    private fun setFilmsDetails() {
        //Получаем наш фильм из переданного бандла
        film = arguments?.get("film") as Film

        //Устанавливаем заголовок
        binding.detailsToolbar.title = film.title
        //Устанавливаем картинку
        binding.detailsPoster.setImageResource(film.poster)
        //Устанавливаем описание
        binding.detailsDescription.text = film.description

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}