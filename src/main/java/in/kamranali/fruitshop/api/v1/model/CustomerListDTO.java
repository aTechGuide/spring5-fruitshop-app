package in.kamranali.fruitshop.api.v1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by bornshrewd on 20/10/17
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerListDTO {

    List<CustomerDTO> customers;
}
