package com.ocr.mareunion;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import java.util.Calendar;
import java.util.Collections;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.ocr.mareunion.adapter.ReunionAdapter;
import com.ocr.mareunion.di.Di;
import com.ocr.mareunion.event.CreateReunionEvent;
import com.ocr.mareunion.event.DeleteReunionEvent;
import com.ocr.mareunion.model.Meeting;
import com.ocr.mareunion.service.MeeetingApiService;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity  {
    private int currentScreenOrientation = ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED;
    ArrayList<Meeting> meetingsDate= new ArrayList<>();
    ArrayList<Meeting> meetingsResultat  = new ArrayList<>();
    ArrayList<Meeting> meetings  = new ArrayList<>();
    ReunionAdapter adapter = new ReunionAdapter(meetings);
    private int mYear;
    private int mMonth;
    private int mDay;
    private String date;
    private RecyclerView myRecyclerView;
    private MeeetingApiService mApiService;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showCurrentOrientation();
        mApiService = Di.getReunionApiService();

        mYear= Calendar.getInstance().get(Calendar.YEAR);
        mMonth=Calendar.getInstance().get(Calendar.MONTH)+1;
        mDay=Calendar.getInstance().get(Calendar.DAY_OF_MONTH) ;
        myRecyclerView = findViewById(R.id.rvReunion);
        myRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        //dataMeeting();
        initList();
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

            int drawable;

            switch (salle){
                case "Mario" : drawable = R.drawable.mario;
                break;
                case "Luigi" : drawable = R.drawable.luigy;
                break;
                case "Peach" : drawable = R.drawable.peach;
                break;
                case "Toad" : drawable = R.drawable.toad;
                break;
                default: drawable = R.drawable.ic_delete;
            }
                Meeting meeting = new Meeting(salle, sujet,time , mail, drawable,date);
                meetings.add(meeting);
                adapter.updateData(meetings);
        }
    }


    public void initList(){

        meetings = (ArrayList<Meeting>) mApiService.getReunions();
        ReunionAdapter adapter = new ReunionAdapter(meetings);
        myRecyclerView.setAdapter(adapter);

    }

    public void onDeleteNeighbour(DeleteReunionEvent event) {
        mApiService.deleteReunion(event.mReunion);
        initList();
    }
    public void onCreateNeighbour(CreateReunionEvent event) {
        mApiService.createReunion(event.mReunion);
        initList();
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
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

    private void filtre(String salle){
        meetingsResultat.clear();
        for (Meeting meeting : meetings){
            if(meeting.getSalle().equals(salle)){
                meetingsResultat.add(meeting);
                RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rvReunion);
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(new LinearLayoutManager(this));
                recyclerView.setAdapter(new ReunionAdapter(meetingsResultat));
                adapter.notifyDataSetChanged();
            }
        }
    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.triDate:
                meetingsDate.clear();
               show_Datepicker();
                return true;
            case R.id.mario:
                filtre("Mario");
                return true;
            case R.id.luigi:
                filtre("Luigi");
                return true;
            case R.id.peach:
               filtre("Peach");
                return true;
            case R.id.toad:
               filtre("Toad");
                return true;
            case R.id.clear:
                initList();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
   // private void initList() {
   //     RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rvReunion);
   //     meetings = favorite ? mApiService.getNeighbourFavorit() : mApiService.getNeighbours();
   //     adapter = new ReunionAdapter(meetings);
   //     recyclerView.setAdapter(new ReunionAdapter(meetingsResultat));
//
   // }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void dataMeeting(){
        Meeting meeting1 = new Meeting("Mario","Save Peach","9h03","maxime@lesint.fr,lola@cargo.fr,paul@pogba.fr",R.drawable.mario,"28-4-2020");
        meetings.add(meeting1);
        Meeting meeting2 = new Meeting("Luigi","ghost hunter","10h42","maxime@lesint.fr,lola@cargo.fr,paul@pogba.fr",R.drawable.luigy,"29-4-2020");
        meetings.add(meeting2);
        Meeting meeting3= new Meeting("Peach","Stop Mario","11h00","maxime@lesint.fr,lola@cargo.fr,paul@pogba.fr",R.drawable.peach,"30-4-2020");
        meetings.add(meeting3);
        Meeting meeting4 = new Meeting("Toad","Retraite","15h35","maxime@lesint.fr,lola@cargo.fr,paul@pogba.fr",R.drawable.toad,"28-4-2020");
        meetings.add(meeting4);
    }

    private void show_Datepicker() {
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);


        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {
                        date = dayOfMonth + "-" + (monthOfYear + 1) + "-" + year;
                        for (Meeting meeting : meetings) {
                            if (meeting.getDate().equals(date)) {
                                meetingsDate.add(meeting);
                            }
                        }
                        RecyclerView recyclerViewDate = (RecyclerView) findViewById(R.id.rvReunion);
                        recyclerViewDate.setAdapter(new ReunionAdapter(meetingsDate));

                    }
                }, year, mMonth, mDay);



        RecyclerView recyclerViewDate = (RecyclerView) findViewById(R.id.rvReunion);
        recyclerViewDate.setHasFixedSize(true);
        recyclerViewDate.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewDate.setAdapter(new ReunionAdapter(meetingsDate));
        adapter.notifyDataSetChanged();
        datePickerDialog.show();

    }
    private void showCurrentOrientation()
    {
        // Get current orientation.
        currentScreenOrientation = getRequestedOrientation();

        // If above method can not get current screen orientation.
        if(currentScreenOrientation == ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED)
        {
            // Get screen orientation from activity configuration.
            currentScreenOrientation = this.getResources().getConfiguration().orientation;
        }

        // Show different text messages by different screen orientation.
        StringBuffer msgBuf = new StringBuffer();

        if(currentScreenOrientation == ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE)
        {
        }else if(currentScreenOrientation == ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
        {
        }else if(currentScreenOrientation == -1)
        {
        }

    }

}


