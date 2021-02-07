package com.buzzware.sofitapplication.Activity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.TextView;
import android.widget.Toast;

import com.buzzware.sofitapplication.Activity.Fragment.BaseFragment;
import com.buzzware.sofitapplication.Activity.Fragment.ServiceFragment;
import com.buzzware.sofitapplication.R;
import com.google.android.material.navigation.NavigationView;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentTransaction;

public class BaseActivity extends AppCompatActivity implements
      NavigationView.OnNavigationItemSelectedListener{
    ActionBarDrawerToggle toggle;
    NavigationView navigationView;
    DrawerLayout drawer;
    Toolbar toolbar;
    public static TextView toolbartitle_TV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
         toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        initBaseUINavigation();
    }

    private void initBaseUINavigation() {
        toolbar = findViewById ( R.id.toolbar );
        setSupportActionBar ( toolbar );
        drawer = findViewById ( R.id.drawer_layout );
        navigationView = findViewById ( R.id.nav_view );
        toolbartitle_TV=findViewById(R.id.toolbartitle_TV);
        toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close );
        drawer.addDrawerListener ( toggle );
        toggle.syncState ();
        navigationView.setNavigationItemSelectedListener ( this );
        toolbartitle_TV.setText("Home");
        loadFragment(new BaseFragment());
        toolbar.setTitleTextColor( Color.GRAY );
        navigationView.setItemIconTintList(null);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //todo for setting at right side of Drawer
        getMenuInflater().inflate(R.menu.base, menu);
        return true;
    }
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        DrawerLayout drawer = findViewById ( R.id.drawer_layout );
        drawer.closeDrawer ( GravityCompat.START );
        switch (item.getItemId()){
            case R.id.nav_home:
                toolbartitle_TV.setText("Home");
                loadFragment(new BaseFragment());
                break;
            case R.id.nav_service :
                toolbartitle_TV.setText("Government Services");
                loadFragment(new ServiceFragment());
                break;
        }
        return true;
    }
    private void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}