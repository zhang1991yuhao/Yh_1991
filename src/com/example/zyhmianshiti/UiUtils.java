//package com.example.zyhmianshiti;
//
//import android.content.Context;
//import android.content.res.ColorStateList;
//import android.content.res.Resources;
//import android.graphics.drawable.Drawable;
//import android.os.Handler;
//import android.view.View;
//
//public class UiUtils {
//	
//	/** 获取上下文对象 */
//	public static Context getContext(){
//		return BaseApplication.getContext();
//	}
//	
//	/** 获取Handler对象 */
//	public static Handler getHandler(){
//		return BaseApplication.getHandler();
//	}
//	
//	/** 获取主线程对象 */
//	public static Thread getMainThread(){
//		return BaseApplication.getMainThread();
//	}
//	
//	/** 获取主线程ID */
//	public static int getMainThreadId(){
//		return BaseApplication.getMainThreadId();
//	}
//	
//	/** 判断当前运行线程是否是主线程 */
//	public static boolean isRunInMainThread(){
//		return BaseApplication.getMainThreadId() == android.os.Process.myTid();
//	}
//	
//	/** 将任务放置在主线程中运行 */
//	public static void runInMainThread(Runnable runnable){
//		// 如果当前任务就是在主线程中的,直接运行
//		if(getMainThreadId() == android.os.Process.myTid()){
//			runnable.run();
//		}else{
//			// 将任务传递到主线程的消息队列中,让其运行
//			getHandler().post(runnable);
//		}
//	}
//	
//	/** 填充布局 */
//	public static View inflate(int layoutId){
//		return View.inflate(getContext(), layoutId, null);
//	}
//	
//	/** 获取资源目录*/
//	public static Resources getResources(){
//		return getContext().getResources();
//	}
//	
//	/** 获取String */
//	public static String getString(int stringId){
//		return getResources().getString(stringId);
//	}
//	
//	/** 获取Drawable */
//	public static Drawable getDrawable(int drawableId){
//		return getResources().getDrawable(drawableId);
//	}
//	
//	/** 获取StringArray */
//	public static String[] getStringArray(int stringArrayId){
//		return getResources().getStringArray(stringArrayId);
//	}
//	
//	/** 根据颜色选择器id,获取颜色选择器对象 */
//	public static ColorStateList getColorStateList(int mTabTextColorResId) {
//		return getResources().getColorStateList(mTabTextColorResId);
//	}
//	
//	/** 通过ID获取颜色 */
//	public static int getColor(int colorId) {
//		return getResources().getColor(colorId);
//	}
//	
//	/** Dip 转 Px */
//	public static int dip2px(int dip){
//		float d = getResources().getDisplayMetrics().density;
//		return (int)(dip * d + 0.5);
//	}
//	
//	/** Px 转 Dip */
//	public static int px2dip(int px){
//		float d = getResources().getDisplayMetrics().density;
//		return (int)(px / d + 0.5);
//	}
//}
