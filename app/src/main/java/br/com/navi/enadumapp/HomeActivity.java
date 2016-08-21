package br.com.navi.enadumapp;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import br.com.navi.enadumapp.Adapter.FragmentPageAdapter;
import br.com.navi.enadumapp.Model.Aluno;
import br.com.navi.enadumapp.Utils.SessionRepository;

public class HomeActivity extends AppCompatActivity {

    private Aluno aluno;
    private TabLayout tab;
    private ViewPager view;
    private TextView lblAluno;
    private TextView lblCurso;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //Obtem componentes
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tab = (TabLayout) findViewById(R.id.tab_principal);
        view = (ViewPager) findViewById(R.id.view_pager);
        lblAluno = (TextView) findViewById(R.id.lblAluno);
        lblCurso = (TextView) findViewById(R.id.lblCurso);

        setSupportActionBar(toolbar);

        //Configura as tabs
        view.setAdapter(new FragmentPageAdapter(getSupportFragmentManager(), getResources().getStringArray(R.array.titulos_tab)));

        //Configura a view
        tab.setupWithViewPager(view);

        //Obtem os dados do aluno
        //aluno = SessionRepository.aluno;
        //APENAS PARA TESTES - REMOVER
        aluno = new Aluno("69254","44261175851","FIAP");
        aluno.setNome("Victor Monte");
        aluno.setCurso("Sistemas de Informação");

        //Valida usuario
        if (aluno == null) {
            // Construtor de Mensagem
            AlertDialog.Builder builder = new AlertDialog.Builder(HomeActivity.this);
            builder.setMessage("Usuário invalido!")
                    .setCancelable(false)
                    .setPositiveButton("Ok", new DialogInterface.OnClickListener(){

                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.cancel();
                        }
                    });

            //Mensagem
            AlertDialog alert = builder.create();
            alert.setTitle("Enadum Informa");
            alert.show();
        }
        else{
            //Mostra os dados do aluno
            lblAluno.setText("Bem vindo, " + aluno.getNome());
            lblCurso.setText(aluno.getCurso());

            FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Snackbar.make(view, "MITOR SERMITOR", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            });
        }


    }

}
