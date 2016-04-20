package com.muhardin.endy.belajar.android.security.httpsession.activity;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.muhardin.endy.belajar.android.security.httpsession.R;
import com.muhardin.endy.belajar.android.security.httpsession.helpers.RestClient;

import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnInfo = (Button) findViewById(R.id.btnLoadUserInfo);
        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AsyncTask<Void, Void, Boolean>(){
                    private Map<String, Object> info;

                    @Override
                    protected Boolean doInBackground(Void... params) {
                        RestClient rc = new RestClient();
                        info = rc.getUserInfo();
                        return true;
                    }

                    @Override
                    protected void onPostExecute(Boolean aBoolean) {
                        TextView txtUsername = (TextView) findViewById(R.id.txtUsername);
                        txtUsername.setText(info.get("username").toString());

                        TextView txtRole = (TextView) findViewById(R.id.txtRole);
                        txtRole.setText(info.get("role").toString());

                    }
                }.execute();
            }
        });


        Button btnLogout = (Button) findViewById(R.id.btnLogout);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AsyncTask<Void, Void, Boolean>(){
                    @Override
                    protected Boolean doInBackground(Void... params) {
                        RestClient rc = new RestClient();
                        rc.logout();
                        return true;
                    }

                    @Override
                    protected void onPostExecute(Boolean sukses) {
                        if(sukses){
                            Intent next = new Intent(MainActivity.this,LoginActivity.class);
                            startActivity(next);
                        } else {
                            Toast.makeText(MainActivity.this, "Logout gagal", Toast.LENGTH_LONG).show();
                        }
                    }
                }.execute();
            }
        });
    }
}
