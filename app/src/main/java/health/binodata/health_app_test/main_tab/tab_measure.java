package health.binodata.health_app_test.main_tab;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.icu.util.Calendar;
import android.icu.util.GregorianCalendar;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import health.binodata.health_app_test.R;

/**
 * Created by KouxuanNB on 2017/5/19.
 */
public class tab_measure extends Fragment {
    Spinner sp_type;
    Spinner sp_status;
    Button button_date;
    TextView tv_time;
    TimePickerDialog tpd;

    Handler mHandler ;
    int mHour;
    int mMinute;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.tab_measure,container,false);
        button_date=(Button)v.findViewById(R.id.dateButton);
        tv_time=(TextView)v.findViewById(R.id.tv_time);

        final FragmentActivity c = getActivity();


        button_date.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

            }
        });
        //時間選擇器
       /* tpd=new TimePickerDialog(c, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int hourOfDay, int minute) {
                tv_time.setText((hourOfDay>12?hourOfDay-12:hourOfDay)
                +" : "+minute+" "+(hourOfDay>12?" PM ":" AM "));
            }
        },calendar.get(Calendar.HOUR_OF_DAY),calendar.get(calendar.MINUTE),false);*/


        //狀態的下拉選單
                sp_status = (Spinner) v.findViewById(R.id.spinner_status);
        ArrayAdapter<CharSequence> lunchList_ststus = ArrayAdapter.createFromResource(this.getActivity(),
                R.array.measure_status,
                android.R.layout.simple_spinner_dropdown_item);
        sp_status.setAdapter(lunchList_ststus);

        //類型的下拉選單
        sp_type=(Spinner)v.findViewById(R.id.spinner_type);
        ArrayAdapter<CharSequence> lunchList_type = ArrayAdapter.createFromResource(this.getActivity(),
                R.array.measure_type,
                android.R.layout.simple_spinner_dropdown_item);
        sp_type.setAdapter(lunchList_type);



        return v;
    }
}
