package com.example.vmac.WatBot;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/**
 * Last Edited by Manas Taneja 12/15/2018.
 */


public class RecyclerTouchListener implements RecyclerView.OnItemTouchListener {

  private GestureDetector gestureDetector;
  private ClickListener clickListener;

  /**
   *
   * @param context = inputting application context
   * @param recyclerView = inputting a recycler view
   * @param clickListener = inputting a listener for clicks
   */

  public RecyclerTouchListener(Context context, final RecyclerView recyclerView, final ClickListener clickListener) {
    this.clickListener = clickListener;
    gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {

      /**
       *
       * @param e = inputting a motion event done by the user
       * @return simply returns true, the execution of the method indicates a quick, single tap
       */

      @Override
      public boolean onSingleTapUp(MotionEvent e) {
        return true;
      }

      /**
       *
       * @param e = inputting a motion event done by the user
       */

      @Override
      public void onLongPress(MotionEvent e) {
        View child = recyclerView.findChildViewUnder(e.getX(), e.getY());
        if (child != null && clickListener != null) {
          clickListener.onLongClick(child, recyclerView.getChildPosition(child));
        }
      }
    });
  }

  /**
   *
   * @param rv = inputting a recycler view
   * @param e = inputting a motion event done by the user
   * @return returns false after execution
   */

  @Override
  public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {

    View child = rv.findChildViewUnder(e.getX(), e.getY());
    if (child != null && clickListener != null && gestureDetector.onTouchEvent(e)) {
      clickListener.onClick(child, rv.getChildPosition(child));
    }
    return false;
  }

  /**
   *
   * @param rv = inputting a recycler view
   * @param e = inputting a motion event done by the user
   */

  @Override
  public void onTouchEvent(RecyclerView rv, MotionEvent e) {
  }

  /**
   *
   * @param disallowIntercept = inputting a boolean to allow or not allow the interception of touch events
   */

  @Override
  public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

  }
}