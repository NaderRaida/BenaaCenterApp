package com.goldcode.naderwalid.benaapp.Activities;

import android.content.Intent;
import android.drm.DrmStore;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.goldcode.naderwalid.benaapp.Adapters.MyPagerAdapter;
import com.goldcode.naderwalid.benaapp.R;

public class HomeActivity extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;
    ViewPager viewPager ;
    TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("");
//        toolbar.setPaddingRelative(350,0,0,0);
        setSupportActionBar(toolbar);

        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_if_th_menu_216424);

        viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager(), this));
        viewPager.setCurrentItem(0);
        tabLayout = findViewById(R.id.tabLayout);
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
                                viewPager.setCurrentItem(0);

                                break;
                            case R.id.nav_news:
                                viewPager.setCurrentItem(1);

                                break;
                            case R.id.nav_events:
                                viewPager.setCurrentItem(2);

                                break;
                            case R.id.nav_who_are_we:
                                Intent whoAreWeIntent = new Intent(getApplicationContext(),WhoAreWeActivity.class);
                                startActivity(whoAreWeIntent);
                                mDrawerLayout.openDrawer(GravityCompat.START);
                                if (menuItem.isChecked()){
                                    menuItem.setChecked(false);
                                }
                                break;
                            case R.id.nav_contact_us:
                                Intent contactUsIntent = new Intent(getApplicationContext(),ContactUsActivity.class);
                                startActivity(contactUsIntent);
                                mDrawerLayout.openDrawer(GravityCompat.START);
                                if (menuItem.isChecked()){
                                    menuItem.setChecked(false);
                                }
                                break;

                        }
                        return true;
                    }
                });



    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

