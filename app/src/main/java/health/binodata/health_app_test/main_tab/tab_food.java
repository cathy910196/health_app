package health.binodata.health_app_test.main_tab;

import android.app.TimePickerDialog;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInstaller;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.icu.text.SimpleDateFormat;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Random;

import health.binodata.health_app_test.R;

/**
 * Created by KouxuanNB on 2017/5/19.
 */
public class tab_food extends Fragment {
    Spinner sp_meal;
    Button button_time,button_c,button_p;
    ImageView iv_p;
    TextView tv_time;
    TimePickerDialog timePickerDialog;
    private DisplayMetrics mPhone;
    private final static int CAMERA = 66 ;
    private final static int PHOTO = 99 ;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.tab_food,container,false);
        button_time=(Button)v.findViewById(R.id.timeButton);
        button_c=(Button)v.findViewById(R.id.button_c);
        button_p=(Button)v.findViewById(R.id.button_p);
        iv_p=(ImageView) v.findViewById(R.id.iv_picture);
        tv_time=(TextView)v.findViewById(R.id.tv_time);

        final FragmentActivity c = getActivity();

        button_time.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                //這邊就是呼叫 TimePickerDialog 的程式碼
                timePickerDialog = new TimePickerDialog(c, new TimePickerDialog.OnTimeSetListener() {

                    @Override
                    public void onTimeSet(TimePicker timePicker, int hours, int minutes) {
                        tv_time.setText("時間-" + hours + ":" + minutes);
                    }
                }, 1, 1, true);
                timePickerDialog.setTitle("請選擇時間:");
                timePickerDialog.show();
            }
        });
        //相機
        button_p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(intent, PHOTO);
            }
        });

        //相簿
        button_c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ContentValues value = new ContentValues();
                value.put(MediaStore.Audio.Media.MIME_TYPE, "image/jpeg");
                // Uri uri= getContentResolver().insert(Media.EXTERNAL_CONTENT_URI,
                //value);
                Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                intent.putExtra(MediaStore.EXTRA_OUTPUT, Environment.getDataDirectory().getAbsolutePath());
                startActivityForResult(intent, CAMERA);

            }
        });
        //早餐午餐晚餐
        sp_meal=(Spinner)v.findViewById(R.id.spinner_meal);
        ArrayAdapter<CharSequence> lunchList_meal = ArrayAdapter.createFromResource(this.getActivity(),
                R.array.meal,
                android.R.layout.simple_spinner_dropdown_item);
        sp_meal.setAdapter(lunchList_meal);


        return v;
    }


}
