package com.buzzware.sofitapplication.Activity.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.buzzware.sofitapplication.Activity.BaseActivity;
import com.buzzware.sofitapplication.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
public class BaseFragment extends Fragment {
    BottomNavigationView bottomNavigationView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_base, container, false);
        setUpNavigation(view);
        return view;
    }
    public void setUpNavigation(View view){
        bottomNavigationView = (BottomNavigationView)view.findViewById(R.id.bttm_nav);
        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        BaseActivity.toolbartitle_TV.setText("Home");
        loadFragment(new HomeFragment());
    }
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.home:
                    BaseActivity.toolbartitle_TV.setText("Home");
                    loadFragment(new HomeFragment());
                    return true;
                case R.id.service:
                    BaseActivity.toolbartitle_TV.setText("Government Services");
                    loadFragment(new ServiceFragment());
                    return true;
                case R.id.post:
                    BaseActivity.toolbartitle_TV.setText("Post");
                    loadFragment(new PostsFragment());
                    return true;
            }
            return false;
        }
    };
        private boolean loadFragment(Fragment fragment)
    {
        if (fragment != null) {
            getChildFragmentManager().beginTransaction().replace(R.id.baseframe, fragment).commit();
            return true;
        }
        return false;
    }
}