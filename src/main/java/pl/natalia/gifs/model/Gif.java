package pl.natalia.gifs.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
// @AllArgsConstructor - 2 sposób na konstruktor (wszystko argumentowy) przy użyciu adnotacji
public class Gif {

    private String name;
    private String userName;
    private Boolean favorite;
    private int categoryId;

    public Gif(String name, String userName, Boolean favorite, int categoryId) {
        this.name = name;
        this.userName = userName;
        this.favorite = favorite;
        this.categoryId = categoryId;
    }
}
