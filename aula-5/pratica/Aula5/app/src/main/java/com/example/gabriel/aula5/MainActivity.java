package com.example.gabriel.aula5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

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

    public void changeTextClickHandler(View view) {
        TextView helloText = findViewById(R.id.hello_text);
        helloText.setText("Botão foi clicado");
    }

    public void navigateToNext(View view) {
        TextView helloText = findViewById(R.id.hello_text);

        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("TextoHello", helloText.getText());
        startActivity(intent);
    }
}
