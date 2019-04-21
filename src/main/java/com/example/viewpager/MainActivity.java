package com.example.viewpager;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {

    private ViewPager vp;
    private ArrayList<View> list;
    private MyAdapter adapter;
    private ArrayList<String> title;
    private TabLayout tab;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        vp = findViewById(R.id.vp);
        tab = findViewById(R.id.tab);
        list=new ArrayList<>();
        View view = LayoutInflater.from(this).inflate(R.layout.layout_item, null);
        View view2 = LayoutInflater.from(this).inflate(R.layout.layout_item2, null);
        View view3 = LayoutInflater.from(this).inflate(R.layout.layout_item3, null);
        list.add(view);
        list.add(view2);
        list.add(view3);

        title=new ArrayList<>();
        title.add("页面1");
        title.add("页面2");
        title.add("页面3");

        
        adapter=new MyAdapter(list,title);
        vp.setAdapter(adapter);

        //TabLayout与ViewPager绑定关联
        tab.setupWithViewPager(vp);
        //设置滑动监听
        vp.addOnPageChangeListener(this);
        //设置默认选中页面
        vp.setCurrentItem(list.size()-1);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {


    }

    @Override
    public void onPageSelected(int position) {
        Toast.makeText(MainActivity.this,"显示的当前"+position+"页面",Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
