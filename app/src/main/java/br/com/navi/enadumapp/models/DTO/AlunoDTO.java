package br.com.navi.enadumapp.models.DTO;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Danilo on 19/09/2016.
 */

public class AlunoDTO {

    @SerializedName("id")
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
