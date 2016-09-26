package br.com.navi.enadumapp.models.API;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.com.navi.enadumapp.Request.LoginRequest;
import br.com.navi.enadumapp.Request.SimuladoRequest;
import br.com.navi.enadumapp.models.Aluno;
import br.com.navi.enadumapp.models.DTO.SimuladoDTO;
import br.com.navi.enadumapp.models.SimuladoEnade;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface HttpAPI {

    String endpoint = "http://10.0.2.2:8080/";
    //String endpoint = "http://requestb.in/";

    //@POST("xp8u7xxp")
    @POST("enadumweb/services/loginAluno")
    Call<Aluno> getAluno(@Body LoginRequest loginRequest);

    @POST("enadumweb/services/resultadoEnade")
    Call<Aluno> postResultado(@Body SimuladoDTO simuladoDTO);

    @GET("enadumweb/services/buscaSimulado")
    Call<SimuladoEnade> getSimuladoEnade(@Query("id") int id);

    Gson gson = new GsonBuilder()
            .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
            .create();

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(endpoint)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build();
}
