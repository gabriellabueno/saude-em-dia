package br.edu.fatec.diariosaude.view;

import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import java.util.List;

import br.edu.fatec.diariosaude.R;
import br.edu.fatec.diariosaude.controller.PessoaController;
import br.edu.fatec.diariosaude.util.Pessoa;
import br.edu.fatec.diariosaude.util.Sugestao;
import br.edu.fatec.diariosaude.view.adapter.PessoaAdapter;

public class SugestaoFragment extends Fragment {

    private ListView listViewSugestao;

    // Variáveis para Controller
    private PessoaController controller;

    // Adapter para apresentar dados no ListView
    PessoaAdapter adapter;

    // Variáveis para componentes XML
    private TextView edtIMC, edtIndiceIMC, txtNutricao, txtAtvFisica, txtSedentario;
    private LinearLayout layoutSugestoes;

    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        // Apresenta o layout do Fragment
        View view = inflater.inflate(R.layout.fragment_sugestao, container, false);

        listViewSugestao = view.findViewById(R.id.listViewSugestao);

        // Inicializando o controller
        controller = new PessoaController(this.getContext());

        // Listar pessoas no ListView
        List<Pessoa> pessoas = listAll();
        if(pessoas == null) {
            controller.updateTable();
        }

        // Variáveis para componentes XML
        edtIMC = view.findViewById(R.id.edtIMC);
        edtIndiceIMC = view.findViewById(R.id.edtIndiceIMC);
        txtNutricao = view.findViewById(R.id.txtNutricao);
        txtAtvFisica = view.findViewById(R.id.txtAtvFisica);
        txtSedentario = view.findViewById(R.id.txtSedentario);
        layoutSugestoes = view.findViewById(R.id.layout_sugestoes);

        layoutSugestoes.setVisibility(View.GONE);
        txtSedentario.setVisibility(View.GONE);


        // Clica no item da ListView leva para a tela de Manutenção
        listViewSugestao.setOnItemClickListener((parent, v, position, id) -> {

            // Obtém o pessoa clicada
            Pessoa pessoaSelecionada = adapter.getItem(position);

            if(pessoaSelecionada != null) {
                gerarSugestao(pessoaSelecionada);
            }
            layoutSugestoes.setVisibility(View.VISIBLE);

        });


        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onResume() {
        super.onResume();

        listAll();
        if(adapter.isEmpty())
            controller.updateTable();
    }

    public void gerarSugestao(Pessoa pessoa) {
        pessoa.setSugestao();
        Sugestao sugestao = pessoa.getSugestao();

        edtIMC.setText(String.valueOf(pessoa.getImc()));
        edtIndiceIMC.setText(pessoa.getIndiceIMC());
        txtNutricao.setText(sugestao.getSugestaoNutricional());
        txtAtvFisica.setText(sugestao.getSugestaoAtvFisica());
        if(pessoa.isSedentario() == 1) {
            txtSedentario.setVisibility(View.VISIBLE);
            txtSedentario.setText(sugestao.getSugestaoSedentario());
        }
    }

    // Listar todos os alunos na ListvIiew
    public List<Pessoa> listAll() {

        // Popula array com dados do BD
        List<Pessoa> pessoas = controller.listAll();

        // Envia array para adapter
        adapter = new PessoaAdapter(getContext(), pessoas);

        // Popula ListView com itens do array
        listViewSugestao.setAdapter(adapter);
        return pessoas;
    }
}