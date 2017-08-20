package com.scoproject.bakingapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.scoproject.bakingapp.R;
import com.scoproject.bakingapp.data.Receipe;
import com.scoproject.bakingapp.data.Ingredient;
import com.scoproject.bakingapp.data.Step;
import com.scoproject.bakingapp.ui.activity.home.HomeActivity;
import com.scoproject.bakingapp.ui.activity.step.StepActivity;
import com.scoproject.bakingapp.utils.Helper;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ibnumuzzakkir on 8/17/17.
 * Android Engineer
 * SCO Project
 */

public class ReceipeAdapter extends RecyclerView.Adapter<ReceipeAdapter.ViewHolder> {
    private List<Receipe> mReceipeList;
    private LayoutInflater mLayoutInflater;
    private Context mContext;

    public ReceipeAdapter(List<Receipe> receipeList){
        mReceipeList = receipeList;
        notifyDataSetChanged();

    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        mLayoutInflater = LayoutInflater.from(mContext);
        View itemView = mLayoutInflater.inflate(R.layout.item_receipe, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Receipe receipe = mReceipeList.get(position);
        holder.mTvReceipeName.setText(receipe.getName());
        if(!receipe.getImage().isEmpty()){
            Picasso.with(mContext).load(receipe.getImage()).placeholder(R.drawable.receipe_default_bg).into(holder.mImageReceipe);
        }else{
            Picasso.with(mContext).load(R.drawable.receipe_default_bg).into(holder.mImageReceipe);
        }

        holder.mCardViewReceipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, StepActivity.class);
                intent.putExtra("receipeData",receipe);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mReceipeList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView mTvReceipeName;
        CardView mCardViewReceipe;
        ImageView mImageReceipe;

        public ViewHolder(View itemView) {
            super(itemView);
            mCardViewReceipe = itemView.findViewById(R.id.card_receipe);
            mImageReceipe = itemView.findViewById(R.id.image_receipe);
            mTvReceipeName = itemView.findViewById(R.id.tv_receipe_name);
        }
    }
}
