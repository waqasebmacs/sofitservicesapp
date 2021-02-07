package com.buzzware.sofitapplication.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.buzzware.sofitapplication.R;
import com.buzzware.sofitapplication.Retrofit.PostService.PostModel;

import java.util.ArrayList;


public class PostServices extends RecyclerView.Adapter<PostServices.MyViewHolder> {
    private ArrayList<PostModel> postServiceModelList;
    Context mContext;

    public PostServices(ArrayList<PostModel> arrayList, Context context) {
        this.postServiceModelList = arrayList;
        this.mContext = context;
    }

    @Override
    public PostServices.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.postservices_layout, parent, false);
        return new PostServices.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(PostServices.MyViewHolder holder, int position) {
        PostModel postServiceModel = postServiceModelList.get(position);
        if (postServiceModel != null) {
            holder.postuidTv.setText("" + postServiceModel.getId());
            holder.posttitleTv.setText("" + postServiceModel.getTitle());
            holder.postbodyTV.setText("" + postServiceModel.getBody());
        }
    }

    @Override
    public int getItemCount() {
        return postServiceModelList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView postuseridTv, postuidTv, posttitleTv, postbodyTV;

        public MyViewHolder(View view) {
            super(view);
            postuseridTv = view.findViewById(R.id.postuseridTv);
            postuidTv = view.findViewById(R.id.postuseridTv);
            posttitleTv = view.findViewById(R.id.titleTv);
            postbodyTV = view.findViewById(R.id.postbodyTv);
        }
    }
}
