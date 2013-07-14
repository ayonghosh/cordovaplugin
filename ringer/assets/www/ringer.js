/*
 * Cordova ringer plugin for Android
 * Author: Ayon Ghosh
 * Version: 1.0
 * Last modified: 14 July 2013
 */
var NORMAL  = 1;
var VIBRATE = 2;
var SILENT  = 3;

var Ringer = {
	setRingerMode: function(mode, success, fail) {
		cordova.exec(success, fail, "Ringer", "ringerMode", [mode]);
	}
}

setRingerMode = function(mode, ringerSuccess, ringerFail) {
	Ringer.setRingerMode(mode, ringerSuccess, ringerFail);
}
