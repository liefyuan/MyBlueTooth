package com.example.wo.mybluetooth;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by yuanlifu on 2016/11/20.
 */
public class PlaceholderFragment extends Fragment {
    private static final String ARG_SECTION_NUMBER = "section_number";
    static int PageNumber;//页面选择

    public PlaceholderFragment() {
    }

    public static PlaceholderFragment newInstance(int sectionNumber) {
        PlaceholderFragment fragment = new PlaceholderFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {//实现不同的View通过滑动TabActivity
        PageNumber = getArguments().getInt(ARG_SECTION_NUMBER);
        switch (PageNumber) {
            case 1:
                View rootView = inflater.inflate(R.layout.fragment_main, container, false);

                return rootView;
            case 2:
                View rootView1 = inflater.inflate(R.layout.activity_serial, container, false);

                return rootView1;
        }
        return null;
    }

    /**
     * Created by yuanlifu on 2016/11/20.
     */
    public static class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return newInstance(position + 1);
        }

        @Override
        public int getCount() {
            return 2;//Tab的个数
        }

        @Override
        public CharSequence getPageTitle(int position) {//设置TayLayout的Title
            switch (position) {
                case 0:
                    return "SECTION 1";
                case 1:
                    return "SECTION 2";
                case 2:
                    return "SECTION 3";
            }
            return null;
        }
    }
}
