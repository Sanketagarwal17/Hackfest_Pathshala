package com.example.android.pathshalaapp.Faculty;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.pathshalaapp.Faculty.FacultyAdapter;
import com.example.android.pathshalaapp.Faculty.FacultyModelClass;
import com.example.android.pathshalaapp.R;

import java.util.ArrayList;

public class FacultyAdapter extends RecyclerView.Adapter<FacultyAdapter.ViewHolder>
{
    Context context;
    ArrayList<FacultyModelClass> arrayList;

    public FacultyAdapter(Context context, ArrayList<FacultyModelClass> arrayList)
    {
        this.context=context;
        this.arrayList=arrayList;
    }

    @NonNull
    @Override
    public FacultyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.notice_list_item, parent, false);
        return new FacultyAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FacultyAdapter.ViewHolder viewHolder, int position)
    {
        FacultyModelClass faculty=arrayList.get(position);
        String name=faculty.getName();
        String subj=faculty.getSubject();
        viewHolder.name.setText(name);
        viewHolder.subject.setText(subj);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView name,subject;
        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);
            name=itemView.findViewById(R.id.faculty_name);
            subject=itemView.findViewById(R.id.faculty_subject);
        }
    }
}