package com.yucun.mastercardsforkids.activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.yucun.mastercardsforkids.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class LoginActivity extends Activity {
    @Bind(R.id.name)
    EditText name;
    @Bind(R.id.password)
    EditText password;
    Activity activity = this;
    @Bind(R.id.confirm_login)
    Button confirmLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        ParseUser.logInInBackground("julia", "julia", new LogInCallback() {
            public void done(ParseUser user, ParseException e) {

                if (user != null) {
                    // Hooray! The user is logged in.

                    startActivity(new Intent(getApplicationContext(), MainActivity.class));

                } else {
                    // Signup failed. Look at the ParseException to see what happened.
                }
            }
        });

//        confirmLogin.setOnClickListener(new View.OnClickListener() {
//            ProgressDialog progressDialog;
//            @Override
//            public void onClick(View v) {
//                Handler handler=new Handler();
//                handler.post(new Runnable() {
//                    @Override
//                    public void run() {
//                        progressDialog = ProgressDialog.show(activity, null, "Loading...", true, false);
//                    }
//                });
//
////
//
//                ParseUser.logInInBackground(name.getText().toString(), password.getText().toString(), new LogInCallback() {
//                    public void done(ParseUser user, ParseException e) {
//                        progressDialog.dismiss();
//                        if (user != null) {
//                            // Hooray! The user is logged in.
//
//                            startActivity(new Intent(getApplicationContext(), MainActivity.class));
//
//                        } else {
//                            // Signup failed. Look at the ParseException to see what happened.
//                        }
//                    }
//                });
//
//            }
//        });
    }

}