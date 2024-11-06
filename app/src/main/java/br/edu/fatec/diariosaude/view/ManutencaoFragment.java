package br.edu.fatec.diariosaude.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.Toast;

import java.text.DecimalFormat;

import br.edu.fatec.diariosaude.R;
import br.edu.fatec.diariosaude.controller.PessoaController;
import br.edu.fatec.diariosaude.util.Pessoa;

public class ManutencaoFragment extends Fragment {

    // Variáveis para componentes XML
    private EditText edtNome;
    private EditText edtGenero;
    private EditText edtIdade;
    private EditText edtPeso;
    private EditText edtAltura;
    private Switch swtSedentario;
    private RadioButton rdbMasculino;
    private RadioButton rdbFeminino;
    private Switch swtGestante;
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
        // Apresenta o layout do Fragment
        View view = inflater.inflate(R.layout.fragment_manutencao, container, false);

        // Inicializa Controller
        pessoaController = new PessoaController(this.getContext());

        // Variáveis para componentes XML
        edtNome = view.findViewById(R.id.edtNome);
        edtGenero = view.findViewById(R.id.edtGenero);
        edtIdade = view.findViewById(R.id.edtIdade);
        edtPeso = view.findViewById(R.id.edtPeso);
        edtAltura = view.findViewById(R.id.edtAltura);
        swtSedentario = view.findViewById(R.id.swtSedentario);
        rdbMasculino = view.findViewById(R.id.rdbMasculino);
        rdbFeminino = view.findViewById(R.id.rdbFeminino);
        swtGestante = view.findViewById(R.id.swtGestante);
        btnAtualizar = view.findViewById(R.id.btnAtualizar);
        btnExcluir = view.findViewById(R.id.btnExcluir);

        // Recebe ID da pessoa selecionada da tela Controle
        if (getArguments() != null) {
            pessoaSelecionadaID = getArguments().getInt("pessoaSelecionadaID");
        }

        // Busca dados a partir do ID e armazena em instância de Pessoa
        pessoa = pessoaController.read(pessoaSelecionadaID);


        swtGestante.setVisibility(View.GONE); // switch gestante invisível até selecionar sexo

        // RADIO BUTTON FEMININO
        // Listener para mudanças na seleção dos RadioButtons
        rdbFeminino.setOnCheckedChangeListener(
                (compoundButton, b) -> {
                    if(rdbFeminino.isChecked()) {
                        swtGestante.setVisibility(View.VISIBLE);
                        sexo = 1;
                    } else {
                        swtGestante.setVisibility(View.GONE);
                        sexo = 0;
                    }
                }
        );

        // SWITCH GESTANTE
        swtGestante.setOnCheckedChangeListener((compoundButton, b) -> {
            gestante = swtGestante.isChecked() ? 1 : 0;
        });


        // SWITCH SEDENTARIO
        swtSedentario.setOnCheckedChangeListener((compoundButton, b) -> {
            sedentario = swtSedentario.isChecked() ? 1 : 0;
        });



        // Preenche campos de inputs com os dados retornados
        preencheCamposEdt(pessoa);


        // Botão Atualizar
        btnAtualizar.setOnClickListener(v -> {
            pessoa = recebeInputs();
            if (pessoa != null) {
                pessoa.setId(pessoaSelecionadaID);
                pessoaController.update(pessoa);
                pessoaController.mostrarMensagem("atualizada");
            } else {
                Toast.makeText(getContext(), "É necessário preencher todos os campos para atualizar.", Toast.LENGTH_LONG).show();
            }
        });


        //Botão Excluir
        btnExcluir.setOnClickListener(v -> {
            pessoa = new Pessoa();
            pessoa.setId(pessoaSelecionadaID);
            pessoaController.delete(pessoa);
            pessoaController.mostrarMensagem("removida");
            limpaCamposEdt();
        });


        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }


    // Recebe dados do usuário e armazena em nova instância de Pessoa
    public Pessoa recebeInputs() {
        pessoa = new Pessoa();

        pessoa.setNome(edtNome.getText().toString());
        pessoa.setGenero(edtGenero.getText().toString());
        pessoa.setIdade(Integer.parseInt(edtIdade.getText().toString()));
        pessoa.setAltura(Float.parseFloat(edtAltura.getText().toString()));
        pessoa.setPeso(Double.parseDouble(edtPeso.getText().toString()));
        pessoa.setSexo(sexo);
        pessoa.setGestante(gestante);
        pessoa.setSedentario(sedentario);

        return pessoa;
    }

    // Preenche campos de inputs com os dados da pessoa para Manutencao
    public void preencheCamposEdt(Pessoa pessoa) {
        edtNome.setText(pessoa.getNome());
        edtGenero.setText(pessoa.getGenero());
        edtIdade.setText(String.valueOf(pessoa.getIdade()));

        String alturaFormatada = new DecimalFormat("#.00").format(pessoa.getAltura());
        edtAltura.setText(alturaFormatada);

        edtPeso.setText(String.valueOf(pessoa.getPeso()));

        if(pessoa.getSexo() == 1) {
            rdbFeminino.setChecked(true);
            swtGestante.setVisibility(View.VISIBLE);
        } else {
            rdbMasculino.setChecked(true);
            swtGestante.setVisibility(View.GONE);
        }

        if(pessoa.isGestante() == 1) {
            swtGestante.setChecked(true);
        }

        if(pessoa.isSedentario() == 1)
            swtSedentario.setChecked(true);
    }

    public void limpaCamposEdt() {
        edtNome.setText(null);
        edtGenero.setText(null);
        edtIdade.setText(null);
        edtAltura.setText(null);
        edtPeso.setText(null);
        swtGestante.setVisibility(View.GONE);
        rdbFeminino.setChecked(false);
        rdbMasculino.setChecked(false);
        swtSedentario.setChecked(false);
    }



}