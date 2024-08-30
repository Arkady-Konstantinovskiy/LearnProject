package com.example.learnapplication

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_YES
import androidx.appcompat.app.AppCompatDelegate.setDefaultNightMode
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.learnapplication.databinding.ActivityMainBinding
import com.example.learnapplication.databinding.FragmentDetailsBinding
import com.example.learnapplication.ui.details.DetailsFragment
import com.example.learnapplication.ui.home.HomeFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
//    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initNavigation()
//        setSupportActionBar(binding.appBarMain.topAppBar)





        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


    }

    private fun initNavigation() {
        binding.toolbarMain.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.settings -> {
                    if (AppCompatDelegate.getDefaultNightMode() == MODE_NIGHT_YES){
                        setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                        Toast.makeText(this, "Ночная тема выкл", Toast.LENGTH_SHORT).show()
                    } else {
                        setDefaultNightMode(MODE_NIGHT_YES)
                        Toast.makeText(this, "Ночная тема вкл", Toast.LENGTH_SHORT).show()
                    }

                    true
                }
                else -> false
            }
        }

        val navView: BottomNavigationView = binding.bottomNavigation

//        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment_content_main) as NavHostFragment
//        val navController = navHostFragment.navController
        val navController = findNavController(R.id.nav_host_fragment_content_main)
//        короче было как-то так + в content_main.xml был прописан fragment вместо androidX.***.FragmentContainerView
//        из изменений теперь блокируется bottomNavigation при нахождение в фрагменте с деталями,
//        в остальном при смене темы все также крашится
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
//        val appBarConfiguration = AppBarConfiguration(
//            setOf(
//                R.id.nav_favorites, R.id.nav_watch_later, R.id.nav_selections
//            )
//        )
//        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

    }

//    Стандартный вариант передачи даннных FragmentDetails и его запуска без использования Navigate
//    P.S: при активном окне FragmentDetails приложение вылетало на смене темы Day/Night если фрагмент передовался в NavHostFragment, ошибку выдавала библиотека Navigate
//    fun launchDetailsFragment(film: Film) {
//        //Создаем "посылку"
//        val bundle = Bundle()
//        //Кладем наш фильм в "посылку"
//        bundle.putParcelable("film", film)
//        //Кладем фрагмент с деталями в перменную
//        val fragment = DetailsFragment()
//        //Прикрепляем нашу "посылку" к фрагменту
//        fragment.arguments = bundle
//
//        //Запускаем фрагмент
//        supportFragmentManager
//            .beginTransaction()
//            .replace(R.id.nav_host_fragment_content_main, fragment)
//            .addToBackStack(null)
//            .commit()
//    }

}
