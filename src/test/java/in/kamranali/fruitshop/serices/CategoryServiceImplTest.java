package in.kamranali.fruitshop.serices;

import in.kamranali.fruitshop.api.v1.mapper.CategoryMapper;
import in.kamranali.fruitshop.api.v1.model.CategoryDTO;
import in.kamranali.fruitshop.domain.Category;
import in.kamranali.fruitshop.repositories.CategoryRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by bornshrewd on 20/10/17
 */
public class CategoryServiceImplTest {

    CategoryService categoryService;

    @Mock
    CategoryRepository categoryRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        categoryService = new CategoryServiceImpl(CategoryMapper.INSTANCE, categoryRepository);
    }

    @Test
    public void getAllCategories() throws Exception {

        List<Category> categories = Arrays.asList(new Category(), new Category(), new Category());
        Mockito.when(categoryRepository.findAll()).thenReturn(categories);

        List<CategoryDTO> categoryDTOS = categoryService.getAllCategories();

        assertEquals(3, categoryDTOS.size());
    }

    @Test
    public void getCategoryByName() throws Exception {

        String kamran = "Kamran";
        
        Category category = new Category();
        category.setId(1L);

        category.setName(kamran);

        Mockito.when(categoryRepository.findByName(Mockito.anyString())).thenReturn(category);

        CategoryDTO categoryDTO = categoryService.getCategoryByName(kamran);

        assertEquals(Long.valueOf(1L), categoryDTO.getId());
        assertEquals(kamran, categoryDTO.getName());
    }

}