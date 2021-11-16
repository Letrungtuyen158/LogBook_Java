package com.example.coureworkjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;

public class MainActivity extends AppCompatActivity {

    EditText tlType,tlBedroom,tlDatetime,tlPrice,tlFurniture,tlNote,tlReporter;
    Button Add;

    AwesomeValidation awesomeValidation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tlType = findViewById(R.id.tl_type);
        tlBedroom = findViewById(R.id.tl_bedrooms);
        tlDatetime = findViewById(R.id.tl_datetime);
        tlPrice = findViewById(R.id.tl_price);
        tlFurniture = findViewById(R.id.tl_furniture);
        tlNote = findViewById(R.id.tl_note);
        tlReporter = findViewById(R.id.tl_reporter);
        Add = findViewById(R.id.tl_add);

        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);

        awesomeValidation.addValidation(this, R.id.tl_type,
                RegexTemplate.NOT_EMPTY, R.string.valuee_type);
        awesomeValidation.addValidation(this, R.id.tl_bedrooms,
                RegexTemplate.NOT_EMPTY, R.string.valuee_bedrooms);
        awesomeValidation.addValidation(this, R.id.tl_datetime,
                RegexTemplate.NOT_EMPTY, R.string.valuee_datetime);
        awesomeValidation.addValidation(this, R.id.tl_price,
                RegexTemplate.NOT_EMPTY, R.string.valuee_price);
        awesomeValidation.addValidation(this, R.id.tl_furniture,
                RegexTemplate.NOT_EMPTY, R.string.valuee_furniture);
        awesomeValidation.addValidation(this, R.id.tl_note,
                RegexTemplate.NOT_EMPTY, R.string.valuee_note);
        awesomeValidation.addValidation(this, R.id.tl_reporter,
                RegexTemplate.NOT_EMPTY, R.string.valuee_reporter);

        Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //validation check submit form
                if (awesomeValidation.validate()) {
                    //success
                    Toast.makeText(getApplicationContext()
                            , "succesly", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext()
                            , "Errors", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }}

