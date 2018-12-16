package com.example.vmac.WatBot;

import android.view.View;

/**
 * Last Edited by Manas Taneja 12/15/2018.
 */

public interface ClickListener {

  /**
   *
   * @param view = inputting the view
   * @param position = inputting position (most likely to be used with message ArrayList)
   */

  void onClick(View view, int position);

  /**
   *
   * @param view = inputting the view
   * @param position = inputting position (most likely to be used with message ArrayList)
   */

  void onLongClick(View view, int position);
}