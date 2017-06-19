package health.binodata.health_app_test.main_tab;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import health.binodata.health_app_test.R;

/**
 * Created by KouxuanNB on 2017/5/19.
 */
public class tab_measure extends Fragment {
    Spinner sp_type;
    Spinner sp_status;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.tab_measure,container,false);

        //狀態的下拉選單
        sp_status=(Spinner)v.findViewById(R.id.spinner_status);
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
