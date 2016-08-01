package com.example.zyhmianshiti;

import java.io.Serializable;
import java.util.List;

public class FindClass implements Serializable{

    private String name;
    private String txt ;
    public List<String> imgList;// 图片集合
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTxt() {
		return txt;
	}
	public void setTxt(String txt) {
		this.txt = txt;
	}
	public List<String> getImgList() {
		return imgList;
	}
	public void setImgList(List<String> imgList) {
		this.imgList = imgList;
	}
    
    
	
	
	
}
