package cn.itsite.dreamnote.main;

import android.os.Bundle;
import android.support.annotation.NonNull;


import org.greenrobot.eventbus.EventBus;

import cn.itsite.abase.mvp.contract.base.BaseContract;
import cn.itsite.abase.mvp.view.base.BaseActivity;
import cn.itsite.dreamnote.R;
import cn.itsite.dreamnote.main.view.MainFragment;

public class MainActivity extends BaseActivity {

    private final String TAG = this.getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //在MainActivity中使用loadRootFragment方法加载Fragment，被加载的页面不可被点击和滑动
        //使用loadMultipleRootFragment则可以，什么鬼...
        //更新了版本就可以了
        if (savedInstanceState == null) {
            loadRootFragment(R.id.fl_main_activity, MainFragment.newInstance());
        }

        closeLunch();
    }

    private void closeLunch() {
//        EventBus.getDefault().postSticky(new EventData(Constants.EVENT_FINISH_LAUNCH));
        EventBus.getDefault().postSticky("");
    }

    @NonNull
    @Override
    protected BaseContract.Presenter createPresenter() {
        return null;
    }

}
