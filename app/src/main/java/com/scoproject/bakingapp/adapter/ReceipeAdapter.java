package com.scoproject.bakingapp.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.scoproject.bakingapp.R;
import com.scoproject.bakingapp.data.Baking;

import java.util.List;

/**
 * Created by ibnumuzzakkir on 8/17/17.
 * Android Engineer
 * SCO Project
 */

public class ReceipeAdapter extends RecyclerView.Adapter<ReceipeAdapter.ViewHolder> {
    private List<Baking> mBakingList;
    private LayoutInflater mLayoutInflater;

    public ReceipeAdapter(List<Baking> bakingList){
        mBakingList = bakingList;
        notifyDataSetChanged();

    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mLayoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = mLayoutInflater.inflate(R.layout.item_receipe, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Baking baking = mBakingList.get(position);
        holder.mTvReceipeName.setText(baking.getName());
    }

    @Override
    public int getItemCount() {
        return mBakingList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView mTvReceipeName;

        public ViewHolder(View itemView) {
            super(itemView);
            mTvReceipeName = itemView.findViewById(R.id.tv_receipe_name);
        }
    }
}
