package in.cg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import in.cg.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

}