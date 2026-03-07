package in.cg.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import in.cg.dto.RestaurantDTO;
import in.cg.entity.Restaurant;

public interface RestaurantService {

    Restaurant addRestaurant(RestaurantDTO dto);

    Page<Restaurant> getRestaurants(Pageable pageable);

}