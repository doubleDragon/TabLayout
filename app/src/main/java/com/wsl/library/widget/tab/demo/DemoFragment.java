package com.wsl.library.widget.tab.demo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by wsl on 17/5/8.
 */

public class DemoFragment extends Fragment{

    private String mText;

    public static DemoFragment newInstance(String text) {
        Bundle bundle = new Bundle();
        bundle.putString("extra", text);

        DemoFragment fragment = new DemoFragment();
        fragment.setArguments(bundle);

        return fragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mText = getArguments().getString("extra", "");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        TextView textView = new TextView(container.getContext());
        textView.setText(mText);
        textView.setGravity(Gravity.CENTER);
        return textView;
    }
}
