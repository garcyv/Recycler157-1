package com.example.recycler157_1;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recycler157_1.databinding.WordItemListBinding;

import java.util.ArrayList;
import java.util.List;

import android.widget.Toast;

public class Adapter extends RecyclerView.Adapter<Adapter.Viewholderwords> {
   List<String> mwordList;
   // referencia interface
    private PasarElemento pasarElemento;

    public Adapter(List<String> mwordList,PasarElemento pasarElemento) {
        this.pasarElemento= pasarElemento;
        this.mwordList = mwordList;
    }

    @NonNull
    @Override
    // devuelve objeto viwholder , la calse que definimos
    public Viewholderwords onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        WordItemListBinding mBinding;
        mBinding= WordItemListBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new Viewholderwords(mBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholderwords holder, int position) {
       String word = mwordList.get(position);
       holder.textView.setText(word);

    }

    @Override
    public int getItemCount() {
        return mwordList.size();
    }


    public class Viewholderwords extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView textView;

        public Viewholderwords(@NonNull WordItemListBinding mBinding) {
            super(mBinding.getRoot());
            textView = mBinding.textView;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = getLayoutPosition();
            String element = mwordList.get(position);
            Toast.makeText(v.getContext(), element, Toast.LENGTH_LONG).show();
         mwordList.set(position,element+"click");
         notifyDataSetChanged();
         pasarElemento.passElement(element);
        }
    }

    public interface PasarElemento{
        void passElement(String elemento);
    }

}
