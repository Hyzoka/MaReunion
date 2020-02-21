package com.ocr.mareunion;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import java.util.Collections;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;
import java.util.Comparator;

@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class MainActivity extends AppCompatActivity  {

    ArrayList<Meeting> meetings  = new ArrayList();
    ReunionAdapter adapter = new ReunionAdapter(meetings);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dataMeeting();

        FloatingActionButton myFab = (FloatingActionButton)findViewById(R.id.fab);
        myFab.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,addMeeting.class);
                startActivityForResult(intent, 2);
            }
        });

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rvReunion);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==2)
        {
            String salle=data.getStringExtra("salle");
            int heure=data.getIntExtra("heure",0);
            String min=data.getStringExtra("min");
            String sujet=data.getStringExtra("sujet");
            String mail=data.getStringExtra("mail");

            Drawable drawable;

            switch (salle.toString()){
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

           Meeting meeting = new Meeting(salle,sujet,heure,min,mail,drawable);
            meetings.add(meeting);
            adapter.updateData(meetings);
        }
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }




    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.triDate:
                Collections.sort(meetings);
                adapter.notifyDataSetChanged();
                return true;
            case R.id.triSalle:
                Collections.sort(
                        meetings,new Meeting.meetingRoomomparator()
                );
                adapter.notifyDataSetChanged();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void dataMeeting(){
        Meeting meeting1 = new Meeting("Mario","Save Peach",10,"30","maxime@lesint.fr,lola@cargo.fr,paul@pogba.fr",getDrawable(R.drawable.mario));
        meetings.add(meeting1);
        Meeting meeting2 = new Meeting("Luigi","ghost hunter",15,"45","maxime@lesint.fr,lola@cargo.fr,paul@pogba.fr",getDrawable(R.drawable.luigy));
        meetings.add(meeting2);
        Meeting meeting3= new Meeting("Peach","Stop Mario",9,"10","maxime@lesint.fr,lola@cargo.fr,paul@pogba.fr",getDrawable(R.drawable.peach));
        meetings.add(meeting3);
        Meeting meeting4 = new Meeting("Toad","Retraite",16,"00","maxime@lesint.fr,lola@cargo.fr,paul@pogba.fr",getDrawable(R.drawable.toad));
        meetings.add(meeting4);
    }



}
