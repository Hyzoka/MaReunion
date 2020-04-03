package com.ocr.mareunion;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.ocr.mareunion.adapter.ReunionAdapter;
import com.ocr.mareunion.model.Meeting;

import java.util.ArrayList;

@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class MainActivity extends AppCompatActivity  {

    ArrayList<Meeting> meetingsDate= new ArrayList<>();
    ArrayList<Meeting> meetingsResultat  = new ArrayList<>();
    ArrayList<Meeting> meetings  = new ArrayList<>();
    ReunionAdapter adapter = new ReunionAdapter(meetings);
    private int mYear;
    private int mMonth;
    private int mDay;
    private Calendar c;
    private Context ctx = this;
    private String date;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mYear= Calendar.getInstance().get(Calendar.YEAR);
        mMonth=Calendar.getInstance().get(Calendar.MONTH)+1;
        mDay=Calendar.getInstance().get(Calendar.DAY_OF_MONTH) ;

        dataMeeting();
        recyclerView();
        floatingBouton();



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==2)
        {
            String salle=data.getStringExtra("salle");
            String time=data.getStringExtra("time");
            String date=data.getStringExtra("date");
            String sujet=data.getStringExtra("sujet");
            String mail=data.getStringExtra("mail");

            Drawable drawable;

            switch (salle){
                case "Mario" : drawable = getDrawable(R.drawable.mario);
                break;
                case "Luigi" : drawable = getDrawable(R.drawable.luigy);
                break;
                case "Peach" : drawable = getDrawable(R.drawable.peach);
                break;
                case "Toad" : drawable = getDrawable(R.drawable.toad);
                break;
                default: drawable = getDrawable(R.drawable.ic_delete);
            }
                Meeting meeting = new Meeting(salle, sujet,time , mail, drawable,date);
                meetings.add(meeting);
                adapter.updateData(meetings);
        }
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    private void recyclerView(){
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rvReunion);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Collections.sort(meetings,new Meeting.meetingDateComparator());
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    private void floatingBouton(){
        FloatingActionButton myFab = (FloatingActionButton)findViewById(R.id.fab);
        myFab.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,addMeeting.class);
                startActivityForResult(intent, 2);
            }
        });
    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.triDate:
               show_Datepicker();
                RecyclerView recyclerViewDate = (RecyclerView) findViewById(R.id.rvReunion);
                recyclerViewDate.setHasFixedSize(true);
                recyclerViewDate.setLayoutManager(new LinearLayoutManager(this));
                recyclerViewDate.setAdapter(new ReunionAdapter(meetingsDate));
                adapter.notifyDataSetChanged();
                return true;
            case R.id.mario:
                meetingsResultat.clear();
                for (Meeting meeting : meetings){
                    if(meeting.getSalle().equals("Mario")){
                        meetingsResultat.add(meeting);
                        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rvReunion);
                        recyclerView.setHasFixedSize(true);
                        recyclerView.setLayoutManager(new LinearLayoutManager(this));
                        recyclerView.setAdapter(new ReunionAdapter(meetingsResultat));
                        adapter.notifyDataSetChanged();
                    }
                }

                return true;
            case R.id.luigi:
                meetingsResultat.clear();
                for (Meeting meeting : meetings){
                    if(meeting.getSalle().equals("Luigi")){
                        meetingsResultat.add(meeting);
                        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rvReunion);
                        recyclerView.setHasFixedSize(true);
                        recyclerView.setLayoutManager(new LinearLayoutManager(this));
                        recyclerView.setAdapter(new ReunionAdapter(meetingsResultat));
                        adapter.notifyDataSetChanged();
                    }
                }
                return true;
            case R.id.peach:
                meetingsResultat.clear();
                for (Meeting meeting : meetings){
                    if(meeting.getSalle().equals("Peach")){
                        meetingsResultat.add(meeting);
                        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rvReunion);
                        recyclerView.setHasFixedSize(true);
                        recyclerView.setLayoutManager(new LinearLayoutManager(this));
                        recyclerView.setAdapter(new ReunionAdapter(meetingsResultat));
                        adapter.notifyDataSetChanged();
                    }
                }
                return true;
            case R.id.toad:
                meetingsResultat.clear();
                for (Meeting meeting : meetings){
                    if(meeting.getSalle().equals("Toad")){
                        meetingsResultat.add(meeting);
                        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rvReunion);
                        recyclerView.setHasFixedSize(true);
                        recyclerView.setLayoutManager(new LinearLayoutManager(this));
                        recyclerView.setAdapter(new ReunionAdapter(meetingsResultat));
                        adapter.notifyDataSetChanged();
                    }
                }
                return true;
            case R.id.clear:
                recyclerView();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void dataMeeting(){
        Meeting meeting1 = new Meeting("Mario","Save Peach","9h03","maxime@lesint.fr,lola@cargo.fr,paul@pogba.fr",getDrawable(R.drawable.mario),"28-04-2020");
        meetings.add(meeting1);
        Meeting meeting2 = new Meeting("Luigi","ghost hunter","10h42","maxime@lesint.fr,lola@cargo.fr,paul@pogba.fr",getDrawable(R.drawable.luigy),"29-04-2020");
        meetings.add(meeting2);
        Meeting meeting3= new Meeting("Peach","Stop Mario","11h00","maxime@lesint.fr,lola@cargo.fr,paul@pogba.fr",getDrawable(R.drawable.peach),"30-04-2020");
        meetings.add(meeting3);
        Meeting meeting4 = new Meeting("Toad","Retraite","15h35","maxime@lesint.fr,lola@cargo.fr,paul@pogba.fr",getDrawable(R.drawable.toad),"28-04-2020");
        meetings.add(meeting4);
    }

    private void show_Datepicker() {
        c = Calendar.getInstance();
        int mYearParam = mYear;
        int mMonthParam = mMonth-1;
        int mDayParam = mDay;

        DatePickerDialog datePickerDialog = new DatePickerDialog(ctx,
                new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {
                        mMonth = monthOfYear + 1;
                        mYear=year;
                        mDay=dayOfMonth;
                        date = mDay + "-" + mMonth;
                        for (Meeting meeting : meetings){
                            if (meeting.getDate().equals(date)){
                                meetingsDate.add(meeting);
                            }

                        }
                    }
                }, mYearParam, mMonthParam, mDayParam);

        datePickerDialog.show();
    }


}
