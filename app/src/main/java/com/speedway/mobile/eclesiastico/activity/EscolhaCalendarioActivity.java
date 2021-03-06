package com.speedway.mobile.eclesiastico.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.CalendarView;

import com.speedway.mobile.eclesiastico.R;
import com.speedway.mobile.eclesiastico.util.l.Utils;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class EscolhaCalendarioActivity extends AppCompatActivity {

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
                Date dataDiaSeguinte = new Date();
                Date dataEscolhida = new Date(year-1900, month, dayOfMonth);

                GregorianCalendar gc = new GregorianCalendar();
                gc.setTime(dataDiaSeguinte);
                gc.set(Calendar.DATE, gc.get(Calendar.DATE) - 1);
                dataDiaSeguinte = gc.getTime();

                if(dataDiaSeguinte.after(dataEscolhida)){
                    Utils.alertaMensagem(EscolhaCalendarioActivity.this, "A data escolhida não pode ser anterior a data atual.");
                }else {
                    EventoActivity.date = dataEscolhida;
                    Intent intent = new Intent(EscolhaCalendarioActivity.this,
                            EventoActivity.class);
                    startActivity(intent);
                }
            }
        });
//        calendario = (CalendarView) findViewById (R.id.calendario);
//        calendario.setOnDateChangeListener (new calendario.OnDateChangeListener ());
//        calendario.setOnClickListener (new CalendarView.OnDateChangeListener () {
//            @Override
//            public void onSelectedDayChange (@NonNull CalendarView view, int year, int month, int dayOfMonth) {
//                Intent intent = new Intent (getApplicationContext(), EventoActivity.class);
//                startActivity(intent);
//            }




// {
//            @Override
//            public void onSelectedDayChange (View v) {
//                Intent intent = new Intent (getApplicationContext(), EventoActivity.class);
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
