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
public class tab_sport extends Fragment {
    Spinner sp;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.tab_sport,container,false);
        sp=(Spinner)v.findViewById(R.id.spinner_sport);
        ArrayAdapter<CharSequence> lunchList = ArrayAdapter.createFromResource(this.getActivity(),
                R.array.sport,
                android.R.layout.simple_spinner_dropdown_item);
        sp.setAdapter(lunchList);
        return v;
    }
}
