package health.binodata.health_app_test.main_tab;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import health.binodata.health_app_test.R;

/**
 * Created by KouxuanNB on 2017/5/19.
 */
public class tab_sport extends Fragment {
    Spinner sp;
    Button button_time1;
    TextView tv_time1;
    Button button_time2;
    TextView tv_time2;
    TimePickerDialog timePickerDialog;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.tab_sport,container,false);
        button_time1=(Button)v.findViewById(R.id.timeButton1);
        tv_time1=(TextView)v.findViewById(R.id.tv_time1);
        button_time2=(Button)v.findViewById(R.id.timeButton2);
        tv_time2=(TextView)v.findViewById(R.id.tv_time2);
        sp=(Spinner)v.findViewById(R.id.spinner_sport);

        final FragmentActivity c = getActivity();

        button_time1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                //這邊就是呼叫 TimePickerDialog 的程式碼
                timePickerDialog = new TimePickerDialog(c, new TimePickerDialog.OnTimeSetListener() {

                    @Override
                    public void onTimeSet(TimePicker timePicker, int hours, int minutes) {
                        tv_time1.setText("時間-" + hours + ":" + minutes);
                    }
                }, 1, 1, true);
                timePickerDialog.setTitle("請選擇時間");
                timePickerDialog.show();
            }
        });



        button_time2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                //這邊就是呼叫 TimePickerDialog 的程式碼
                timePickerDialog = new TimePickerDialog(c, new TimePickerDialog.OnTimeSetListener() {

                    @Override
                    public void onTimeSet(TimePicker timePicker, int hours, int minutes) {
                        tv_time2.setText("時間-" + hours + ":" + minutes);
                    }
                }, 1, 1, true);
                timePickerDialog.setTitle("請選擇時間");
                timePickerDialog.show();
            }
        });


        ArrayAdapter<CharSequence> lunchList = ArrayAdapter.createFromResource(this.getActivity(),
                R.array.sport,
                android.R.layout.simple_spinner_dropdown_item);
        sp.setAdapter(lunchList);
        return v;
    }
}
