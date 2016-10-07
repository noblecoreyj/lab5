package com.example.cjn8.lab4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.preference.PreferenceFragment;

/* Lab 5
 *
 * @author: Corey Noble (cjn8)
 * @version: 1.0 (Fall 2016)
 */

public class AboutActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getFragmentManager().beginTransaction().replace(android.R.id.content, new SettingsFragment()).commit();
    }
}