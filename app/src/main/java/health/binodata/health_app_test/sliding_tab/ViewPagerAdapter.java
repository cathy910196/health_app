package health.binodata.health_app_test.sliding_tab;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import health.binodata.health_app_test.main_tab.tab_food;
import health.binodata.health_app_test.main_tab.tab_info;
import health.binodata.health_app_test.main_tab.tab_measure;
import health.binodata.health_app_test.main_tab.tab_sport;
import health.binodata.health_app_test.main_tab.tab_tech;

/**
 * Created by hp1 on 21-01-2015.
 */
public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    CharSequence Titles[]; // This will Store the Titles of the Tabs which are Going to be passed when ViewPagerAdapter is created
    int NumbOfTabs; // Store the number of tabs, this will also be passed when the ViewPagerAdapter is created


    // Build a Constructor and assign the passed Values to appropriate values in the class
    public ViewPagerAdapter(FragmentManager fm, CharSequence mTitles[], int mNumbOfTabsumb) {
        super(fm);

        this.Titles = mTitles;
        this.NumbOfTabs = mNumbOfTabsumb;

    }

    //This method return the fragment for the every position in the View Pager
    @Override
    public Fragment getItem(int position) {

        if(position == 2) // if the position is 0 we are returning the First tab
        {
            tab_food tab1 = new tab_food();
            return tab1;
        }
        else if(position == 0)             // As we are having 2 tabs if the position is now 0 it must be 1 so we are returning second tab
        {
            tab_info tab2 = new tab_info();
            return tab2;
        }else if(position == 1)             // As we are having 2 tabs if the position is now 0 it must be 1 so we are returning second tab
        {
            tab_measure tab3 = new tab_measure();
            return tab3;
        }else if(position == 3)
        {
            tab_sport tab4 = new tab_sport();
            return tab4;
        }else{
            tab_tech tab5 = new tab_tech();
            return tab5;
        }


    }

    // This method return the titles for the Tabs in the Tab Strip

    @Override
    public CharSequence getPageTitle(int position) {
        return Titles[position];
    }

    // This method return the Number of tabs for the tabs Strip

    @Override
    public int getCount() {
        return NumbOfTabs;
    }
}