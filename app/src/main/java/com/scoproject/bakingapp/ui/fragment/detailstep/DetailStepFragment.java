package com.scoproject.bakingapp.ui.fragment.detailstep;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.ui.SimpleExoPlayerView;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.util.Util;
import com.scoproject.bakingapp.BakingApp;
import com.scoproject.bakingapp.R;
import com.scoproject.bakingapp.data.Step;
import com.scoproject.bakingapp.ui.activity.detailstep.DetailStepActivity;
import com.scoproject.bakingapp.ui.activity.home.HomeActivity;
import com.scoproject.bakingapp.ui.activity.home.HomeModule;
import com.scoproject.bakingapp.ui.activity.step.StepActivity;
import com.scoproject.bakingapp.ui.activity.step.StepModule;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ibnumuzzakkir on 8/19/17.
 * Android Engineer
 * SCO Project
 */

public class DetailStepFragment extends Fragment implements DetailStepFragmentContract.View {
    @Inject
    DetailStepFragmentPresenter mDetailStepFragmentPresenter;

    @BindView(R.id.recipe_step_video)
    SimpleExoPlayerView mExoStepVideo;
    @BindView(R.id.recipe_step_description)
    TextView mTvStepDescription;


    private DetailStepFragmentContract.UserActionListener mActionListener;
    private int source = 0;
    private Step mStep = null;
    private AdaptiveTrackSelection.Factory videoTrackSelectionFactory;
    private DefaultTrackSelector trackSelector;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_detail_step, container, false);
        Bundle bundle = getArguments();
        ButterKnife.bind(this, view);
        if(bundle != null){
            source =  bundle.getInt("source");
            mStep = bundle.getParcelable("data");
            setupPlayer(mStep.getVideoURL());
            mTvStepDescription.setText(mStep.getDescription());
        }
        if(source == 0){
            BakingApp.get()
                    .getAppComponent()
                    .plus(new StepModule((StepActivity) getActivity()))
                    .inject(this);
        }else{
            BakingApp.get()
                    .getAppComponent()
                    .plus(new StepModule((DetailStepActivity) getActivity()))
                    .inject(this);
        }
        mActionListener = mDetailStepFragmentPresenter;
        mDetailStepFragmentPresenter.setView(this);
        return view;
    }


    private void setupPlayer(String url){
        DefaultBandwidthMeter bandwidthMeter = new DefaultBandwidthMeter();
        TrackSelection.Factory videoTrackSelectionFactory =
                new AdaptiveTrackSelection.Factory(bandwidthMeter);
        TrackSelector trackSelector =
                new DefaultTrackSelector(videoTrackSelectionFactory);
        SimpleExoPlayer player =
                ExoPlayerFactory.newSimpleInstance(getContext(), trackSelector);

        mExoStepVideo.setPlayer(player);

        DataSource.Factory dataSourceFactory = new DefaultDataSourceFactory(getContext(), "Baking App", bandwidthMeter);
        ExtractorsFactory extractorsFactory = new DefaultExtractorsFactory();
        MediaSource videoSource = new ExtractorMediaSource(Uri.parse(url),
                dataSourceFactory, extractorsFactory, null, null);
        player.prepare(videoSource);
    }


}
