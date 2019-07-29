package com.fomin.autofind.impl;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;

import com.fomin.autofind.inject.AutoLayout;
import com.fomin.autofind.base.BaseFragment;

public class AutoLayoutImpl {


    public static void inject(Activity activity) {
        AutoLayout layout = activity.getClass().getAnnotation(AutoLayout.class);
        if (layout == null) {
            return;
        }

        if (layout.value() != 0) {
            activity.setContentView(layout.value());
        }
        if (!layout.name().equals("")) {
            activity.setContentView(getId(layout.name(), activity));
        }
    }

    public static void inject(BaseFragment fragment) {
        AutoLayout layout = fragment.getClass().getAnnotation(AutoLayout.class);
        if (layout == null || fragment.getContext() == null) {
            return;
        }
        if (layout.value() != 0) {
            fragment.setResId(layout.value());
        }
        if (!layout.name().equals("")) {
            fragment.setResId(getId(layout.name(), fragment.getContext()));
        }
    }

    private static int getId(String name, Context context) {
        Resources res = context.getResources();
        return res.getIdentifier(name, "layout", context.getPackageName());
    }
}
