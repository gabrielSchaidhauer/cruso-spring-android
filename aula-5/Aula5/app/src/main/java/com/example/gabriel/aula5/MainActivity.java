package com.example.gabriel.aula5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("teste", "onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("teste", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("teste", "onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("teste", "onrestart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("teste", "onpause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("teste", "onstop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("teste", "ondestroy");
    }
}
