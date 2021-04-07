package 00000000000000;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class DesparamentacaoActivity extends AppCompatActivity {

    String[] listaNomes = {

            "L",

            "",

            "A",

            "",

            "G",

            "Ó",

            "",

            "M",
            ""
    };

    int [] listaIcones = {R.drawable.luvas_d1, R.drawable.maos_d2, R.drawable.avental_d3, R.drawable.maos_d4, R.drawable.gorro_d5, R.drawable.oculos_6, R.drawable.maos_d7, R.drawable.mascara_d8, R.drawable.maos_d9};

    String[] listaDescricoes = {

            "Luvas",
00000000000000
    };

    String[] listaDicas = {

            "Utilizar a mão oposta, tocando na parte externa para puxá-la até deixá-la pelo avesso. Com a mão desenluvada, retirar a outra luva (pegando por dentro na parte não contaminada, até ficar pelo avesso).",
00000000000000
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_sembotoes);
/**/
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
        meuAlerta = new AlertDialog.Builder(DesparamentacaoActivity.this);

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