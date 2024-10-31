package br.edu.fatec.diariosaude.view.controle;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import java.util.List;

import br.edu.fatec.diariosaude.R;
import br.edu.fatec.diariosaude.controller.PessoaController;
import br.edu.fatec.diariosaude.model.Pessoa;
import br.edu.fatec.diariosaude.view.manutencao.Manutencao;

public class ControleFragment extends Fragment {

    private ControleViewModel viewModel;
    private ListView listViewControle;

    // Variáveis para Controller
    private PessoaController controller;

    // Adapter para apresentar dados no ListView
    PessoaAdapter adapter;

    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        // Infla o layout do Fragment
        View view = inflater.inflate(R.layout.fragment_controle, container, false);
        // Inicializa a ViewModel associada ao Fragment
        viewModel = new ViewModelProvider(this).get(ControleViewModel.class);

        // Inicializando o controller
        controller = new PessoaController(this.getContext());


        listViewControle = view.findViewById(R.id.listViewControle);

        // Listar pessoas no ListView
        List<Pessoa> pessoas = listAll();
        if(pessoas == null) {
            controller.updateTable();
        }


        // Clica no item da ListView leva para a tela de Manutenção
        listViewControle.setOnItemClickListener((parent, v, position, id) -> {

            // Obtém o pessoa clicada
            Pessoa pessoaSelecionada = adapter.getItem(position);

            // Envia ID de pessoaSelecionada para Activity Manutenção
            Intent it = new Intent(getContext(), Manutencao.class);
            it.putExtra("id-pessoa-selecionada", pessoaSelecionada.getId());
            startActivity(it);
        });

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

        listAll();
        if(adapter.isEmpty())
            controller.updateTable();
    }

    // Listar todos os alunos na ListvIiew
    public List<Pessoa> listAll() {

        // Popula array com dados do BD
        List<Pessoa> pessoas = controller.listAll();

        // Envia array para adapter
        adapter = new PessoaAdapter(getContext(), pessoas);

        // Poupula ListView com itens do array
        listViewControle.setAdapter(adapter);
        return pessoas;
    }
}