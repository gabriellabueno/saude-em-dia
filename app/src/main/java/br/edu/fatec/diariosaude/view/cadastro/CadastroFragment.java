package br.edu.fatec.diariosaude.view.cadastro;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

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

public class CadastroFragment extends Fragment {

    private CadastroViewModel viewModel;

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
    private Button btnCadastrar;

    // Variáveis para Controller
    PessoaController pessoaController;
    Pessoa pessoa;

    // Variáveis para definir valores booleanos
    // Salvos como INT pois o BD não aceita booleano
    private Integer sexo;
    private Integer gestante;
    private Integer sedentario;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Infla o layout do Fragment
        View view = inflater.inflate(R.layout.fragment_cadastro, container, false);
        // Inicializa a ViewModel associada ao Fragment
        viewModel = new ViewModelProvider(this).get(CadastroViewModel.class);

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
        btnCadastrar = view.findViewById(R.id.btnCadastrar);



        // CONDICIONAL RADIO BUTTON FEMININO
        // Listener para mudanças na seleção dos RadioButtons
        viewModel.isFemininoSelected().observe(getViewLifecycleOwner(), isSelected -> {

            if(isSelected) {
                swtGestante.setVisibility(View.VISIBLE);
                sexo = 1;
            } else {
                swtGestante.setVisibility(View.GONE);
                sexo = 0;
            }

        });

        // Listener para o RadioButton Feminino
        rdbFeminino.setOnCheckedChangeListener((buttonView, isChecked) -> {
            // Atualiza a seleção na ViewModel quando o estado do RadioButton muda
            viewModel.setFemininoSelected(isChecked);
        });


        // SWITCH GESTANTE
        viewModel.isGestanteSelected().observe(getViewLifecycleOwner(), isSelected -> {
            gestante = isSelected ? 1 : 0;
        });

        swtGestante.setOnCheckedChangeListener((buttonView, isChecked) -> {
            viewModel.setGestanteSelected(isChecked);
        });


        // SWITCH SEDENTARIO
        viewModel.isSedentarioSelected().observe(getViewLifecycleOwner(), isSelected -> {
            sedentario = isSelected ? 1 : 0;
        });

        swtSedentario.setOnCheckedChangeListener((buttonView, isChecked) -> {
            viewModel.setSedentarioSelected(isChecked);
        });


        // BOTÃO CADASTRAR
        btnCadastrar.setOnClickListener(v -> {
            pessoa = getInputs();
            pessoaController.create(pessoa);
            pessoaController.mostrarMensagem("inserido");
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


}