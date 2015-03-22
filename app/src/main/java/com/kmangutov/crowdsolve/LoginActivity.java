package com.kmangutov.crowdsolve;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.kmangutov.crowdsolve.models.ServerResponse;
import com.kmangutov.crowdsolve.models.User;
import com.kmangutov.crowdsolve.services.QuestionService;
import com.kmangutov.crowdsolve.singletons.LoggedInUser;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


public class LoginActivity extends Activity {

    @InjectView(R.id.editTextEmail)
    EditText mEditTextEmail;

    @InjectView(R.id.editTextPassword)
    EditText mEditTextPassword;

    @InjectView(R.id.textViewLoginTitle)
    TextView mTextViewLoginTitle;

    @InjectView(R.id.buttonLogin)
    Button mButtonGo;

    QuestionService mQuestionService;
    LoggedInUser mLoggedInUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.inject(this);

        mQuestionService = QuestionService.getInstance();
        mLoggedInUser = LoggedInUser.getInstance();

        /*YoYo.with(Techniques.FadeInLeft)
                .duration(2000)
                .playOn(mEditTextEmail);*/
    }

    public User formUser() {

        String email = mEditTextEmail.getText().toString();
        String password = mEditTextPassword.getText().toString();

        return new User(email, password);
    }

    @OnClick(R.id.buttonLogin)
    public void onGo() {

        //ignore backend to demo ui
        launchMain();

        /*
        mQuestionService.mApi
                .login(formUser())
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

                        //if (resp.isSuccess())
                            launchMain();
                        //else
                        //    toast("Error logging in. " + resp.message);
                    }
                });*/
    }

    @OnClick(R.id.buttonRegister)
    public void onRegister() {

        //Ignore backend for now to demo UI
        launchMain();

        /*
        mQuestionService.mApi
                .register(formUser())
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

                        if (resp.isSuccess())
                            launchMain();
                        else
                            toast("Error registering in. " + resp.message);
                    }
                });*/
    }

    public void toast(String s) {

        Toast.makeText(this , s, Toast.LENGTH_LONG);
    }

    public void launchMain() {

        Intent myIntent = new Intent(this, MainActivity.class);
        startActivity(myIntent);
    }
}
