package com.kmangutov.crowdsolve;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);

        mMyPagerAdapter = new MyPagerAdapter(this.getSupportFragmentManager());
        mPager.setAdapter(mMyPagerAdapter);
        mTabs.setViewPager(mPager);
    }
}
