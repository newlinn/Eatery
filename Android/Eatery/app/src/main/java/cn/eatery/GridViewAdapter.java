package cn.eatery;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.daimajia.swipe.adapters.BaseSwipeAdapter;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by LingChen on 15/6/8.
 */
public class GridViewAdapter extends BaseSwipeAdapter {

    private Context context;
    private List<?> data;
    private ViewHolder viewHolder;

    public GridViewAdapter(Context context, List<?> data, Type Holder) {
        this.context = context;
        this.data = data;
        this.viewHolder = viewHolder;
    }

    @Override
    public int getSwipeLayoutResourceId(int position) {
        return R.id.swipe;
    }

    @Override
    public View generateView(int position, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.table_item, null);
    }

    @Override
    public void fillValues(int position, View convertView) {
        //TextView t = (TextView) convertView.findViewById(R.id.position);
        //t.setText((position + 1) + ".");
        this.viewHolder.setViewContent(position, convertView, this.data.get(position));
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {

        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }
}
