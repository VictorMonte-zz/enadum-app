package br.com.navi.enadumapp.models.DTO;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Danilo on 26/09/2016.
 */

public class SimuladoDTO2 {

    @SerializedName("id")
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
