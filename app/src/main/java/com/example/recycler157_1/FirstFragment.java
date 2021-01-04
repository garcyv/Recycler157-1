package com.example.recycler157_1;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.recycler157_1.databinding.FragmentFirstBinding;

import java.util.ArrayList;
import java.util.List;

public class FirstFragment extends Fragment {
    private FragmentFirstBinding mbinding;
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

             Adapter madapter = new Adapter(wordList());
             mbinding.rv.setAdapter(madapter);
             mbinding.rv.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    private List<String> wordList(){
        List<String> listado = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            listado.add("Palabra "+ i);
        }
        return listado;
    }

}