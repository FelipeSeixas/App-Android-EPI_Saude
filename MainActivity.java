package 00000000000000;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class MainActivity extends AppCompatActivity {

    AdView mAdview;

    Button param;
    Button desparam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        mAdview = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdview.loadAd(adRequest);

        param = findViewById(R.id.button2);
        desparam = findViewById(R.id.button);

        param.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TROCA DE TELAS:
                Intent intent = new Intent(getApplicationContext(), ParamentacaoActivity.class);

                //Teste Opção A - Usando Bundle:
                Bundle params = new Bundle();
                params.putString("nome", "Paramentação");

                //Utilizando o nome:
                intent.putExtras(params);
                startActivity(intent);
            }
        });

        desparam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TROCA DE TELAS:
                Intent intent = new Intent(getApplicationContext(), DesparamentacaoActivity.class);

                //Teste Opção A - Usando Bundle:
                Bundle params = new Bundle();
                params.putString("nome", "Desparamentação");

                //Utilizando o nome:
                intent.putExtras(params);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.meu_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){

        switch (item.getItemId()){

            case R.id.ref:
                Toast.makeText(MainActivity.this, "Agência Nacional de Vigilância Sanitária - ANVISA. Site: www.portal.anvisa.gov.br. Acesso  em: 26/05/2020.", Toast.LENGTH_LONG).show(); break;

            case R.id.lav_anvisa_vid:
                Toast.makeText(MainActivity.this, "Exibindo uma lista de vídeos explicativos...", Toast.LENGTH_LONG).show();
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/results?search_query=higieniza%C3%A7%C3%A3o+das+maos+anvisa+"))); break;

            case R.id.lav_anvisa_foto:
                Toast.makeText(MainActivity.this, "Exibindo uma lista de imagens explicativas...", Toast.LENGTH_LONG).show();
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/search?q=higieniza%C3%A7%C3%A3o+das+m%C3%A3os+anvisa&sxsrf=ALeKk02061-Oki-Xv7qEz81blhZOITsCng:1590484803386&source=lnms&tbm=isch&sa=X&ved=2ahUKEwjBvOfNmdHpAhXPHLkGHei3DugQ_AUoAXoECAwQAw&biw=684&bih=568&dpr=1.5"))); break;

            case R.id.denun:
                Toast.makeText(MainActivity.this, "Abrindo o site de denúncias (EPI´s)", Toast.LENGTH_LONG).show();
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://sbmn.org.br/amb-cria-canal-para-servicos-reportarem-falta-de-epi/"))); break;

            case R.id.denunmed:
                Toast.makeText(MainActivity.this, "Abrindo o site de denúncias (medicamentos)", Toast.LENGTH_LONG).show();
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www10.anvisa.gov.br/ouvidoria/CadastroProcedimentoInternetACT.do?metodo=inicia"))); break;

            case R.id.dev:
                Toast toast = Toast.makeText(this, "Felipe Seixas (Natal-RN): felipe.economista@hotmail.com", Toast.LENGTH_LONG);
                View toastView = toast.getView(); // This'll return the default View of the Toast.

                /* And now you can get the TextView of the default View of the Toast. */
                TextView toastMessage = (TextView) toastView.findViewById(android.R.id.message);
                toastMessage.setTextSize(18);
                toastMessage.setTextColor(Color.RED);
                toastMessage.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_foto1, 0, 0, 0);
                toastMessage.setGravity(Gravity.CENTER);
                toastMessage.setCompoundDrawablePadding(16);
                toastView.setBackgroundColor(Color.WHITE);
                toast.show();
        }

        return super.onOptionsItemSelected(item);
    }
}