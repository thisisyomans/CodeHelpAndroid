package com.example.vmac.WatBot;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

  /**
   *
   * @param savedInstanceState = inputting a bundle for the on creation method
   */

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    Intent intent = new Intent(this, MainActivity.class);
    startActivity(intent);
  }
}
