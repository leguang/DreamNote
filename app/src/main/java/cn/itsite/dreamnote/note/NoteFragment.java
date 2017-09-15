package cn.itsite.dreamnote.note;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cn.itsite.abase.mvp.view.base.BaseFragment;
import cn.itsite.dreamnote.R;
import cn.itsite.dreamnote.main.view.MainFragment;

/**
 * Created by leguang on 2017/9/15 0015.
 * Email：langmanleguang@qq.com
 */

public class NoteFragment extends BaseFragment {
    public final String TAG = MainFragment.class.getSimpleName();

    public static NoteFragment newInstance() {
        return new NoteFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.recyclerview, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
