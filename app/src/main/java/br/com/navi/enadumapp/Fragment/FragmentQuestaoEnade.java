package br.com.navi.enadumapp.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import br.com.navi.enadumapp.R;
import br.com.navi.enadumapp.SimuladoActivity;
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

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_questao_enade,container,false);

        this.enunciado = (TextView) view.findViewById(R.id.questao_enade_enunciado);
        this.listaDeRespostas = (ListView) view.findViewById(R.id.questao_enade_respostas);

        SimuladoEnadeActivity activity = (SimuladoEnadeActivity) getActivity();
        SimuladoEnade simuladoEnade = activity.getSimulado();

        this.questaoEnade = simuladoEnade.getQuestao(activity.getPosicao());
        //questaoEnade.setEnunciado("T odas estas questões, devidamente ponderadas, levantam dúvidas sobre se a crescente influência da mídia maximiza as possibilidades por conta do impacto na agilidade decisória. O cuidado em identificar pontos críTodas estas questões, devidamente ponderadas, levantam dúvidas sobre se a crescente influência da mídia maximiza as possibilidades por conta do impacto na agilidade decisória. O cuidado em identificar pontos críticos na consulta aos diversos militantes apresenta tendências no sentido de aprovar a manutenção das direções preferenciais no sentido do progresso. É importante questionar o quanto a consolidação das estruturas assume importantes posições no estabelecimento dos métodos utilizados na avaliação de resultados. O incentivo ao avanço tecnológico, assim como o desenvolvimento contínuo de distintas formas de atuação oferece uma interessante oportunidade para verificação do orçamento setorial. Podemos já vislumbrar o modo pelo qual a hegemonia do ambiente político agrega valor ao estabelecimento das condições financeiras e administrativas exigidas.A prática cotidiana prova que a competitividade nas transações comerciais pode nos levar a considerar a reestruturação do fluxo de informações. Pensando mais a longo prazo, a valorização de fatores subjetivos cumpre um papel essencial na formulação das diretrizes de desenvolvimento para o futuro. Assim mesmo, o surgimento do comércio virtual afeta positivamente a correta previsão do sistema de formação de quadros que corresponde às necessidades.Acima de tudo, é fundamental ressaltar que a constante divulgação das informações exige a precisão e a definição do levantamento das variáveis envolvidas. Neste sentido, o entendimento das metas propostas é uma das consequências do investimento em reciclagem técnica. Evidentemente, a determinação clara de objetivos obstaculiza a apreciação da importância dos índices pretendidos. Ainda assim, existem dúvidas a respeito de como o comprometimento entre as equipes talvez venha a ressaltar a relatividade de alternativas às soluções ortodoxas.É claro que o novo modelo estrutural aqui preconizado estimula a padronização do sistema de participação geral. Gostaria de enfatizar que o consenso sobre a necessidade de qualificação nos obriga à análise de todos os recursos funcionais envolvidos. O que temos que ter sempre em mente é que o desafiador cenário globalizado representa uma abertura para a melhoria das formas de ação.A nível organizacional, a mobilidade dos capitais internacionais auxilia a preparação e a composição dos modos de operação convencionais. Nunca é demais lembrar o peso e o significado destes problemas, uma vez que a necessidade de renovação processual ainda não demonstrou convincentemente que vai participar na mudança do retorno esperado a longo prazo. Não obstante, o julgamento imparcial das eventualidades aponta para a melhoria dos paradigmas corporativos.Todas estas questões, devidamente ponderadas, levantam dúvidas sobre se a crescente influência da mídia maximiza as possibilidades por conta do impacto na agilidade decisória. O cuidado em identificar pontos críticos na consulta aos diversos militantes apresenta tendências no sentido de aprovar a manutenção das direções preferenciais no sentido do progresso. É importante questionar o quanto a consolidação das estruturas assume importantes posições no estabelecimento dos métodos utilizados na avaliação de resultados. O incentivo ao avanço tecnológico, assim como o desenvolvimento contínuo de distintas formas de atuação oferece uma interessante oportunidade para verificação do orçamento setorial. Podemos já vislumbrar o modo pelo qual a hegemonia do ambiente político agrega valor ao estabelecimento das condições financeiras e administrativas exigidas.A prática cotidiana prova que a competitividade nas transações comerciais pode nos levar a considerar a reestruturação do fluxo de informações. Pensando mais a longo prazo, a valorização de fatores subjetivos cumpre um papel essencial na formulação das diretrizes de desenvolvimento para o futuro. Assim mesmo, o surgimento do comércio virtual afeta positivamente a correta previsão do sistema de formação de quadros que corresponde às necessidades.Acima de tudo, é fundamental ressaltar que a constante divulgação das informações exige a precisão e a definição do levantamento das variáveis envolvidas. Neste sentido, o entendimento das metas propostas é uma das consequências do investimento em reciclagem técnica. Evidentemente, a determinação clara de objetivos obstaculiza a apreciação da importância dos índices pretendidos. Ainda assim, existem dúvidas a respeito de como o comprometimento entre as equipes talvez venha a ressaltar a relatividade de alternativas às soluções ortodoxas.É claro que o novo modelo estrutural aqui preconizado estimula a padronização do sistema de participação geral. Gostaria de enfatizar que o consenso sobre a necessidade de qualificação nos obriga à análise de todos os recursos funcionais envolvidos. O que temos que ter sempre em mente é que o desafiador cenário globalizado representa uma abertura para a melhoria das formas de ação.A nível organizacional, a mobilidade dos capitais internacionais auxilia a preparação e a composição dos modos de operação convencionais. Nunca é demais lembrar o peso e o significado destes problemas, uma vez que a necessidade de renovação processual ainda não demonstrou convincentemente que vai participar na mudança do retorno esperado a longo prazo. Não obstante, o julgamento imparcial das eventualidades aponta para a melhoria dos paradigmas corporativos.ticos na consulta aos diversos militantes apresenta tendências no sentido de aprovar a manutenção das direções preferenciais no sentido do progresso. É importante questionar o quanto a consolidação das estruturas assume importantes posições no estabelecimento dos métodos utilizados na avaliação de resultados. O incentivo ao avanço tecnológico, assim como o desenvolvimento contínuo de distintas formas de atuação oferece uma interessante oportunidade para verificação do orçamento setorial. Podemos já vislumbrar o modo pelo qual a hegemonia do ambiente político agrega valor ao estabelecimento das condições financeiras e administrativas exigidas.A prática cotidiana prova que a competitividade nas transações comerciais pode nos levar a considerar a reestruturação do fluxo de informações. Pensando mais a longo prazo, a valorização de fatores subjetivos cumpre um papel essencial na formulação das diretrizes de desenvolvimento para o futuro. Assim mesmo, o surgimento do comércio virtual afeta positivamente a correta previsão do sistema de formação de quadros que corresponde às necessidades.Acima de tudo, é fundamental ressaltar que a constante divulgação das informações exige a precisão e a definição do levantamento das variáveis envolvidas. Neste sentido, o entendimento das metas propostas é uma das consequências do investimento em reciclagem técnica. Evidentemente, a determinação clara de objetivos obstaculiza a apreciação da importância dos índices pretendidos. Ainda assim, existem dúvidas a respeito de como o comprometimento entre as equipes talvez venha a ressaltar a relatividade de alternativas às soluções ortodoxas.É claro que o novo modelo estrutural aqui preconizado estimula a padronização do sistema de participação geral. Gostaria de enfatizar que o consenso sobre a necessidade de qualificação nos obriga à análise de todos os recursos funcionais envolvidos. O que temos que ter sempre em mente é que o desafiador cenário globalizado representa uma abertura para a melhoria das formas de ação.A nível organizacional, a mobilidade dos capitais internacionais auxilia a preparação e a composição dos modos de operação convencionais. Nunca é demais lembrar o peso e o significado destes problemas, uma vez que a necessidade de renovação processual ainda não demonstrou convincentemente que vai participar na mudança do retorno esperado a longo prazo. Não obstante, o julgamento imparcial das eventualidades aponta para a melhoria dos paradigmas corporativos.");
        questaoEnade.setEnunciado("oloko");
        this.enunciado.setText(questaoEnade.getEnunciado());
        this.respostas = questaoEnade.getRespostas();

        ArrayAdapter<Resposta> adapter = new ArrayAdapter<>(getActivity(),android.R.layout.simple_list_item_single_choice, respostas);

        this.listaDeRespostas.setAdapter(adapter);
        setListViewHeightBasedOnChildren(listaDeRespostas);


        return view;
    }

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
        params.height = (totalHeight/5) + (listView.getDividerHeight() * (listAdapter.getCount() - 1) - 180);
        listView.setLayoutParams(params);
        listView.requestLayout();
    }
}
