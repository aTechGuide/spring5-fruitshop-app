package in.kamranali.fruitshop.repositories;

import in.kamranali.fruitshop.domain.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by bornshrewd on 22/10/17
 */
public interface VendorRepository extends JpaRepository<Vendor, Long> {
}
