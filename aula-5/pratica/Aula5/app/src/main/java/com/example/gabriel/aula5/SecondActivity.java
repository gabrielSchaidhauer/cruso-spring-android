package com.example.gabriel.aula5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private TextView textSecond;
    private String receivedText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        this.textSecond = findViewById(R.id.text_second);
        this.receivedText = getIntent().getStringExtra("TextoHello");
    }

    public void navigateToThird (View view) {
        Intent intent = new Intent(this, MyFragmentActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();

        this.textSecond.setText(this.receivedText);
    }
}
