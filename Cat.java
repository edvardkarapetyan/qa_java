package com.example;

import java.util.List;

public class Cat {
    private Predator predator;  // меняем тип на Predator

    public Cat(Predator predator) {  // меняем параметр на Predator
        this.predator = predator;
    }

    public String getSound() {
        return "Мяу";
    }

    public List<String> getFood() throws Exception {
        return predator.eatMeat();
    }
}
