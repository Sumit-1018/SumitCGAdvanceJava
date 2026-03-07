package in.cg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import in.cg.dto.FoodItemDTO;
import in.cg.entity.FoodItem;
import in.cg.service.FoodItemService;

@RestController
@RequestMapping("/api/restaurants")
public class FoodItemController {

    @Autowired
    private FoodItemService foodItemService;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/{restaurantId}/fooditems")
    public FoodItem addFoodItem(
            @PathVariable Long restaurantId,
            @RequestBody FoodItemDTO dto) {

        return foodItemService.addFoodItem(restaurantId, dto);
    }

    @GetMapping("/{restaurantId}/fooditems")
    public List<FoodItem> getFoodItems(@PathVariable Long restaurantId) {

        return foodItemService.getFoodItemsByRestaurant(restaurantId);
    }
}