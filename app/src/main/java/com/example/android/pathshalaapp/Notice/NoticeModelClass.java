package com.example.android.pathshalaapp.Notice;

public class NoticeModelClass
{
    String name;String notice;

    public String getName() {
        return name;
    }

    public String getNotice() {
        return notice;
    }

    public NoticeModelClass(String notice, String name) {
        this.name = name;
        this.notice = notice;
    }
    public NoticeModelClass()
    {

    }
}