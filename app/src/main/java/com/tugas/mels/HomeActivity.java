package com.tugas.mels;



import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.tugas.mels.R;

public class HomeActivity extends AppCompatActivity {

    private BottomNavigationView nMainNav;
    private FrameLayout nMainFrame;

    private HomeFragment homeFragment;
    private TipsFragment tipsFragment;
    private SkincareFragment galleryFragment;
    private KondisiKulitFragment kondisiKulitFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        nMainFrame = (FrameLayout)findViewById(R.id.main_frame);
        nMainNav = (BottomNavigationView)findViewById(R.id.main_nav);

        homeFragment = new HomeFragment();
        tipsFragment = new TipsFragment();
        galleryFragment = new SkincareFragment();
        kondisiKulitFragment = new KondisiKulitFragment();

        setFragment(kondisiKulitFragment);




        nMainNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {

                switch (menuItem.getItemId()){


                    case R.id.daily_nav:
                        setFragment(tipsFragment);
                        return true;

                    case R.id.gallery_nav :
                        setFragment(galleryFragment);
                        return true;

                    case R.id.music_nav :
                        setFragment(kondisiKulitFragment);
                        return true;
//
//                    case R.id.profile_nav :
//                        setFragment(profileFragment);
//                        return true;

                        default:
                            return false;

                }

            }

            private void setFragment(Fragment fragment) {

                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.main_frame, fragment);
                fragmentTransaction.commit();
            }
        });
    }

    private void setFragment(Fragment fragment) {

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_frame, fragment);
        fragmentTransaction.commit();
    }


}
