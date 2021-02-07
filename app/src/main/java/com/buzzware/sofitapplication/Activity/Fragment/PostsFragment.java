package com.buzzware.sofitapplication.Activity.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.buzzware.sofitapplication.Adapter.PostServices;
import com.buzzware.sofitapplication.R;
import com.buzzware.sofitapplication.Retrofit.Api.ApiClient;
import com.buzzware.sofitapplication.Retrofit.Dialogebox.CustomProgressDialog;
import com.buzzware.sofitapplication.Retrofit.PostService.PostModel;
import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
public class PostsFragment extends Fragment {
    RecyclerView postservicerecycler;
    ArrayList<PostModel> postServiceModels;
    PostServices postServices;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_posts, container, false);
        init(view);
        return view;
    }
    private void init(View view) {
        postservicerecycler = view.findViewById(R.id.post_RV);
        postServiceModels = new ArrayList<>();
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        postservicerecycler.setLayoutManager(mLayoutManager);
        postServiceDataShow();
    }
    public void postServiceDataShow()
    {
        CustomProgressDialog.getInstance(getActivity()).showProgressDialog();
        Retrofit retrofit= new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiClient apiInterface= retrofit.create(ApiClient.class);
        Call<ArrayList<PostModel>> call= apiInterface.postServiceData();
        call.enqueue(new Callback<ArrayList<PostModel>>() {
            @Override
            public void onResponse(Call<ArrayList<PostModel>> call, Response<ArrayList<PostModel>> response) {
                CustomProgressDialog.getInstance(getActivity()).dismissProgressDialog();
                postServiceModels.addAll(response.body());
                postServices = new PostServices(postServiceModels,getActivity());
                postservicerecycler.setAdapter(postServices);
                postServices.notifyDataSetChanged();
            }
            @Override
            public void onFailure(Call<ArrayList<PostModel>> call, Throwable t) {
                CustomProgressDialog.getInstance(getActivity()).dismissProgressDialog();
            }
        });
    }
}