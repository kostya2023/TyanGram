package org.konstantin.ui;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;

import org.konstantin.ui.ActionBar.BaseFragment;
import org.konstantin.ui.Components.SizeNotifierFrameLayout;

public class EmptyBaseFragment extends BaseFragment {

    @Override
    public View createView(Context context) {
        return fragmentView = new SizeNotifierFrameLayout(context);
    }

}
