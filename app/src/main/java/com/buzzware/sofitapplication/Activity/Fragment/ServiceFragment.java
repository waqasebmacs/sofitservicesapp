package com.buzzware.sofitapplication.Activity.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.buzzware.sofitapplication.Adapter.ServicesAdapter;
import com.buzzware.sofitapplication.Model.ServicesModel;
import com.buzzware.sofitapplication.R;
import java.util.ArrayList;
public class ServiceFragment extends Fragment {
    RecyclerView servicerecycler;
    ArrayList<ServicesModel> servicesModels;
    ServicesAdapter servicesAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_service, container, false);
        init(view);
        return view;
    }
    private void init(View view) {
        servicerecycler =view.findViewById(R.id.servicerecyclerView);
        servicesModels = new ArrayList<>();
        govtServicesData();
    }
    //todo just show it as dummy data
    public void govtServicesData()
    {
        servicesModels.add ( new ServicesModel ( R.drawable.govern_b,R.drawable.car_ser,R.drawable.property_ic, R.drawable.media_ic,
                R.drawable.govern_b,R.drawable.payment_h,R.drawable.library,R.drawable.medicnine_ic,R.drawable.news,
                R.drawable.utilty_ic,"Home","Vehicle","Propoerty",
                "Media","Complain","Salary","Liabrary","Schedual",
                "Commerce", "Wallet"));
        servicesModels.add ( new ServicesModel ( R.drawable.govern_b,R.drawable.car_ser,R.drawable.property_ic, R.drawable.media_ic,
                R.drawable.govern_b,R.drawable.payment_h,R.drawable.library,R.drawable.medicnine_ic,R.drawable.news,
                R.drawable.utilty_ic,"Home","Vehicle","Propoerty",
                "Media","Complain","Salary","Liabrary","Schedual",
                "Commerce", "Wallet"));
        servicesModels.add ( new ServicesModel ( R.drawable.govern_b,R.drawable.car_ser,R.drawable.property_ic, R.drawable.media_ic,
                R.drawable.govern_b,R.drawable.payment_h,R.drawable.library,R.drawable.medicnine_ic,R.drawable.news,
                R.drawable.utilty_ic,"Home","Vehicle","Propoerty",
                "Media","Complain","Salary","Liabrary","Schedual",
                "Commerce", "Wallet"));


        servicesAdapter = new ServicesAdapter( servicesModels,getActivity ());
        servicerecycler.setAdapter(servicesAdapter);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        servicerecycler.setLayoutManager(mLayoutManager);
    }
}