package cn.itsite.dreamnote.launch.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import cn.itsite.abase.cache.SPCache;
import cn.itsite.abase.mvp.view.base.BaseFragment;
import cn.itsite.dreamnote.App;
import cn.itsite.dreamnote.R;
import cn.itsite.dreamnote.common.Constants;
import cn.itsite.dreamnote.launch.contract.SplashContract;
import cn.itsite.dreamnote.launch.presenter.SplashPresenter;
import cn.itsite.dreamnote.main.MainActivity;

/**
 * Author：leguang on 2016/10/9 0009 15:49
 * Email：langmanleguang@qq.com
 */
public class SplashFragment extends BaseFragment<SplashContract.Presenter>
        implements SplashContract.View {
    private static final String TAG = SplashFragment.class.getSimpleName();
    private Unbinder unbinder;

    public static SplashFragment newInstance() {
        return new SplashFragment();
    }

    @NonNull
    @Override
    protected SplashContract.Presenter createPresenter() {
        return new SplashPresenter(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_splash, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initData();
    }

    private void initData() {
        boolean isFirstEntry = (boolean) SPCache.get(App.mContext, Constants.ISFIRSTENTRY, true);
        if (isFirstEntry) {
            start(GuideFragment.newInstance());
        } else {
            go2Main();
        }
    }

    public void go2Main() {
        _mActivity.startActivity(new Intent(_mActivity, MainActivity.class));
        _mActivity.overridePendingTransition(0, 0);
        //此处之所以延迟退出是因为立即退出在小米手机上会有一个退出跳转动画，而我不想要这个垂直退出的跳转动画。
        getView().postDelayed(() -> _mActivity.finish(), 1000);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
