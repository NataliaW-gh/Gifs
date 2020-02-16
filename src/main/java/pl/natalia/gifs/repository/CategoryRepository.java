package pl.natalia.gifs.repository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.natalia.gifs.model.Category;
import pl.natalia.gifs.model.Gif;

import java.util.Arrays;
import java.util.List;

@Repository
public class CategoryRepository {

    private static final List<Category> ALL_CATEGORIES = Arrays.asList(
        new Category(0, "funny"),
        new Category(1, "sport"),
        new Category(2, "it")

    );

    public List<Category> getAllCategories(){
        return ALL_CATEGORIES;
    }

    public Category getCategoryById(int id){
        for (Category c : ALL_CATEGORIES)
            if(c.getId() == (id)){
            return c;
        }

        return null;
    }





}
