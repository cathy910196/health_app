package health.binodata.health_app_test.main_tab;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import health.binodata.health_app_test.R;

/**
 * Created by KouxuanNB on 2017/5/22.
 */
//衛教宣導
public class tab_tech extends Fragment {
    int[] image_chart=new int[]{R.drawable.pressure_img,R.drawable.blood_sugar_img,R.drawable.weight_img,R.drawable.sport_img};
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.tab_tech,container,false);
        ArrayList<String> myDataset = new ArrayList<>();
        for(int i = 0; i < 4 ; i++){
            //myDataset.add(i + "測試");
            switch(i) {
                case 0:
                    myDataset.add("血壓趨勢");
                    break;
                case 1:
                    myDataset.add("血糖趨勢");
                    break;
                case 2:
                    myDataset.add("體重趨勢");
                    break;
                case 3:
                    myDataset.add("運動習慣");
                    break;
                default:
                    myDataset.add("null");
            }
        }

        MyAdapter myAdapter = new MyAdapter(myDataset);
        RecyclerView mList = (RecyclerView) v.findViewById(R.id.list_view);
        final FragmentActivity c = getActivity();
        final LinearLayoutManager layoutManager = new LinearLayoutManager(c);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mList.setLayoutManager(layoutManager);
        mList.setAdapter(myAdapter);
        return v;
    }
    public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
        private List<String> mData;


        public class ViewHolder extends RecyclerView.ViewHolder {
            public TextView mTextView;
            public ImageView mImageView;
            public ViewHolder(View v) {
                super(v);
                mTextView = (TextView) v.findViewById(R.id.info_text);
                mImageView = (ImageView) v.findViewById(R.id.img);
            }
        }

        public MyAdapter(List<String> data) {
            mData = data;

        }

        @Override
        public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item, parent, false);
            ViewHolder vh = new ViewHolder(v);
            return vh;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            holder.mTextView.setText(mData.get(position));
            holder.mImageView.setImageResource(image_chart[position]);

        }

        @Override
        public int getItemCount() {
            return mData.size();
        }
    }
}
