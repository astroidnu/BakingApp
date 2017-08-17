package com.scoproject.bakingapp.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.scoproject.bakingapp.BakingApp;
import com.scoproject.bakingapp.R;
import com.scoproject.bakingapp.adapter.ReceipeAdapter;
import com.scoproject.bakingapp.data.Baking;
import com.scoproject.bakingapp.ui.activity.home.HomeActivity;
import com.scoproject.bakingapp.ui.activity.home.HomeModule;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ibnumuzzakkir on 8/17/17.
 * Android Engineer
 * SCO Project
 */

public class ReceipeFragment extends Fragment implements ReceipeContract.View {
    @Inject
    ReceipePresenter mReceipePresenter;

    @BindView(R.id.rv_receipe)
    RecyclerView mRvReceipe;

    private ReceipeContract.UserActionListener mActionListener;
    private ReceipeAdapter mReceipeAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_receipe, container, false);
        setupFragmentComponent();
        mActionListener = mReceipePresenter;
        mActionListener.getBakingData();
        mReceipePresenter.setView(this);
        ButterKnife.bind(this, view);
        return view;
    }

    private void setupFragmentComponent() {
        BakingApp.get()
                .getAppComponent()
                .plus(new HomeModule((HomeActivity) getActivity()))
                .inject(this);
    }

    @Override
    public void setReceipeAdapter(List<Baking> bakingList) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        mReceipeAdapter = new ReceipeAdapter(bakingList);
        mRvReceipe.setLayoutManager(linearLayoutManager);
        mRvReceipe.setAdapter(mReceipeAdapter);
    }
}
