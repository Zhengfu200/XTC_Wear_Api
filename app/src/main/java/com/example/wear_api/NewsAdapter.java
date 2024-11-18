package com.example.wear_api;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder>{
    private List<NewsResponse.NewsItem> newsList;
    private Context context;

    public NewsAdapter(Context context,List<NewsResponse.NewsItem> newsList) {
        this.newsList = newsList;
        this.context = context;
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.news_item, parent, false);
        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
        NewsResponse.NewsItem newsItem = newsList.get(position);
        holder.titleTextView.setText(newsItem.title);
        holder.sourceTextView.setText(newsItem.source);

        holder.itemView.setOnClickListener(v ->{
            Intent intent = new Intent(context, DetailActivity.class);
            intent.putExtra("title", newsItem.title);
            intent.putExtra("source", newsItem.source);
            intent.putExtra("ctime", newsItem.ctime);
            intent.putExtra("url", newsItem.url);
            intent.putExtra("description", newsItem.description);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    public static class NewsViewHolder extends RecyclerView.ViewHolder {
        TextView titleTextView;
        TextView sourceTextView;

        public NewsViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.news_title);
            sourceTextView = itemView.findViewById(R.id.news_source);
        }
    }
}
