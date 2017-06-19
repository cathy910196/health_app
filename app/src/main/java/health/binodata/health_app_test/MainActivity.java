package health.binodata.health_app_test;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import health.binodata.health_app_test.menu_setting.account_info;
import health.binodata.health_app_test.menu_setting.care_talk;
import health.binodata.health_app_test.menu_setting.change_pwd;
import health.binodata.health_app_test.sliding_tab.SlidingTabLayout;
import health.binodata.health_app_test.sliding_tab.ViewPagerAdapter;

public class MainActivity extends AppCompatActivity {
    ViewPager pager;
    ViewPagerAdapter adapter;
    SlidingTabLayout tabs;
    CharSequence Titles[]={"個人資訊","生理量測","飲食記錄","運動紀錄","衛教宣導"};
    int Numboftabs =5;
    Handler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //toolbar.setOnMenuItemClickListener(onMenuItemClick);

        // Creating The ViewPagerAdapter and Passing Fragment Manager, Titles fot the Tabs and Number Of Tabs.
        adapter =  new ViewPagerAdapter(getSupportFragmentManager(),Titles,Numboftabs);

        // Assigning ViewPager View and setting the adapter
        pager = (ViewPager) findViewById(R.id.pager);

        pager.setAdapter(adapter);

        // Assiging the Sliding Tab Layout View
        tabs = (SlidingTabLayout) findViewById(R.id.tabs);
        tabs.setDistributeEvenly(true); // To make the Tabs Fixed set this true, This makes the tabs Space Evenly in Available width

        // Setting Custom Color for the Scroll bar indicator of the Tab View
        tabs.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {
            @Override
            public int getIndicatorColor(int position) {
                return getResources().getColor(R.color.tabsScrollColor);
            }
        });

        // Setting the ViewPager For the SlidingTabsLayout
        tabs.setViewPager(pager);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch(item.getItemId()) {
            case R.id.account_info:

                Intent intent = new Intent(this, account_info.class);
                startActivity(intent);

                return true;

            case R.id.change_pwd:
                Intent intent3 = new Intent(this, change_pwd.class);
                startActivity(intent3);

                return true;
            case R.id.logout:
                Intent intent4 = new Intent(this, LoginActivity.class);
                startActivity(intent4);

                return true;
            case R.id.bell:
                Intent intent5 = new Intent(this, care_talk.class);
                startActivity(intent5);
                return true;
            case R.id.tech:
                Intent intent6 = new Intent(this, TeachActivity.class);
                startActivity(intent6);
                return true;
            default:
                return false;
            //return super.onOptionsItemSelected(item);
        }
    }
}
