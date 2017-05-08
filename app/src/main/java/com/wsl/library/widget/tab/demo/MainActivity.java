package com.wsl.library.widget.tab.demo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.wsl.library.widget.tab.TabLayout;
import com.wsl.library.widget.tab.TabView;

import java.util.Map;

public class MainActivity extends AppCompatActivity {


    private String[] mTitle = {"微信", "通讯录"};
    private int[] mIconSelect = {R.drawable.ic_account_circle_black_24dp, R.drawable.ic_alarm_on_black_24dp};
    private int[] mIconNormal = {R.drawable.ic_account_circle_white_24dp, R.drawable.ic_alarm_on_white_24dp};
    private ViewPager mViewPager ;
    private TabLayout mTabView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewPager = (ViewPager)findViewById(R.id.id_view_pager) ;
//        mViewPager.setOffscreenPageLimit(4);
        mViewPager.setAdapter(new PageAdapter(getSupportFragmentManager()));
        mTabView = (TabLayout)findViewById(R.id.id_tab) ;
        mTabView.setViewPager(mViewPager);
    }

    class PageAdapter extends FragmentPagerAdapter implements TabLayout.OnItemIconTextSelectListener{

        public PageAdapter(FragmentManager fm) {
            super(fm);
        }
        @Override
        public Fragment getItem(int position) {
            String text = "fragment: " + position;
            return DemoFragment.newInstance(text);
        }
        @Override
        public int[] onIconSelect(int position) {
            int icon[] = new int[2] ;
            icon[0] = mIconSelect[position] ;
            icon[1] = mIconNormal[position] ;
            return icon;
        }
        @Override
        public String onTextSelect(int position) {
            return mTitle[position];
        }

        @Override
        public int getCount() {
            return mTitle.length;
        }
    }
}
