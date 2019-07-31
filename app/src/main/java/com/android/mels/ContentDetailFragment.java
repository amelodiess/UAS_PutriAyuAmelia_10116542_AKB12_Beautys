package com.android.mels;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;

import com.android.ceritamahasiswaa.R;
import com.squareup.picasso.Picasso;


/**
 * A simple {@link Fragment} subclass.
 */
public class ContentDetailFragment extends Fragment {


    private TipsFragment tipsFragment;
    private KondisiKulitFragment kondisiKulitFragment;
    private SkincareFragment skincareFragment;
    public ContentDetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_tips_detail, container, false);
        TextView titleView = (TextView) view.findViewById(R.id.title);
        WebView contentView = (WebView) view.findViewById(R.id.content);
        ImageView imageView = (ImageView) view.findViewById(R.id.image);

        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String type = getArguments().getString("type");
                final FragmentTransaction ft = getFragmentManager().beginTransaction();
                if(type == "tips"){
                    tipsFragment = new TipsFragment();
                    ft.replace(R.id.main_frame, tipsFragment );
                }else if(type == "kondisikulit"){
                    kondisiKulitFragment = new KondisiKulitFragment();
                    ft.replace(R.id.main_frame, kondisiKulitFragment );
                }else{
                    skincareFragment = new SkincareFragment();
                    ft.replace(R.id.main_frame, skincareFragment);
                }
                ft.commit();
            }
        });

        titleView.setText(getArguments().getString("title"));
        contentView.loadData(getArguments().getString("content"), "text/html; charset=UTF-8", null);
        Picasso.get().load(getArguments().getString("image")).into(imageView);
        return view;
    }

}
