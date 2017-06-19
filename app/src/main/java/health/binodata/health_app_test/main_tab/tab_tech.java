package health.binodata.health_app_test.main_tab;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import health.binodata.health_app_test.R;

/**
 * Created by KouxuanNB on 2017/5/22.
 */
//衛教宣導
public class tab_tech extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.tab_tech,container,false);

        return v;
    }
}
