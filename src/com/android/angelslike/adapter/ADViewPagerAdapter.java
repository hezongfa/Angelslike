package com.android.angelslike.adapter;

import java.util.ArrayList;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.android.angelslike.R;
import com.android.angelslike.bean.Advertisement;
import com.android.angelslike.utils.http.HttpConstants;
import com.bumptech.glide.Glide;
import com.hzf.activity.BaseActivity;

public class ADViewPagerAdapter extends PagerAdapter {
	private ArrayList<Advertisement> ad_list;
	private Context context;

	public ADViewPagerAdapter(ArrayList<Advertisement> ad_list, Context context) {
		this.context = context;
		this.ad_list = ad_list;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return ad_list.size();
	}

	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		// TODO Auto-generated method stub
		return arg0 == (View) arg1;
	}

	// private int mChildCount = 0;

	// @Override
	// public void notifyDataSetChanged() {
	// mChildCount = getCount();
	// super.notifyDataSetChanged();
	// }
	//
	// @Override
	// public int getItemPosition(Object object) {
	// if (mChildCount > 0) {
	// mChildCount--;
	// return POSITION_NONE;
	// }
	// return super.getItemPosition(object);
	// }

	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		// TODO Auto-generated method stub
		// System.out.println("destroyItem="+position);
		container.removeView((View) object);
	}

	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		// TODO Auto-generated method stub
		// final Advertisement ad = ad_list.get(position);
		View view = LayoutInflater.from(context).inflate(R.layout.adimg, null);
		ImageView img = (ImageView) view.findViewById(R.id.image);
		img.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				// Intent intent = new Intent(context, ADActivity.class);
				// Bundle bundle = new Bundle();
				// bundle.putSerializable("ad", ad);
				// intent.putExtras(bundle);
				// context.startActivity(intent);
			}
		});
		Glide.with((BaseActivity) context)
				.load(HttpConstants.imgurl1 + ad_list.get(position).getImg())
				.into(img);
		container.addView(view);
		return view;
	}
}
