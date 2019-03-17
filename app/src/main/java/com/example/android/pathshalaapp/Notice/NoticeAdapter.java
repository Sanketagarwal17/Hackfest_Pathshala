package com.example.android.pathshalaapp.Notice;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.pathshalaapp.Notice.Notice;
import com.example.android.pathshalaapp.Notice.NoticeModelClass;
import com.example.android.pathshalaapp.R;
import com.example.android.pathshalaapp.chatroom.ChatRoom_studs_adapter;

import java.util.ArrayList;

public class NoticeAdapter extends RecyclerView.Adapter<NoticeAdapter.ViewHolder>
{
    Context context;
    ArrayList<NoticeModelClass> arrayList;
    public NoticeAdapter(Context context, ArrayList<NoticeModelClass> arrayList)
    {
        this.context=context;
        this.arrayList=arrayList;
    }


    @NonNull
    @Override
    public NoticeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.notice_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NoticeAdapter.ViewHolder viewHolder, int position)
    {
        NoticeModelClass notice=arrayList.get(position);
        String name=notice.getName();
        String msg=notice.getNotice();
        viewHolder.name.setText(name);
        viewHolder.message.setText(msg);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView name,message;
        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);
            name=itemView.findViewById(R.id.notice_username);
            message=itemView.findViewById(R.id.notice_notice);

        }
    }
}