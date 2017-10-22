package in.kamranali.fruitshop.controllers.v1;

import in.kamranali.fruitshop.api.v1.model.CustomerDTO;
import in.kamranali.fruitshop.serices.CustomerService;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static in.kamranali.fruitshop.controllers.v1.AbstractRestControllerTest.asJsonString;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by bornshrewd on 20/10/17
 */
public class CustomerControllerTest {

    public static final String KAMRAN = "kamran";
    public static final String ALI = "Ali";

    @Mock
    CustomerService customerService;

    @InjectMocks
    CustomerController customerController;

    MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);

        mockMvc = MockMvcBuilders.standaloneSetup(customerController).build();
    }

    @Test
    public void getListOfCustomers() throws Exception {

        List<CustomerDTO> customerDTOS = Arrays.asList(new CustomerDTO(), new CustomerDTO(), new CustomerDTO());

        when(customerService.getAllCustomers()).thenReturn(customerDTOS);

        mockMvc.perform(get("/api/v1/customers/")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.customers", Matchers.hasSize(3)));
    }

    @Test
    public void getCustomerById() throws Exception {

        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setFirstname(KAMRAN);

        when(customerService.getCustomerById(Mockito.anyLong())).thenReturn(customerDTO);

        mockMvc.perform(get("/api/v1/customers/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstname", equalTo("kamran")));
    }

    @Test
    public void createNewCustomer() throws Exception {

        CustomerDTO customer = new CustomerDTO();
        customer.setFirstname(KAMRAN);
        customer.setLastname("Ali");

        CustomerDTO returnDTO = new CustomerDTO();
        returnDTO.setFirstname(customer.getFirstname());
        returnDTO.setLastname(customer.getLastname());
        returnDTO.setCustomerUrl("/api/v1/customers/1");

        when(customerService.createNewCustomer(customer)).thenReturn(returnDTO);

        mockMvc.perform(post("/api/v1/customers/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(customer)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.firstname", equalTo(KAMRAN)))
                .andExpect(jsonPath("$.customer_url", equalTo("/api/v1/customers/1")));

    }

    @Test
    public void createUpdateCustomer() throws Exception {

        CustomerDTO customer = new CustomerDTO();
        customer.setFirstname(KAMRAN);
        customer.setLastname(ALI);

        CustomerDTO returnDTO = new CustomerDTO();
        returnDTO.setFirstname(customer.getFirstname());
        returnDTO.setLastname(customer.getLastname());
        returnDTO.setCustomerUrl("/api/v1/customers/1");

        when(customerService.saveCustomerByDTO(Mockito.anyLong(), Mockito.any(CustomerDTO.class))).thenReturn(returnDTO);

        mockMvc.perform(put("/api/v1/customers/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(customer)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstname", equalTo(KAMRAN)))
                .andExpect(jsonPath("$.customer_url", equalTo("/api/v1/customers/1")));

    }

    @Test
    public void patchCustomer() throws Exception {

        CustomerDTO customer = new CustomerDTO();
        customer.setFirstname(KAMRAN);

        CustomerDTO returnDTO = new CustomerDTO();
        returnDTO.setFirstname(customer.getFirstname());
        returnDTO.setLastname("Ali");
        returnDTO.setCustomerUrl("/api/v1/customers/1");

        when(customerService.patchCustomer(Mockito.anyLong(), Mockito.any(CustomerDTO.class))).thenReturn(returnDTO);

        mockMvc.perform(patch("/api/v1/customers/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(customer)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstname", equalTo(KAMRAN)))
                .andExpect(jsonPath("$.customer_url", equalTo("/api/v1/customers/1")));

    }

    @Test
    public void deleteCustomer() throws Exception {

        mockMvc.perform(delete("/api/v1/customers/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        verify(customerService).deleteCustomerById(anyLong());

    }
}