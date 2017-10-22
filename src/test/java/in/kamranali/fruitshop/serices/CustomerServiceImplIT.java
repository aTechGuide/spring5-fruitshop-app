package in.kamranali.fruitshop.serices;

import com.sun.org.apache.xalan.internal.xsltc.dom.SortingIterator;
import in.kamranali.fruitshop.api.v1.mapper.CustomerMapper;
import in.kamranali.fruitshop.api.v1.model.CustomerDTO;
import in.kamranali.fruitshop.bootstrap.Bootstrap;
import in.kamranali.fruitshop.domain.Customer;
import in.kamranali.fruitshop.repositories.CategoryRepository;
import in.kamranali.fruitshop.repositories.CustomerRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

/**
 * Created by bornshrewd on 22/10/17
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class CustomerServiceImplIT {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CategoryRepository categoryRepository;

    CustomerService customerService;

    @Before
    public void setUp() throws Exception {

        Bootstrap bootstrap = new Bootstrap(categoryRepository, customerRepository);
        bootstrap.run();

        customerService = new CustomerServiceImpl(CustomerMapper.INSTANCE, customerRepository);
    }

    @Test
    public void pathCustomerUpdateFirstName() throws Exception {

        String updatedName = "UpdatedName";
        Long id = getCustomerIdValue();

        Customer originalCustomer = customerRepository.getOne(id);
        String originalFirstName = originalCustomer.getFirstname();
        String originalLastName = originalCustomer.getLastname();

        assertNotNull(originalCustomer);

        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setFirstname(updatedName);

        customerService.patchCustomer(id, customerDTO);
        Customer updatedCustomer = customerRepository.findById(id).get();

        assertNotNull(updatedCustomer);
        assertEquals(updatedName, updatedCustomer.getFirstname());
        assertThat(originalFirstName, not(equalTo(updatedCustomer.getFirstname())));
        assertThat(originalLastName, equalTo(updatedCustomer.getLastname()));
    }

    private Long getCustomerIdValue() {

        return customerRepository.findAll().get(0).getId();
    }
}
