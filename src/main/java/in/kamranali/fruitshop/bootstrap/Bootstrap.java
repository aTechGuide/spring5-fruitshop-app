package in.kamranali.fruitshop.bootstrap;

import in.kamranali.fruitshop.domain.Category;
import in.kamranali.fruitshop.domain.Customer;
import in.kamranali.fruitshop.domain.Vendor;
import in.kamranali.fruitshop.repositories.CategoryRepository;
import in.kamranali.fruitshop.repositories.CustomerRepository;
import in.kamranali.fruitshop.repositories.VendorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Created by bornshrewd on 19/10/17
 */
@Component
public class Bootstrap implements CommandLineRunner{

    private CategoryRepository categoryRepository;
    private CustomerRepository customerRepository;
    private VendorRepository vendorRepository;

    public Bootstrap(CategoryRepository categoryRepository, CustomerRepository customerRepository, VendorRepository vendorRepository) {
        this.categoryRepository = categoryRepository;
        this.customerRepository = customerRepository;
        this.vendorRepository = vendorRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        loadCategories();
        loadCustomers();
        loadVendors();
    }

    private void loadVendors() {

        Vendor vendor = new Vendor();
        vendor.setName("KAMRAN");
        vendorRepository.save(vendor);

        Vendor vendor1 = new Vendor();
        vendor1.setName("DAUD");
        vendorRepository.save(vendor1);
    }

    private void loadCustomers() {

        Customer customer1 = new Customer();
        customer1.setId(1L);
        customer1.setFirstname("Kamran");
        customer1.setLastname("Ali");
        customerRepository.save(customer1);

        Customer customer2 = new Customer();
        customer2.setId(2L);
        customer2.setFirstname("Daud");
        customer2.setLastname("Ali");
        customerRepository.save(customer2);
    }

    private void loadCategories() {
        Category fruits = new Category();
        fruits.setName("Fruits");

        Category dried = new Category();
        dried.setName("Dried");

        Category fresh = new Category();
        fresh.setName("Fresh");

        Category exotic = new Category();
        exotic.setName("Exotic");

        Category nuts = new Category();
        nuts.setName("Nuts");

        categoryRepository.save(fruits);
        categoryRepository.save(dried);
        categoryRepository.save(fresh);
        categoryRepository.save(exotic);
        categoryRepository.save(nuts);
    }
}
