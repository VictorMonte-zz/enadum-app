package br.com.navi.enadumapp.Request;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Victor on 25/09/2016.
 */

public class SimuladoRequest {

    @SerializedName("id")
    private Integer id;

    public SimuladoRequest(int id)
    {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
