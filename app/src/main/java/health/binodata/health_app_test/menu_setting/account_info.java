package health.binodata.health_app_test.menu_setting;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.google.firebase.database.DataSnapshot;

import java.util.ArrayList;

import health.binodata.health_app_test.R;

public class account_info extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_info);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        //返回建
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
}
