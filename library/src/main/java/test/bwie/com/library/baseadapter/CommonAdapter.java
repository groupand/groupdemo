package test.bwie.com.library.baseadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by djx on 2016/11/9.
 */
public abstract class CommonAdapter<T> extends BaseAdapter {

    protected LayoutInflater mInflater;
    protected Context mContext;
    protected List<T> list;
    protected final int mItemLayoutId;

    public CommonAdapter(Context context, List<T> mDatas,int itemLayoutId)
    {
        mInflater = LayoutInflater.from(context);
        this.mContext = context;
        this.list = list;
        this.mItemLayoutId = itemLayoutId;
    }


    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        final ViewHolder viewHolder = getViewHolder(i, view,
                viewGroup);
        convert(viewHolder, (T) getItem(i));
        return viewHolder.getConvertView();
    }

    /*** 实现给View赋数据的方法 */
    public abstract void convert(ViewHolder helper, T item);

    private ViewHolder getViewHolder(int position, View convertView,
                                     ViewGroup parent)
    {
        return ViewHolder.get(mContext, convertView, parent, mItemLayoutId,
                position);
    }


}
