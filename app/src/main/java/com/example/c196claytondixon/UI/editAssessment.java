package com.example.c196claytondixon.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.DatePickerDialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.c196claytondixon.Database.Repository;
import com.example.c196claytondixon.Entity.AssessmentEntity;
import com.example.c196claytondixon.Entity.CourseEntity;
import com.example.c196claytondixon.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class editAssessment extends AppCompatActivity {

    TextView assessmentIDField;
    EditText assessmentTitle;
    EditText assessmentStart;
    EditText assessmentEnd;
    EditText courseIDField;
    RadioGroup radioGroupEdit;
    RadioButton objectiveRadioEdit;
    RadioButton performanceRadioEdit;
    Integer id;
    String title;
    String start;
    String end;
    String type;
    Integer courseID;
    Repository repo;
    DatePickerDialog.OnDateSetListener startDate;
    final Calendar myCalendarStart = Calendar.getInstance();
    DatePickerDialog.OnDateSetListener endDate;
    final Calendar myCalendarEnd = Calendar.getInstance();
    String myFormat;
    SimpleDateFormat sdf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_assessment);
        myFormat = "MM/dd/yy";
        sdf = new SimpleDateFormat(myFormat, Locale.US);
        assessmentIDField = findViewById(R.id.assessmentIDField);
        assessmentTitle = findViewById(R.id.assessmentTitle);
        assessmentStart = findViewById(R.id.assessmentStart);
        assessmentEnd = findViewById(R.id.assessmentEnd);
        radioGroupEdit = findViewById(R.id.radioGroupEdit);
        performanceRadioEdit = findViewById(R.id.performanceRadioEdit);
        objectiveRadioEdit = findViewById(R.id.objectiveRadioEdit);
        courseIDField = findViewById(R.id.courseIDField);
        id = getIntent().getIntExtra("id", 0);
        title = getIntent().getStringExtra("title");
        start = getIntent().getStringExtra("start");
        end = getIntent().getStringExtra("end");
        type = getIntent().getStringExtra("type");
        courseID = getIntent().getIntExtra("courseID", 0);
        assessmentIDField.setText(id.toString());
        assessmentTitle.setText(title);
        assessmentStart.setText(start);
        assessmentEnd.setText(end);
        courseIDField.setText(courseID.toString());
        if(type.equals("Objective")) {
            radioGroupEdit.check(R.id.objectiveRadioEdit);
        } else if (type.equals("Performance")) {
            radioGroupEdit.check(R.id.performanceRadioEdit);
        }
        repo = new Repository(getApplication());




        assessmentStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Date date;
                String info = assessmentStart.getText().toString();
                if(info.equals(""))info="02/10/22";
                try {
                    myCalendarStart.setTime(sdf.parse(info));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                new DatePickerDialog(editAssessment.this, startDate, myCalendarStart.get(Calendar.YEAR),
                        myCalendarStart.get(Calendar.MONTH), myCalendarStart.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        startDate = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                myCalendarStart.set(Calendar.YEAR, year);
                myCalendarStart.set(Calendar.MONTH, month);
                myCalendarStart.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabelStart();
            }
        };

        assessmentEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Date date;
                String info = assessmentEnd.getText().toString();
                if(info.equals(""))info="02/10/22";
                try {
                    myCalendarEnd.setTime(sdf.parse(info));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                new DatePickerDialog(editAssessment.this, endDate, myCalendarEnd.get(Calendar.YEAR),
                        myCalendarEnd.get(Calendar.MONTH), myCalendarEnd.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        endDate = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                myCalendarEnd.set(Calendar.YEAR, year);
                myCalendarEnd.set(Calendar.MONTH, month);
                myCalendarEnd.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabelStart();
            }
        };
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.setAlert:
                String startDateFromScreen = assessmentStart.getText().toString();
                String endDateFromScreen = assessmentEnd.getText().toString();
                Date myDate1 = null;
                Date myDate2 = null;
                try {
                    myDate1=sdf.parse(startDateFromScreen);
                    myDate2=sdf.parse(endDateFromScreen);

                } catch (ParseException e) {
                    e.printStackTrace();
                }
                Long trigger1 = myDate1.getTime();
                Long trigger2 = myDate2.getTime();
                Intent intent1 = new Intent(editAssessment.this, MyReceiver.class);
                Intent intent2 = new Intent(editAssessment.this, MyReceiver.class);
//                intent.putExtra("key", "test message");
                intent1.putExtra("key",  type + " " + "Assessment " + title + " start date is today");
                intent2.putExtra("key",  type + " " + "Assessment " + title + " end date is today" );
                PendingIntent sender = PendingIntent.getBroadcast(editAssessment.this, MainActivity.numAlert++, intent1, PendingIntent.FLAG_IMMUTABLE);
                PendingIntent sender2 = PendingIntent.getBroadcast(editAssessment.this, MainActivity.numAlert++, intent2, PendingIntent.FLAG_IMMUTABLE);
                AlarmManager alarmManager1 = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
                AlarmManager alarmManager2 = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
                alarmManager1.set(AlarmManager.RTC_WAKEUP, trigger1, sender);
                alarmManager2.set(AlarmManager.RTC_WAKEUP, trigger2, sender2);
                return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    private void updateLabelStart() {
        assessmentStart.setText(sdf.format(myCalendarStart.getTime()));
        assessmentEnd.setText(sdf.format(myCalendarEnd.getTime()));
    }



    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_edit_assessment, menu);
        return true;
    }

    public void save(View view) {
        if(performanceRadioEdit.isChecked()) {
            type = "Performance";
        } else if(objectiveRadioEdit.isChecked()) {
            type  = "Objective";
        }
        AssessmentEntity assessmentEntity;
        assessmentEntity = new AssessmentEntity(id, assessmentTitle.getText().toString(), assessmentStart.getText().toString(),
                assessmentEnd.getText().toString(), type, Integer.parseInt(courseIDField.getText().toString()));
        repo.updateAssessment(assessmentEntity);
        Intent intent = new Intent(editAssessment.this, Assessments.class);
        startActivity(intent);
    }

    public void delete(View view) {
        if(performanceRadioEdit.isChecked()) {
            type = "Performance";
        } else if(objectiveRadioEdit.isChecked()) {
            type  = "Objective";
        }
        AssessmentEntity assessmentEntity;
        assessmentEntity = new AssessmentEntity(id, assessmentTitle.getText().toString(), assessmentStart.getText().toString(),
                assessmentEnd.getText().toString(), type, Integer.parseInt(courseIDField.getText().toString()));
        repo.deleteAssessment(assessmentEntity);
        Intent intent = new Intent(editAssessment.this, Assessments.class);
        startActivity(intent);
    }
}