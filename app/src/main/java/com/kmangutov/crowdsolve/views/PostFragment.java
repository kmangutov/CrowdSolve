package com.kmangutov.crowdsolve.views;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.kmangutov.crowdsolve.R;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by kmangutov on 3/21/15.
 */
public class PostFragment extends Fragment {

    @InjectView(R.id.layoutOptions)
    LinearLayout mLayoutOptions;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_post, container, false);
        ButterKnife.inject(this, view);

        return view;
    }

    @OnClick(R.id.buttonAsk)
    public void onAsk() {

        LayoutInflater inflater =
                (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        ViewGroup parent = (ViewGroup) mLayoutOptions;
        inflater.inflate(R.layout.view_edittext, parent);
    }
}
