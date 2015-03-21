package com.kmangutov.crowdsolve.views;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.kmangutov.crowdsolve.R;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by kmangutov on 3/21/15.
 */
public class AnalyzeFragment extends Fragment {

    @InjectView(R.id.chart1)
    PieChart mChart;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_analyze, container, false);
        ButterKnife.inject(this, view);

        mChart.setHoleRadius(60f);
        mChart.setCenterText("Question");
        mChart.setRotationEnabled(false);


        fuck();

        return view;
    }

    protected void fuck() {

        ArrayList<Entry> q1 = new ArrayList<Entry>();

        Entry a = new Entry(125f, 0);
        Entry b = new Entry(50f, 1);

        q1.add(a);
        q1.add(b);

        PieDataSet data = new PieDataSet(q1, "Question 1");

        ArrayList<String> xVals = new ArrayList<String>();
        xVals.add("Answer one");
        xVals.add("Answer two");

        data.setColors(ColorTemplate.COLORFUL_COLORS);

        PieData plotData = new PieData(xVals, data);

        mChart.setData(plotData);
        mChart.invalidate();
    }
}