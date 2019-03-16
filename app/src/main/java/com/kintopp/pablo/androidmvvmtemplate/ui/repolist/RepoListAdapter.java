package com.kintopp.pablo.androidmvvmtemplate.ui.repolist;

import android.view.ViewGroup;

import com.kintopp.pablo.androidmvvmtemplate.databinding.RepoItemBinding;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RepoListAdapter extends RecyclerView.Adapter<RepoListAdapter.CustomViewHolder>{


    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    protected class CustomViewHolder extends RecyclerView.ViewHolder {

        private RepoItemBinding binding;
        public CustomViewHolder(RepoItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }


    }
}
