package br.com.navi.enadumapp.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.LinkedList;
import java.util.List;

import br.com.navi.enadumapp.R;
import br.com.navi.enadumapp.Utils.SessionRepository;
import br.com.navi.enadumapp.models.Aluno;
import br.com.navi.enadumapp.models.Curso;

/**
 * Created by Victor Monte on 17/08/2016.
 */
public class FragmentSimulados extends Fragment {

    private ListView listViewDisciplinas;
    Aluno aluno;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View layoutSimulados = inflater.inflate(R.layout.fragment_simulados,container,false);

        this.listViewDisciplinas = (ListView) layoutSimulados.findViewById(R.id.lista_simulados_listview);

        aluno = SessionRepository.aluno;

        List<Curso> cursos = new LinkedList<Curso>(aluno.getCursos());

        this.listViewDisciplinas.setAdapter(new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, cursos));

//        this.listViewDisciplinas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Disciplina selecionada  = (Disciplina) adapterView.getItemAtPosition(i);
//
//                Intent fazerSimulado  = new Intent(getActivity(), SimuladoActivity.class);
//                startActivity(fazerSimulado);
//            }
//        });

        return layoutSimulados;
    }

}
