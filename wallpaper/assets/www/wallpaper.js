/*
 * Cordova wallpaper plugin for Android
 * Author: Ayon Ghosh
 * Version: 1.0
 * Last modified: 15 August 2013
 */

var Wallpaper = {
	setAssetWallpaper: function(path, success, fail) {
		cordova.exec(success, fail, "Wallpaper", "setAssetWallpaper", [path]);
	}
}

setAssetWallpaper = function(path, wallpaperSuccess, wallpaperFail) {
	Wallpaper.setAssetWallpaper(path, wallpaperSuccess, wallpaperFail);
}
