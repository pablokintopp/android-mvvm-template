package com.kintopp.pablo.androidmvvmtemplate.ui.repolist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.kintopp.pablo.androidmvvmtemplate.data.model.GithubRepo;
import com.kintopp.pablo.androidmvvmtemplate.databinding.RepoItemBinding;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RepoListAdapter extends RecyclerView.Adapter<RepoListAdapter.CustomViewHolder>{


    private List<GithubRepo> items;


    public RepoListAdapter() {
        this.items = new ArrayList<>();
    }


    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        RepoItemBinding itemBinding = RepoItemBinding.inflate(layoutInflater, parent, false);
        CustomViewHolder viewHolder = new CustomViewHolder(itemBinding);

        //ToDo setup item click on card click

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        holder.bind(getItem(position));
    }

    private GithubRepo getItem(int position){
        return this.items.get(position);
    }

    public List<GithubRepo> getItems() {
        return items;
    }

    public void setItems(List<GithubRepo> items) {
        this.items = items;
    }

    public void addItems(List<GithubRepo> items){
        this.items.addAll(items);
    }

    @Override
    public int getItemCount() {
        return this.items.size();
    }

    protected class CustomViewHolder extends RecyclerView.ViewHolder {

        private RepoItemBinding binding;
        public CustomViewHolder(RepoItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(GithubRepo repo){
            binding.setRepo(repo);
            binding.executePendingBindings();
        }


    }
}
