/**
 * Displays the settings with values from the shared preferences.
 */

package com.ese2013.mub;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;

import com.ese2013.mub.util.SharedPrefsHandler;

public class SettingsFragment extends Fragment {

	private SharedPrefsHandler prefs;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		prefs = new SharedPrefsHandler(getActivity().getApplicationContext());

		View view = inflater.inflate(R.layout.fragment_settings, container, false);
		
		Switch languageSwitch = (Switch) view.findViewById(R.id.language_switch);
		Spinner languageSpinner = (Spinner) view.findViewById(R.id.language_spinner);
		Switch notificationSwitch = (Switch) view.findViewById(R.id.notification_switch);
		Spinner notificationSpinner = (Spinner) view.findViewById(R.id.notification_spinner);
		EditText notificationEditText = ((EditText) view.findViewById(R.id.edit_text_notification));
		
		languageSwitch.setChecked(prefs.getDoTranslation());
		languageSpinner.setSelection(prefs.getLanguage());
		notificationSwitch.setChecked(prefs.getDoNotification());
		notificationSpinner.setSelection(prefs.getNotificationMensas());
		notificationEditText.setText(prefs.getNotificationFood());
		return view;
	}

	@Override
	public void onPause() {
		super.onPause();

		prefs.setDoTranslation(((Switch) this.getView().findViewById(R.id.language_switch)).isChecked());
		prefs.setLanguage(((Spinner) this.getView().findViewById(R.id.language_spinner)).getSelectedItemPosition());
		prefs.setDoNotification(((Switch) this.getView().findViewById(R.id.notification_switch)).isChecked());
		prefs.setNotificationMensas(((Spinner) this.getView().findViewById(R.id.notification_spinner))
				.getSelectedItemPosition());
		prefs.setNotificationFood(((EditText) this.getView().findViewById(R.id.edit_text_notification)).getText().toString());
	}
}