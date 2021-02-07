package com.buzzware.sofitapplication.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.buzzware.sofitapplication.Model.NewsModel;
import com.buzzware.sofitapplication.R;
import java.util.ArrayList;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.MyViewHolder> {
    private ArrayList<NewsModel> newsModels;
    Context mContext;
    public NewsAdapter(ArrayList<NewsModel> arrayList, Context context){
        this.newsModels = arrayList;
        this.mContext=context;
    }
    @Override
    public NewsAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.newslayout, parent, false);

        return new NewsAdapter.MyViewHolder(itemView);
    }
    @Override
    public void onBindViewHolder(NewsAdapter.MyViewHolder holder, int position) {
        NewsModel newsModel = newsModels.get(position);
        holder.newdimageview.setImageResource(newsModel.getNewsimage());
        holder.newdmodelTtile.setText(newsModel.getNewstitle());
    }
    @Override
    public int getItemCount() {
       return newsModels.size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView newdmodelTtile;
        ImageView newdimageview;

        public MyViewHolder(View view) {
            super(view);
            newdmodelTtile = view.findViewById(R.id.newsitem_text);
            newdimageview = view.findViewById(R.id.newsitem_image);

        }
    }

}
