package cn.itsite.dreamnote.main.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import cn.itsite.abase.mvp.view.base.BaseFragment;
import cn.itsite.dreamnote.App;
import cn.itsite.dreamnote.R;
import cn.itsite.dreamnote.mine.view.MineFragment;
import cn.itsite.dreamnote.note.NoteFragment;
import me.yokeyword.fragmentation.SupportFragment;

import static cn.itsite.dreamnote.common.Constants.KEY_POSITION;

/**
 * Author：leguang on 2016/10/9 0009 15:49
 * Email：langmanleguang@qq.com
 */

public class MainFragment extends BaseFragment {
    public final String TAG = MainFragment.class.getSimpleName();
    @BindView(R.id.bottom_navigation_fragment)
    AHBottomNavigation navigation;
    private SupportFragment[] mFragments = new SupportFragment[3];
    private ArrayList<AHBottomNavigationItem> items = new ArrayList<>();
    Unbinder unbinder;
    private int prePosition = 0;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        unbinder = ButterKnife.bind(this, view);
        if (savedInstanceState == null) {
            mFragments[0] = NoteFragment.newInstance();
            mFragments[1] = NoteFragment.newInstance();
            mFragments[2] = MineFragment.newInstance();
            loadMultipleRootFragment(R.id.fl_container_main_fragment, 0, mFragments[0], mFragments[2]);
        } else {
            mFragments[0] = NoteFragment.newInstance();
            mFragments[1] = NoteFragment.newInstance();
            mFragments[2] = MineFragment.newInstance();
        }
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initNavigation();
    }

    private void initNavigation() {
        items.add(new AHBottomNavigationItem(R.string.tab0, R.drawable.ic_room_78, R.color.white));
        items.add(new AHBottomNavigationItem(R.string.tab1, R.drawable.ic_room_78, R.color.white));
        items.add(new AHBottomNavigationItem(R.string.tab2, R.drawable.ic_room_78, R.color.white));
        navigation.addItems(items);
        navigation.setDefaultBackgroundColor(getResources().getColor(R.color.white));
        navigation.setBehaviorTranslationEnabled(false);
        navigation.setColored(true);
        navigation.setForceTint(false);
        navigation.setAccentColor(ContextCompat.getColor(App.mContext, R.color.base_color));
        navigation.setInactiveColor(ContextCompat.getColor(App.mContext, R.color.gray));
        navigation.setForceTitlesDisplay(true);
        navigation.setOnTabSelectedListener((position, wasSelected) -> {
            showHideFragment(mFragments[position], mFragments[prePosition]);
            prePosition = position;
        });
        navigation.setCurrentItem(0);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_POSITION, prePosition);
    }
}
