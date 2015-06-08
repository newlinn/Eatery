package cn.eatery;

import android.content.Context;
import android.media.Image;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by LingChen on 15/6/8.
 */
public class ViewHolder {

    private final SparseArray<View> subViews;
    private View convertView;

    private ViewHolder(Context context, ViewGroup parent,
                       int layoutId, int position) {
        this.subViews = new SparseArray<View>();
        convertView = LayoutInflater.from(context)
                .inflate(layoutId, parent, false);
        convertView.setTag(this);
    }

    public static ViewHolder get(Context context, View convertView,
                                 ViewGroup parent, int layoutId, int position) {
        if (convertView == null)
            return new ViewHolder(context, parent, layoutId, position);

        return (ViewHolder) convertView.getTag();
    }

    public <T extends View> T getView(int viewId) {
        View view = subViews.get(viewId);
        if (view == null) {
            view = this.convertView.findViewById(viewId);
            subViews.put(viewId, view);
        }
        return (T) view;
    }

    public View getConvertView(){
        return this.convertView;
    }

    public ViewHolder setText(int viewId, String text){
        TextView tv = getView(viewId);
        tv.setText(text);
        return this;
    }

    public ViewHolder setImageResource(int viewId, int resId ){
        ImageView iv = getView(viewId);
        iv.setImageResource(resId);
        return this;
    }

}