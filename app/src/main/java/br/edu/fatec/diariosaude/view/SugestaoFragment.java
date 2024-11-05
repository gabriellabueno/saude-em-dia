package br.edu.fatec.diariosaude.view;

import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import br.edu.fatec.diariosaude.R;
import br.edu.fatec.diariosaude.util.IMC_indice;

public class SugestaoFragment extends Fragment {
    TextView txtSugestoesFixas;
    TextView txtIndice_IMC;
    TextView txtIMC;
    TextView txtSugestoesAlimentares;
    TextView txtAtividadeFixa;
    TextView txtAtividadeFisica;
    TextView txtGravida;
    TextView txtSedentario;
    Button btnSugestao;

    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        // Apresenta o layout do Fragment
        View view = inflater.inflate(R.layout.fragment_sugestao, container, false);

        txtSugestoesFixas = view.findViewById(R.id.txtSugestoesFixas);
        txtIndice_IMC = view.findViewById(R.id.txtIndice_IMC);
        txtIMC = view.findViewById(R.id.txtIMC);
        txtSugestoesAlimentares = view.findViewById(R.id.txtSugestoesAlimentares);
        txtAtividadeFixa = view.findViewById(R.id.txtAtividadeFixa);
        txtAtividadeFisica = view.findViewById(R.id.txtAtividadeFisica);
        txtGravida = view.findViewById(R.id.txtGravida);
        txtSedentario = view.findViewById(R.id.txtSedentario);
        btnSugestao = view.findViewById(R.id.btnSugestao);



        // Insere texto no TextView (txtSugestoesFixas)
        String htmlText = "A <u>Organização Mundial da Saúde (OMS)</u> atualizou as recomendações alimentares sobre o consumo de carboidratos e gorduras para adultos e crianças. As novas diretrizes visam à limitação do consumo para a redução de ganho de peso prejudicial à saúde. Evidências científicas mostram a relação entre a ingestão excessiva desses produtos e os riscos de doenças. A qualidade e a quantidade são ambas importantes para uma boa saúde, conforme indica a OMS.<br>\n" +
                "A alimentação saudável é fundamental para prevenir contra doenças crônicas. Uma dieta rica em alimentos ultraprocessados, além de aumentar o risco de desenvolver diabetes, obesidade, hipertensão e câncer, pode intensificar os sintomas relacionados à má digestão, à inflamação e a transtornos de neurodesenvolvimento.\n";
        txtSugestoesFixas.setText(Html.fromHtml(htmlText, Html.FROM_HTML_MODE_LEGACY));

        // MOSTRAR O ÍNDICE DA PESSOA
        /*
        txtIndice_IMC.setText(indice);
         */

        // PEGAR IMC DA PESSOA E COLOCAR
        /*
        if (idade < 65) {
            if (imc < 18.5) {
                txtIMC.setText(IMC_indice.ABAIXO);
                Toast.makeText(this, "IMC BAIXO!", Toast.LENGTH_LONG).show();
                }
            else if (18.6 < imc < 24.9)
                    txtIMC.setText(IMC_indice.NORMAL);
                else if (25.0 < imc < 29.9) {
                    txtIMC.setText(IMC_indice.SOBREPESO);
                    Toast.makeText(this, "IMC ALTO!", Toast.LENGTH_LONG).show();
                    }
                else if (30.0 < imc 34.9) {
                txtIMC.setText(IMC_indice.OBESIDADE1);
                Toast.makeText(this, "IMC ALTO!", Toast.LENGTH_LONG).show();
                }
            else if (35.0 < imc < 39.9) {
                    txtIMC.setText(IMC_indice.OBESIDADE2);
                    Toast.makeText(this, "IMC ALTO!", Toast.LENGTH_LONG).show();
                    }
                else txtIMC.setText(IMC_indice.OBESIDADE3);
                Toast.makeText(this, "IMC ALTO!", Toast.LENGTH_LONG).show();
            } else if (imc < 22.0) {
                txtIMC.setText(IMC_indice.ABAIXO);
                Toast.makeText(this, "IMC BAIXO!", Toast.LENGTH_LONG).show();
                }
            else if (22.0 < imc < 27.0)
                txtIMC.setText(IMC_indice.NORMAL);
            else if (27.0 < imc < 29.9) {
                txtIMC.setText(IMC_indice.SOBREPESO);
                Toast.makeText(this, "IMC ALTO!", Toast.LENGTH_LONG).show();
                }
            else txtIMC.setText(IMC_indice.OBESIDADE);
            Toast.makeText(this, "IMC ALTO!", Toast.LENGTH_LONG).show();
        }
        */

        // PEGAR SUGESTÃO DE ALIMENTAÇÃO GERADA E COLOCAR NO TEXTVIEW (TXTSUGESTOESALIMENTARES)
        /*
        txtSugestoesAlimentares.setText(sugestao);
         */

        // Insere texto no TextView (txtAtividadeFixa)
        String htmlText1 = "Atividades físicas quando praticadas regularmente trazem inúmeros benefícios para a saúde corporal e mental.<br>" +
                "            Qualquer quantidade de atividade física é melhor do que nenhuma, e quanto mais, melhor.<br>" +
                "            Deve-se começar com pequenas quantidades de atividade física e aumentar gradualmente a frequência, intensidade e a duração.";

        txtAtividadeFixa.setText(Html.fromHtml(htmlText1, Html.FROM_HTML_MODE_LEGACY));

        // PEGAR SUGESTÃO DE ATIVIDADE FÍSICA GERADA E COLOCAR NO TEXTVIEW (TXTATIVIDADEFISICA)
        /*
        txtAtividadeFisica.setText(sugestao);
        */

        // SE GRÁVIDA
        /*
        txtGravida.setText(Fixas.GRAVIDEZ.getMessage());
        */

        // SE SEDENTÁRIO, PEGAR SUGESTÃO PARA SEDENTÁRIO AO INVÉS DE SUGESTÃO NORMAL DE EXERCÍCIO
        /*txtSedentario.setText(sugestao);
         */
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}