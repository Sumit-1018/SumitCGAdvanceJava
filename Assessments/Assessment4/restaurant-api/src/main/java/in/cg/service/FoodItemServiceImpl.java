package in.cg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.cg.dto.FoodItemDTO;
import in.cg.entity.FoodItem;
import in.cg.repository.FoodItemRepository;

@Service
public class FoodItemServiceImpl implements FoodItemService {

    @Autowired
    private FoodItemRepository foodItemRepository;

    @Override
    public FoodItem addFoodItem(Long restaurantId, FoodItemDTO dto) {

        FoodItem foodItem = new FoodItem();

        foodItem.setName(dto.getName());
        foodItem.setPrice(dto.getPrice());
        foodItem.setCategory(dto.getCategory());
        foodItem.setRestaurantId(restaurantId);

        return foodItemRepository.save(foodItem);
    }

    @Override
    public List<FoodItem> getFoodItemsByRestaurant(Long restaurantId) {
        return foodItemRepository.findByRestaurantId(restaurantId);
    }
}