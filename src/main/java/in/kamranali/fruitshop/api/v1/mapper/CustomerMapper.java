package in.kamranali.fruitshop.api.v1.mapper;

import in.kamranali.fruitshop.api.v1.model.CustomerDTO;
import in.kamranali.fruitshop.domain.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Created by bornshrewd on 20/10/17
 */
@Mapper
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);
    CustomerDTO customerToCustomerDTO(Customer customer);
}
