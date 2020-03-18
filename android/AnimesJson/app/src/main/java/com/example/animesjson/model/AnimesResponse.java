
package com.example.animesjson.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class AnimesResponse {

    @SerializedName("Animes")
    private List<Anime> animes;

    public List<Anime> getAnimes() {
        return animes;
    }

    public void setAnimes(List<Anime> animes) {
        this.animes = animes;
    }

}
