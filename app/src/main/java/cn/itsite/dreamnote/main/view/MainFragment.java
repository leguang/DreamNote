package cn.itsite.dreamnote.main.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
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
import cn.itsite.dreamnote.R;
import me.yokeyword.fragmentation.SupportFragment;

/**
 * Author：leguang on 2016/10/9 0009 15:49
 * Email：langmanleguang@qq.com
 */

public class MainFragment extends BaseFragment {
    private final String TAG = this.getClass().getSimpleName();
    @BindView(R.id.bottom_navigation_fragment)
    AHBottomNavigation bottomNavigation;
    private int bottomNavigationPreposition = 0;
    private SupportFragment[] mFragments = new SupportFragment[3];
    private ArrayList<AHBottomNavigationItem> navigationItems = new ArrayList<>();
    //记录启动activity之前是哪一个activity，在activity被销毁，回到这里之后哪一个AHButton按钮被选中
    private int fragmentPosition = 0;
    Unbinder unbinder;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        unbinder = ButterKnife.bind(this, view);
        if (savedInstanceState == null) {
//            mFragments[0] = PersonalInfoFragment.newInstance();
//            mFragments[2] = OtherShareFramgent.newInstance();
            loadMultipleRootFragment(R.id.fl_container_main_fragment, 0, mFragments[0], mFragments[2]);
        } else {
//            mFragments[0] = findFragment(PersonalInfoFragment.class);
//            mFragments[2] = findFragment(OtherShareFramgent.class);
        }
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initBottomNavigation();
    }

    private void initBottomNavigation() {
//        AHBottomNavigationItem item1 = new AHBottomNavigationItem(R.string.tab_1, R.drawable.ic_menu_camera, R.color.white);
//        AHBottomNavigationItem item2 = new AHBottomNavigationItem(R.string.tab_2, R.drawable.ic_menu_camera, R.color.white);
//        AHBottomNavigationItem item3 = new AHBottomNavigationItem(R.string.tab_3, R.drawable.ic_menu_camera, R.color.white);
//        navigationItems.add(item1);
//        navigationItems.add(item2);
//        navigationItems.add(item3);
//        bottomNavigation.addItems(navigationItems);
//        bottomNavigation.setDefaultBackgroundColor(getResources().getColor(R.color.white));
//        bottomNavigation.setBehaviorTranslationEnabled(false);
//        bottomNavigation.setColored(true);
//        bottomNavigation.setForceTint(false);
//        bottomNavigation.setAccentColor(getResources().getColor(R.color.base_color));
//        bottomNavigation.setInactiveColor(getResources().getColor(R.color.gray));
//        bottomNavigation.setForceTitlesDisplay(true);
//        bottomNavigation.setOnTabSelectedListener(new AHBottomNavigation.OnTabSelectedListener() {
//            @Override
//            public void onTabSelected(int position, final boolean wasSelected) {
//                if (position == 1) {
//                    startActivity(new Intent(_mActivity, AddChooseActivity.class));
//                    bottomNavigation.setCurrentItem(fragmentPosition);
//                } else {
//                    fragmentPosition = position;
//                    showHideFragment(mFragments[position], mFragments[bottomNavigationPreposition]);
//                    bottomNavigationPreposition = position;
//                }
//
//            }
//        });
//        bottomNavigation.setCurrentItem(0);
    }
}
