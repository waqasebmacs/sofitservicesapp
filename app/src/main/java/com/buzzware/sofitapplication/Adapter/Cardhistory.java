package com.buzzware.sofitapplication.Adapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.buzzware.sofitapplication.Model.PaymentHistoryModel;
import com.buzzware.sofitapplication.R;
import java.util.ArrayList;
public class Cardhistory extends RecyclerView.Adapter<Cardhistory.MyViewHolder> {
    private ArrayList<PaymentHistoryModel> paymentHistoryModels;
    Context mContext;
    public Cardhistory(ArrayList<PaymentHistoryModel> arrayList, Context context){
        this.paymentHistoryModels = arrayList;
        this.mContext=context;
    }
    @Override
    public Cardhistory.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.paymentcardhistory_layout, parent, false);
        return new Cardhistory.MyViewHolder(itemView);
    }
    @Override
    public void onBindViewHolder(Cardhistory.MyViewHolder holder, int position) {
        PaymentHistoryModel newsModel = paymentHistoryModels.get(position);
        Glide
                .with(mContext)
                .load(newsModel.getPaycardImageview())
                .centerCrop()
                .into(holder.paycardimageview);
        holder.cardtype.setText(newsModel.getCardnameTV());
    }
    @Override
    public int getItemCount() {
       return paymentHistoryModels.size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView cardtype;
        ImageView paycardimageview;
        public MyViewHolder(View view) {
            super(view);
            cardtype = view.findViewById(R.id.cardnameTV);
            paycardimageview = view.findViewById(R.id.carttypeIV);
        }
    }
}
