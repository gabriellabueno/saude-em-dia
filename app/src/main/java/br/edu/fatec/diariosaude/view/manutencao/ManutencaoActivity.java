package br.edu.fatec.diariosaude.view.manutencao;


import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;


import br.edu.fatec.diariosaude.R;
import br.edu.fatec.diariosaude.controller.PessoaController;
import br.edu.fatec.diariosaude.model.Pessoa;

public class ManutencaoActivity extends AppCompatActivity {

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

    private Integer idPessoaSelecionada;

    // Variáveis para controller:
    PessoaController pessoaController;
    Pessoa pessoa;

    // Variáveis para definir valores booleanos
    // Salvos como INT pois o BD não aceita booleano
    private Integer sexo;
    private Integer gestante;
    private Integer sedentario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manutencao);


        // Variáveis para componentes XML
        edtNome = findViewById(R.id.edtNome);
        edtIdade = findViewById(R.id.edtIdade);
        edtPeso = findViewById(R.id.edtPeso);
        edtAltura = findViewById(R.id.edtAltura);
        swtSedentario = findViewById(R.id.swtSedentario);
        rdbMasculino = findViewById(R.id.rdbMasculino);
        rdbFeminino = findViewById(R.id.rdbFeminino);
        swtGestante = findViewById(R.id.swtGestante);
        rdbDiabetes = findViewById(R.id.rdbDiabetes);
        rdbHipertensao = findViewById(R.id.rdbHipertensao);
        rdbCardiopatia = findViewById(R.id.rdbCardiopatia);
        btnAtualizar = findViewById(R.id.btnAtualizar);
        btnExcluir = findViewById(R.id.btnExcluir);

        // Recebe ID da pessoa selecionada para preencher campos
        Intent it = getIntent();
        idPessoaSelecionada = it.getIntExtra("id-pessoa-selecionada", 0);

        // Preenche campos de input com dados do Aluno selecionado
        // a partir do ID (necessário chamar método READ da controller/DAO)

        pessoaController = new PessoaController(getApplicationContext());

        //MÉTODO NÃO FUNCIONA
        // Botão Atualizar
        btnAtualizar.setOnClickListener(v -> {
            pessoa = getInputs();
            pessoa.setId(idPessoaSelecionada);
            pessoaController.update(pessoa);
            pessoaController.mostrarMensagem("atualizada");
        });


        //Botão Excluir
        btnExcluir.setOnClickListener(v -> {
            pessoa = new Pessoa();
            pessoa.setId(idPessoaSelecionada);
            pessoaController.delete(pessoa);
            pessoaController.mostrarMensagem("removida");
        });

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