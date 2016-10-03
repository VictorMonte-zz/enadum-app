package br.com.navi.enadumapp.Adapter;

import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.com.navi.enadumapp.R;
import br.com.navi.enadumapp.models.Aluno;
import br.com.navi.enadumapp.models.DTO.AlunoRankingDTO;

/**
 * Created by Victor Monte on 27/08/2016.
 */
public class RankingAdapter extends BaseAdapter {

    public List<AlunoRankingDTO> ranking;
    public FragmentActivity context;
    LayoutInflater inflater = null;

    public RankingAdapter(FragmentActivity ctx, List<AlunoRankingDTO> ranking)
    {
        this.context = ctx;
        this.ranking = ranking;
        inflater = (LayoutInflater)ctx.getSystemService(ctx.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return ranking.size();
    }

    @Override
    public Object getItem(int i) {
        return ranking.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View row = inflater.inflate(R.layout.listview_ranking, null);

        TextView posicao = (TextView)row.findViewById(R.id.txtPosicao);
        posicao.setText(String.valueOf(i+1) + "° " + ranking.get(i).getNome());

        TextView instituicao = (TextView)row.findViewById(R.id.txtInstituicaoRanking);
        instituicao.setText(ranking.get(i).getInstituicao());

        TextView pontuacao = (TextView)row.findViewById(R.id.txtPontuacao);
        pontuacao.setText(ranking.get(i).getExperiencia().toString());

        ImageView avatar = (ImageView)row.findViewById(R.id.ivAvatarRanking);
        switch (i)
        {
            case 0:
                avatar.setImageResource(R.drawable.gold);
                break;
            case 1:
                avatar.setImageResource(R.drawable.silver);
                break;
            case 2:
                avatar.setImageResource(R.drawable.bronze);
                break;
            default:
                avatar.setVisibility(View.INVISIBLE);
                break;
        }

        return row;
    }
}
