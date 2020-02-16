package pl.natalia.gifs.repository;

import org.springframework.stereotype.Repository;
import pl.natalia.gifs.model.Gif;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Repository

public class GifRepository {

    private  static List<Gif> ALL_GIF = Arrays.asList(
            new Gif ("android-explosion", "mols", true,1),
            new Gif ("ben-and-mike", "mika", true,2),
            new Gif ("book-dominos", "mem", true,0),
            new Gif ("compiler-bot", "bot", true,1),
            new Gif ("cowboy-coder", "code", true,1),
            new Gif ("infinite-andrew", "andrew", false,2)
    );

    public List<Gif> getGifs(){
        return ALL_GIF;
    }


    public String getGifNames(){
        String result ="";
        for (Gif gif: ALL_GIF){
            result+=gif.getName();
        }
        return  result;
    }

    //przy pomocy strumienia
    public List<Gif> getFavoritesGifs(){
        return ALL_GIF.stream()
                .filter(Gif::getFavorite)
                .collect(Collectors.toList());

    // 2 sposób
    /*
    List<Gif> favorites = new ArrayList<>();
    for(Gif allGif:ALL_GIFS)

    {
        if (allGif.getFavorite()) {
            favorites.add(allGif);
        }
    }
    return favorites;
    */

    }


}
