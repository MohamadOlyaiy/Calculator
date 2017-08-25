package com.example.mohamadol.calcwithtablayout;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
PAGER ADAPTER BY MOHAMAD OLYAIY AUG 2017
 CLASS PAPER ADAPTER EXTENDS FRAGMENTPAGERADAPTER
 TO MANAGE FRAGMENTS
 THE CLASS CREATES FRAGMENTS ACCORDING TO THE POSITION ON TABLAYOUT
 */

public class PagerAdapter extends FragmentPagerAdapter {
    int totaltab;
    public PagerAdapter(FragmentManager fm, int tabnumbers){
        super(fm);
        this.totaltab=tabnumbers;
    }
    @Override
    public Fragment getItem(int position) {
        switch(position){
            case 0:
                SimpleCalculatorFragment tab1=new SimpleCalculatorFragment();
                return tab1;
            case 1:
                WebFragment tab2=new WebFragment();
                return tab2;
           case 2:
                CreditssFragment tab3=new CreditssFragment();
                return tab3;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return totaltab;
    }
}
