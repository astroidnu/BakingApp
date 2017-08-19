package com.scoproject.bakingapp.adapter;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.gson.Gson;
import com.scoproject.bakingapp.R;
import com.scoproject.bakingapp.data.Baking;
import com.scoproject.bakingapp.data.Ingredient;
import com.scoproject.bakingapp.data.Step;
import com.scoproject.bakingapp.ui.activity.home.HomeActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ibnumuzzakkir on 8/17/17.
 * Android Engineer
 * SCO Project
 */

public class ReceipeAdapter extends RecyclerView.Adapter<ReceipeAdapter.ViewHolder> {
    private List<Baking> mBakingList;
    private LayoutInflater mLayoutInflater;
    private Context mContext;

    public ReceipeAdapter(List<Baking> bakingList){
        mBakingList = bakingList;
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
        Baking baking = mBakingList.get(position);
        holder.mTvReceipeName.setText(baking.getName());
        holder.mCardViewReceipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                ArrayList<Ingredient> ingredientArrayList = new ArrayList<>();
                ArrayList<Step> arrayList  = new ArrayList<>();
                arrayList.addAll(baking.getSteps());
                ingredientArrayList.addAll(baking.getIngredients());
                bundle.putParcelableArrayList("step_data",  arrayList);
                bundle.putParcelableArrayList("ingredient_data",  ingredientArrayList);
                ((HomeActivity)mContext).loadFragment("stepFragment", bundle, baking.getName());
            }
        });
    }

    @Override
    public int getItemCount() {
        return mBakingList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView mTvReceipeName;
        CardView mCardViewReceipe;

        public ViewHolder(View itemView) {
            super(itemView);
            mCardViewReceipe = itemView.findViewById(R.id.card_receipe);
            mTvReceipeName = itemView.findViewById(R.id.tv_receipe_name);
        }
    }
}
