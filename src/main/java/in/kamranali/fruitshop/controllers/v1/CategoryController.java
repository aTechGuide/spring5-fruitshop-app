package in.kamranali.fruitshop.controllers.v1;

import in.kamranali.fruitshop.api.v1.model.CategoryDTO;
import in.kamranali.fruitshop.api.v1.model.CategoryListDTO;
import in.kamranali.fruitshop.serices.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by bornshrewd on 20/10/17
 */
@RestController
@RequestMapping(CategoryController.BASE_URL)
public class CategoryController {

    public static final String BASE_URL = "/api/v1/categories/";
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public CategoryListDTO getallCategories(){

        return new CategoryListDTO(categoryService.getAllCategories());
    }

    @GetMapping("{name}")
    @ResponseStatus(HttpStatus.OK)
    public CategoryDTO getCategoryByName(@PathVariable String name){

        return categoryService.getCategoryByName(name);
    }
}
