package in.kamranali.fruitshop.repositories;

import in.kamranali.fruitshop.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by bornshrewd on 19/10/17
 */
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
