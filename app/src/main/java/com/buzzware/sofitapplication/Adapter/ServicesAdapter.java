package com.buzzware.sofitapplication.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.buzzware.sofitapplication.Model.ServicesModel;
import com.buzzware.sofitapplication.R;
import java.util.List;
public class ServicesAdapter extends RecyclerView.Adapter<ServicesAdapter.MyViewHolder> {
    private List<ServicesModel> servicesModelList;
    Context mContext;
    public ServicesAdapter(List<ServicesModel> list, Context context) {
        this.servicesModelList = list;
        this.mContext = context; }
    @Override
    public ServicesAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.govtservice_layout, parent, false);
        return new ServicesAdapter.MyViewHolder(itemView);
    }
    @Override
    public void onBindViewHolder(ServicesAdapter.MyViewHolder holder, int position) {
        ServicesModel servicesModel = servicesModelList.get(position);
//        Glide.with(mContext).load("url for online image get).into(holder.serviceImageview);
        Glide.with(mContext).load(servicesModel.getServiceImageview()).into(holder.serviceImageview);
        Glide.with(mContext).load(servicesModel.getServicvehicleIV()).into(holder.servicvehicleIV);
        Glide.with(mContext).load(servicesModel.getServicpropertyIV()).into(holder.servicepropertyIV);
        Glide.with(mContext).load(servicesModel.getServicmediaIV()).into(holder.servicemedia_IV);

        Glide.with(mContext).load(servicesModel.getServicecomplainIv()).into(holder.complaintsIV);
        Glide.with(mContext).load(servicesModel.getServicvenvirmentIV()).into(holder.serviceIV);
        Glide.with(mContext).load(servicesModel.getServicheavyIV()).into(holder.workIV);
        Glide.with(mContext).load(servicesModel.getServicschedualIV()).into(holder.schedualIV);

        Glide.with(mContext).load(servicesModel.getServiccommerecIV()).into(holder.comerceIV);
        Glide.with(mContext).load(servicesModel.getServicwalletIV()).into(holder.waletIV);

       // holder.serviceImageview.setImageResource(servicesModel.getServiceImageview());
        holder.propertysericeTitle.setText(servicesModel.getPropertysericeTitle());
        holder.vehicleserviceTitle.setText(servicesModel.getVehicleserviceTitle());
        holder.housesericeTitle.setText(servicesModel.getHousesericeTitle());
        holder.mediaserviceTitle.setText(servicesModel.getMediaserviceTitle());
        holder.complainsericeTitle.setText(servicesModel.getComplainsericeTitle());
        holder.serviceTitle.setText(servicesModel.getServiceTitle());
        holder.workserviceTitle.setText(servicesModel.getWorkserviceTitle());
        holder.schedualsericeTitle.setText(servicesModel.getSchedualsericeTitle());
        holder.ComerceserviceTitle.setText(servicesModel.getComerceserviceTitle());
        holder.waletsericeTitle.setText(servicesModel.getWaletsericeTitle());
    }
    @Override
    public int getItemCount() {
        return servicesModelList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView serviceImageview,servicvehicleIV,servicepropertyIV,servicemedia_IV;
        ImageView complaintsIV,serviceIV,workIV,schedualIV;
        ImageView comerceIV,waletIV;
        TextView propertysericeTitle, vehicleserviceTitle, housesericeTitle, mediaserviceTitle, complainsericeTitle;
        TextView serviceTitle, workserviceTitle, schedualsericeTitle, ComerceserviceTitle, waletsericeTitle;

        public MyViewHolder(View view) {
            super(view);
            serviceImageview = view.findViewById(R.id.home_IV);
            servicvehicleIV= view.findViewById(R.id.travel_IV);
            servicepropertyIV= view.findViewById(R.id.property_IV);
            servicemedia_IV= view.findViewById(R.id.media_IV);
            complaintsIV = view.findViewById(R.id.complaintsIV);
            serviceIV= view.findViewById(R.id.serviceIV);
            workIV= view.findViewById(R.id.workIV);
            schedualIV= view.findViewById(R.id.schedualIV);
            comerceIV= view.findViewById(R.id.comerceIV);
            waletIV= view.findViewById(R.id.waletIV);
            propertysericeTitle = view.findViewById(R.id.home_Tv);
            vehicleserviceTitle = view.findViewById(R.id.traveTV);
            housesericeTitle = view.findViewById(R.id.propertyTV);
            mediaserviceTitle = view.findViewById(R.id.mediaTV);
            complainsericeTitle = view.findViewById(R.id.complainTV);
            serviceTitle = view.findViewById(R.id.serviceTV);
            workserviceTitle = view.findViewById(R.id.workTV);
            schedualsericeTitle = view.findViewById(R.id.schedualTV);
            ComerceserviceTitle = view.findViewById(R.id.comerceTV);
            waletsericeTitle = view.findViewById(R.id.waletTV);
        }
    }
}


