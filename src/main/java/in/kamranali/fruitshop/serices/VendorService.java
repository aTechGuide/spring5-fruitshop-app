package in.kamranali.fruitshop.serices;

import in.kamranali.fruitshop.api.v1.model.VendorDTO;
import in.kamranali.fruitshop.api.v1.model.VendorListDTO;

/**
 * Created by bornshrewd on 25/10/17
 */
public interface VendorService {

    VendorDTO getVendorById(Long id);

    VendorListDTO getAllVendors();

    VendorDTO createNewVendor(VendorDTO vendorDTO);

    VendorDTO saveVendorByDTO(Long id, VendorDTO vendorDTO);

    VendorDTO patchVendor(Long id, VendorDTO vendorDTO);

    void deleteVendorById(Long id);
}
