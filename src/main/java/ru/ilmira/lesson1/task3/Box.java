package ru.ilmira.lesson1.task3;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit> {
    private final List<T> box = new ArrayList<>();

    public List<T> getBox() {
        return box;
    }

    public float getWeight() {
        float res = 0.0f;
        for (T w: box) {
            res += w.getWeight();
        }
        return res;
    }

    public boolean compare(Box <?> box) {
        return Math.abs(this.getWeight() - box.getWeight()) < 0.00001;
    }

    public void addFruit(T fruit) {
        box.add(fruit);
    }
    public void addFruits(T[] fruits) {
        for (T fruit : fruits) {
            addFruit(fruit);
        }
    }

    public void passToBox(Box<T> anotherBox) {
        anotherBox.getBox().addAll(this.box);
        this.box.clear();
    }

}
