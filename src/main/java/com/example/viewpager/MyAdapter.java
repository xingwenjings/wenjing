package com.example.viewpager;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class MyAdapter extends PagerAdapter {
    private ArrayList<View> list;
    private ArrayList<String> title;

    public MyAdapter(ArrayList<View> list, ArrayList<String> title) {
        this.list = list;
        this.title = title;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        container.addView(list.get(position));
        return list.get(position);
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        //super.destroyItem(container, position, object);
        container.removeView(list.get(position));

    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {

        return title.get(position);
    }
}
