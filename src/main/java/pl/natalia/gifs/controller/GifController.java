package pl.natalia.gifs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.natalia.gifs.model.Gif;
import pl.natalia.gifs.repository.GifRepository;

import java.util.List;

@Controller
public class GifController {

   // @Autowired
   // GifRepository gifRepository;

    final GifRepository gifRepository;

    public GifController(GifRepository gifRepository){
        this.gifRepository = gifRepository;
    }

    @GetMapping("/")
    // @ResponseBody - to juz nam nie potrzebne bo mamy plik html
    public  String sayHello(ModelMap modelMap){
        //1. krok pracy z thymeleaf Wyciągnięcie gifów
        List<Gif> gifsList = gifRepository.getGifs();

        //2. Przekazanie do view
        modelMap.put("gifs", gifsList);

        //2. Zwrocennie widoku
        return "home";
    }

    @GetMapping("/showgifsinbrowser")
    @ResponseBody
    public String showGifNames(){
        return gifRepository.getGifNames();
    }

    @GetMapping("/favorites")
    public String favoritesGif(ModelMap modelMap){
        //1.wyciagniecie wartosci
        List<Gif> favoritesGifs = gifRepository.getFavoritesGifs();

        //2.przekazanie do view
        modelMap.put("gifs", favoritesGifs);

        //3.zwrocenie widoku
        return "favorites";

    }

    @GetMapping("gif/{name}") // w wasach bo zmienna z @PathVariable
    public  String getGifByName(@PathVariable String name, ModelMap modelMap){
        //1.wyciagniecie wartosci
        Gif g = gifRepository.getGifByName(name);

        //2.przekazanie do view
        modelMap.put("gif", g);

        //3.zwrocenie widoku
        return "gif-details";

    }

}
