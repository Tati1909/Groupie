package com.example.groupie

fun List<Superhero>.toSuperHeroITem() : List<SuperHeroItem>{
    return this.map {
        SuperHeroItem(it)
    }
}