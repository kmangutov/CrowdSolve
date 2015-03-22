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
import com.kmangutov.crowdsolve.models.Question;

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

        Question q = new Question();
        q.question = "Should I get Chinese or Mexican food?";
        q.options = new ArrayList<String>();
        q.options.add("Chinese");
        q.options.add("Mexican");

        dummyChart(q);

        return view;
    }

    protected void dummyChart(Question q) {

        mChart.setHoleRadius(60f);
        mChart.setCenterText(q.question);
        mChart.setDescription("Results");
        mChart.setRotationEnabled(false);

        ArrayList<Entry> q1 = new ArrayList<Entry>();

        Entry a = new Entry(125f, 0);
        Entry b = new Entry(50f, 1);

        q1.add(a);
        q1.add(b);

        PieDataSet data = new PieDataSet(q1, "");

        ArrayList<String> xVals = new ArrayList<String>();
        for(String s : q.options)
            xVals.add(s);

        data.setColors(ColorTemplate.COLORFUL_COLORS);

        PieData plotData = new PieData(xVals, data);

        mChart.setData(plotData);
        mChart.invalidate();
    }
}