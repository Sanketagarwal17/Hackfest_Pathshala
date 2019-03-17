package com.example.android.pathshalaapp.Profile;


import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.pathshalaapp.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Profile extends AppCompatActivity {
    @NonNull
    @BindView(R.id.student_batch)
    EditText student_batch;

    @NonNull
    @BindView(R.id.student_number)
    EditText student_number;

    @NonNull
    @BindView(R.id.student_email)
    TextView student_email;

    @NonNull
    @BindView(R.id.student_name)
    EditText student_name;

    @NonNull
    @BindView(R.id.student_standard)
    EditText student_standard;

    @NonNull
    @BindView(R.id.student_school)
    EditText student_school;

    FirebaseUser firebaseUser;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;


    String name,school,mobile,email,std,batch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        ButterKnife.bind(this);

        firebaseUser= FirebaseAuth.getInstance().getCurrentUser();
        batch=student_batch.getText().toString();
        name=student_name.getText().toString();
        school=student_school.getText().toString();
        mobile=student_number.getText().toString();
        email= firebaseUser.getEmail();
        std=student_standard.getText().toString();

        firebaseDatabase=FirebaseDatabase.getInstance();
        databaseReference=firebaseDatabase.getReference("Students_Profile");

        Button submit=findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                ProfilePojo profile=new ProfilePojo(name,school,mobile,email,std,batch);
                databaseReference.push().setValue(profile).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful())
                            Toast.makeText(Profile.this,"Uploaded on FireBase",Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(Profile.this,task.getException().getMessage(),Toast.LENGTH_SHORT).show();

                    }
                });
            }
        });

    }
}