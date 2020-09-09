package com.example.lionortiger.Tables;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.lionortiger.R;

import java.util.ArrayList;
import java.util.List;

public class TablesActivity extends AppCompatActivity {

    ViewPager viewPager;
    PagerAdapter pagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tables);

        List<Fragment> list = new ArrayList<>();
        list.add(new oneFragment());
        list.add(new twoFragment());
        list.add(new threeFragment());
        list.add(new fourFragment());
        list.add(new fiveFragment());
        list.add(new sixFragment());
        list.add(new sevenFragment());
        list.add(new eightFragment());
        list.add(new nineFragment());
        list.add(new tenFragment());

        viewPager = findViewById(R.id.viewPager);
        pagerAdapter = new SlidePagerAdapter(getSupportFragmentManager(),list);
        viewPager.setAdapter(pagerAdapter);
    }
}