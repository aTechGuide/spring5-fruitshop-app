package in.kamranali.fruitshop.serices;

import in.kamranali.fruitshop.api.v1.mapper.CategoryMapper;
import in.kamranali.fruitshop.api.v1.model.CategoryDTO;
import in.kamranali.fruitshop.repositories.CategoryRepository;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by bornshrewd on 20/10/17
 */
public class CategoryServiceImpl implements CategoryService {

    private final CategoryMapper categoryMapper;
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryMapper categoryMapper, CategoryRepository categoryRepository) {
        this.categoryMapper = categoryMapper;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<CategoryDTO> getAllCategories() {
        return categoryRepository.findAll()
                .stream()
                .map(categoryMapper::categoryToCategoryDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CategoryDTO getCategoryByName(String name) {
        return categoryMapper.categoryToCategoryDTO(categoryRepository.findByName(name));
    }
}
