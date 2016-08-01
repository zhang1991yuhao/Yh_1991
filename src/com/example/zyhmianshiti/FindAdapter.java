package com.example.zyhmianshiti;

import java.util.List;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.king.photo.R;

public class FindAdapter extends BaseAdapter {  
  
    private LayoutInflater mInflater;  
    private Context context;
  
    private List<FindClass> mhistoryList;
    
    
    public FindAdapter(Context c, List<FindClass> historyList)  
    {  
    	 this.context = c;
        mInflater = LayoutInflater.from(c);  
        mhistoryList = historyList;  
        
        
        
    }  
    
  
    @Override  
    public int getCount()  
    {  
        return mhistoryList.size();  
    }  
  
    @Override  
    public Object getItem(int position)  
    {  
        return mhistoryList.get(position);  
    }  
  
    @Override  
    public long getItemId(int position)  
    {  
        return position;  
    }  
  
    @Override  
    public View getView(int position, View convertView, ViewGroup parent)  
    {  
  
        ViewHolder holder = null;  
        if (convertView == null)  
        {  
            holder = new ViewHolder();  
            convertView = mInflater.inflate(R.layout.find_item, null); 
            
            
            holder.a1 = (TextView) convertView.findViewById(R.id.a1);
            holder.a0 = (TextView) convertView.findViewById(R.id.a0);
            holder.gridView = (NoScrollGridView) convertView.findViewById(R.id.gridView);
            
            
            
            convertView.setTag(holder);  
        } else  
        {  
            holder = (ViewHolder) convertView.getTag();  
        }  
  
       
         final FindClass bean =mhistoryList.get(position);
        
		
		 
		 holder.a0.setText(bean.getName()+"");
		 holder.a1.setText(bean.getTxt()+"");
		 
	
		 
		 if(bean.imgList != null && bean.imgList.size() > 0){
				// 有：设置Adapter显示图片
				holder.gridView.setVisibility(View.VISIBLE);
				// 图片数组转图片集合
				final String[] urls = bean.imgList.toArray(new String[bean.imgList.size()]);
				
				 
				holder.gridView.setAdapter(new CircleGridAdapter(context,urls));
			}else{
				// 否：隐藏
				holder.gridView.setVisibility(View.GONE);
			}
     
  
        return convertView;  
    }  
  
    private final class ViewHolder  
    {  
		TextView a1,a0; 
		NoScrollGridView gridView;
    }
    
} 