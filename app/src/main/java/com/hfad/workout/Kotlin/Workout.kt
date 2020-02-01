package com.hfad.workout.Kotlin

class Workout //В объекте Workout хранится имя и описание
private constructor(val name: String, val description: String) {

    companion object {
        val workouts = arrayOf(
                Workout("The Limb Loosener", "5 Отжимания от руки\n10 Одной ногой приседания\n15 Подтягивания"),
                Workout("Core Agony", "100 Подтягивания\n100 Отжимания\n100 Приседаний\n100 Приседаний"),
                Workout("The Wimp Special", "5 Подтягивания\n10 Отжиманий\n15 Приседаний"),
                Workout("Strength and Length", "Бег на 500 метров\n21 x 1.5 pood kettleball\n21 х подтягивания")
        )
    }

    override fun toString(): String {
        return this.name
    }
}