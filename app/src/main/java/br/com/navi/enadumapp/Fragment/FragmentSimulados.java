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
import android.widget.ExpandableListView;
import android.widget.ListView;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import br.com.navi.enadumapp.Adapter.ExpandableListResultadosAdapter;
import br.com.navi.enadumapp.Adapter.ExpandableListSimuladosAdapter;
import br.com.navi.enadumapp.R;
import br.com.navi.enadumapp.SimuladoActivity;
import br.com.navi.enadumapp.SimuladoEnadeActivity;
import br.com.navi.enadumapp.Utils.SessionRepository;
import br.com.navi.enadumapp.models.Aluno;
import br.com.navi.enadumapp.models.Curso;
import br.com.navi.enadumapp.models.SimuladoEnade;

/**
 * Created by Victor Monte on 17/08/2016.
 */
public class FragmentSimulados extends Fragment {

    private Aluno aluno;
    private List<Curso> listDataHeader;
    private HashMap<Curso, List<SimuladoEnade>> listDataChild;

    private ExpandableListView elvSimulados;
    private ExpandableListSimuladosAdapter listAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View layoutSimulados = inflater.inflate(R.layout.fragment_simulados,container,false);

        elvSimulados = (ExpandableListView) getView().findViewById(R.id.elvSimulados);

        listAdapter = new ExpandableListSimuladosAdapter(getActivity(), listDataHeader, listDataChild);

        listDataHeader = SessionRepository.aluno.getCursos();

        listDataChild = new HashMap<Curso, List<SimuladoEnade>>();
        for(Curso curso : SessionRepository.aluno.getCursos()) {
            listDataChild.put(curso, curso.getCursoMEC().getSimuladosEnade());
        }

        this.listViewDisciplinas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Curso selecionado  = (Curso) adapterView.getItemAtPosition(i);

                SessionRepository.simulado =  selecionado.getCursoMEC().getSimuladosEnade().get(0);

                Intent fazerSimulado  = new Intent(getActivity(), SimuladoEnadeActivity.class);
                startActivity(fazerSimulado);
            }
        });

        return layoutSimulados;
    }

}
