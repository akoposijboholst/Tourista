package com.touristadev.tourista.activities;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import com.jaredrummler.materialspinner.MaterialSpinner;
import com.touristadev.tourista.R;
import com.touristadev.tourista.controllers.Controllers;
import com.touristadev.tourista.dataModels.Packages;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;


public class BooknowActivity extends AppCompatActivity {
    private Calendar myCalendar;
    private EditText edtDate;
    private MaterialSpinner spinner;
    private Controllers mControllers = new Controllers();
    private ArrayList<Packages> mList = new ArrayList<>();
    private int position;
    private String typePackage, packageTitle;
    private Button btnCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booknow);
        Intent i = getIntent();
        mList = mControllers.getControllerPackaaes();
        position = i.getIntExtra("position", 0);
        typePackage = i.getStringExtra("type");
        packageTitle = i.getStringExtra("title");
        edtDate = (EditText) findViewById(R.id.edtDate);

        myCalendar = Calendar.getInstance();
        btnCheck = (Button) findViewById(R.id.btnCheckout);
        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(BooknowActivity.this, PaypalActivity.class);
                i.putExtra("position", position);
                i.putExtra("type", typePackage);
                i.putExtra("title", packageTitle);
                startActivity(i);
            }
        });
        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub

                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
                btnCheck.setEnabled(true);
            }

        };

        edtDate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(BooknowActivity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();

            }
        });

        spinner = (MaterialSpinner) findViewById(R.id.spinner);

        spinner.setItems("0", "1", "2", "3", "4", "5", "6", "7", "8", "9");
//        spinner.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener<String>() {
//
//            @Override public void onItemSelected(MaterialSpinner view, int position, long id, String item) {
//
//            }
//        });
    }

    private void updateLabel() {

        String myFormat = "MM/dd/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        edtDate.setText(sdf.format(myCalendar.getTime()));
    }


}



