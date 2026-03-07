package in.cg.service;

import java.util.List;

import in.cg.dto.FoodItemDTO;
import in.cg.entity.FoodItem;

public interface FoodItemService {

    FoodItem addFoodItem(Long restaurantId, FoodItemDTO dto);

    List<FoodItem> getFoodItemsByRestaurant(Long restaurantId);

}