package com.example.vmac.WatBot;

/**
 * Last Edited by Manas Taneja 12/15/2018.
 */

import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import java.util.ArrayList;


public class ChatAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


  private int SELF = 100;
  private ArrayList<Message> messageArrayList;

  /**
   *
   * @param messageArrayList = inputting an ArrayList of messages
   */

  public ChatAdapter(ArrayList<Message> messageArrayList) {
    this.messageArrayList = messageArrayList;

  }

  /**
   *
   * @param parent = inputting the parent of the view (which is a ViewGroup)
   * @param viewType = inputting the type of the view
   * @return returns a new ViewHolder with an itemView passed into it
   */

  @Override
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View itemView;

    // view type is to identify where to render the chat message
    // left or right
    if (viewType == SELF) {
      // self message
      itemView = LayoutInflater.from(parent.getContext())
        .inflate(R.layout.chat_item_self, parent, false);
    } else {
      // WatBot message
      itemView = LayoutInflater.from(parent.getContext())
        .inflate(R.layout.chat_item_watson, parent, false);
    }


    return new ViewHolder(itemView);
  }

  /**
   *
   * @param position = inputting an integer position (for the message ArrayList)
   * @return returns the position
   */

  @Override
  public int getItemViewType(int position) {
    Message message = messageArrayList.get(position);
    if (message.getId() != null && message.getId().equals("1")) {
      return SELF;
    }

    return position;
  }

  /**
   *
   * @param holder = inputting a view holder
   * @param position = inputting an integer position (for the message ArrayList)
   */

  @Override
  public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
    Message message = messageArrayList.get(position);
    message.setMessage(message.getMessage());
    ((ViewHolder) holder).message.setText(message.getMessage());
  }

  /**
   *
   * @return returns the size of the message ArrayList
   */

  @Override
  public int getItemCount() {
    return messageArrayList.size();
  }

  /**
   * this is the view holder class used as a parameter up above
   */

  public class ViewHolder extends RecyclerView.ViewHolder {
    TextView message;

    /**
     *
     * @param view = inputting the view
     */

    public ViewHolder(View view) {
      super(view);
      message = (TextView) itemView.findViewById(R.id.message);

      //TODO: Uncomment this if you want to use a custom Font
            /*String customFont = "Montserrat-Regular.ttf";
            Typeface typeface = Typeface.createFromAsset(itemView.getContext().getAssets(), customFont);
            message.setTypeface(typeface);*/

    }
  }


}