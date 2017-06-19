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
public class tab_food extends Fragment {
    Spinner sp_meal;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.tab_food,container,false);

        //早餐午餐晚餐
        sp_meal=(Spinner)v.findViewById(R.id.spinner_meal);
        ArrayAdapter<CharSequence> lunchList_meal = ArrayAdapter.createFromResource(this.getActivity(),
                R.array.meal,
                android.R.layout.simple_spinner_dropdown_item);
        sp_meal.setAdapter(lunchList_meal);


        return v;
    }
}
