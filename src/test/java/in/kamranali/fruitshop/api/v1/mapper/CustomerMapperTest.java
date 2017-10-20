package in.kamranali.fruitshop.api.v1.mapper;

import in.kamranali.fruitshop.api.v1.model.CategoryDTO;
import in.kamranali.fruitshop.api.v1.model.CustomerDTO;
import in.kamranali.fruitshop.domain.Customer;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by bornshrewd on 20/10/17
 */
public class CustomerMapperTest {

    CustomerMapper customerMapper = CustomerMapper.INSTANCE;

    @Test
    public void customerToCustomerDTO() throws Exception {

        Customer customer = new Customer();
        customer.setFirstname("Kamran");
        customer.setLastname("Ali");

        CustomerDTO customerDTO = customerMapper.customerToCustomerDTO(customer);

        assertEquals(customer.getFirstname(), customerDTO.getFirstname());
        assertEquals(customer.getLastname(), customerDTO.getLastname());
    }

}