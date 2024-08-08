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
import android.widget.TextView;
import android.widget.Toast;

import com.example.c196claytondixon.Database.Repository;
import com.example.c196claytondixon.Entity.AssessmentEntity;
import com.example.c196claytondixon.Entity.TermEntity;
import com.example.c196claytondixon.R;
import com.example.c196claytondixon.Entity.CourseEntity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;


public class editCourse extends AppCompatActivity {
    EditText termIDField;
    TextView courseIDField;
    EditText courseTitle;
    EditText courseStart;
    EditText courseEnd;
    EditText courseStatus;
    EditText courseNotes;
    EditText courseInstructorName;
    EditText courseInstructorPhoneNumber;
    EditText courseInstructorEmail;
    DatePickerDialog.OnDateSetListener startDate;
    final Calendar myCalendarStart = Calendar.getInstance();
    DatePickerDialog.OnDateSetListener endDate;
    final Calendar myCalendarEnd = Calendar.getInstance();
    TextView textview10;
    TextView textview11;
    TextView textview12;
    TextView textview13;
    TextView textview14;
    Integer termID;
    Integer courseID;
    String title;
    String start;
    String end;
    String status;
    String notes;
    String instructorName;
    Long instructorPhoneNumber;
    String instructorEmail;
    Repository repo;
    String myFormat;
    SimpleDateFormat sdf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_course);
        myFormat = "MM/dd/yy";
        sdf = new SimpleDateFormat(myFormat, Locale.US);
        termIDField = findViewById(R.id.termIDField);
        courseIDField = findViewById(R.id.courseIDField);
        courseTitle = findViewById(R.id.courseTitle);
        courseStart = findViewById(R.id.courseStart);
        courseEnd = findViewById(R.id.courseEnd);
        courseStatus = findViewById(R.id.courseStatus);
        courseNotes = findViewById(R.id.courseNotes);
        courseInstructorName = findViewById(R.id.courseInstructorName);
        courseInstructorEmail = findViewById(R.id.courseInstructorEmail);
        courseInstructorPhoneNumber = findViewById(R.id.courseInstructorPhoneNumber);
        textview10 = findViewById(R.id.textView10);
        textview11 = findViewById(R.id.textView11);
        textview12 = findViewById(R.id.textView12);
        textview13 = findViewById(R.id.textView13);
        textview14 = findViewById(R.id.textView14);
        courseID = getIntent().getIntExtra("courseID", 0);
        termID = getIntent().getIntExtra("termID", 0);
        title = getIntent().getStringExtra("title");
        start = getIntent().getStringExtra("start");
        end = getIntent().getStringExtra("end");
        status = getIntent().getStringExtra("status");
        notes = getIntent().getStringExtra("notes");
        instructorName = getIntent().getStringExtra("instructorName");
        instructorPhoneNumber = getIntent().getLongExtra("instructorPhoneNumber", 0);
        instructorEmail = getIntent().getStringExtra("instructorEmail");
        termIDField.setText(termID.toString());
        courseIDField.setText(courseID.toString());
        courseTitle.setText(title);
        courseStart.setText(start);
        courseEnd.setText(end);
        courseStatus.setText(status);
        courseNotes.setText(notes);
        courseInstructorName.setText(instructorName);
        courseInstructorPhoneNumber.setText(String.valueOf(instructorPhoneNumber));
        courseInstructorEmail.setText(instructorEmail);
        repo = new Repository(getApplication());

        courseStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Date date;
                String info = courseStart.getText().toString();
                if(info.equals(""))info="02/10/22";
                try {
                    myCalendarStart.setTime(sdf.parse(info));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                new DatePickerDialog(editCourse.this, startDate, myCalendarStart.get(Calendar.YEAR),
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

        courseEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Date date;
                String info = courseEnd.getText().toString();
                if(info.equals(""))info="02/10/22";
                try {
                    myCalendarEnd.setTime(sdf.parse(info));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                new DatePickerDialog(editCourse.this, endDate, myCalendarEnd.get(Calendar.YEAR),
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

        List<AssessmentEntity> assessmentList = repo.getAssessmentByCourse(courseID);
        ArrayList<String> assessmentNames = new ArrayList<>();

        for(int count = 0; assessmentList.size() > count; count++) {
                assessmentNames.add(count, assessmentList.get(count).getAssessmentTitle());
        }


//        Toast errorToast4 = Toast.makeText(editCourse.this, "assessmentList list size = " + assessmentList.size(), Toast.LENGTH_LONG);
//        errorToast4.show();
//        Toast errorToast4 = Toast.makeText(editCourse.this, "assessmentNames list size = " + assessmentNames.size(), Toast.LENGTH_LONG);
//        errorToast4.show();

        if(assessmentNames.size() > 0) {
            textview10.setText(assessmentNames.get(0));
            if(assessmentNames.size() > 1) textview11.setText(assessmentNames.get(1));
            if(assessmentNames.size() > 2) textview12.setText(assessmentNames.get(2));
            if(assessmentNames.size() > 3) textview13.setText(assessmentNames.get(3));
            if(assessmentNames.size() > 4) textview14.setText(assessmentNames.get(4));
        }
        }

        private void updateLabelStart() {
            courseStart.setText(sdf.format(myCalendarStart.getTime()));
            courseEnd.setText(sdf.format(myCalendarEnd.getTime()));
        }

        public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_edit_course, menu);
        return true;
        }

        public boolean onOptionsItemSelected(MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.share:
                    Intent sendIntent = new Intent();
                    sendIntent.setAction(Intent.ACTION_SEND);
                    sendIntent.putExtra(Intent.EXTRA_TEXT, courseNotes.getText().toString());
                    sendIntent.putExtra(Intent.EXTRA_TITLE,  title + " Course Notes");
                    sendIntent.setType("text/plain");
                    Intent shareIntent = Intent.createChooser(sendIntent, null);
                    startActivity(shareIntent);
                    return true;
                case R.id.notify:
                    String startDateFromScreen = courseStart.getText().toString();
                    String endDateFromScreen = courseEnd.getText().toString();
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
                    Intent intent1 = new Intent(editCourse.this, MyReceiver.class);
                    Intent intent2 = new Intent(editCourse.this, MyReceiver.class);
                    intent1.putExtra("key", "Course " + title + " start date is today");
                    intent2.putExtra("key", "Course " + title + " end date is today" );
                    PendingIntent sender = PendingIntent.getBroadcast(editCourse.this, MainActivity.numAlert++, intent1, PendingIntent.FLAG_IMMUTABLE);
                    PendingIntent sender2 = PendingIntent.getBroadcast(editCourse.this, MainActivity.numAlert++, intent2, PendingIntent.FLAG_IMMUTABLE);
                    AlarmManager alarmManager1 = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
                    AlarmManager alarmManager2 = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
                    alarmManager1.set(AlarmManager.RTC_WAKEUP, trigger1, sender);
                    alarmManager2.set(AlarmManager.RTC_WAKEUP, trigger2, sender2);
                    return true;
            }
        return super.onOptionsItemSelected(menuItem);
        }


    public void save(View view) {
        CourseEntity courseEntity;
        courseEntity = new CourseEntity(courseID, courseTitle.getText().toString(), courseStart.getText().toString(),
            courseEnd.getText().toString(), courseStatus.getText().toString(), courseNotes.getText().toString(), Integer.parseInt(termIDField.getText().toString()),
                courseInstructorName.getText().toString(), Long.parseLong(courseInstructorPhoneNumber.getText().toString()),
                courseInstructorEmail.getText().toString());
        repo.updateCourse(courseEntity);
        Intent intent = new Intent(editCourse.this, Courses.class);
        startActivity(intent);
    }

    public void delete(View view) {
        if(textview10.getText().toString().isEmpty()) {
        CourseEntity courseEntity;
        courseEntity = new CourseEntity(courseID, courseTitle.getText().toString(), courseStart.getText().toString(),
                courseEnd.getText().toString(), courseStatus.getText().toString(), courseNotes.getText().toString(), Integer.parseInt(termIDField.getText().toString()),
                courseInstructorName.getText().toString(), Long.parseLong(courseInstructorPhoneNumber.getText().toString()),
                courseInstructorEmail.getText().toString());
        repo.deleteCourse(courseEntity);
        Intent intent = new Intent(editCourse.this, Courses.class);
        startActivity(intent);
        } else {
            Toast errorToast = Toast.makeText(editCourse.this, "Delete all assessments belonging to this course before deleting this course"
                    , Toast.LENGTH_LONG);
            errorToast.show();
        }
    }
}