package com.example.cjn8.lab4;

import android.content.SharedPreferences;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.view.View;

/* Lab 5
 *
 * @author: Corey Noble (cjn8)
 * @version: 1.0 (Fall 2016)
 */

public class SettingsFragment extends PreferenceFragment implements SharedPreferences.OnSharedPreferenceChangeListener{

    private SharedPreferences prefs;
    private boolean teamHarambae;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);
        prefs = PreferenceManager.getDefaultSharedPreferences(getActivity());
    }

    @Override
    public void onResume() {
        super.onResume();
        teamHarambae = prefs.getBoolean("mainPreference", false);
        this.setDefaultPreference(teamHarambae);
        prefs.registerOnSharedPreferenceChangeListener(this);
    }

    private void setDefaultPreference(boolean pref) {
        Preference defaultPref = findPreference("mainPreference");
        if (teamHarambae) {
            MainActivity.status.setText("The preference is true!");
        }
        else {
            MainActivity.status.setText("The preference is false!");
        }
    }

    @Override
    public void onPause() {
        prefs.unregisterOnSharedPreferenceChangeListener(this);
        super.onPause();
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences prefs, String key) {
        if (key.equals("mainPreference")) {
            teamHarambae = prefs.getBoolean(key, true);
        }
        this.setDefaultPreference(teamHarambae);
    }
}