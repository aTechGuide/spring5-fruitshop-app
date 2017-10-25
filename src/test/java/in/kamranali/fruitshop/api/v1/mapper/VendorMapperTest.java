package in.kamranali.fruitshop.api.v1.mapper;

import in.kamranali.fruitshop.api.v1.model.VendorDTO;
import in.kamranali.fruitshop.domain.Vendor;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by bornshrewd on 22/10/17
 */
public class VendorMapperTest {

    public static final String KAMRAN = "KAMRAN";
    VendorMapper vendorMapper = VendorMapper.INSTANCE;

    @Test
    public void vendorToVendorDTO() throws Exception {

        Vendor vendor = new Vendor();
        vendor.setName(KAMRAN);

        VendorDTO vendorDTO = vendorMapper.vendorToVendorDTO(vendor);

        assertEquals(vendor.getName(), vendorDTO.getName());
    }

    @Test
    public void vendorDTOToVendor() throws Exception {

        VendorDTO vendorDTO = new VendorDTO();
        vendorDTO.setName(KAMRAN);

        Vendor vendor = vendorMapper.vendorDTOToVendor(vendorDTO);

        assertEquals(vendorDTO.getName(), vendor.getName());
    }

}