package com.ocr.mareunion;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.opengl.Visibility;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.google.android.material.snackbar.Snackbar;

import java.util.Calendar;


public class addMeeting extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    LinearLayout btnAdd;
    ImageView imgDate, imgTime;
    EditText sujetEdit,mailEdit;
    String[] country = {"Mario","Luigi","Peach","Toad"};
    String salle;
    ConstraintLayout btnDatePicker, btnTimePicker;
    TextView txtDate, txtTime;
    private int mMonth;
    private int mDay;
    private int mHour;
    private int mMinute;
    private int style;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_meeting);


        sujetEdit=(EditText)findViewById(R.id.etsujet);
        mailEdit=(EditText)findViewById(R.id.etMail);
        btnAdd=(LinearLayout)findViewById(R.id.addMeeting);
        btnDatePicker=(ConstraintLayout)findViewById(R.id.btn_date);
        btnTimePicker=(ConstraintLayout) findViewById(R.id.btn_time);
        txtDate = (TextView) findViewById(R.id.txtDate);
        txtTime = (TextView) findViewById(R.id.txtTime);
        imgTime = (ImageView) findViewById(R.id.imgTime);
        imgDate = (ImageView) findViewById(R.id.imgDate);

        btnDatePicker.setOnClickListener(this);
        btnTimePicker.setOnClickListener(this);



        if (btnAdd.getTranslationY() != 0f)
            btnAdd.animate().translationY(0f);

        spinner();


            btnAdd.setOnClickListener(new View.OnClickListener() {
                @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
                @Override
                public void onClick(View v) {



                        Intent intent = new Intent(addMeeting.this, MainActivity.class);
                        intent.putExtra("salle", salle);
                        intent.putExtra("time", txtTime.getText().toString());
                        intent.putExtra("date", txtDate.getText().toString());
                        intent.putExtra("sujet", sujetEdit.getText().toString());
                        intent.putExtra("mail", mailEdit.getText().toString());

                        setResult(2, intent);
                        finish();
                    }


            });



    }


    @Override
    public void onClick(View v) {

        if (v == btnDatePicker) {

            // Get Current Date
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            mMonth = c.get(Calendar.MONTH);
            mDay = c.get(Calendar.DAY_OF_MONTH);


            DatePickerDialog datePickerDialog = new DatePickerDialog(this,style,
                    new DatePickerDialog.OnDateSetListener() {

                        @Override
                        public void onDateSet(DatePicker view, int year,
                                              int monthOfYear, int dayOfMonth) {
                            txtDate.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                            imgDate.setVisibility(View.VISIBLE);


                        }
                    }, year, mMonth, mDay);

            datePickerDialog.show();
        }
        if (v == btnTimePicker) {

            // Get Current Time
            final Calendar c = Calendar.getInstance();
            mHour = c.get(Calendar.HOUR_OF_DAY);
            mMinute = c.get(Calendar.MINUTE);

            // Launch Time Picker Dialog
            TimePickerDialog timePickerDialog = new TimePickerDialog(this,style,
                    new TimePickerDialog.OnTimeSetListener() {

                        @Override
                        public void onTimeSet(TimePicker view, int hourOfDay,
                                              int minute) {

                            txtTime.setText(hourOfDay + ":" + minute);
                            imgTime.setVisibility(View.VISIBLE);
                        }
                    }, mHour, mMinute, false);
            timePickerDialog.show();
        }
    }

    private void spinner(){
        Spinner spin = (Spinner) findViewById(R.id.spinner);
        spin.setOnItemSelectedListener(this);
        ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_spinner_item, country);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(aa);
    }

    public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
        salle = country[position];
        switch (country[position]) {
            case "Mario":
                mailEdit.setBackgroundResource(R.drawable.backgroung_edit_mario);
                sujetEdit.setBackgroundResource(R.drawable.backgroung_edit_mario);
                btnDatePicker.setBackgroundResource(R.drawable.background_mario_color);
                btnTimePicker.setBackgroundResource(R.drawable.background_mario_color);
                style = R.style.DialogThemeMario;

                break;
            case "Luigi":
                mailEdit.setBackgroundResource(R.drawable.backgroung_edit_luigi);
                sujetEdit.setBackgroundResource(R.drawable.backgroung_edit_luigi);
                btnTimePicker.setBackgroundResource(R.drawable.backgroung_luigi_color);
                btnDatePicker.setBackgroundResource(R.drawable.backgroung_luigi_color);
                style = R.style.DialogThemeLuigi;

                break;
            case "Peach":
                mailEdit.setBackgroundResource(R.drawable.backgroung_edit_peach);
                sujetEdit.setBackgroundResource(R.drawable.backgroung_edit_peach);
                btnTimePicker.setBackgroundResource(R.drawable.backgroung_peach_color);
                btnDatePicker.setBackgroundResource(R.drawable.backgroung_peach_color);
                style = R.style.DialogThemePeach;
                break;
            case "Toad":
                mailEdit.setBackgroundResource(R.drawable.backgroung_edit_toad);
                sujetEdit.setBackgroundResource(R.drawable.backgroung_edit_toad);
                btnTimePicker.setBackgroundResource(R.drawable.backgroung_toad_color);
                btnDatePicker.setBackgroundResource(R.drawable.backgroung_toad_color);
                style = R.style.DialogThemeToad;
                break;
        }

    }


    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

}