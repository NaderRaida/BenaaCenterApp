package com.goldcode.naderwalid.benaapp.Activities;

import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import com.goldcode.naderwalid.benaapp.Adapters.MyPagerAdapter;
import com.goldcode.naderwalid.benaapp.R;

public class HomeActivity extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
//        Toolbar toolbar = findViewById(R.id.toolbar);
//        toolbar.setTitle("الشاشة الرئيسية");
//        toolbar.setPaddingRelative(350,0,0,0);
//        setSupportActionBar(toolbar);
        ViewPager viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager(), this));
        viewPager.setCurrentItem(0);
        TabLayout tabLayout = findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);



        mDrawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        // set item as selected to persist highlight
                        menuItem.setChecked(true);
                        // close drawer when item is tapped
                        mDrawerLayout.closeDrawers();

                        // Add code here to update the UI based on the item selected
                        // For example, swap UI fragments here
                        switch(menuItem.getItemId()){
                            case R.id.nav_home:
                                Toast.makeText(getApplicationContext(),"home is selected",Toast.LENGTH_LONG).show();
                                break;
                            case R.id.nav_who_are_we:
                                Toast.makeText(getApplicationContext(),"who are we is selected",Toast.LENGTH_LONG).show();
                                break;
                        }
                        return true;
                    }
                });

    }
}

