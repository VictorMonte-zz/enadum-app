package br.com.navi.enadumapp;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import br.com.navi.enadumapp.Fragment.FragmentQuestao;

/**
 * Created by Danilo on 28/08/2016.
 */
public class SimuladoActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simulado);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.questoes_view,new FragmentQuestao());
        transaction.commit();

    }



}
