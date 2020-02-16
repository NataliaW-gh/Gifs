package pl.natalia.gifs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import pl.natalia.gifs.model.Category;
import pl.natalia.gifs.repository.CategoryRepository;
import pl.natalia.gifs.repository.GifRepository;

import java.util.List;


@Controller
public class CategoryController {

    final CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }


    @GetMapping("/categories")
    public String gifCategories(ModelMap modelMap){
        //1. Pobranie wszystkich kategorii
        List<Category> categoryList = categoryRepository.getAllCategories();
        //2. Przekazanie obiektów do widoku
        modelMap.put("categories",categoryList);
        //3. Wyswietlenie widoku
        return "categories";
    }
}
