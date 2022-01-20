package com.example.groupie

import com.example.groupie.databinding.ItemSuperheroBinding
import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.Item

/**
Класс Item предоставляет простые обратные вызовы для привязки объекта модели к сгенерированным полям.

В getLayout()функции мы вернем макет одного элемента, который мы хотим использовать в нашем RecyclerView,
и в bind()функции мы свяжем представления с данными супергероя, как мы делали это onBindViewHolder()в обычном адаптере RecyclerView.
Обратите внимание, мы получаем SuperHero объект в конструкторе SuperHeroItem класса.
 */
class SuperHeroItem(private val superhero: Superhero) : Item<GroupieViewHolder>() {

    override fun getLayout() = R.layout.item_superhero

    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        with(viewHolder.itemView) {
            val binding = ItemSuperheroBinding.bind(this)

            viewHolder.itemView.apply {
                binding.txtRealName.text = superhero.realName
                binding.txtName.text = superhero.name
            }
        }
    }

}