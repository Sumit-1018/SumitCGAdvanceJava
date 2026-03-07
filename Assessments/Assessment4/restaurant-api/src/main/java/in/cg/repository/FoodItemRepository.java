package in.cg.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import in.cg.entity.FoodItem;

public interface FoodItemRepository extends JpaRepository<FoodItem, Long> {

    List<FoodItem> findByRestaurantId(Long restaurantId);

}