package com.example.recycler157_1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recycler157_1.databinding.WordItemListBinding;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.Viewholderwords> {
   List<String> mwordList;

    public Adapter(List<String> mwordList) {
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


    public class Viewholderwords extends RecyclerView.ViewHolder {
        public TextView textView;

        public Viewholderwords(@NonNull WordItemListBinding mBinding) {
            super(mBinding.getRoot());
            textView = mBinding.textView;

        }
    }
}
