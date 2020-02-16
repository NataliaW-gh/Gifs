package pl.natalia.gifs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GifsController {

    @GetMapping("/")
    @ResponseBody
    public  String sayHello(){
        return "działa";
    }
}
