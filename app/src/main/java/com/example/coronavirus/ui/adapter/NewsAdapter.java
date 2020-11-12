package com.example.coronavirus.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coronavirus.R;
import com.example.coronavirus.restclient.dto.News;

import java.util.ArrayList;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ModelViewHolder>{

    private ArrayList<News> newsList = new ArrayList<>();

    @NonNull
    @Override
    public ModelViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news ,parent, false);
        return new ModelViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ModelViewHolder holder, int position) {
        holder.onBind(newsList.get(position));
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    public void setData(ArrayList<News> newsList){
        this.newsList = newsList;
        notifyDataSetChanged();
    }

    class ModelViewHolder extends RecyclerView.ViewHolder {

        private TextView tvTitle;
        private TextView tvContent;
        private ImageView ivImage;

        public ModelViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_news_title);
            tvContent = itemView.findViewById(R.id.tv_news_content);
            ivImage = itemView.findViewById(R.id.iv_news_image);
        }

        void onBind(News news){
            tvTitle.setText(news.getTitle());
            tvContent.setText(news.getContent());
            ivImage.setImageResource(news.getImageId());
        }
    }
}
