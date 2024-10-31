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
import br.edu.fatec.diariosaude.model.Pessoa;

public class Manutencao extends AppCompatActivity {

    private EditText edtNome;
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

    private Integer idPessoaSelecionada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manutencao);


        // Variáveis para componentes XML
        edtNome = findViewById(R.id.edtNome);
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

        // Recebe ID da pessoa selecionada para preencher campos
        Intent it = getIntent();
        idPessoaSelecionada = it.getIntExtra("id-pessoa-selecionada", 0);

        // Preenche campos de input com dados do Aluno selecionado
        // a partir do ID (necessário chamar método READ da controller/DAO)


        // Botão Atualizar
        btnAtualizar.setOnClickListener(v -> {
            //pessoa = new Pessoa();
            //pessoaController.update(pessoa);
        });




    }



}