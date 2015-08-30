package com.android.angelslike.ui.piece;

import java.util.ArrayList;
import java.util.List;

import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ProgressBar;

import com.android.angelslike.R;
import com.android.angelslike.bean.ClubBean;
import com.android.angelslike.bean.PageInfo;
import com.android.angelslike.utils.http.ApiClient;
import com.android.angelslike.utils.http.ApiClient.HttpCallBack;
import com.android.angelslike.utils.http.JsonHelper;
import com.bumptech.glide.Glide;
import com.hzf.adapter.BaseAdapterHelper;
import com.hzf.adapter.QuickAdapter;
import com.hzf.fragment.BaseListFragment;
import com.hzf.utils.JsonExplain;
import com.hzf.utils.StringUtil;
import com.hzf.widget.roundedimageview.RoundedImageView;

public class MyPieceListFragment extends BaseListFragment {
	protected QuickAdapter<ClubBean> adapter;
	ArrayList<ClubBean> clubBeans;

	@Override
	public void initedView() {
		// TODO Auto-generated method stub

	}

	@Override
	public void getData(int indexPage, int pageSize) {
		// TODO Auto-generated method stub
		getListData(indexPage);
	}

	@Override
	public BaseAdapter getAdapter() {
		// TODO Auto-generated method stub
		clubBeans = new ArrayList<ClubBean>();
		adapter = new QuickAdapter<ClubBean>(baseActivity,
				R.layout.listitem_piece, clubBeans) {

			@Override
			protected void convert(BaseAdapterHelper helper, ClubBean item) {
				// TODO Auto-generated method stub
				RoundedImageView ivHead = helper.getView(R.id.ivHead);
				helper.setText(R.id.tvClubTitle,
						StringUtil.trimString(item.getTitle()));
				helper.setText(R.id.tvClubWhat,
						"[凑什么] " + StringUtil.trimString(item.getPname()));
				helper.setText(R.id.tvEveryPrice, item.getEveryprice() + "");
				helper.setText(R.id.tvClubOutday,
						StringUtil.trimString(item.getOutday()));
				helper.setText(R.id.tvClubStates,
						StringUtil.trimString(item.getNowstatus()));
				helper.setText(R.id.tvClubCopies, "目标" + item.getCopies()
						+ "份  |  已凑" + item.getCurrentcopies() + "份");
				helper.setText(R.id.tvClubName,
						StringUtil.trimString(item.getName()));
				Glide.with(baseActivity).load(item.getImg()).into(ivHead);

				ProgressBar progressBar = helper.getView(R.id.progressBar);
				int progress = 0;
				if (item.getCurrentcopies() != 0) {
					progress = getPercent(item.getCurrentcopies(),
							item.getCopies());
				}
				progressBar.setProgress(progress);
			}
		};
		return adapter;
	}

	public int getPercent(long x, long total) {
		double x_double = x * 1.0;
		double tempresult = x_double / total;
		return (int) (tempresult * 100);
	}

	@Override
	public void onListItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		// TODO Auto-generated method stub
	    baseActivity.pushActivity(baseActivity.getIntent(PieceDetailActivity.class).putExtra("ClubBean",
            adapter.getItem(position)));
	}

	private void getListData(final int indexPage) {
		String sort = "new";
		ApiClient.getInstance(baseActivity).getList("list_cou", indexPage + "",
				"", "", sort, "", "", "", new HttpCallBack() {

					@Override
					public void onSuccess(String result) {
						// TODO Auto-generated method stub
						stopRefresh();
						String pageinfo = JsonExplain.getStringValue(result,
								JsonHelper.KEY_pageinfo);
						PageInfo info = (PageInfo) JsonExplain.explainJson(
								pageinfo, PageInfo.class);
						if (info.getMaxpage() == indexPage) {
							canLoadMore = false;
						}
						String list = JsonExplain.getStringValue(result,
								JsonHelper.KEY_list);
						List<ClubBean> beans = JsonExplain.explainListJson(
								list, ClubBean[].class);
						if (indexPage == 1) {
							adapter.clear();
						}
						if (beans != null && beans.size() > 0) {
							adapter.addAll(beans);
						}
					}

					@Override
					public void onStart() {
						// TODO Auto-generated method stub

					}

					@Override
					public void onLoading(long total, long current,
							boolean isUploading) {
						// TODO Auto-generated method stub

					}

					@Override
					public void onFailure(String msg) {
						// TODO Auto-generated method stub
						stopRefresh();
					}
				});
	}
}
