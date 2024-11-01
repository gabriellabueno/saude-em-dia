package br.edu.fatec.diariosaude.view.manutencao;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Switch;

import br.edu.fatec.diariosaude.R;
import br.edu.fatec.diariosaude.controller.PessoaController;
import br.edu.fatec.diariosaude.model.Pessoa;
import br.edu.fatec.diariosaude.view.cadastro.CadastroViewModel;

public class ManutencaoFragment extends Fragment {

    private ManutencaoViewModel viewModel;

    // Variáveis para componentes XML
    private EditText edtNome;
    private EditText edtIdade;
    private EditText edtPeso;
    private EditText edtAltura;
    private Switch swtSedentario;
    private RadioButton rdbMasculino;
    private RadioButton rdbFeminino;
    private Switch swtGestante;
    private CheckBox rdbDiabetes;
    private CheckBox rdbHipertensao;
    private CheckBox rdbCardiopatia;
    private Button btnAtualizar;
    private Button btnExcluir;

    // Variáveis para controller:
    private PessoaController pessoaController;
    private Pessoa pessoa;

    // Variáveis para definir valores booleanos
    // Salvos como INT pois o MySQL não aceita booleano
    private Integer sexo;
    private Integer gestante;
    private Integer sedentario;

    // Variável para manipular pessoa selecionada em Controle
    private Integer pessoaSelecionadaID;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Infla o layout do Fragment
        View view = inflater.inflate(R.layout.fragment_manutencao, container, false);
        // Inicializa a ViewModel associada ao Fragment
        viewModel = new ViewModelProvider(this).get(ManutencaoViewModel.class);

        // Inicializa Controller
        pessoaController = new PessoaController(this.getContext());

        // Variáveis para componentes XML
        edtNome = view.findViewById(R.id.edtNome);
        edtIdade = view.findViewById(R.id.edtIdade);
        edtPeso = view.findViewById(R.id.edtPeso);
        edtAltura = view.findViewById(R.id.edtAltura);
        swtSedentario = view.findViewById(R.id.swtSedentario);
        rdbMasculino = view.findViewById(R.id.rdbMasculino);
        rdbFeminino = view.findViewById(R.id.rdbFeminino);
        swtGestante = view.findViewById(R.id.swtGestante);
        rdbDiabetes = view.findViewById(R.id.rdbDiabetes);
        rdbHipertensao = view.findViewById(R.id.rdbHipertensao);
        rdbCardiopatia = view.findViewById(R.id.rdbCardiopatia);
        btnAtualizar = view.findViewById(R.id.btnAtualizar);
        btnExcluir = view.findViewById(R.id.btnExcluir);

        // Recebe ID da pessoa selecionada da tela Controle
        if (getArguments() != null) {
            pessoaSelecionadaID = getArguments().getInt("pessoaSelecionadaID");
        }

        // Busca dados a partir do ID e armazena em instância de Pessoa
        pessoa = pessoaController.read(pessoaSelecionadaID);

        // Preenche campos de inputs com os dados retornados
        setInputs(pessoa);


        // Botão Atualizar
        btnAtualizar.setOnClickListener(v -> {
            pessoa = getInputs();
            pessoa.setId(pessoaSelecionadaID);
            pessoaController.update(pessoa);
            pessoaController.mostrarMensagem("atualizada");
        });


        //Botão Excluir
        btnExcluir.setOnClickListener(v -> {
            pessoa = new Pessoa();
            pessoa.setId(pessoaSelecionadaID);
            pessoaController.delete(pessoa);
            pessoaController.mostrarMensagem("removida");
        });



        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }


    // Recebe dados do usuário e armazena em nova instância de Pessoa
    public Pessoa getInputs() {
        pessoa = new Pessoa();

        pessoa.setNome(edtNome.getText().toString());
        pessoa.setIdade(Integer.parseInt(edtIdade.getText().toString()));
        pessoa.setAltura(Float.parseFloat(edtAltura.getText().toString()));
        pessoa.setPeso(Float.parseFloat(edtPeso.getText().toString()));
        pessoa.setSexo(sexo);
        pessoa.setGestante(gestante);
        pessoa.setSedentario(sedentario);

        return pessoa;
    }

    // Preenche campos de inputs com os dados da pessoa para Manutencao
    public void setInputs(Pessoa pessoa) {
        edtNome.setText(pessoa.getNome());
        edtIdade.setText(String.valueOf(pessoa.getIdade()));
        edtAltura.setText(String.valueOf(pessoa.getAltura()));
        edtPeso.setText(String.valueOf(pessoa.getPeso()));

        if(pessoa.getSexo() == 1)
            rdbFeminino.setChecked(true);
        else
            rdbMasculino.setChecked(true);

        if(pessoa.isGestante() == 1)
            swtGestante.setVisibility(View.VISIBLE);

        if(pessoa.isSedentario() == 1)
            swtSedentario.setChecked(true);
    }


}