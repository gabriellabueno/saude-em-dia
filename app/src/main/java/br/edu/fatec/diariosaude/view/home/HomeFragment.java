package br.edu.fatec.diariosaude.view.home;

import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import com.google.android.material.textfield.TextInputEditText;

import br.edu.fatec.diariosaude.R;

public class HomeFragment extends Fragment {

    private HomeViewModel viewModel;

    Button btnComecar;
    TextView txtHome;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        // Infla o layout do Fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        // Inicializa a ViewModel associada ao Fragment
        viewModel = new ViewModelProvider(this).get(HomeViewModel.class);


        btnComecar = view.findViewById(R.id.btnComecar);
        txtHome = view.findViewById((R.id.txtHome));

        // Insere texto no TextInputEditText (edtIntroducao)
        // NÃO TÁ FUNCIONANDO
        /* String htmlText = "<b>Bem-vindo ao Saúde em Dia!</b>\\n\n" +
        "        Sua jornada para uma vida saudável começa aqui.\n" +
                "        Nós acreditamos que cada pessoa é única, e por isso oferecemos\n" +
                "        sugestões personalizadas de alimentação e exercícios físicos,\n" +
                "        levando em consideração suas características corporais.\\n\n" +
                "        <b>Com o Saúde em Dia, você terá acesso a:\\n</b>\n" +
                "        <u>Planos de Alimentação Personalizados:</u> Dicas de refeições saudáveis adaptadas às suas necessidades.\\n\n" +
                "        <u>Rotinas de Exercícios:</u> Sugestões de atividades físicas que se encaixam no seu perfil e estilo de vida.\\n\n" +
                "        Prepare-se para transformar sua saúde e bem-estar de forma simples e eficaz.\\n<b>Vamos juntos nessa jornada!</b>";
        edtIntroducao.setText(Html.fromHtml(htmlText, Html.FROM_HTML_MODE_LEGACY));
        */


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