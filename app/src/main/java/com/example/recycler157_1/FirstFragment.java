package com.example.recycler157_1;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.recycler157_1.databinding.FragmentFirstBinding;

import java.util.ArrayList;
import java.util.List;

public class FirstFragment extends Fragment implements Adapter.PasarElemento {
    private FragmentFirstBinding mbinding;
    List<String> listado = new ArrayList<>();

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        mbinding = FragmentFirstBinding.inflate(inflater,container,false);
        return mbinding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

             Adapter madapter = new Adapter(wordList(),this);
             mbinding.rv.setAdapter(madapter);
             mbinding.rv.setLayoutManager(new LinearLayoutManager(getContext()));

             mbinding.btnfab.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {
                     listado.add("Palabra " + listado.size());
                     mbinding.rv.getAdapter().notifyItemInserted(listado.size());
                     mbinding.rv.smoothScrollToPosition(listado.size());
                 }
             });
    }

    private List<String> wordList(){

        for (int i = 0; i < 10; i++) {
            listado.add("Palabra "+ i);
        }
        return listado;
    }

    @Override
    public void passElement(String elemento) {
       // Toast.makeText(getContext(), elemento, Toast.LENGTH_SHORT).show();
        Log.d("CLICK",elemento);
        Bundle bundle = new Bundle();
        String name = elemento;
        bundle.putString("name", name);
        Navigation.findNavController(mbinding.getRoot())
                .navigate(R.id.action_FirstFragment_to_SecondFragment,bundle);
    }
}