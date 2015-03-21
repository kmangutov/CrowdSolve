package com.kmangutov.crowdsolve;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;


public class LoginActivity extends Activity {

    @InjectView(R.id.editTextEmail)
    EditText mEditTextEmail;

    @InjectView(R.id.editTextPassword)
    EditText mEditTextPassword;

    @InjectView(R.id.textViewLoginTitle)
    TextView mTextViewLoginTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButterKnife.inject(this);



        YoYo.with(Techniques.FadeInLeft)
                .duration(700)
                .playOn(mTextViewLoginTitle);


        YoYo.with(Techniques.FadeInLeft)
                .duration(700)
                .playOn(mEditTextEmail);


        YoYo.with(Techniques.FadeInLeft)
                .duration(700)
                .playOn(mEditTextPassword);
    }

    @OnClick(R.id.buttonGo)
    public void onGo() {

        Intent myIntent = new Intent(this, MainActivity.class);
        startActivity(myIntent);
    }
}
