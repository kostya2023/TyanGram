package org.konstantin.ui.Components;

import android.view.View;

import org.konstantin.tyangram.ImageReceiver;

public interface AttachableDrawable {
    void onAttachedToWindow(ImageReceiver parent);
    void onDetachedFromWindow(ImageReceiver parent);

    default void setParent(View view) {}
}
