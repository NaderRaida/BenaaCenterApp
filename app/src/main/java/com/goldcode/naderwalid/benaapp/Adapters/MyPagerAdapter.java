package com.goldcode.naderwalid.benaapp.Adapters;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.goldcode.naderwalid.benaapp.Fragments.EventsFragment;
import com.goldcode.naderwalid.benaapp.Fragments.HomeFragment;
import com.goldcode.naderwalid.benaapp.Fragments.NewsFragment;
import com.goldcode.naderwalid.benaapp.R;

/**
 * Created by NaderWalid on 7/16/2018.
 */

public class MyPagerAdapter extends FragmentStatePagerAdapter {
    private final int HOME_FRAGMENT = 0;
    private final int NEWS_FRAGMENT = 1;
    private final int EVENTS_FRAGMENT = 2;
    private final int PAGES_COUNT = 3;
    private final Context context;

    public MyPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case HOME_FRAGMENT:
                fragment = new HomeFragment();
                break;
            case NEWS_FRAGMENT:
                fragment = new NewsFragment();
                break;
            case EVENTS_FRAGMENT:
                fragment = new EventsFragment();
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return PAGES_COUNT;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String fragment = "";
        switch (position) {
            case HOME_FRAGMENT:
                fragment = context.getString(R.string.fragment_home);
                break;
            case NEWS_FRAGMENT:
                fragment = context.getString(R.string.fragment_news);
                break;
            case EVENTS_FRAGMENT:
                fragment = context.getString(R.string.fragment_activities);
                break;
        }
        return fragment;
    }
}
