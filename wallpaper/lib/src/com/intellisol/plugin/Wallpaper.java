/*
 * Cordova plugin for Android to set a wallpaper from assets.
 * 
 * Copyright (c) 2013 - Ayon Ghosh
 * 
 * Author: Ayon Ghosh
 * Version 1.0
 * Last modified: 15 August 2013
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

import java.io.InputStream;

import org.apache.cordova.api.CallbackContext;
import org.apache.cordova.api.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;

import android.app.WallpaperManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

public class Wallpaper extends CordovaPlugin {
	// action name
	public static final String NATIVE_ACTION_STRING="setAssetWallpaper";
		
	@Override
	public boolean execute(String action, JSONArray args,
			CallbackContext callbackContext) throws JSONException {
		try {
			// get path from argument
			String path = args.getString(0);
			
			// get context (Android)
			Context ctxt = cordova.getActivity().getBaseContext();
			WallpaperManager wallpaperManager = WallpaperManager.getInstance(ctxt);
			
			// get image file
            InputStream bitmapIn = cordova.getActivity().getAssets().open(path);
            Bitmap bitmap = BitmapFactory.decodeStream(bitmapIn);
			
			// set wallpaper
            wallpaperManager.setBitmap(bitmap);
			
		}catch (JSONException e) {
			// log error
			Log.d("Wallpaper", e.toString()); 
			return false;
		}catch (Exception e) {
			// log error
			Log.d("Wallpaper", e.toString());
			return false;
		}
		return true;
	}
}
