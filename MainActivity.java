package com.example.myapp;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private TextView dateTextView, detailsTextView;
    private EditText nameEditText, birthYearEditText;
    private Button showDetailsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        dateTextView = findViewById(R.id.dateTextView);
        detailsTextView = findViewById(R.id.detailsTextView);
        nameEditText = findViewById(R.id.nameEditText);
        birthYearEditText = findViewById(R.id.birthYearEditText);
        showDetailsButton = findViewById(R.id.showDetailsButton);


        String currentDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        dateTextView.setText("date: " + currentDate);


        showDetailsButton.setOnClickListener(view -> {

            String name = nameEditText.getText().toString();
            String birthYear = birthYearEditText.getText().toString();


            if (TextUtils.isEmpty(name) || TextUtils.isEmpty(birthYear)) {

                Toast.makeText(MainActivity.this, "enter name and birth tear", Toast.LENGTH_SHORT).show();
            } else {

                String details = "name: " + name + "\nbirth year: " + birthYear;
                detailsTextView.setText(details);
            }
        });
    }
}
