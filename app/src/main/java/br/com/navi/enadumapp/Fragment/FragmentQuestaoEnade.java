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
    private Integer mmh;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_questao_enade,container,false);

        mmh = 1000000000;
        this.enunciado = (TextView) view.findViewById(R.id.questao_enade_enunciado);
        this.listaDeRespostas = (ListView) view.findViewById(R.id.questao_enade_respostas);

        activity = (SimuladoEnadeActivity) getActivity();
        SimuladoEnade simuladoEnade = activity.getSimulado();

        this.questaoEnade = simuladoEnade.getQuestao(activity.getPosicao());
        this.enunciado.setText(questaoEnade.getEnunciado());
        this.respostas = questaoEnade.getRespostas();

        ArrayAdapter<Resposta> adapter = new ArrayAdapter<>(getActivity(),android.R.layout.simple_list_item_single_choice, respostas);

        this.listaDeRespostas.setAdapter(adapter);
        //setListViewHeightBasedOnChildren(listaDeRespostas);
        setListViewHeightBasedOnItems(listaDeRespostas);
        //getListViewSize(listaDeRespostas);



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

//    public void setListViewHeightBasedOnChildren(ListView listView) {
//        ListAdapter listAdapter = listView.getAdapter();
//        if (listAdapter == null) {
//            // pre-condition
//            return;
//        }
//
//        Integer totalHeight = listView.getPaddingTop() + listView.getPaddingBottom();
//        int desiredWidth = View.MeasureSpec.makeMeasureSpec(listView.getWidth(), View.MeasureSpec.AT_MOST);
//        for (int i = 0; i < listAdapter.getCount(); i++) {
//            View listItem = listAdapter.getView(i, null, listView);
//
//            if(listItem != null){
//                // This next line is needed before you call measure or else you won't get measured height at all. The listitem needs to be drawn first to know the height.
//                listItem.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT));
//                listItem.measure(desiredWidth, View.MeasureSpec.UNSPECIFIED);
//                Integer mh = listItem.getMeasuredHeight();
//                totalHeight += listItem.getMeasuredHeight();
//                Log.d("Total height", mh.toString());
//                if(mh < mmh){
//                    mmh = mh;
//                }
//            }
//        }
//
//        ViewGroup.LayoutParams params = listView.getLayoutParams();
//        Integer dividerHeight = listView.getDividerHeight();
//        Log.d("mmh", mmh.toString());
////        params.height = (totalHeight/2) + (listView.getDividerHeight() * (listAdapter.getCount() - 1) - 180) ;
//        params.height = (totalHeight/2) - mmh * 4;
//        listView.setLayoutParams(params);
//        listView.requestLayout();
//    }

    public static boolean setListViewHeightBasedOnItems(ListView listView) {

        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter != null) {

           // int numberOfItems = listAdapter.getCount();
            int numberOfItems = 5;

            // Get total height of all items.
            int totalItemsHeight = 0;
            for (int itemPos = 0; itemPos < numberOfItems; itemPos++) {
                View item = listAdapter.getView(itemPos, null, listView);
                item.measure(0, 0);
                totalItemsHeight += item.getMeasuredHeight();
            }

            // Get total height of all item dividers.
            int totalDividersHeight = listView.getDividerHeight() *
                    (numberOfItems - 1);

            // Set list height.
            ViewGroup.LayoutParams params = listView.getLayoutParams();
            params.height = totalItemsHeight + totalDividersHeight + 246;
            listView.setLayoutParams(params);
            listView.requestLayout();

            return true;

        } else {
            return false;
        }

    }

//    public static void getListViewSize(ListView myListView) {
//        ListAdapter myListAdapter = myListView.getAdapter();
//        if (myListAdapter == null) {
//            //do nothing return null
//            return;
//        }
//        //set listAdapter in loop for getting final size
//        int totalHeight = 0;
//        for (int size = 0; size < myListAdapter.getCount(); size++) {
//            View listItem = myListAdapter.getView(size, null, myListView);
//            listItem.measure(0, 0);
//            totalHeight += listItem.getMeasuredHeight();
//        }
//        //setting listview item in adapter
//        ViewGroup.LayoutParams params = myListView.getLayoutParams();
//        params.height = totalHeight + (myListView.getDividerHeight() * (myListAdapter.getCount() - 1));
//        myListView.setLayoutParams(params);
//        // print height of adapter on log
//        Log.i("height of listItem:", String.valueOf(totalHeight));
//    }

    public Integer getIdResposta(){
        return this.idResposta;
    }
}
