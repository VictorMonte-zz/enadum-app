package br.com.navi.enadumapp.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.List;

import br.com.navi.enadumapp.Adapter.RankingAdapter;
import br.com.navi.enadumapp.R;
import br.com.navi.enadumapp.models.Aluno;

/**
 * Created by Victor Monte on 17/08/2016.
 */
public class FragmentRanking extends Fragment {

    public List<Aluno> ranking;
    public ListView lvRanking;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_ranking, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

//        gerarMockRanking();

        lvRanking = (ListView)getView().findViewById(R.id.lvRanking);
        lvRanking.setAdapter(new RankingAdapter(getActivity(), this.ranking));
    }

//    private void gerarMockRanking() {
//        ranking = new ArrayList<Aluno>();
//        Aluno aluno = new Aluno();
//
//        //aluno 1
//        aluno.setNome("Mitor Sermitor");
//        aluno.setInstituicao("FIAP");
//        aluno.setPontuacao(1000);
//        ranking.add(aluno);
//
//        //aluno 2
//        aluno = new Aluno();
//        aluno.setNome("Joao");
//        aluno.setInstituicao("FIAP");
//        aluno.setPontuacao(800);
//        ranking.add(aluno);
//
//        //aluno 3
//        aluno = new Aluno();
//        aluno.setNome("Oka");
//        aluno.setInstituicao("FIAP");
//        aluno.setPontuacao(750);
//        ranking.add(aluno);
//
//        //aluno 4
//        aluno = new Aluno();
//        aluno.setNome("Bruno");
//        aluno.setInstituicao("FIAP");
//        aluno.setPontuacao(730);
//        ranking.add(aluno);
//
//        //aluno 5
//        aluno = new Aluno();
//        aluno.setNome("Pedro Dubas");
//        aluno.setInstituicao("FIAP");
//        aluno.setPontuacao(520);
//        ranking.add(aluno);
//    }
}
