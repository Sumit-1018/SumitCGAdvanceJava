package in.cg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import in.cg.dto.RestaurantDTO;
import in.cg.entity.Restaurant;
import in.cg.service.RestaurantService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/restaurants")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public Restaurant addRestaurant(@Valid @RequestBody RestaurantDTO dto) {

        return restaurantService.addRestaurant(dto);
    }

    @GetMapping
    public Page<Restaurant> getRestaurants(
            @RequestParam int page,
            @RequestParam int size) {

        return restaurantService.getRestaurants(PageRequest.of(page, size));
    }
}