package com.example.android.pathshalaapp.Faculty;

public class FacultyModelClass
{
    String name,subject;

    public FacultyModelClass() {
    }

    public String getName() {
        return name;
    }

    public String getSubject() {
        return subject;
    }

    public FacultyModelClass(String name, String subject) {
        this.name = name;
        this.subject = subject;
    }
}