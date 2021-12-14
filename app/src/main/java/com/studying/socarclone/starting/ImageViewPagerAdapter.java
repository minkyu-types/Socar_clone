package com.studying.socarclone.starting;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.PagerAdapter;

import com.studying.socarclone.R;

public class ImageViewPagerAdapter extends PagerAdapter {
    private Context mContext = null;

    public ImageViewPagerAdapter(Context context){
        mContext = context;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = null;

        if(mContext != null){
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.starting_fragment_page, container, false);

            ImageView imageView = (ImageView) view.findViewById(R.id.imageview_for_viewpager);
            // TO-DO: 여기에 페이지 교체될때마다 이미지 바뀌게 설정하기
        }

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        // ViewPager에서 삭제
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return 10;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return (view == (View) object);
    }
}
