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
import com.kmangutov.crowdsolve.models.UserWrapper;
import com.kmangutov.crowdsolve.services.QuestionService;

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

    String email = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButterKnife.inject(this);
        mQuestionService = new QuestionService();

        /*YoYo.with(Techniques.FadeInLeft)
                .duration(2000)
                .playOn(mEditTextEmail);


        YoYo.with(Techniques.FadeInLeft)
                .duration(2500)
                .playOn(mEditTextPassword);


        YoYo.with(Techniques.FadeInLeft)
                .duration(3000)
                .playOn(mButtonGo);*/
    }

    public UserWrapper formUser() {

        User u = new User(
                mEditTextEmail.getText().toString(),
                mEditTextPassword.getText().toString());
        UserWrapper uw = new UserWrapper();
        uw.user = u;

        return uw;
    }



    @OnClick(R.id.buttonLogin)
    public void onGo() {


        email = mEditTextEmail.getText().toString();
        User u = new User(
                mEditTextEmail.getText().toString(),
                mEditTextPassword.getText().toString());

        mQuestionService.mApi
                .login(u)
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
                            toast("Error logging in. " + resp.message);
                    }
                });
    }



    @OnClick(R.id.buttonRegister)
    public void onRegister() {

        email = mEditTextEmail.getText().toString();
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
                });
    }

    public void toast(String s) {

        Toast.makeText(this , s, Toast.LENGTH_LONG);
    }

    public void launchMain() {

        Intent myIntent = new Intent(this, MainActivity.class);
        myIntent.putExtra("email", email);
        startActivity(myIntent);
    }
}
