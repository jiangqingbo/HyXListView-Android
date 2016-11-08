package com.huyunit.xlistview.delslide;

/**
 * author: bobo
 * create time: 2016/11/08 14:35
 * Email: jqbo84@163.com
 */
public interface OnDeleteListioner {
	public abstract boolean isCandelete(int position);
	public abstract void onDelete(int ID);
	public abstract void onBack();
}
