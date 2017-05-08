package com.example.ferra.ebdapp.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.CalendarView;

import com.example.ferra.ebdapp.R;

public class CalendarioActivity extends AppCompatActivity {

    CalendarView calendario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendario);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final CalendarView calendarView = (CalendarView) findViewById(R.id.calendario);

//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//                calendario.setSelectedWeekBackgroundColor (getColor(R.color.colorPrimaryDark));
//            }
//        }
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
//
//                calendario.getFocusedMonthDateColor(R.color.colorPrimaryDark);
//
//        }

        // quando selecionado alguma data diferente da padrão
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener () {

            @Override
            public void onSelectedDayChange(CalendarView view, int year,
                                            int month, int dayOfMonth) {
                Intent intent = new Intent(CalendarioActivity.this,
                        SalvarDataActivity.class);
                intent.putExtra("dataLongMiliseconds",
                        (Long) calendarView.getDate());
                startActivity(intent);

            }
        });
//        calendario = (CalendarView) findViewById (R.id.calendario);
//        calendario.setOnDateChangeListener (new calendario.OnDateChangeListener ());
//        calendario.setOnClickListener (new CalendarView.OnDateChangeListener () {
//            @Override
//            public void onSelectedDayChange (@NonNull CalendarView view, int year, int month, int dayOfMonth) {
//                Intent intent = new Intent (getApplicationContext(), SalvarDataActivity.class);
//                startActivity(intent);
//            }




// {
//            @Override
//            public void onSelectedDayChange (View v) {
//                Intent intent = new Intent (getApplicationContext(), SalvarDataActivity.class);
//                startActivity(intent);
//
//            }
//        });


//        calendario.setOnClickListener (new CalendarView.OnDateChangeListener ()



//            @Override
//            public void onSelectedDayChange (@NonNull CalendarView view, int year, int month, int dayOfMonth) {
//
//            }
//
//        }

//            @Override
//            public void onSelectedDayChange (CalendarView view,int year, int month, int dayOfMonth){
//                Toast.makeText (getApplicationContext (), dayOfMonth + "/" + month + "/" + year, Toast.LENGTH_LONG).show ();
//
//
//            }
//        };


    }

}
