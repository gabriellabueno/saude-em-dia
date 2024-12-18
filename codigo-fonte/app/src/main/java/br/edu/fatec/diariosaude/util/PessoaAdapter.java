package br.edu.fatec.diariosaude.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import br.edu.fatec.diariosaude.R;

public class PessoaAdapter extends ArrayAdapter<Pessoa> {
    private Context context;

    public PessoaAdapter(Context context, List<Pessoa> pessoas) {
        super(context, 0, pessoas);
        this.context = context;
    }

    // convertView - view que é "reciclada"
    // quando o ListView precisa apresentar um item, checa se há uma view disponível
    // ao invés de criar uma do zero

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Se não houver nenhuma view para reutilizar, cria uma nova
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate( // instancia o layout XML dos itens
                    R.layout.item_pessoa_listview, parent, false);
        }

        // Linkando componentes XML com variáveis
        TextView tvID = convertView.findViewById(R.id.tvID);
        TextView tvNome = convertView.findViewById(R.id.tvNome);
        TextView tvIdade = convertView.findViewById(R.id.tvIdade);


        // Popula os campos do item com o objeto passado
        Pessoa pessoa = getItem(position);
        if (pessoa != null) {
            tvID.setText(String.valueOf(pessoa.getId()));
            tvNome.setText(pessoa.getNome());
            tvIdade.setText(String.valueOf(pessoa.getIdade()));
        }


        return convertView;
    }
}
