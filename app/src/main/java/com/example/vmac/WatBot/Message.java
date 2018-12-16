package com.example.vmac.WatBot;

/**
 * Last Edited by Manas Taneja 12/15/2018.
 */

import java.io.Serializable;

public class Message implements Serializable {
  String id, message;


  public Message() {
  }

  /**
   *
   * @param id = inputting a string that serves as the id for the message
   * @param message = inputting a string that is the message itself
   * @param createdAt = inputting a string for the time the message was created
   */

  public Message(String id, String message, String createdAt) {
    this.id = id;
    this.message = message;


  }

  /**
   *
   * @return returns a String that is the id of the message
   */

  public String getId() {
    return id;
  }

  /**
   *
   * @param id = sets the id of the message to the id (String) that has been given as an argument
   */

  public void setId(String id) {
    this.id = id;
  }

  /**
   *
   * @return returns a String that is the message itself
   */

  public String getMessage() {
    return message;
  }

  /**
   *
   * @param message = sets the message itself to the message (String) that has been given as an argument
   */

  public void setMessage(String message) {
    this.message = message;
  }


}

