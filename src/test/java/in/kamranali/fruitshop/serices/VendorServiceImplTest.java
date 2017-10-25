package in.kamranali.fruitshop.serices;

import in.kamranali.fruitshop.api.v1.mapper.VendorMapper;
import in.kamranali.fruitshop.api.v1.model.VendorDTO;
import in.kamranali.fruitshop.api.v1.model.VendorListDTO;
import in.kamranali.fruitshop.domain.Vendor;
import in.kamranali.fruitshop.repositories.VendorRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

/**
 * Created by bornshrewd on 25/10/17
 */
public class VendorServiceImplTest {

    private static final String NAME = "KAMRAN";
    private static final String NAME2 = "DAUD";

    @Mock
    VendorRepository vendorRepository;
    VendorService vendorService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        vendorService = new VendorServiceImpl(VendorMapper.INSTANCE, vendorRepository);
    }

    @Test
    public void getVendorById() throws Exception {

        Vendor vendor = getVendor1();

        given(vendorRepository.findById(Mockito.anyLong())).willReturn(Optional.of(vendor));

        VendorDTO vendorDTO = vendorService.getVendorById(1L);

        then(vendorRepository).should().findById(anyLong());
        assertThat(vendorDTO.getName(), is(equalTo(NAME)));

    }

    @Test(expected = ResourceNotFoundException.class)
    public void getVendorByIdNotFound() throws Exception {

        given(vendorRepository.findById(anyLong())).willReturn(Optional.empty());

        VendorDTO vendorDTO = vendorService.getVendorById(1L);

        then(vendorRepository).should().findById(anyLong());
    }

    @Test
    public void getAllVendors() throws Exception {

        List<Vendor> vendors = Arrays.asList(getVendor1(), getVendor2());
        given(vendorRepository.findAll()).willReturn(vendors);

        VendorListDTO vendorListDTO = vendorService.getAllVendors();

        then(vendorRepository).should().findAll();
        assertThat(vendorListDTO.getVendors().size(), is(equalTo(2)));
    }

    @Test
    public void createNewVendor() throws Exception {

        given(vendorRepository.save(Mockito.any(Vendor.class))).willReturn(getVendor1());

        VendorDTO vendorDTO1 = new VendorDTO();
        vendorDTO1.setName(NAME);

        VendorDTO vendorDTO = vendorService.createNewVendor(vendorDTO1);

        then(vendorRepository).should().save(Mockito.any(Vendor.class));
        assertThat(vendorDTO.getVendorUrl(), containsString("1"));
    }

    @Test
    public void saveVendorByDTO() throws Exception {

        given(vendorRepository.save(Mockito.any(Vendor.class))).willReturn(getVendor1());

        VendorDTO vendorDTO = new VendorDTO();
        vendorDTO.setName(NAME);

        VendorDTO savedvendorDTO = vendorService.saveVendorByDTO(1L, vendorDTO);

        then(vendorRepository).should().save(Mockito.any(Vendor.class));
        assertThat(savedvendorDTO.getVendorUrl(), containsString("1"));

    }

    @Test
    public void patchVendor() throws Exception {

        VendorDTO vendorDTO = new VendorDTO();
        vendorDTO.setName(NAME);

        Vendor vendor = getVendor1();

        given(vendorRepository.save(Mockito.any(Vendor.class))).willReturn(getVendor1());
        given(vendorRepository.findById(anyLong())).willReturn(Optional.of(vendor));

        VendorDTO savedvendorDTO = vendorService.patchVendor(1L, vendorDTO);

        then(vendorRepository).should().save(Mockito.any(Vendor.class));
        then(vendorRepository).should().findById(anyLong());
        assertThat(savedvendorDTO.getVendorUrl(), containsString("1"));
    }

    @Test
    public void deleteVendorById() throws Exception {

        vendorService.deleteVendorById(1L);
        then(vendorRepository).should().deleteById(anyLong());
    }

    private Vendor getVendor1() {

        Vendor vendor = new Vendor();
        vendor.setName(NAME);
        vendor.setId(1L);

        return vendor;
    }

    private Vendor getVendor2() {

        Vendor vendor = new Vendor();
        vendor.setName(NAME2);
        vendor.setId(1L);

        return vendor;
    }

}