package test.bwie.com.library.baseactivity;

import android.os.Bundle;

/**
 * Created by djx on 2016/11/8.
 */
public interface IOBaseActivity {

    /**
     * 加载布局文件
     * @return
     */
    public abstract int bindLayout();

    /**
     * 初始化数据
     */
    public abstract void initData();

    /**
     * 初始化控件
     */
    public abstract void initView(Bundle savedInstanceState);

    /**
     * 加载网络数据
     */
    public abstract void LoadData();

}
