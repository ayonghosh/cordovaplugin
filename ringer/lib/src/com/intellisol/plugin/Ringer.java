/*
 * Cordova plugin for Android to set ringer mode to normal, vibrate or silent.
 * 
 * Copyright (c) 2013 - Ayon Ghosh
 * 
 * Author: Ayon Ghosh
 * Version 1.0
 * Last modified: 14 July 2013
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.intellisol.plugin;

import org.apache.cordova.api.CallbackContext;
import org.apache.cordova.api.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;

import android.content.Context;
import android.media.AudioManager;
import android.util.Log;

public class Ringer extends CordovaPlugin {
	// action name
	public static final String NATIVE_ACTION_STRING="ringerMode"; 
	
	private static final int NORMAL = 1;
	private static final int VIBRATE = 2;
	private static final int SILENT = 3;
	
	@Override
	public boolean execute(String action, JSONArray args,
			CallbackContext callbackContext) throws JSONException {
		if (NATIVE_ACTION_STRING.equals(action)) {
			int mode;
			try {
				// get mode from argument
				mode = args.getInt(0);
				
				// get context (Android)
				Context ctxt = cordova.getActivity().getBaseContext();
				if (mode == NORMAL) {
					// set ringer mode
					AudioManager audioManager = (AudioManager) ctxt.getSystemService(Context.AUDIO_SERVICE);
					audioManager.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
				}else if (mode == VIBRATE) {
					AudioManager audioManager = (AudioManager) ctxt.getSystemService(Context.AUDIO_SERVICE);
					audioManager.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
				}else if (mode == SILENT) {
					AudioManager audioManager = (AudioManager) ctxt.getSystemService(Context.AUDIO_SERVICE);
					audioManager.setRingerMode(AudioManager.RINGER_MODE_SILENT);
				}
				
			}catch (JSONException e) {
				// log error
				Log.d("Ringer", e.toString()); 
				return false;
			}catch (Exception e) {
				// log error
				Log.d("Ringer", e.toString());
				return false;
			}
		}
		return true;
	}
} 