package in.kamranali.fruitshop.api.v1.mapper;

import in.kamranali.fruitshop.api.v1.model.VendorDTO;
import in.kamranali.fruitshop.domain.Vendor;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Created by bornshrewd on 22/10/17
 */
@Mapper
public interface VendorMapper {

    VendorMapper INSTANCE = Mappers.getMapper(VendorMapper.class);
    VendorDTO vendorToVendorDTO(Vendor vendor);
    Vendor vendorDTOToVendor(VendorDTO vendorDTO);
}
