package com.kmangutov.crowdsolve.views;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.kmangutov.crowdsolve.R;
import com.kmangutov.crowdsolve.models.Question;
import com.kmangutov.crowdsolve.models.ServerResponse;
import com.kmangutov.crowdsolve.services.QuestionService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.android.view.ViewActions;
import rx.android.widget.OnTextChangeEvent;
import rx.android.widget.WidgetObservable;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by kmangutov on 3/21/15.
 */
public class PostFragment extends Fragment {


    @InjectView(R.id.textViewOptions)
    TextView mTextViewOptions;

    @InjectView(R.id.editTextAddOption)
    EditText mEditTextAddOption;

    @InjectView(R.id.textViewOptionsTitle)
    TextView mTextViewOptionsTitle;

    @InjectView(R.id.buttonAddOption)
    Button mButtonAddOption;

    @InjectView(R.id.buttonAsk)
    Button mButtonAsk;

    @InjectView(R.id.editTextTitle)
    EditText mEditTextTitle;

    QuestionService mQuestionService;

    protected int count = 0;
    protected static final int COUNT_MAX = 4;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_post, container, false);
        ButterKnife.inject(this, view);

        mButtonAsk.setEnabled(false);
        mButtonAddOption.setEnabled(false);
        setCountTitle();

        setupAddHook();
        mQuestionService = new QuestionService();

        return view;
    }

    String email;
    public void setEmail(String email) {
        this.email = email;
    }

    //only enable awdd button if there is text in textfield
    public void setupAddHook() {

        WidgetObservable.text(mEditTextAddOption)
                .map(new Func1<OnTextChangeEvent, String>() {
                    @Override
                    public String call(OnTextChangeEvent onTextChangeEvent) {
                        return onTextChangeEvent.text().toString();
                    }
                })
                .map(new Func1<String, Boolean>() {
                    @Override
                    public Boolean call(String s) {
                        return !s.equals("");
                    }
                })
                .subscribe(ViewActions.setEnabled(mButtonAddOption));

    }

    public void setCountTitle() {

        mTextViewOptionsTitle.setText("Options (" + count + "/" + COUNT_MAX + ")");
    }

    List<String> options = new ArrayList<String>();
    public Question getQuestion() {

        Question question = new Question();
        question.question = mEditTextTitle.getText().toString().replaceAll("\n", "");

        HashMap<Integer, String> map = new HashMap<>();
        for(int i = 0; i < options.size(); i++)
            map.put(i, options.get(i).replaceAll("\n", ""));

        question.answers = map;
        options = new ArrayList<String>();
        question.email = email;

        return question;
    }

    public void postQuestion() {

        mQuestionService.mApi
                .postQuestion(getQuestion())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ServerResponse>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(ServerResponse resp) {

                        System.out.println("response: " + resp.message);
                    }
                });
    }

    @OnClick(R.id.buttonAddOption)
    public void onAdd() {

        if(count >= 1)
            mButtonAsk.setEnabled(true);

        if(count == COUNT_MAX) {

            return;
        }

        String str = mEditTextAddOption.getText().toString();
        mTextViewOptions.append("\n - " + str);
        options.add(str);

        count++;
        setCountTitle();
        mEditTextAddOption.setText("");

        if(count == COUNT_MAX)
            mButtonAddOption.setEnabled(false);
    }

    @OnClick(R.id.buttonAsk)
    public void onAsk() {

        postQuestion();

        mButtonAddOption.setEnabled(true);
        mEditTextAddOption.setText("");
        mTextViewOptions.setText("");
        mEditTextTitle.setText("");
        count = 0;
        setCountTitle();
        mButtonAsk.setEnabled(false);
    }
}
