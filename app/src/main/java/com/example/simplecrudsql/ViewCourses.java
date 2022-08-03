package com.example.simplecrudsql;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

// https://www.geeksforgeeks.org/how-to-read-data-from-sqlite-database-in-android/

public class ViewCourses extends AppCompatActivity {

    private ArrayList<CourseModal> courseModalArrayList;
    private DBHandler dbHandler;
    private CourseRVAdapter courseRVAdapter;
    private RecyclerView coursesRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_courses);

        courseModalArrayList = new ArrayList<>();
        dbHandler = new DBHandler(ViewCourses.this);

        courseModalArrayList = dbHandler.readCourses();

        courseRVAdapter = new CourseRVAdapter(courseModalArrayList, ViewCourses.this);
        coursesRV = findViewById(R.id.idRVCourses);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ViewCourses.this, RecyclerView.VERTICAL, false);
        coursesRV.setLayoutManager(linearLayoutManager);

        coursesRV.setAdapter(courseRVAdapter);
    }
}
