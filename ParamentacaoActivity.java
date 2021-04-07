package 00000000000000;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class ParamentacaoActivity extends AppCompatActivity {

    String[] listaNomes = {

            "",

            "A",

            "",

            "M",

            "",

            "Ó",

            "G",

            "L"
    };

    int [] listaIcones = {R.drawable.maos_1, R.drawable.avental_2, R.drawable.maos_3, R.drawable.mascara_4, R.drawable.maos_5, R.drawable.oculos_6,R.drawable.gorro_7,R.drawable.luvas_8};

    String[] listaDescricoes = {

            "Higienizar as mãos",
00000000000000
    };

    String[] listaDicas = {

            "Higienizar por no mínimo 20 segundos. Respeitando todas as etapas recomendadas pela ANVISA.",

            00000000000000
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_sembotoes);

        ListView minhaLista = findViewById(R.id.minhaLista);

        final MeuAdaptador meuAdaptador;
        meuAdaptador = new MeuAdaptador(getApplicationContext(), R.layout.minha_celula);

        int i = 0;

        for(String nome: listaNomes){
            DadosEpis dadosEpis;
            dadosEpis = new DadosEpis(listaIcones[i], nome,listaDescricoes[i], listaDicas[i]);
            meuAdaptador.add(dadosEpis);
            i++;
        }

        minhaLista.setAdapter(meuAdaptador);

        minhaLista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(DesparamentacaoActivity.this, "" + listaNomes[position], Toast.LENGTH_SHORT).show();

                DadosEpis dadosEpis;
                dadosEpis = (DadosEpis) meuAdaptador.getItem(position);


                criaAlerta(dadosEpis);
            }
        });
    }

    public void criaAlerta(DadosEpis dadosEpis){
        AlertDialog.Builder meuAlerta;
        meuAlerta = new AlertDialog.Builder(ParamentacaoActivity.this);

        meuAlerta.setTitle(dadosEpis.getDescricao());
        meuAlerta.setMessage(dadosEpis.getDicas());

        meuAlerta.setCancelable(true);
        meuAlerta.setIcon(dadosEpis.getIcone());

        meuAlerta.setPositiveButton("Entendi", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            
            }
        });

        meuAlerta.create();
        meuAlerta.show();
    }
}