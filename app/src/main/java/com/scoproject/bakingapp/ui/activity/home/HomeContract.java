package com.scoproject.bakingapp.ui.activity.home;

import android.os.Bundle;
import android.support.v4.app.Fragment;

/**
 * Created by ibnumuzzakkir on 8/17/17.
 * Android Engineer
 * SCO Project
 */

public class HomeContract {
    public interface View{
        void loadFragment(String fragmentId, Bundle bundle, String title);
        void setupFragment();
    }
    public interface UserActionListener{

    }
}

