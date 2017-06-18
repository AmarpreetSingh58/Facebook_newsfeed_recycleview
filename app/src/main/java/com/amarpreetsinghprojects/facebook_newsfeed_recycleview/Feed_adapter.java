package com.amarpreetsinghprojects.facebook_newsfeed_recycleview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by kulvi on 06/17/17.
 */

public class Feed_adapter extends RecyclerView.Adapter<Feed_adapter.ViewHolder> {

    ArrayList<Feed_elements> feedElementsArrayList;
    Context c;

    public Feed_adapter(ArrayList<Feed_elements> feedElementsArrayList, Context c) {
        this.feedElementsArrayList = feedElementsArrayList;
        this.c = c;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater l = LayoutInflater.from(c);
        View v = l.inflate(R.layout.feed_listview,parent,false);
        ViewHolder vH = new ViewHolder(v);

        return vH;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Feed_elements f = feedElementsArrayList.get(position);
        holder.title.setText(f.getTitle());
        holder.date.setText(f.getDate());
        holder.feed.setText(f.getFeed());

        if (f.getFeed().length()<100){
            holder.feed.setTextSize(30);
        }
        else {
            holder.feed.setTextSize(12);
        }
    }

    @Override
    public int getItemCount() {

        return feedElementsArrayList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView title, date, feed;
        public ViewHolder(View itemView) {
            super(itemView);

            title = (TextView)itemView.findViewById(R.id.title_textview);
            date = (TextView)itemView.findViewById(R.id.date_textView);
            feed = (TextView)itemView.findViewById(R.id.feed_textView);
        }
    }
}
