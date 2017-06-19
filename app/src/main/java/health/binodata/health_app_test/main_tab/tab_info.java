package health.binodata.health_app_test.main_tab;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;


import java.util.ArrayList;
import java.util.List;

import health.binodata.health_app_test.R;

/**
 * Created by KouxuanNB on 2017/5/19.
 */
public class tab_info extends Fragment {
    // MPAndroidChart
    LineChart chart;
    /*ArrayList <String> xVals = new ArrayList<String>();
    ArrayList <String> yVals = new ArrayList<String>();*/

    final int DATA_COUNT = 5;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.tab_info, container, false);

        LineChart chart_line = (LineChart)v.findViewById(R.id.chart1);
        chart_line.setData(getLineData());
        //chart_line.getAxisLeft().setAxisMaxValue(100f);
        chart_line.getAxisLeft().setAxisMinValue(30f);

        return v;
    }
    private List<Entry> getChartData(){


        List<Entry> chartData = new ArrayList<>();

        chartData.add(new Entry(120, 0));
        chartData.add(new Entry(125, 1));
        chartData.add(new Entry(150, 2));
        chartData.add(new Entry(100, 3));
        chartData.add(new Entry(130, 4));

        return chartData;
    }
    private List<String> getLabels(){
        List<String> chartLabels = new ArrayList<>();
        for(int i=1;i<DATA_COUNT+1;i++){
            chartLabels.add("6/"+i);
        }
        return chartLabels;
    }
    private LineData getLineData(){
        LineDataSet dataSetA = new LineDataSet(getChartData(), "血壓值");

        List<LineDataSet> dataSets = new ArrayList<>();
        dataSets.add(dataSetA); // add the datasets

        return new LineData(getLabels(), dataSets);
    }

}