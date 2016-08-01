package com.example.zyhmianshiti;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.king.photo.R;
import com.nostra13.universalimageloader.core.ImageLoader;

public class CircleGridAdapter extends BaseAdapter {
	
	private String[] mFiles;
	private LayoutInflater mLayoutInflater;
	private Context mContext;
	
	public CircleGridAdapter(Context c,String[] files) {
		this.mFiles = files;
		mLayoutInflater = LayoutInflater.from(c);
	}

	@Override
	public int getCount() {
		return mFiles == null ? 0 : mFiles.length;
	}

	@Override
	public String getItem(int position) {
		return mFiles[position];
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
		if (convertView == null) {
			holder = new ViewHolder();
			convertView = mLayoutInflater.inflate(R.layout.item_gridview_circle,parent, false);
			holder.imageView = (ImageView) convertView.findViewById(R.id.album_image);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		String url = getItem(position);
		
		ImageLoader.getInstance().displayImage(url, holder.imageView);
		
		return convertView;
	}

	private static class ViewHolder {
		ImageView imageView;
	}
}
