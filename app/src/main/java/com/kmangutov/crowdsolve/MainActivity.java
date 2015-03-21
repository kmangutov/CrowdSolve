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

        getSupportActionBar().setTitle("CrowdSolve");
        getSupportActionBar().setBackgroundDrawable(
                new ColorDrawable(Color.parseColor("#60B9CE")));

        mMyPagerAdapter = new MyPagerAdapter(this.getSupportFragmentManager());
        mPager.setAdapter(mMyPagerAdapter);
        mTabs.setViewPager(mPager);

        //mTabs.setUnderlineColorResource(R.color.color_black);
        mTabs.setIndicatorColorResource(R.color.color_foreground);
        //mTabs.setTextColorResource(R.color.color_white);
        //mTabs.setTabBackground(R.color.color_black);
        mTabs.setBackgroundColor(Color.parseColor("#E0E0E0"));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }
}
