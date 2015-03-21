package com.kmangutov.crowdsolve.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.kmangutov.crowdsolve.views.LoginFragment;
import com.kmangutov.crowdsolve.views.QuestionFragment;

/**
 * Created by kmangutov on 3/21/15.
 */
public class MyPagerAdapter extends FragmentPagerAdapter {

    QuestionFragment mQuestionFragment;
    LoginFragment mLoginFragmentOne;
    LoginFragment mLoginFragmentTwo;

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
                if(mLoginFragmentOne == null)
                    return (mLoginFragmentOne = new LoginFragment());

            case 2:
                if(mLoginFragmentTwo == null)
                    return (mLoginFragmentTwo = new LoginFragment());

            default: return null;
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {

        return "fager " + position;
    }
}
