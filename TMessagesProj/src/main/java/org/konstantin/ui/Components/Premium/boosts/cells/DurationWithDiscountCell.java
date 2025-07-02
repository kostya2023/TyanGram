package org.konstantin.ui.Components.Premium.boosts.cells;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.SpannableStringBuilder;
import android.view.Gravity;
import android.view.View;

import org.konstantin.tyangram.AndroidUtilities;
import org.konstantin.tyangram.BillingController;
import org.konstantin.tyangram.LocaleController;
import org.konstantin.tgnet.TLRPC;
import org.konstantin.ui.ActionBar.Theme;
import org.konstantin.ui.Components.CheckBox2;
import org.konstantin.ui.Components.LayoutHelper;
import org.konstantin.ui.Components.Premium.boosts.DiscountSpan;

@SuppressLint("ViewConstructor")
public class DurationWithDiscountCell extends DurationCell {

    protected final CheckBox2 checkBox;
    private TLRPC.TL_premiumGiftCodeOption option;

    public DurationWithDiscountCell(Context context, Theme.ResourcesProvider resourcesProvider) {
        super(context, resourcesProvider);
        checkBox = new CheckBox2(context, 21, resourcesProvider);
        checkBox.setColor(Theme.key_premiumGradient1, Theme.key_checkboxDisabled, Theme.key_dialogRoundCheckBoxCheck);
        checkBox.setDrawUnchecked(true);
        checkBox.setDrawBackgroundAsArc(10);
        addView(checkBox);
        titleTextView.setTypeface(AndroidUtilities.bold());
        radioButton.setVisibility(GONE);
        updateLayouts();
    }

    @Override
    protected void updateLayouts() {
        super.updateLayouts();
        titleTextView.setLayoutParams(LayoutHelper.createFrame(LayoutHelper.MATCH_PARENT, LayoutHelper.WRAP_CONTENT, Gravity.CENTER_VERTICAL | (LocaleController.isRTL ? Gravity.RIGHT : Gravity.LEFT), LocaleController.isRTL ? 20 : 102, 0, LocaleController.isRTL ? 102 : 20, 0));
        subtitleTextView.setLayoutParams(LayoutHelper.createFrame(LayoutHelper.MATCH_PARENT, LayoutHelper.WRAP_CONTENT, Gravity.CENTER_VERTICAL | (LocaleController.isRTL ? Gravity.RIGHT : Gravity.LEFT), LocaleController.isRTL ? 20 : 102, 0, LocaleController.isRTL ? 102 : 20, 0));

        if (checkBox != null) {
            checkBox.setLayoutParams(LayoutHelper.createFrame(22, 22, Gravity.CENTER_VERTICAL | (LocaleController.isRTL ? Gravity.RIGHT : Gravity.LEFT), LocaleController.isRTL ? 15 : 20, 0, LocaleController.isRTL ? 20 : 15, 0));
        }
    }

    @Override
    public void setChecked(boolean checked, boolean animated) {
        if (checkBox.getVisibility() == View.VISIBLE) {
            checkBox.setChecked(checked, animated);
        }
    }

    public void setDuration(TLRPC.TL_premiumGiftCodeOption option, TLRPC.TL_premiumGiftCodeOption minOption, int usersCount, boolean needDivider, boolean selected) {
        this.option = option;
        long price = option.amount;
        CharSequence currency = option.currency;
        SpannableStringBuilder titleBuilder = new SpannableStringBuilder(LocaleController.formatPluralString("Months", option.months)) ;
        int discount = (int) ((1.0 - (option.amount / (double) option.months) / (minOption.amount / (double) minOption.months)) * 100);
        if (discount > 0) {
            titleTextView.setText(titleBuilder.append(DiscountSpan.applySpan("", discount)));
        } else {
            titleTextView.setText(titleBuilder);
        }
        setSubtitle(null);
        totalTextView.setText(BillingController.getInstance().formatCurrency(usersCount > 0 ? price : 0, currency.toString()));
        setDivider(needDivider);
        checkBox.setChecked(selected, false);
    }

    public TLRPC.TL_premiumGiftCodeOption getOption() {
        return option;
    }

    @Override
    protected boolean needCheck() {
        return true;
    }
}
