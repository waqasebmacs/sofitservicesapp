package com.buzzware.sofitapplication.Activity.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.buzzware.sofitapplication.Adapter.Cardhistory;
import com.buzzware.sofitapplication.Adapter.NewsAdapter;
import com.buzzware.sofitapplication.Model.NewsModel;
import com.buzzware.sofitapplication.Model.PaymentHistoryModel;
import com.buzzware.sofitapplication.R;
import java.util.ArrayList;
public class HomeFragment extends Fragment {
    RecyclerView newsdataRecyclerView,paymentcardrecyclerView;
    ArrayList<NewsModel> newsModels;
    ArrayList<PaymentHistoryModel> paymentHistoryModels;
    Cardhistory cardhistory;
    NewsAdapter newsAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_home, container, false);
        init(view);
        return view;
    }
    private void init(View view) {
        newsdataRecyclerView =view.findViewById(R.id.newsrecyclerView);
        paymentcardrecyclerView =view.findViewById(R.id.cardsrecyclerview);
        paymentHistoryModels = new ArrayList<>();
        newsModels = new ArrayList<>();
        newsAdapter = new NewsAdapter( newsModels,getActivity ());
        cardhistory = new Cardhistory( paymentHistoryModels,getActivity ());
        CardHistory();
        NewsDetails();
    }
    public void NewsDetails()
    {
        newsModels.add ( new NewsModel ( R.drawable.menicon,"Lorem Ipsum is simply dummy text of the printing and typesetting industry."));
        newsModels.add ( new NewsModel ( R.drawable.menicon,"Lorem Ipsum is simply dummy text of the printing and typesetting industry."));
        newsModels.add ( new NewsModel ( R.drawable.menicon,"Lorem Ipsum is simply dummy text of the printing and typesetting industry."));
        newsdataRecyclerView.setAdapter(newsAdapter);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, true);
        newsdataRecyclerView.setLayoutManager(mLayoutManager);
    }
    public void CardHistory()
    {
        paymentHistoryModels.add ( new PaymentHistoryModel ( R.drawable.payment_h,"Payment History"));
        paymentHistoryModels.add ( new PaymentHistoryModel ( R.drawable.payment_h,"Payment History"));
        paymentHistoryModels.add ( new PaymentHistoryModel ( R.drawable.payment_h,"Payment History"));
        paymentcardrecyclerView.setAdapter(cardhistory);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, true);
        paymentcardrecyclerView.setLayoutManager(mLayoutManager);
    }
}