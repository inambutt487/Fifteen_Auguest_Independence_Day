package com.example.waseem.forteenaugust;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.provider.MediaStore;

import java.io.File;

public class Ids {
	public static Context context;

	public static String appDirectoryFolder = "/PhotoEditor/";

	public Ids(Context cnt){

		context = cnt;
	}

	public static void addMedia(Context c, File f) {
		Intent intent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
		intent.setData(Uri.fromFile(f));
		c.sendBroadcast(intent);
	}

	public static void removeMediaFile(Context c, File f) {
		ContentResolver resolver = c.getContentResolver();
		/*****for VIDEO *****/
		resolver.delete(MediaStore.Video.Media.EXTERNAL_CONTENT_URI,
				MediaStore.Video.Media.DATA + "=?", new String[]{f.getAbsolutePath()});

	}

	public void mediaScanner(Context context, File fileToDelete, File fileToAdd) {

		MediaScannerConnection.scanFile(
				context,
				new String[]{fileToDelete.getAbsolutePath(), fileToAdd.getAbsolutePath()},
				null, null);

	}

	public String getVidPath(Uri uri) {
		String[] projection = {MediaStore.Video.Media.DATA};
		Cursor cursor = context.getContentResolver().query(uri, projection, null, null, null);
		if (cursor == null) return null;
		int column_index = cursor.getColumnIndexOrThrow(MediaStore.Video.Media.DATA);
		cursor.moveToFirst();
		String s = cursor.getString(column_index);
		cursor.close();
		return s;
	}

//	 public static void rateUs() {
//
//		Intent browserIntent = new Intent(Intent.ACTION_VIEW,
//				Uri.parse("https://play.google.com/store/apps/details?id=com.smartnewapps.men.hair.changer.fashion"));
//		context.startActivity(browserIntent);
//	}
//
//	public static void moreApp() {
//
//		Uri uri = Uri.parse("https://play.google.com/store/apps/developer?id=Smart%20New%20Free%20Apps&hl=en");
//		Intent intent = new Intent(Intent.ACTION_VIEW, uri);
//		context.startActivity(intent);
//	}

//	public static void shareApp() {
//
//		String playStoreLink = "https://play.google.com/store/apps/details?id=" + context.getPackageName();
//        String yourShareText = context.getResources().getString(R.string.accept) + playStoreLink;
//        Intent shareIntent = ShareCompat.IntentBuilder.from((Activity) context).setType("text/plain").setText(yourShareText).getIntent();
//        context.startActivity(Intent.createChooser(shareIntent, "Share App!"));
//	}
}
