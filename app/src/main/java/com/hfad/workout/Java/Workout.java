package com.hfad.workout.Java;

public class Workout {
    private String name;
    private String description;

    public static final Workout[] workouts = {
            new Workout("The Limb Loosener", "5 Отжимания от руки\n10 Одной ногой приседания\n15 Подтягивания"),
            new Workout("Core Agony", "100 Подтягивания\n100 Отжимания\n100 Приседаний\n100 Приседаний"),
            new Workout("The Wimp Special", "5 Подтягивания\n10 Отжиманий\n15 Приседаний"),
            new Workout("Strength and Length", "Бег на 500 метров\n21 x 1.5 pood kettleball\n21 х подтягивания")
    };

    //В объекте Workout хранится имя и описание
    private Workout(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return this.name;
    }
}
