/*
SIMPLE CALCULATOR
DESIGNED BY MOHAMAD OLYAIY
AUG 2017
 */







package com.example.mohamadol.calcwithtablayout;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.*;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Instance of Tablayout
        TabLayout tablayout=(TabLayout)findViewById(R.id.tab_layout);
        //Adding the tabs
        tablayout.addTab(tablayout.newTab().setIcon(R.drawable.laptop));
        tablayout.addTab(tablayout.newTab().setIcon(R.drawable.earth));
         tablayout.addTab(tablayout.newTab().setIcon(R.drawable.copyright));

        //Instance of viewPager
        final ViewPager viewpager=(ViewPager)findViewById(R.id.viewpager);

        //new Instance of PagerAdapter passing the fragment manager and number of tabs as arguments
        //Support Fragment manager is used to support older versions of android
        final PagerAdapter adapter= new PagerAdapter(getSupportFragmentManager(),tablayout.getTabCount());

        viewpager.setAdapter(adapter);
        viewpager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tablayout));

        tablayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener(){
            @Override public void onTabSelected(TabLayout.Tab tab){
                viewpager.setCurrentItem(tab.getPosition());
            }
            @Override public void onTabUnselected(TabLayout.Tab tab){

            }
            @Override public void onTabReselected(TabLayout.Tab tab){

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
