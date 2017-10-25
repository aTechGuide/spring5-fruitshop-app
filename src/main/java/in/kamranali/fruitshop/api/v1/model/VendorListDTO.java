package in.kamranali.fruitshop.api.v1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by bornshrewd on 22/10/17
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VendorListDTO {

    List<VendorDTO> vendors;
}
