package br.com.navi.enadumapp.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.LinkedList;
import java.util.List;

import br.com.navi.enadumapp.Adapter.RankingAdapter;
import br.com.navi.enadumapp.R;
import br.com.navi.enadumapp.Utils.SessionRepository;
import br.com.navi.enadumapp.models.Aluno;
import br.com.navi.enadumapp.models.DTO.AlunoRankingDTO;
import br.com.navi.enadumapp.models.Instituicao;

/**
 * Created by Victor Monte on 17/08/2016.
 */
public class FragmentRanking extends Fragment {

    public List<AlunoRankingDTO> ranking;
    public ListView lvRanking;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_ranking, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //gerarMockRanking();
        ranking =  SessionRepository.aluno.getRanking();

        lvRanking = (ListView)getView().findViewById(R.id.lvRanking);
        lvRanking.setAdapter(new RankingAdapter(getActivity(), this.ranking));
    }

//    private void gerarMockRanking() {
//        ranking = new LinkedList<Aluno>();
//        Aluno aluno = new Aluno();
//
//
//        Instituicao instituicao = new Instituicao();
//        instituicao.setNome("FIAP");
//
//        //aluno 1
//        aluno.setNome("Mitor Sermitor");
//        aluno.setInstituicao(instituicao);
//        aluno.setExperiencia(1000.0);
//        ranking.add(aluno);
//
//        //aluno 2
//        aluno = new Aluno();
//        aluno.setNome("Joao");
//        aluno.setInstituicao(instituicao);
//        aluno.setExperiencia(800.0);
//        ranking.add(aluno);
//
//        //aluno 3
//        aluno = new Aluno();
//        aluno.setNome("Oka");
//        aluno.setInstituicao(instituicao);
//        aluno.setExperiencia(750.0);
//        ranking.add(aluno);
//
//        //aluno 4
//        aluno = new Aluno();
//        aluno.setNome("Bruno");
//        aluno.setInstituicao(instituicao);
//        aluno.setExperiencia(730.0);
//        ranking.add(aluno);
//
//        //aluno 5
//        aluno = new Aluno();
//        aluno.setNome("Pedro Dubas");
//        aluno.setInstituicao(instituicao);
//        aluno.setExperiencia(520.0);
//        ranking.add(aluno);
//    }
}
