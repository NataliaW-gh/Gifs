package pl.natalia.gifs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pl.natalia.gifs.model.Category;
import pl.natalia.gifs.model.Gif;
import pl.natalia.gifs.repository.CategoryRepository;
import pl.natalia.gifs.repository.GifRepository;

import java.util.List;


@Controller
public class CategoryController {

    final CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    @Autowired
    GifRepository gifRepository;

    @GetMapping("/categories")
    public String gifCategories(ModelMap modelMap){
        //1. Pobranie wszystkich kategorii
        List<Category> categoryList = categoryRepository.getAllCategories();
        //2. Przekazanie obiektów do widoku
        modelMap.put("categories",categoryList);
        //3. Wyswietlenie widoku
        return "categories";
    }

    @GetMapping("/category/{id}")
    public String gifsCategory(@PathVariable int id, ModelMap modelMap){
        //1. Pobranie kategorii po id
            Category category = categoryRepository.getCategoryById(id);
        // 1.2 Pobieranie gifów z id danej kategorii
            List<Gif> gifs = gifRepository.getGifsByCategoryId(id);
        //2 Przekazanie do widoku
        modelMap.put("category", category);
        modelMap.put("gifs", gifs);
        //3. Zwocenie widoku
        return "category";
    }
}
