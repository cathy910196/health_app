package health.binodata.health_app_test.menu_setting;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

import health.binodata.health_app_test.R;

public class account_info extends AppCompatActivity implements ChildEventListener {
    ArrayAdapter<String> fileDBAdapter;
    ListView list_info;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_info);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        list_info=(ListView)findViewById(R.id.list_info);
        //返回建
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        fileDBAdapter =
                new ArrayAdapter<>(this,
                        android.R.layout.simple_list_item_1,
                        android.R.id.text1);
        list_info.setAdapter(fileDBAdapter);

        FirebaseDatabase fireDB = FirebaseDatabase.getInstance();
        DatabaseReference myRef = fireDB.getReference("contact");
        myRef.addChildEventListener(this);
    }
    @Override
    public void onChildAdded(DataSnapshot dataSnapshot, String s) {
        fileDBAdapter.add(
                String.valueOf(dataSnapshot.child("name").getValue()));
    }

    @Override
    public void onChildRemoved(DataSnapshot dataSnapshot) {
        fileDBAdapter.remove(
                String.valueOf(dataSnapshot.child("name").getValue()));
    }

    @Override
    public void onChildChanged(DataSnapshot dataSnapshot, String s) { }

    @Override
    public void onChildMoved(DataSnapshot dataSnapshot, String s) { }

    @Override
    public void onCancelled(DatabaseError databaseError) { }

}
