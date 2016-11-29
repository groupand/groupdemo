package test.bwie.com.library.baseactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.Map;

import butterknife.ButterKnife;
import okhttp3.Callback;
import test.bwie.com.library.okhttp.OkHttpUtils;

/**
 * Created by djx on 2016/11/8.
 */
public abstract class BaseActivity extends AppCompatActivity implements IOBaseActivity{

    private View mRootView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(bindLayout()!=0){
            mRootView = View.inflate(this,bindLayout(),null);
            setContentView(mRootView);
            ButterKnife.bind(this);
            initData();
            initView(savedInstanceState);
            LoadData();

        }else {
            Log.e("Activity","bindLayout return 0 !");
        }
    }


    public View getRootView(){
        return mRootView;
    }

    /**
     * get异步请求
     * @param url
     * @param callback
     */
    public void getAyn(String url, Callback callback){
        OkHttpUtils.get(url,callback);
    }

    /**
     * post网络请求
     * @param url
     * @param map
     * @param callback
     */
    public  void getPost(String url,Map<String,String> map,Callback callback){
        OkHttpUtils.post(url,map,callback);
    }




    /**
     * 吐司
     * @param msg
     */
    public void showToast(CharSequence msg){
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();

    }

    /**
     * 启动Activity
     * @param cls
     */
    public void startAct(Class<? extends BaseActivity> cls){
        Intent intent=new Intent(this,cls);

        startActivity(intent);
    }
    /**
     * 启动带参数Activity
     * @param cls
     *
     */

    public void startAct(Class<? extends BaseActivity> cls,Bundle bundle){
        Intent intent=new Intent(this,cls);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    /**
     * 添加Fragment
     */
    public void addFragment(){

    }
    public void removeFragment(){

    }
    public void replaceFragment() {
    }

    @Override
    protected void onDestroy() {
        mRootView=null;
        ButterKnife.unbind(this);
        super.onDestroy();
    }
}
