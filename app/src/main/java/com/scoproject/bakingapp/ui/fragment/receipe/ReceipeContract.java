package com.scoproject.bakingapp.ui.fragment.receipe;

import com.scoproject.bakingapp.data.Receipe;

import java.util.List;

/**
 * Created by ibnumuzzakkir on 8/17/17.
 * Android Engineer
 * SCO Project
 */

public class ReceipeContract {
    public interface View{
        void setReceipeAdapter(List<Receipe> receipeList);
    }
    public interface UserActionListener{
        void getBakingData();
    }
}
