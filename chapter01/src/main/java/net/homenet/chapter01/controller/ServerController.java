package net.homenet.chapter01.controller;

import net.homenet.chapter01.domain.Dish;
import net.homenet.chapter01.service.KitchenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ServerController {

    private final KitchenService kitchenService;

    @Autowired
    public ServerController(KitchenService kitchenService) {
        this.kitchenService = kitchenService;
    }

    @GetMapping("/server")
    public List<Dish> serveDishes() {
        return kitchenService.getDishes();
    }

    @GetMapping("/served-dishes")
    public List<Dish> deliverDishes() {
        return kitchenService.getDishes().stream()
            .map(Dish::deliver)
            .collect(Collectors.toList());
    }

}
