package com.scoproject.bakingapp.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.scoproject.bakingapp.R;
import com.scoproject.bakingapp.data.Step;

import java.util.List;

/**
 * Created by ibnumuzzakkir on 8/17/17.
 * Android Engineer
 * SCO Project
 */

public class StepAdapter extends RecyclerView.Adapter<StepAdapter.ViewHolder> {
    private List<Step> mStepList;
    private LayoutInflater mLayoutInflater;

    public StepAdapter(List<Step> stepList){
        mStepList = stepList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mLayoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = mLayoutInflater.inflate(R.layout.item_step, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Step step = mStepList.get(position);
        holder.mStepName.setText(step.getDescription());
    }

    @Override
    public int getItemCount() {
        return mStepList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView mStepName;
        public ViewHolder(View itemView) {
            super(itemView);
            mStepName = itemView.findViewById(R.id.tv_step_name);

        }
    }
}
