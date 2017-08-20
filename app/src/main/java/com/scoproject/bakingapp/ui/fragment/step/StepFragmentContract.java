package com.scoproject.bakingapp.ui.fragment.step;

import com.scoproject.bakingapp.data.Ingredient;
import com.scoproject.bakingapp.data.Step;

import java.util.List;

/**
 * Created by ibnumuzzakkir on 8/17/17.
 * Android Engineer
 * SCO Project
 */

public class StepFragmentContract {
    public interface View{
        void setStepAdapter(List<Step> stepList,List<Ingredient> ingredientList);
    }

    public interface UserActionListener{
    }
}
