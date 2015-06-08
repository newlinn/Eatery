package cn.eatery;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by C on 2015/6/8.
 */
public abstract class CommonAdapter<T> extends BaseAdapter {

    protected LayoutInflater inflater;
    protected Context context;
    protected List<T> data;
    protected final int layoutId;

    public CommonAdapter(Context context, List<T> data, int layoutId) {
        this.inflater = LayoutInflater.from(context);
        this.context = context;
        this.data = data;
        this.layoutId = layoutId;
    }

    private ViewHolder getViewHolder(View convertView, ViewGroup parent, int position) {
        return ViewHolder.get(context, convertView, parent, layoutId,
                position);
    }

    public abstract void setSubView(ViewHolder viewHolder, T item);

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = getViewHolder(convertView, parent, position);
        setSubView(viewHolder, data.get(position));
        return viewHolder.getConvertView();
    }

    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
}
