package br.com.navi.enadumapp.Adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Checkable;
import android.widget.TextView;

import java.util.List;

import br.com.navi.enadumapp.R;
import br.com.navi.enadumapp.models.Resposta;

/**
 * Created by Danilo on 02/10/2016.
 */

public class ListaRespostasAdapter extends BaseAdapter implements Checkable{

    private final List<Resposta> respostas;
    private final Activity activity;
    private boolean mChecked = false;

    public ListaRespostasAdapter(List<Resposta> respostas, Activity activity) {
        this.respostas = respostas;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return respostas.size();
    }

    @Override
    public Object getItem(int i) {
        return respostas.get(i);
    }

    @Override
    public long getItemId(int i) {
        return respostas.get(i).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = activity.getLayoutInflater().inflate(R.layout.item_resposta, parent, false);

        Resposta resposta = respostas.get(position);

        TextView sentenca = (TextView) view.findViewById(R.id.resposta);
        sentenca.setText(resposta.getSenteca());

        return view;
    }

    @Override
    public void setChecked(boolean checked) {
        if (mChecked != checked) {
            mChecked = checked;
        }
    }

    @Override
    public boolean isChecked() {
        return mChecked;
    }

    @Override
    public void toggle() {
        mChecked = !mChecked;
    }
}
