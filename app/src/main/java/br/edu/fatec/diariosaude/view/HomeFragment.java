package br.edu.fatec.diariosaude.view;

import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import br.edu.fatec.diariosaude.R;

public class HomeFragment extends Fragment {

    Button btnComecar;
    TextView txtIntroducao;
    String frase1, frase2, frase3, frase4, frase5;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        // Apresenta o layout do Fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);


        btnComecar = view.findViewById(R.id.btnComecar);
        txtIntroducao = view.findViewById((R.id.txtIntroducao));
        frase1 = "Atividades físicas quando praticadas regularmente trazem inúmeros benefícios para a saúde corporal e mental.";
        frase2 = "É necessário uma alimentação equilibrada para o bom funcionamento do organismo, tanto do corpo quanto da mente.";
        frase3 = "Deve-se começar com pequenas quantidades de atividade física e aumentar gradualmente a frequência, intensidade e a duração.";
        frase4 = "Qualquer quantidade de atividade física é melhor do que nenhuma, e quanto mais, melhor.";
        frase5 = "A ciência demonstra a importância da alimentação saudável e da nutrição de crianças antes mesmo do nascimento.";


        // Insere texto no TextView (txtIntroducao)
        String htmlText = "<div style='text-align: left;'>" +
                "<b>Bem-vindo ao Saúde em Dia!</b><br><br>" +
        "        Sua jornada para uma vida saudável começa aqui." +
                "        Nós acreditamos que cada pessoa é única, e por isso oferecemos<br>" +
                "        sugestões personalizadas de alimentação e exercícios físicos,<br>" +
                "        levando em consideração suas características corporais.<br><br>" +
                "        <b>Com o Saúde em Dia, você terá acesso a:</b><br>" +
                "        <u>- Planos de Alimentação Personalizados:</u> Dicas de refeições saudáveis adaptadas às suas necessidades.<br>" +
                "        <u>- Rotinas de Exercícios:</u> Sugestões de atividades físicas que se encaixam no seu perfil e estilo de vida.<br>" +
                "        Prepare-se para transformar sua saúde e bem-estar de forma simples e eficaz.<br>" +
                "        <b>Vamos juntos nessa jornada!</b>" +
                "        </div>";
        txtIntroducao.setText(Html.fromHtml(htmlText, Html.FROM_HTML_MODE_LEGACY));



        // BOTÃO COMEÇAR
        // Redireciona para tela de Cadastro
        btnComecar.setOnClickListener(v -> {
            NavController navController = NavHostFragment.findNavController(this);
            navController.navigate(R.id.action_home_to_cadastro);
        });


        return view;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }


}