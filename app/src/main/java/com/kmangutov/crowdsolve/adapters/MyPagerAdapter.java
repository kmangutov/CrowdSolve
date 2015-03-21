package com.kmangutov.crowdsolve.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.kmangutov.crowdsolve.views.AnalyzeFragment;
import com.kmangutov.crowdsolve.views.LoginFragment;
import com.kmangutov.crowdsolve.views.PostFragment;
import com.kmangutov.crowdsolve.views.QuestionFragment;

/**
 * Created by kmangutov on 3/21/15.
 */
public class MyPagerAdapter extends FragmentPagerAdapter {

    QuestionFragment mQuestionFragment;
    PostFragment mPostFragment;
    AnalyzeFragment mAnalyzeFragment;

    public MyPagerAdapter(FragmentManager manager) {

        super(manager);
    }

    @Override
    public int getCount() {

        return 3;
    }

    @Override
    public Fragment getItem(int position) {

        switch(position) {
            case 0:
                if(mQuestionFragment == null)
                    return (mQuestionFragment = new QuestionFragment());

            case 1:
                if(mPostFragment == null)
                    return (mPostFragment = new PostFragment());

            case 2:
                if(mAnalyzeFragment == null)
                    return (mAnalyzeFragment = new AnalyzeFragment());

            default: return null;
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {

        switch(position) {
            case 0:
                return "Answer";

            case 1:
                return "Ask";

            case 2:
                return "Analyze";

            default: return "Tab " + position;
        }
    }
}
