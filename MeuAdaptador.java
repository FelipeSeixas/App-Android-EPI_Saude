package 00000000000000;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

class MeuAdaptador extends ArrayAdapter {
    public MeuAdaptador(@NonNull Context context, int resource) {
        super(context, resource);
    }

    @Override
    public void add(@Nullable Object object) {
        super.add(object);
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View minhaView;
        minhaView = convertView;
        ViewEpis viewEpis;

        if(convertView == null) {
            LayoutInflater inflater = (LayoutInflater)this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            minhaView = inflater.inflate(R.layout.minha_celula, parent, false);

            viewEpis = new ViewEpis();
            viewEpis.icone = (ImageView) minhaView.findViewById(R.id.meuicone);
            viewEpis.titulo = (TextView) minhaView.findViewById(R.id.meuTitulo);
            viewEpis.descricao = (TextView) minhaView.findViewById(R.id.minhaDescricao);

            minhaView.setTag(viewEpis);
        }
        else {
            viewEpis = (ViewEpis) minhaView.getTag();
        }

        DadosEpis dadosEpis;
        dadosEpis = (DadosEpis) this.getItem(position);

        viewEpis.icone.setImageResource(dadosEpis.getIcone());
        viewEpis.titulo.setText(dadosEpis.getNome());
        viewEpis.descricao.setText(dadosEpis.getDescricao());

        return minhaView;

    }
}
