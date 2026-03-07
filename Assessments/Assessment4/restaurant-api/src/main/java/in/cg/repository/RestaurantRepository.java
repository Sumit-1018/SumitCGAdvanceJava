package in.cg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import in.cg.entity.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

}