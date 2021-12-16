package com.studying.socarclone.starting;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.PagerAdapter;

import com.studying.socarclone.R;

import java.util.Timer;
import java.util.TimerTask;

public class ImageViewPagerAdapter extends PagerAdapter {
    private Context mContext = null;
    private int[] images = {R.drawable.imageview_num1, R.drawable.imageview_num2, R.drawable.imageview_num3, R.drawable.imageview_num4, R.drawable.imageview_num5};

    public ImageViewPagerAdapter(Context context){
        mContext = context;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = null;

        if(mContext != null){
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.starting_activity_guide_item, container, false);
            int pos = position % 5;

            ImageView imageView = (ImageView) view.findViewById(R.id.imageview_for_viewpager);
            imageView.setImageResource(images[pos]);
            container.addView(view);
        }

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        // ViewPager에서 삭제
        container.removeView((View) object);
    }

    @Override
    public int getCount() { return 10; } // 메모리 관리가 필요함, 추후에 추가

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return (view == (View) object);
    }
}
