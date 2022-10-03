package net.homenet.chapter01.service;

import net.homenet.chapter01.domain.Dish;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Service
public class KitchenService {

    private final Random picker = new Random();

    private final List<Dish> menu = Arrays.asList(
        new Dish("Sesame chicken"),
        new Dish("Lo mein noddles, plain"),
        new Dish("Sweet & sour beef")
    );

    public List<Dish> getDishes() {
        //noinspection ArraysAsListWithZeroOrOneArgument
        return Arrays.asList(randomDish());
    }

    private Dish randomDish() {
        return menu.get(picker.nextInt(menu.size()));
    }

}
