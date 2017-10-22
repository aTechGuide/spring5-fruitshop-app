package in.kamranali.fruitshop.serices;

import in.kamranali.fruitshop.api.v1.model.CustomerDTO;
import in.kamranali.fruitshop.domain.Customer;

import java.util.List;

/**
 * Created by bornshrewd on 20/10/17
 */
public interface CustomerService {

    List<CustomerDTO> getAllCustomers();

    CustomerDTO getCustomerById(Long id);

    CustomerDTO createNewCustomer(CustomerDTO customerDTO);

    CustomerDTO saveCustomerByDTO(Long id, CustomerDTO customerDTO);

    CustomerDTO patchCustomer(Long id, CustomerDTO customerDTO);

    void deleteCustomerById(Long id);
}
