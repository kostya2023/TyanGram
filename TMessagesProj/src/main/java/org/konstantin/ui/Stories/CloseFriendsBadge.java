package org.konstantin.ui.Stories;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.RequiresApi;

import org.konstantin.tyangram.AndroidUtilities;
import org.konstantin.tyangram.R;
import org.konstantin.ui.Components.ScaleStateListAnimator;

public class CloseFriendsBadge extends ImageView {

    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public CloseFriendsBadge(Context context) {
        super(context);
        paint.setColor(0xff7BD11F);
        setScaleType(ScaleType.CENTER_INSIDE);
        //setPadding(AndroidUtilities.dp(12), AndroidUtilities.dp(12), AndroidUtilities.dp(12), AndroidUtilities.dp(12));
        setImageResource(R.drawable.msg_mini_closefriends);
        ScaleStateListAnimator.apply(this);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        float cx = getMeasuredWidth() / 2f;
        float cy = getMeasuredHeight() / 2f;
        float r = AndroidUtilities.dp(11);
        canvas.drawCircle(cx, cy, r, paint);
        super.onDraw(canvas);
    }
}
