package com.example.zyhmianshiti;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.king.photo.R;

public class FindFragment2 extends Fragment  {
	


	private FindAdapter my_adapter;
	
	private ListView mlistview;
	
	private List<FindClass> list;
	
	private FindClass mtestClass;
	private List<String> mImgList;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view=inflater.inflate(R.layout.find2, container, false);
		mlistview = (ListView) view.findViewById(R.id.listview);
		
		
		initData();
		
		return view;
	}




	private void initData() {
		// 模拟请求网络获取到数据
		mImgList = new ArrayList<>();
		mImgList.add("http://imgsrc.baidu.com/forum/w%3D580/sign=7eb05e9eddf9d72a17641015e428282a/3e87194c510fd9f9b3d66fc8212dd42a2a34a4c9.jpg");
		mImgList.add("http://imgsrc.baidu.com/forum/w%3D580/sign=f09bb261cfbf6c81f7372ce08c3eb1d7/c213c895d143ad4bbd0a10c981025aafa40f06b6.jpg");
		mImgList.add("http://img5.ph.126.net/PpGsC74VUQWuERP1gdwKGQ==/580964351947981315.jpg");
		mImgList.add("http://img1.imgtn.bdimg.com/it/u=3749455878,661128293&fm=21&gp=0.jpg");
		mImgList.add("http://ww2.sinaimg.cn/mw600/a1957912gw1e8aj508g1mj20go0b40uh.jpg");
		mImgList.add("http://img7.aili.com/201511/11/1447231729_95100300.jpg");
		mImgList.add("http://ww2.sinaimg.cn/large/83dcc5dbjw1dtpbjzipdaj.jpg");
		mImgList.add("http://p18.qhimg.com/t0144d6a0802f22be4f.jpg");
		mImgList.add("http://img2.3lian.com/2014/f5/158/d/90.jpg");
		 list = new ArrayList<>();
		for (int i = 1; i < 5; i++) {
			
		        
			 mtestClass =new FindClass();
		        
			 mtestClass.setName("雨豪"+i);
			 mtestClass.setTxt("面试题内容面试题内容面试题内容面试题内容面试题内容面试题内容面试题内容面试题内容面试题内容面试题内容面试题内容");
			 mtestClass.setImgList(mImgList);
		       
		        list.add(mtestClass);
		
		}
		
		Log.d("dd", list.size()+"");
		my_adapter = new FindAdapter(getActivity(), list);
		mlistview.setAdapter(my_adapter);
		

	



	}

}
