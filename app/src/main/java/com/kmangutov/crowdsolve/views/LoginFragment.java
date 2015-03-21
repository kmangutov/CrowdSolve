package com.kmangutov.crowdsolve.views;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kmangutov.crowdsolve.R;
import com.kmangutov.crowdsolve.services.QuestionService;

import butterknife.ButterKnife;

/**
 * Created by kmangutov on 3/21/15.
 */
public class LoginFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_login, container, false);
        ButterKnife.inject(this, view);

        return view;
    }

}
