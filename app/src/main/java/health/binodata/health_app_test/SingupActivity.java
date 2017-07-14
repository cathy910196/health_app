package health.binodata.health_app_test;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import static health.binodata.health_app_test.R.id.view;

public class SingupActivity extends AppCompatActivity {
    FirebaseAuth auth;
    EditText ed_name,ed_personal_num,ed_password,ed_again,ed_address,ed_phone,ed_email;
    Button sign_up;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singup);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        auth = FirebaseAuth.getInstance();
        setdata();
        //返回建
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        listen();
    }
    protected void setdata(){
        ed_name=(EditText)findViewById(R.id.editText10);
        ed_personal_num=(EditText)findViewById(R.id.editText11);
        ed_password=(EditText)findViewById(R.id.editText12);
        ed_again=(EditText)findViewById(R.id.editText_again);
        ed_address=(EditText)findViewById(R.id.editText13);
        ed_phone=(EditText)findViewById(R.id.editText14);
        ed_email=(EditText)findViewById(R.id.editText15);
        sign_up=(Button)findViewById(R.id.button_siginup);
    }
    protected void listen(){
        sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = ed_name.getText().toString();
                String personal_num = ed_personal_num.getText().toString();
                final String password = ed_password.getText().toString();
                String address = ed_address.getText().toString();
                String phone = ed_phone.getText().toString();
                final String email = ed_email.getText().toString();
                auth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (!task.isSuccessful()){

                                    register(email, password);
                                }
                            }
                        });
            }
        });
    }
    private void register(final String email, final String password) {
        createUser(email,password);
    }

    private void createUser(String email, String password) {
        auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(
                        new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {

                                Toast toast = Toast.makeText(SingupActivity.this,
                                        "註冊成功!!", Toast.LENGTH_LONG);
                                toast.show();
                                Intent i = new Intent();
                                i.setClass(SingupActivity.this,LoginActivity.class);
                                startActivity(i);
                            }
                        });
    }

}
