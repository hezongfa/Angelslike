package com.android.angelslike.view;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.android.angelslike.R;

public class CategoryPopupWindow extends PopupWindow {

	Context context;
	View contentView;
	ListView listview;
	ArrayList<PopItem> popItems;
	PAdapter adapter;
	LinearLayout layParent;

	public CategoryPopupWindow(Context context, ArrayList<PopItem> popItems) {
		super(
				LayoutInflater.from(context).inflate(R.layout.categorypopu,
						null), LayoutParams.MATCH_PARENT,
				LayoutParams.MATCH_PARENT, true);
		this.context = context;
		contentView = getContentView();
		// setAnimationStyle(R.style.PopupAnimation);
		setOutsideTouchable(true);
		setTouchable(true);
		ColorDrawable dw = new ColorDrawable(-00000);
		setBackgroundDrawable(dw);
		update();
		// 点击其他地方消失
		contentView.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				dismiss();
				return false;
			}
		});
		this.popItems = new ArrayList<PopItem>();
		adapter = new PAdapter();
		listview = (ListView) contentView.findViewById(R.id.listview);
		listview.setAdapter(adapter);
		setItems(popItems);
	}

	public void setItems(ArrayList<PopItem> popItems) {
		this.popItems.clear();
		if (popItems != null && popItems.size() > 0) {
			this.popItems.addAll(popItems);
			adapter.notifyDataSetChanged();
		}
	}

	public void setOnItemClick(OnItemClickListener listener) {
		listview.setOnItemClickListener(listener);
	}

	class PAdapter extends BaseAdapter {

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return popItems.size();
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			if (convertView == null) {
				convertView = LayoutInflater.from(context).inflate(
						R.layout.categorypopu_item, null);
			}
			TextView tvText = (TextView) convertView.findViewById(R.id.tvText);
			if (popItems.get(position) != null
					&& popItems.get(position).getText() != null) {
				tvText.setText(popItems.get(position).getText());
			}
			return convertView;
		}

	}

}
