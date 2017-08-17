package com.scoproject.bakingapp.ui.activity.home;

/**
 * Created by ibnumuzzakkir on 8/17/17.
 * Android Engineer
 * SCO Project
 */

public class HomeContract {
    public interface View{
        void loadFragment(String fragmentId);
        void setupFragment();
    }
    public interface UserActionListener{
        void getBakingData();
    }
}

