package com.muhardin.endy.belajar.android.security.httpsession.activity;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.muhardin.endy.belajar.android.security.httpsession.R;
import com.muhardin.endy.belajar.android.security.httpsession.helpers.RestClient;

public class LoginActivity extends AppCompatActivity {

    private static final String TAG = "Login";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button btnLogin = (Button) findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username =
                        ((EditText) findViewById(R.id.txtUsername))
                        .getText().toString();
                String password =
                        ((EditText) findViewById(R.id.txtPassword))
                                .getText().toString();

                new AsyncTask<String, Void, Boolean>() {
                    @Override
                    protected Boolean doInBackground(String... params) {
                        String u = params[0];
                        String p = params[1];

                        Log.d(TAG, "Username: "+u);
                        Log.d(TAG, "Password: "+p);

                        RestClient rc = new RestClient();
                        rc.login(u,p);

                        return true;
                    }

                    @Override
                    protected void onPostExecute(Boolean sukses) {
                        if(sukses){
                            Intent next = new Intent(LoginActivity.this,MainActivity.class);
                            startActivity(next);
                        } else {
                            Toast.makeText(LoginActivity.this, "Login gagal", Toast.LENGTH_LONG).show();
                        }
                    }
                }.execute(username, password);


            }
        });

    }
}
