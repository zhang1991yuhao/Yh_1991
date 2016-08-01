package com.example.zyhmianshiti;

import java.util.ArrayList;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.king.photo.R;

public class yhActivity extends FragmentActivity {
	
	private boolean isExit = false;
	private Button b0, b1;
	private ViewPager mPager;
	private ArrayList<Fragment> fragmentsList;
	private View xiaobiao1, xiaobiao2;
	Fragment home1, home2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.yhactivity_main);
        
        init();
        
       
		
        
        
    }
    
    @Override
    protected void onRestart() {
    	// TODO Auto-generated method stub
    	super.onRestart();
    	
    	Log.d("dd", "onRestart");
    }
    
    @Override
    protected void onStart() {
    	// TODO Auto-generated method stub
    	
    	super.onStart();
    	
    	addfragment();
    }
    private void addfragment() {
		// TODO Auto-generated method stub
    	fragmentsList = new ArrayList<Fragment>();

		home1 = new InforFragment1();
		home2 = new FindFragment2();

		fragmentsList.add(home1);
		fragmentsList.add(home2);

		mPager.setAdapter(new MyFragmentPagerAdapter(
				getSupportFragmentManager(), fragmentsList));
		mPager.setOnPageChangeListener(new MyOnPageChangeListener());
		mPager.setCurrentItem(0);
		
	}

	private void init() {
		// TODO Auto-generated method stub
    	xiaobiao1 = (View) findViewById(R.id.xiabiao1);
		xiaobiao2 = (View) findViewById(R.id.xiabiao2);
		b0 = (Button) findViewById(R.id.zhaihui1);
		b1 = (Button) findViewById(R.id.zhaihui2);

		b0.setOnClickListener(new MyOnClickListener(0));
		b1.setOnClickListener(new MyOnClickListener(1));
		mPager = (ViewPager) findViewById(R.id.vPager);
	}

	public class MyOnPageChangeListener implements OnPageChangeListener {

		@Override
		public void onPageSelected(int arg0) {
			

			if (arg0 == 0) {
				
				b1.setTextColor(getResources().getColorStateList(R.color.black));

				b0.setTextColor(getResources().getColorStateList(R.color.darkorange));
				
				xiaobiao1.setVisibility(View.VISIBLE);
				xiaobiao2.setVisibility(View.GONE);
			}
			if (arg0 == 1) {
				b0.setTextColor(getResources().getColorStateList(R.color.black));

				b1.setTextColor(getResources().getColorStateList(R.color.darkorange));
				
				xiaobiao2.setVisibility(View.VISIBLE);
				xiaobiao1.setVisibility(View.GONE);
			}

		}

		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {
		}

		@Override
		public void onPageScrollStateChanged(int arg0) {
		}
	}
	public class MyOnClickListener implements View.OnClickListener {
		private int index = 0;

		public MyOnClickListener(int i) {
			index = i;
		}

		@Override
		public void onClick(View v) {
			mPager.setCurrentItem(index);
		}
	};
	
	// 退出拦截
		@Override
		public boolean onKeyDown(int keyCode, KeyEvent event) {
			// TODO Auto-generated method stub

			if (keyCode == KeyEvent.KEYCODE_BACK) {
				ToQuitTheApp();
				return false;

			} else {
				return super.onKeyDown(keyCode, event);
			}

		}

		private void ToQuitTheApp() {
			if (isExit) {
				// ACTION_MAIN with category CATEGORY_HOME 启动主屏幕
				Intent intent = new Intent(Intent.ACTION_MAIN);
				intent.addCategory(Intent.CATEGORY_HOME);
				startActivity(intent);
				System.exit(0);// 使虚拟机停止运行并退出程序
			} else {
				isExit = true;
				Toast.makeText(yhActivity.this, "再按一下,离开APP", Toast.LENGTH_SHORT)
						.show();
				mHandler.sendEmptyMessageDelayed(0, 2000);// 3秒后发送消息
			}

		}
		Handler mHandler = new Handler() {

			@Override
			public void handleMessage(Message msg) {// 处理消息
				// TODO Auto-generated method stub
				super.handleMessage(msg);
				isExit = false;
			}
		};
}
