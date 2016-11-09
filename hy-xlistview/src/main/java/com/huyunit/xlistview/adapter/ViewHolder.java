package com.huyunit.xlistview.adapter;

import android.util.SparseArray;
import android.view.View;

/**
 * 万能的viewHolder
 * author: bobo
 * create time: 2016/11/08 14:35
 * Email: jqbo84@163.com
 */
public class ViewHolder {
    @SuppressWarnings("unchecked")
    public static <T extends View> T get(View view, int id) {
        SparseArray<View> viewHolder = (SparseArray<View>) view.getTag();
        if (viewHolder == null) {
            viewHolder = new SparseArray<View>();
            view.setTag(viewHolder);
        }
        View childView = viewHolder.get(id);
        if (childView == null) {
            childView = view.findViewById(id);
            viewHolder.put(id, childView);
        }
        return (T) childView;
    }

}
