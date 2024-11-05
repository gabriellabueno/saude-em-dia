package br.edu.fatec.diariosaude.view;

import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import br.edu.fatec.diariosaude.R;

public class SugestaoFragment extends Fragment {

    //SugestaoAdapter adapter;
    Button btnSugestao;

    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        // Apresenta o layout do Fragment
        View view = inflater.inflate(R.layout.fragment_sugestao, container, false);


        btnSugestao = view.findViewById(R.id.btnSugestao);

        //adapter = new SugestaoAdapter(getContext());

        btnSugestao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}