package com.joanfuentes.hintcaseassets.contentholderanimators;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;

import com.joanfuentes.hintcase.ContentHolderAnimator;

public class SlideInFromRightContentHolderAnimator extends ContentHolderAnimator {

    public SlideInFromRightContentHolderAnimator() {
        super();
    }

    public SlideInFromRightContentHolderAnimator(int durationInMilliseconds) {
        super(durationInMilliseconds);
    }

    @Override
    public ValueAnimator getAnimator(final View view, final OnFinishListener onFinishListener) {
        view.setAlpha(1);
        float spaceUntilRightSide = view.getRootView().getWidth() - view.getLeft();
        ObjectAnimator animator = ObjectAnimator.ofFloat(view, View.TRANSLATION_X,
                spaceUntilRightSide, 0);
        animator.setDuration(durationInMilliseconds);
        if (onFinishListener != NO_CALLBACK) {
            animator.addListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animation) { }

                @Override
                public void onAnimationEnd(Animator animation) {
                    onFinishListener.onFinish();
                }

                @Override
                public void onAnimationCancel(Animator animation) { }

                @Override
                public void onAnimationRepeat(Animator animation) { }
            });
        }
        return animator;
    }
}
