package com.kmangutov.crowdsolve;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;

import com.astuetz.PagerSlidingTabStrip;
import com.kmangutov.crowdsolve.adapters.MyPagerAdapter;
import com.kmangutov.crowdsolve.singletons.LoggedInUser;


import butterknife.ButterKnife;
import butterknife.InjectView;
/**
 * Created by kmangutov on 3/18/15.
 */
public class MainActivity extends ActionBarActivity {

    @InjectView(R.id.viewPager)
    ViewPager mPager;

    @InjectView(R.id.tabs)
    PagerSlidingTabStrip mTabs;

    MyPagerAdapter mMyPagerAdapter;

    LoggedInUser mLoggedInUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);

        getSupportActionBar().setTitle("CrowdSolve");
        getSupportActionBar().setBackgroundDrawable(
                new ColorDrawable(Color.parseColor("#60B9CE")));

        mMyPagerAdapter = new MyPagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(mMyPagerAdapter);
        mTabs.setViewPager(mPager);

        mTabs.setIndicatorColorResource(R.color.color_foreground);
        mTabs.setBackgroundColor(Color.parseColor("#E0E0E0"));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }
}
