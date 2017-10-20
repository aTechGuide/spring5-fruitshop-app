package in.kamranali.fruitshop.serices;

import in.kamranali.fruitshop.api.v1.model.CategoryDTO;

import java.util.List;

/**
 * Created by bornshrewd on 20/10/17
 */
public interface CategoryService {
    List<CategoryDTO> getAllCategories();

    CategoryDTO getCategoryByName(String name);

}
