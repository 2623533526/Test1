package com.bawei.test1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Fragment_Login fragment_1;
    private Fragment_Other fragment_2;
    private Fragment_My fragment_3;
    private ArrayList<Fragment> fragments;
    private ViewPager vp;
    private RadioButton bt_1;
    private RadioButton bt_2;
    private RadioButton bt_3;
    private RadioGroup ra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vp = findViewById(R.id.vp);
        bt_1 = findViewById(R.id.bt_1);
        bt_2 = findViewById(R.id.bt_2);
        bt_3 = findViewById(R.id.bt_3);
        ra = findViewById(R.id.ra);
        fragment_1 = new Fragment_Login();
        fragment_2 = new Fragment_Other();
        fragment_3 = new Fragment_My();
        fragments = new ArrayList<>();
        fragments.add(fragment_1);
        fragments.add(fragment_2);
        fragments.add(fragment_3);
          vp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
              @NonNull
              @Override
              public Fragment getItem(int position) {
                  return fragments.get(position);
              }

              @Override
              public int getCount() {
                  return fragments.size();
              }
          });
        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                ra.check(ra.getChildAt(position).getId());
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });




        ra.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case  R.id.bt_1:
                        vp.setCurrentItem(0);
                        break;
                    case  R.id.bt_2:
                        vp.setCurrentItem(1);
                        break;
                    case  R.id.bt_3:
                        vp.setCurrentItem(2);
                        break;
                }
            }
        });
    }
}
