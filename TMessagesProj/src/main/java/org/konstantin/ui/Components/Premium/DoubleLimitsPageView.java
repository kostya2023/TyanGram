package org.konstantin.ui.Components.Premium;

import android.content.Context;

import androidx.recyclerview.widget.RecyclerView;

import org.konstantin.tyangram.UserConfig;
import org.konstantin.ui.ActionBar.Theme;

public class DoubleLimitsPageView extends BaseListPageView {

    DoubledLimitsBottomSheet.Adapter adapter;

    public DoubleLimitsPageView(Context context, Theme.ResourcesProvider resourcesProvider) {
        super(context, resourcesProvider);
    }

    @Override
    public RecyclerView.Adapter createAdapter() {
        adapter = new DoubledLimitsBottomSheet.Adapter(UserConfig.selectedAccount, true, resourcesProvider);
        adapter.containerView = this;
        return adapter;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        adapter.measureGradient(getContext(), getMeasuredWidth(), getMeasuredHeight());
    }
}
