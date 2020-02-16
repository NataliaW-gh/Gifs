package pl.natalia.gifs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.natalia.gifs.repository.GifRepository;

@Controller
public class GifController {

   // @Autowired
   // GifRepository gifRepository;

    final GifRepository gifRepository;

    public GifController(GifRepository gifRepository){
        this.gifRepository = gifRepository;
    }

    @GetMapping("/")
    @ResponseBody
    public  String sayHello(){
        return "działa";
    }

    @GetMapping("/showgifsinbrowser")
    @ResponseBody
    public String showGifNames(){
        return gifRepository.getGifNames();
    }


}
