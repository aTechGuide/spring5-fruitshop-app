package in.kamranali.fruitshop.repositories;

import in.kamranali.fruitshop.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by bornshrewd on 20/10/17
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
