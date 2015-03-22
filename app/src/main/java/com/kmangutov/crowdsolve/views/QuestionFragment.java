package com.kmangutov.crowdsolve.views;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.kmangutov.crowdsolve.R;
import com.kmangutov.crowdsolve.models.Question;
import com.kmangutov.crowdsolve.services.QuestionService;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by kmangutov on 3/21/15.
 */
public class QuestionFragment extends Fragment {

    protected static final String LOG_ID = "QuestionFragment";

    @InjectView(R.id.textViewQuestion)
    TextView mTextViewQuestion;

    @InjectView(R.id.buttonOptionOne)
    Button mButtonOptionOne;

    @InjectView(R.id.buttonOptionTwo)
    Button mButtonOptionTwo;

    QuestionService mQuestionService;

    protected int mQuestionId = 1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_question, container, false);
        ButterKnife.inject(this, view);

        mQuestionService = QuestionService.getInstance();
        loadQuestion(mQuestionId);

        return view;
    }

    public void loadQuestion(int question) {

        /*mQuestionService.mApi
                .getQuestion(question)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Question>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Question question) {
                        loadQuestion(question);
                    }
                });*/
    }

    @OnClick(R.id.buttonOptionOne)
    public void onOptionOne() {

        loadQuestion(++mQuestionId);
    }

    @OnClick(R.id.buttonOptionTwo)
    public void onOptionTwo() {

        loadQuestion(++mQuestionId);
    }

    public void loadQuestion(Question question) {

        Log.d(LOG_ID, "in loadQuestion(Question q)");
        mTextViewQuestion.setText(question.question);
        mButtonOptionOne.setText(question.options.get(0));
        mButtonOptionTwo.setText(question.options.get(1));
    }
}