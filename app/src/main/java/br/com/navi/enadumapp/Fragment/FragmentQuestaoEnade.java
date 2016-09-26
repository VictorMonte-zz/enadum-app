package br.com.navi.enadumapp.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import br.com.navi.enadumapp.R;
import br.com.navi.enadumapp.SimuladoEnadeActivity;
import br.com.navi.enadumapp.models.QuestaoEnade;
import br.com.navi.enadumapp.models.Resposta;
import br.com.navi.enadumapp.models.SimuladoEnade;

/**
 * Created by Danilo on 18/09/2016.
 */

public class FragmentQuestaoEnade extends Fragment{

    private QuestaoEnade questaoEnade;
    private TextView enunciado;
    private ListView listaDeRespostas;
    private List<Resposta> respostas;
    private Integer idResposta;
    private Resposta resposta;
    private SimuladoEnadeActivity activity;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_questao_enade,container,false);

        this.enunciado = (TextView) view.findViewById(R.id.questao_enade_enunciado);
        this.listaDeRespostas = (ListView) view.findViewById(R.id.questao_enade_respostas);

        activity = (SimuladoEnadeActivity) getActivity();
        SimuladoEnade simuladoEnade = activity.getSimulado();

        this.questaoEnade = simuladoEnade.getQuestao(activity.getPosicao());
        this.enunciado.setText(questaoEnade.getEnunciado());
        this.respostas = questaoEnade.getRespostas();

        ArrayAdapter<Resposta> adapter = new ArrayAdapter<>(getActivity(),android.R.layout.simple_list_item_single_choice, respostas);

        this.listaDeRespostas.setAdapter(adapter);
        setListViewHeightBasedOnChildren(listaDeRespostas);

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        Log.d("Destroy", "destruiu um fragment");
        int position = listaDeRespostas.getCheckedItemPosition();
        resposta = (Resposta) listaDeRespostas.getItemAtPosition(position);
        if(resposta != null){
            activity.addResposta(resposta);
        }
    }

//    @Override
//    public void onPause() {
//        super.onPause();
//
//        Log.d("Pause", "pausou um fragment");
//        int position = listaDeRespostas.getCheckedItemPosition();
//        resposta = (Resposta) listaDeRespostas.getItemAtPosition(position);
//        if (resposta != null){
//            activity.addResposta(resposta);
//        }
//    }

    public void setListViewHeightBasedOnChildren(ListView listView) {
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null) {
            // pre-condition
            return;
        }

        int totalHeight = listView.getPaddingTop() + listView.getPaddingBottom();
        int desiredWidth = View.MeasureSpec.makeMeasureSpec(listView.getWidth(), View.MeasureSpec.AT_MOST);
        for (int i = 0; i < listAdapter.getCount(); i++) {
            View listItem = listAdapter.getView(i, null, listView);

            if(listItem != null){
                // This next line is needed before you call measure or else you won't get measured height at all. The listitem needs to be drawn first to know the height.
                listItem.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT));
                listItem.measure(desiredWidth, View.MeasureSpec.UNSPECIFIED);
                totalHeight += listItem.getMeasuredHeight();

            }
        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = (totalHeight/9) + (listView.getDividerHeight() * (listAdapter.getCount() - 1) - 180);
        listView.setLayoutParams(params);
        listView.requestLayout();
    }

    public Integer getIdResposta(){
        return this.idResposta;
    }
}
