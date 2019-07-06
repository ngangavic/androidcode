package com.ngangavictor.checkinternetstatus;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    ConstraintLayout constraintLayout;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        constraintLayout = findViewById(R.id.parentL);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConnectivityManager ConnectionManager=(ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo networkInfo=ConnectionManager.getActiveNetworkInfo();
                if (networkInfo != null && networkInfo.isConnected()==true){
                    Snackbar.make(constraintLayout, "Connected to Internet", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }else {
                    Snackbar.make(constraintLayout,"Not connected to Internet",Snackbar.LENGTH_LONG).setAction("Action",null).show();
                }
            }
        });
    }
}
