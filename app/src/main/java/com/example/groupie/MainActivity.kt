package com.example.groupie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.groupie.databinding.ActivityMainBinding
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder

class MainActivity : AppCompatActivity() {

    lateinit var listHeroes: List<Superhero>

    private val binding: ActivityMainBinding by viewBinding()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //fetching superheroes
        listHeroes = api.fetchHeroes()

        /**
         * Теперь Groupie использует GroupAdapterвместо обычного адаптера для создания списков.
         * Итак, в нашей MainActivity мы создадим GroupAdapter и добавим список супергероев,
         * которые мы получаем из API, в GroupAdapter и установим его в качестве адаптера для RecyclerView.
          */
        val groupAdapter = GroupAdapter<GroupieViewHolder>().apply {
            addAll(listHeroes.toSuperHeroITem())
        }

        binding.recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter = groupAdapter
        }
    }
}