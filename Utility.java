    private static AlphaAnimation mShowAnimation = null;

    public static void setShowAnimation( View view, int duration ){
        if( null == view || duration < 0 ){
            return;
        }
        mShowAnimation = new AlphaAnimation(0.0f, 1.0f);
        mShowAnimation.setDuration(duration);
        mShowAnimation.setFillAfter(true);
        view.startAnimation(mShowAnimation);
    }