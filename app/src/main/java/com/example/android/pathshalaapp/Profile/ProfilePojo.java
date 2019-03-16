package com.example.android.pathshalaapp.Profile;


public class ProfilePojo
{
    private String name,school,mobile,email,std,batch;

    public String getName() {
        return name;
    }

    public String getSchool() {
        return school;
    }

    public String getMobile() {
        return mobile;
    }

    public String getEmail() {
        return email;
    }

    public String getStd() {
        return std;
    }

    public String getBatch() {
        return batch;
    }

    public ProfilePojo(String name, String school, String mobile, String email, String std, String batch) {
        this.name = name;
        this.school = school;
        this.mobile = mobile;
        this.email = email;
        this.std = std;
        this.batch = batch;
    }
}