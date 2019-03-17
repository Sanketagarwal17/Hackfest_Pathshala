package com.example.android.pathshalaapp.Faculty;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import com.example.android.pathshalaapp.Notice.Notice;
import com.example.android.pathshalaapp.Notice.NoticeAdapter;
import com.example.android.pathshalaapp.Notice.NoticeModelClass;
import com.example.android.pathshalaapp.R;
import com.example.android.pathshalaapp.facultyModelClass;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Faculty  extends AppCompatActivity {
    ArrayList<FacultyModelClass> arrayList;
    FirebaseDatabase database;
    DatabaseReference databaseReference;
    FacultyModelClass facultyModelClass;
    FacultyAdapter facultyAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty);

        database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference().child("faculty");

        arrayList = new ArrayList<>();
        final RecyclerView recyclerView = findViewById(R.id.faculty_recyclerview);
        recyclerView.setHasFixedSize(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayout.VERTICAL, false));
        facultyAdapter = new FacultyAdapter(Faculty.this, arrayList);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    facultyModelClass = ds.getValue(FacultyModelClass.class);
                    arrayList.add(facultyModelClass);
                }
                recyclerView.setAdapter(facultyAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}