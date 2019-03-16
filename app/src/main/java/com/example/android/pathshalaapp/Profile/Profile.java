package com.example.android.pathshalaapp.Profile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.example.android.pathshalaapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Profile extends AppCompatActivity {

    @BindView(R.id.student_batch)
    EditText student_batch;

    @BindView(R.id.student_number)
    EditText student_number;

    @BindView(R.id.student_email)
    TextView student_email;

    @BindView(R.id.student_name)
    EditText student_name;

    @BindView(R.id.student_standard)
    EditText student_standard;

    @BindView(R.id.student_school)
    EditText student_school;

    String name,school,mobile,email,std,batch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        ButterKnife.bind(this);

        student_batch.setText(batch);
        student_school.setText(school);
        student_number.setText(number);
        student_email.setText(email);
        student_standard.setText(standard);
        student_name.setText(name);

    }
}
