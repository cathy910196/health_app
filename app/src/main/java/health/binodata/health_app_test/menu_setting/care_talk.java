package health.binodata.health_app_test.menu_setting;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import health.binodata.health_app_test.R;

public class care_talk extends AppCompatActivity {

    private ListView listView;
    private String[] list = {"今天兩點與陳醫師有約","陳醫師與您的預約排成訊息","陳醫師給您的新訊息","您血壓狀況異常"};
    private ArrayAdapter<String> listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_care_talk);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        listView = (ListView)findViewById(R.id.listView_message);
        listAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,list);
        listView.setAdapter(listAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "訊息：" + list[position], Toast.LENGTH_SHORT).show();
            }
        });


        //返回建
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
