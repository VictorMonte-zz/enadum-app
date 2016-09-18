package br.com.navi.enadumapp.models.API;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.com.navi.enadumapp.Request.LoginRequest;
import br.com.navi.enadumapp.models.Aluno;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by Danilo on 17/09/2016.
 */

public interface HttpAPI {

    String endpoint = "http://10.0.2.2:8080/";
    //String endpoint = "http://requestb.in/";

    //@POST("xp8u7xxp")
    @POST("enadumweb/services/login")
    Call<Aluno> getAluno(@Body LoginRequest loginRequest);

    Gson gson = new GsonBuilder()
            .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
            .create();

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(endpoint)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build();
}
