package in.kamranali.fruitshop.serices;

import in.kamranali.fruitshop.api.v1.mapper.CustomerMapper;
import in.kamranali.fruitshop.api.v1.model.CustomerDTO;
import in.kamranali.fruitshop.domain.Customer;
import in.kamranali.fruitshop.repositories.CustomerRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

/**
 * Created by bornshrewd on 20/10/17
 */
public class CustomerServiceImplTest {

    public static final String KAMRAN = "Kamran";

    @Mock
    CustomerRepository customerRepository;

    CustomerMapper customerMapper = CustomerMapper.INSTANCE;

    CustomerService customerService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        customerService = new CustomerServiceImpl(customerMapper, customerRepository);
    }

    @Test
    public void getAllCustomers() throws Exception {

        List<Customer> customers = Arrays.asList(new Customer(), new Customer(), new Customer());
        Mockito.when(customerRepository.findAll()).thenReturn(customers);

        List<CustomerDTO> categoryDTOS = customerService.getAllCustomers();

        assertEquals(3, categoryDTOS.size());
    }

    @Test
    public void getCustomerById() throws Exception {

        Customer customer = new Customer();
        customer.setId(1L);
        customer.setFirstname(KAMRAN);

        Mockito.when(customerRepository.findById(Mockito.anyLong())).thenReturn(Optional.ofNullable(customer));

        CustomerDTO customerDTO = customerService.getCustomerById(1L);

        assertEquals(KAMRAN, customerDTO.getFirstname());
    }

    @Test
    public void createNewCustomer() throws Exception {

        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setFirstname(KAMRAN);

        Customer customer = new Customer();
        customer.setFirstname(customerDTO.getFirstname());
        customer.setId(1L);

        Mockito.when(customerRepository.save(Mockito.any(Customer.class))).thenReturn(customer);

        CustomerDTO savedDTO = customerService.createNewCustomer(customerDTO);

        assertEquals(customerDTO.getFirstname(), savedDTO.getFirstname());
        assertEquals("/api/v1/customer/1", savedDTO.getCustomerUrl());
    }

    @Test
    public void saveCustomerByDTO() throws Exception {

        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setFirstname(KAMRAN);

        Customer customer = new Customer();
        customer.setFirstname(customerDTO.getFirstname());
        customer.setId(1L);

        Mockito.when(customerRepository.save(Mockito.any(Customer.class))).thenReturn(customer);

        CustomerDTO savedDTO = customerService.saveCustomerByDTO(1L, customerDTO);

        assertEquals(customerDTO.getFirstname(), savedDTO.getFirstname());
        assertEquals("/api/v1/customer/1", savedDTO.getCustomerUrl());
    }

}