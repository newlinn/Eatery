package cn.eatery;

import android.view.View;
import android.widget.TextView;

/**
 * Created by LingChen on 15/6/8.
 */
public abstract class ViewHolder {
    public TextView mTextView;
    public abstract void setViewContent(int position, View convertView, Object data);
}
