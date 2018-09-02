package com.example.waseem.forteenaugust;

import android.app.Activity;
import android.app.Dialog;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;


public class DialogExitMain extends Dialog implements
		View.OnClickListener {
	static int aa, bb, cc, dd;
	public Activity c;
	public Dialog d;
	Button yes, no, topTransparent;
	LinearLayout layoutOuter, layoutInner, dialog_bg_inner_buttons;
	View topAnimationView;

	public DialogExitMain(Activity a) {
		super(a);
		// TODO Auto-generated constructor stub
		this.c = a;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.dialogue_exit_main);
		layoutOuter = (LinearLayout) findViewById(R.id.dialog_bg_outer);
		layoutInner = (LinearLayout) findViewById(R.id.dialog_bg_inner);
		dialog_bg_inner_buttons = (LinearLayout) findViewById(R.id.dialog_bg_inner_buttons);
		yes = (Button) findViewById(R.id.btn_yes);
		no = (Button) findViewById(R.id.btn_no);
		//topTransparent = (Button) findViewById(R.id.topTransparent);

		int a = Resources.getSystem().getDisplayMetrics().widthPixels;

		// Toast.makeText(getContext(),a+"", Toast.LENGTH_SHORT).show();
		LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
				(int) Math.ceil((a * 0.9)) , (int) Math.ceil((a * 0.45)) );
		layoutInner.setLayoutParams(layoutParams);

//		LinearLayout.LayoutParams layoutParamsB = new LinearLayout.LayoutParams(
//				10 , (int) Math.ceil(((a / 13) * 3)) );
//		topTransparent.setLayoutParams(layoutParamsB);

		LinearLayout.LayoutParams layoutParamsC = new LinearLayout.LayoutParams(
				(int) Math.ceil(((a / 13) * 3)) , (int) Math.ceil(((a / 13) * 2)) );
		yes.setLayoutParams(layoutParamsC);
		no.setLayoutParams(layoutParamsC);

		yes.setOnClickListener(this);
		no.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_yes:
			android.os.Process.killProcess(android.os.Process.myPid());
            System.exit(1);
			break;
		case R.id.btn_no:
			dismiss();
			break;
		default:
			break;
		}
		dismiss();
	}
}