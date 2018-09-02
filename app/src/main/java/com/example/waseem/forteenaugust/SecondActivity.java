package com.example.waseem.forteenaugust;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.larswerkman.holocolorpicker.ColorPicker;
import com.larswerkman.holocolorpicker.ValueBar;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;

public class SecondActivity extends Activity implements View.OnClickListener, ColorPicker.OnColorChangedListener {

    InterstitialAd mInterstitialAd;

    boolean btn_click_show_hide = true;

    TextView seatxt_view;
    int prog1;
    ColorPicker color_picker;
    ValueBar value_Bar;

    boolean save_image_for_share_boolean = true;
    boolean only_save_image = true;
    boolean sticker_screen_touch = false;

    ImageView i, i1, i2, i3, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13, i14, i15, i16, i17, i18;

    private Bitmap mergeBitmap;
    File storagePath;
    File myImage;
    int receive_intent_value;
    private static Uri imageUri;
    public static final int MEDIA_TYPE_IMAGE = 1;
    final static int CAMERA_CAPTURE = 2;
    private static final int REQUEST_CODE_GALLERY = 1;
    final private int REQUEST_CODE_CAPTURE = 2;

    Button frame_button_id;


    private Uri imgUriPath;
    private ImageView camerview;
    private HashMap<Integer, Integer> replaceMap = new HashMap<Integer, Integer>();
    private DraggableImageView mImageView;
    private int mWidth;
    private int mHeight;
    boolean touch_main_screen = false;
    RelativeLayout horzntal_itemz_show_block_layout, save_layout_button;
    Button btn_remove, btn_next;
    LinearLayout top_two_button, nichy_wali_list_button, shr_save_back_list_button, ad_show_top_big;
    Button eyebutton, starbutton, moonbutton, balloonbutton;
    Button back_button, share_button, save_button, text_button;
    private Bitmap eyeBitmap = null, starBitmap = null, moonBitmp = null, balloonBitmaap = null;
    private EyeAdapter eyeAdapter, starAdapter, moonAdapter, balloonAdapter;
    private ListViewHorizontal horizontalEyeListView , horizontalMoonListView, horizontalBalloonListView;
    //, horizontalstarListView
    ImageView imagee;
    SeekBar barOpacity;
    TextView textOpacitySetting;

    RelativeLayout fram_layout_id_btn;

    private Integer[] eyeArrey = {R.drawable.flg1, R.drawable.flg2, R.drawable.flg3,  R.drawable.flg5,R.drawable.flg6 ,R.drawable.srt1, R.drawable.str2, R.drawable.str3, R.drawable.str4 };
 //   private Integer[] starArray = {R.drawable.star1, R.drawable.star2, R.drawable.star3, R.drawable.star4,  };
    private Integer[] moonArray = {R.drawable.moon1, R.drawable.moon2, R.drawable.moon3, R.drawable.moon4};
    private Integer[] balloonArray = {R.drawable.blon1, R.drawable.bln2 ,R.drawable.ballon1,  R.drawable.balloon3, R.drawable.ballon4 };

    Integer[] imagesfilter = {R.drawable.ff1, R.drawable.ff2, R.drawable.ff3, R.drawable.ff4,
             R.drawable.ff5, R.drawable.ff6, R.drawable.ff7, R.drawable.ff8, R.drawable.ff9,R.drawable.ff10,
            R.drawable.ff11, R.drawable.ff12, R.drawable.ff13,
            R.drawable.ff14, R.drawable.ff15, R.drawable.ff16, R.drawable.ff17, R.drawable.ff18, R.drawable.ff19


    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_second);

        BannerAdmob();
        BannerAdmob2();

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-3444255945927869/8717394557");
        requestNewInterstitial();
        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                requestNewInterstitial();
            }
        });

        textOpacitySetting = (TextView) findViewById(R.id.opacitysetting);
        barOpacity = (SeekBar) findViewById(R.id.opacity);
        imagee = (ImageView) findViewById(R.id.imageView2);
        i = (ImageView) findViewById(R.id.img1);
        i1 = (ImageView) findViewById(R.id.img2);
        i2 = (ImageView) findViewById(R.id.img3);
        i3 = (ImageView) findViewById(R.id.img4);
        i4 = (ImageView) findViewById(R.id.img5);
        i5 = (ImageView) findViewById(R.id.img6);

        i6 = (ImageView) findViewById(R.id.img7);
        i7 = (ImageView) findViewById(R.id.img8);
        i8 = (ImageView) findViewById(R.id.img9);
        i9 = (ImageView) findViewById(R.id.img10);

        i10 = (ImageView) findViewById(R.id.img11);
        i11 = (ImageView) findViewById(R.id.img12);
        i12 = (ImageView) findViewById(R.id.img13);
        i13 = (ImageView) findViewById(R.id.img14);

        i14 = (ImageView) findViewById(R.id.img15);

        i15 = (ImageView) findViewById(R.id.img16);
        i16 = (ImageView) findViewById(R.id.img17);
        i17 = (ImageView) findViewById(R.id.img18);
        i18 = (ImageView) findViewById(R.id.img19);




        frame_button_id = (Button) findViewById(R.id.fram_idz);

        fram_layout_id_btn = (RelativeLayout) findViewById(R.id.fram_layout_id);

        back_button = (Button) findViewById(R.id.backbtn);
        share_button = (Button) findViewById(R.id.sharebtn);
        save_button = (Button) findViewById(R.id.savebtn);
        save_layout_button = (RelativeLayout) findViewById(R.id.save_layout_btn);
        shr_save_back_list_button = (LinearLayout) findViewById(R.id.shr_save_back_list_btn);
        text_button = (Button) findViewById(R.id.textbtn);
        btn_next = (Button) findViewById(R.id.nextbtn);
        eyebutton = (Button) findViewById(R.id.eyeBtn);
      //  starbutton = (Button) findViewById(R.id.starbtn);
        btn_remove = (Button) findViewById(R.id.rmv);
        moonbutton = (Button) findViewById(R.id.moonbtn);
        balloonbutton = (Button) findViewById(R.id.balloonbtn);
        top_two_button = (LinearLayout) findViewById(R.id.top_two_btn);
        nichy_wali_list_button = (LinearLayout) findViewById(R.id.nichy_wali_list_btn);

        mImageView = (DraggableImageView) findViewById(R.id.canvasImage);

        horzntal_itemz_show_block_layout = (RelativeLayout) findViewById(R.id.horzntal_itemz_show_block);
        ad_show_top_big = (LinearLayout) findViewById(R.id.adshow_big);

        btn_next.setOnClickListener(this);
        btn_remove.setOnClickListener(this);
        eyebutton.setOnClickListener(this);
//        starbutton.setOnClickListener(this);
        moonbutton.setOnClickListener(this);
        balloonbutton.setOnClickListener(this);
        back_button.setOnClickListener(this);
        share_button.setOnClickListener(this);
        save_button.setOnClickListener(this);
        text_button.setOnClickListener(this);
        frame_button_id.setOnClickListener(this);

        horzntal_itemz_show_block_layout.setOnClickListener(this);

        horizontalEyeListView = (ListViewHorizontal) findViewById(R.id.horizontalEyeListView);
    //    horizontalstarListView = (ListViewHorizontal) findViewById(R.id.horizontalStarListView);
        horizontalMoonListView = (ListViewHorizontal) findViewById(R.id.horizontalmoonListView);
        horizontalBalloonListView = (ListViewHorizontal) findViewById(R.id.horizontalballoonListView);

        eyeAdapter = new EyeAdapter(SecondActivity.this, R.layout.eye_adapter, eyeArrey);
        horizontalEyeListView.setAdapter(eyeAdapter);


//        starAdapter = new EyeAdapter(SecondActivity.this, R.layout.eye_adapter, starArray);
//        horizontalstarListView.setAdapter(starAdapter);

        moonAdapter = new EyeAdapter(SecondActivity.this, R.layout.eye_adapter, moonArray);
        horizontalMoonListView.setAdapter(moonAdapter);

        balloonAdapter = new EyeAdapter(SecondActivity.this, R.layout.eye_adapter, balloonArray);
        horizontalBalloonListView.setAdapter(balloonAdapter);


        DisplayMetrics displayMatrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMatrics);
        mWidth = displayMatrics.widthPixels;
        mHeight = displayMatrics.heightPixels;
        mImageView.setImageBitmap(Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(),
                R.drawable.trans), this.mWidth, this.mHeight, true));
        replaceMap = new HashMap();
        camerview = (ImageView) findViewById(R.id.m_imagview);


        seatxt_view = (TextView) findViewById(R.id.seatxt_arabman);
        seatxt_view.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // TODO Auto-generated method stub
                drag(event, v);
                return true;
            }
        });


        horizontalEyeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                // TODO Auto-generated method stub
                eyeBitmap = BitmapFactory.decodeResource(getResources(), eyeArrey[arg2]);
                DraggableBitmap stamp1 = new DraggableBitmap(eyeBitmap);
                if (!replaceMap.containsKey(1)) {
                    replaceMap.put(1, mImageView.addOverlayBitmap(stamp1));
                } else {
                    mImageView.replaceOverlayBitmap(stamp1, replaceMap.get(1));
                }


            }
        });

//        horizontalstarListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//
//            @Override
//            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
//                // TODO Auto-generated method stub
//                starBitmap = BitmapFactory.decodeResource(getResources(), starArray[arg2]);
//                DraggableBitmap stamp2 = new DraggableBitmap(starBitmap);
//                if (!replaceMap.containsKey(2)) {
//                    replaceMap.put(2, mImageView.addOverlayBitmap(stamp2));
//                } else {
//                    mImageView.replaceOverlayBitmap(stamp2, replaceMap.get(2));
//                }
//            }
//        });

        horizontalMoonListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                // TODO Auto-generated method stub
                moonBitmp = BitmapFactory.decodeResource(getResources(), moonArray[arg2]);
                DraggableBitmap stamp3 = new DraggableBitmap(moonBitmp);
                if (!replaceMap.containsKey(3)) {
                    replaceMap.put(3, mImageView.addOverlayBitmap(stamp3));
                } else {
                    mImageView.replaceOverlayBitmap(stamp3, replaceMap.get(3));
                }
            }
        });

        horizontalBalloonListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                // TODO Auto-generated method stub
                balloonBitmaap = BitmapFactory.decodeResource(getResources(), balloonArray[arg2]);
                DraggableBitmap stamp4 = new DraggableBitmap(balloonBitmaap);
                if (!replaceMap.containsKey(4)) {
                    replaceMap.put(4, mImageView.addOverlayBitmap(stamp4));
                } else {
                    mImageView.replaceOverlayBitmap(stamp4, replaceMap.get(4));
                }
            }
        });


        Intent in = getIntent();
        receive_intent_value = in.getExtras().getInt("message");
        if (receive_intent_value == 1) {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            imageUri = getOutputMediaFileUri(MEDIA_TYPE_IMAGE);
            intent.putExtra(MediaStore.EXTRA_OUTPUT, setImageUri());
            startActivityForResult(intent, CAMERA_CAPTURE);


        }

        if (receive_intent_value == 2) {
            Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
            photoPickerIntent.setType("image/*");
            startActivityForResult(photoPickerIntent, REQUEST_CODE_GALLERY);
        }

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rmv:
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {
//                    if (btn_click_show_hide == true) {
//                        btn_click_show_hide = false;
                        fram_layout_id_btn.setVisibility(View.GONE);
                        horzntal_itemz_show_block_layout.setVisibility(View.GONE);
                        mImageView.deleteActiveBitmap();
                        fram_layout_id_btn.setVisibility(View.GONE);

             //       }

                }
                break;


            case R.id.eyeBtn:

                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {


                    if (btn_click_show_hide == true) {
                        fram_layout_id_btn.setVisibility(View.GONE);
                        horzntal_itemz_show_block_layout.setVisibility(View.VISIBLE);
                    //    horizontalstarListView.setVisibility(View.GONE);
                        horizontalEyeListView.setVisibility(View.VISIBLE);
                        horizontalMoonListView.setVisibility(View.GONE);
                        horizontalBalloonListView.setVisibility(View.GONE);
                        btn_click_show_hide = false;
                    } else if (btn_click_show_hide == false) {
                        fram_layout_id_btn.setVisibility(View.GONE);
                        horzntal_itemz_show_block_layout.setVisibility(View.GONE);
                  //      horizontalstarListView.setVisibility(View.GONE);
                        horizontalEyeListView.setVisibility(View.GONE);
                        horizontalMoonListView.setVisibility(View.GONE);
                        horizontalBalloonListView.setVisibility(View.GONE);
                        btn_click_show_hide = true;
                    }

                }
                break;

//            case R.id.starbtn:
//
//                if (mInterstitialAd.isLoaded()) {
//                    mInterstitialAd.show();
//                } else {
//
//                    if (btn_click_show_hide == true) {
//                        fram_layout_id_btn.setVisibility(View.GONE);
//                        horzntal_itemz_show_block_layout.setVisibility(View.VISIBLE);
//                //        horizontalstarListView.setVisibility(View.VISIBLE);
//                        horizontalEyeListView.setVisibility(View.GONE);
//                        horizontalMoonListView.setVisibility(View.GONE);
//                        horizontalBalloonListView.setVisibility(View.GONE);
//                        btn_click_show_hide = false;
//                    } else
//                    if (btn_click_show_hide == false) {
//                        fram_layout_id_btn.setVisibility(View.GONE);
//                        horzntal_itemz_show_block_layout.setVisibility(View.GONE);
//                        //horizontalstarListView.setVisibility(View.GONE);
//                        horizontalEyeListView.setVisibility(View.GONE);
//                        horizontalMoonListView.setVisibility(View.GONE);
//                        horizontalBalloonListView.setVisibility(View.GONE);
//                        btn_click_show_hide = true;
//                    }
//
//
//                }
//                break;

            case R.id.moonbtn:
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {

                    if (btn_click_show_hide == true) {

                        fram_layout_id_btn.setVisibility(View.GONE);
                        horzntal_itemz_show_block_layout.setVisibility(View.VISIBLE);
                        horizontalMoonListView.setVisibility(View.VISIBLE);
                      //  horizontalstarListView.setVisibility(View.GONE);
                        horizontalEyeListView.setVisibility(View.GONE);
                        horizontalBalloonListView.setVisibility(View.GONE);

                        btn_click_show_hide = false;

                    } else if (btn_click_show_hide == false) {
                        fram_layout_id_btn.setVisibility(View.GONE);
                        horzntal_itemz_show_block_layout.setVisibility(View.GONE);
                    //    horizontalstarListView.setVisibility(View.GONE);
                        horizontalEyeListView.setVisibility(View.GONE);
                        horizontalMoonListView.setVisibility(View.GONE);
                        horizontalBalloonListView.setVisibility(View.GONE);
                        btn_click_show_hide = true;
                    }

                }
                break;


            case R.id.balloonbtn:
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {

                    if (btn_click_show_hide == true) {

                        fram_layout_id_btn.setVisibility(View.GONE);
                        horzntal_itemz_show_block_layout.setVisibility(View.VISIBLE);
                        horizontalBalloonListView.setVisibility(View.VISIBLE);
                        horizontalMoonListView.setVisibility(View.GONE);
                  //      horizontalstarListView.setVisibility(View.GONE);
                        horizontalEyeListView.setVisibility(View.GONE);

                        btn_click_show_hide = false;

                    } else if (btn_click_show_hide == false) {
                        fram_layout_id_btn.setVisibility(View.GONE);
                        horzntal_itemz_show_block_layout.setVisibility(View.GONE);
                //        horizontalstarListView.setVisibility(View.GONE);
                        horizontalEyeListView.setVisibility(View.GONE);
                        horizontalMoonListView.setVisibility(View.GONE);
                        horizontalBalloonListView.setVisibility(View.GONE);
                        btn_click_show_hide = true;
                    }

                }
                break;

            case R.id.nextbtn:
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {
                    fram_layout_id_btn.setVisibility(View.GONE);
                    horzntal_itemz_show_block_layout.setVisibility(View.GONE);
                 //   horizontalstarListView.setVisibility(View.GONE);
                    horizontalEyeListView.setVisibility(View.GONE);
                    horizontalMoonListView.setVisibility(View.GONE);
                    horizontalBalloonListView.setVisibility(View.GONE);
                    top_two_button.setVisibility(View.GONE);
                    nichy_wali_list_button.setVisibility(View.GONE);
                    shr_save_back_list_button.setVisibility(View.VISIBLE);
                    ad_show_top_big.setVisibility(View.VISIBLE);
                }
                break;

            case R.id.fram_idz:

                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {


                    i.setImageResource(imagesfilter[0]);
                    i1.setImageResource(imagesfilter[1]);
                    i2.setImageResource(imagesfilter[2]);
                    i3.setImageResource(imagesfilter[3]);
                    i4.setImageResource(imagesfilter[4]);
                    i5.setImageResource(imagesfilter[5]);

                    i6.setImageResource(imagesfilter[6]);
                    i7.setImageResource(imagesfilter[7]);
                    i8.setImageResource(imagesfilter[8]);
                    i9.setImageResource(imagesfilter[9]);
                    i10.setImageResource(imagesfilter[10]);
                    i11.setImageResource(imagesfilter[11]);

                    i12.setImageResource(imagesfilter[12]);
                    i13.setImageResource(imagesfilter[13]);
                    i14.setImageResource(imagesfilter[14]);
                    i15.setImageResource(imagesfilter[15]);
                    i16.setImageResource(imagesfilter[16]);
                    i17.setImageResource(imagesfilter[17]);

                    i18.setImageResource(imagesfilter[18]);









                    if (btn_click_show_hide == true) {

                        fram_layout_id_btn.setVisibility(View.VISIBLE);
                        horzntal_itemz_show_block_layout.setVisibility(View.GONE);
                   //     horizontalstarListView.setVisibility(View.GONE);
                        horizontalEyeListView.setVisibility(View.GONE);
                        horizontalMoonListView.setVisibility(View.GONE);
                        horizontalBalloonListView.setVisibility(View.GONE);

                        btn_click_show_hide = false;

                    } else if (btn_click_show_hide == false) {


                        fram_layout_id_btn.setVisibility(View.GONE);
                        horzntal_itemz_show_block_layout.setVisibility(View.GONE);
                //        horizontalstarListView.setVisibility(View.GONE);
                        horizontalEyeListView.setVisibility(View.GONE);
                        horizontalMoonListView.setVisibility(View.GONE);
                        horizontalBalloonListView.setVisibility(View.GONE);
                        btn_click_show_hide = true;

                    }
                }

                break;
            case R.id.textbtn:
//////////////////////
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {

                    horzntal_itemz_show_block_layout.setVisibility(View.GONE);

                    final Dialog text_dialog = new Dialog(
                            SecondActivity.this);
                    text_dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                    text_dialog.setContentView(R.layout.custom_arabman);
                    text_dialog.setCanceledOnTouchOutside(false);

                    ImageView addButton = (ImageView) text_dialog.findViewById(R.id.addtxt);
                    ImageView style_arab_man = (ImageView) text_dialog.findViewById(R.id.style_arabman);
                    ImageView size_arab_man = (ImageView) text_dialog.findViewById(R.id.size_arabman);
                    ImageView color_arab_man = (ImageView) text_dialog.findViewById(R.id.color_arabman);
                    ImageView apply_arab_man = (ImageView) text_dialog.findViewById(R.id.tapply_arabman);

                    addButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            EditDialog();
                        }
                    });


                    style_arab_man.setOnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View arg0) {
                            // TODO Auto-generated method stub
                            styleDialog();
                        }
                    });

                    apply_arab_man.setOnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View arg0) {
                            // TODO Auto-generated method stub

                            text_dialog.dismiss();


                        }
                    });
                    size_arab_man.setOnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View arg0) {
                            // TODO Auto-generated method stub
                            DisplayFontDialog();
                        }
                    });

                    color_arab_man.setOnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View arg0) {
                            // TODO Auto-generated method stub
                            FontColorDialog();
                        }
                    });

                    text_dialog.show();

                }
/////////////////////////
                break;

            case R.id.sharebtn:
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {

                    if (save_image_for_share_boolean == true) {
                        savingImages_for_share();
                        save_image_for_share_boolean = false;
                    }
                    createShareIntent();
                }
                break;

            case R.id.savebtn:
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {

                    if (only_save_image == true) {
                        savingImages_for_share();
                        Toast.makeText(this, "Image has been saved", Toast.LENGTH_SHORT).show();
                        only_save_image = false;
                    } else {
                        Toast.makeText(this, "Image has already been saved", Toast.LENGTH_SHORT).show();
                    }
                }
                break;

            case R.id.backbtn:
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {

                    horzntal_itemz_show_block_layout.setVisibility(View.VISIBLE);
              //      horizontalstarListView.setVisibility(View.GONE);
                    horizontalEyeListView.setVisibility(View.GONE);
                    horizontalMoonListView.setVisibility(View.GONE);
                    horizontalBalloonListView.setVisibility(View.GONE);
                    top_two_button.setVisibility(View.VISIBLE);
                    nichy_wali_list_button.setVisibility(View.VISIBLE);
                    shr_save_back_list_button.setVisibility(View.GONE);
                    ad_show_top_big.setVisibility(View.GONE);
                    save_image_for_share_boolean = true;
                    only_save_image = true;

                }
                break;


        }


        int alpha = barOpacity.getProgress();
        textOpacitySetting.setText(String.valueOf(alpha));
        imagee.setImageAlpha(alpha); //for API Level 16+
        barOpacity.setOnSeekBarChangeListener(barOpacityOnSeekBarChangeListener);
    }

    SeekBar.OnSeekBarChangeListener barOpacityOnSeekBarChangeListener = new SeekBar.OnSeekBarChangeListener() {

        @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            int alpha = barOpacity.getProgress();
            textOpacitySetting.setText(String.valueOf(alpha));
            imagee.setImageAlpha(alpha); //for API Level 16+
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
        }

    };


    public void onimgclick(View v) {
        imagee.setVisibility(View.VISIBLE);

        switch (v.getId()) {
            case R.id.img1:
                imagee.setImageResource(imagesfilter[0]);
                break;
            case R.id.img2:
                imagee.setImageResource(imagesfilter[1]);
                break;
            case R.id.img3:
                imagee.setImageResource(imagesfilter[2]);
                break;
            case R.id.img4:
                imagee.setImageResource(imagesfilter[3]);
                break;
            case R.id.img5:
                imagee.setImageResource(imagesfilter[4]);
                break;
            case R.id.img6:
                imagee.setImageResource(imagesfilter[5]);
                break;


            case R.id.img7:
                imagee.setImageResource(imagesfilter[6]);
                break;
            case R.id.img8:
                imagee.setImageResource(imagesfilter[7]);
                break;
            case R.id.img9:
                imagee.setImageResource(imagesfilter[8]);
                break;
            case R.id.img10:
                imagee.setImageResource(imagesfilter[9]);
                break;
            case R.id.img11:
                imagee.setImageResource(imagesfilter[10]);
                break;
            case R.id.img12:
                imagee.setImageResource(imagesfilter[11]);
                break;



            case R.id.img13:
                imagee.setImageResource(imagesfilter[12]);
                break;
            case R.id.img14:
                imagee.setImageResource(imagesfilter[13]);
                break;
            case R.id.img15:
                imagee.setImageResource(imagesfilter[14]);
                break;
            case R.id.img16:
                imagee.setImageResource(imagesfilter[15]);
                break;
            case R.id.img17:
                imagee.setImageResource(imagesfilter[16]);
                break;
            case R.id.img18:
                imagee.setImageResource(imagesfilter[17]);
                break;

            case R.id.img19:
                imagee.setImageResource(imagesfilter[18]);
                break;

















        }

    }


    public Uri getOutputMediaFileUri(int type) {
        return Uri.fromFile(getOutputMediaFile(type));
    }

    public static boolean isSdPresent() {
        return android.os.Environment.getExternalStorageState().equals(android.os.Environment.MEDIA_MOUNTED);
    }

    private File getOutputMediaFile(int type) {

        String location;

        if (isSdPresent()) {
            location = Environment.getExternalStorageDirectory().toString();
        } else {
            location = getFilesDir().toString();
        }

        Calendar currentDate = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMMddHmmss");
        String dateNow = formatter.format(currentDate.getTime());
        File file = new File(location + "/" + dateNow + ".beard09.JPEG");

        return file;
    }


    protected void onActivityResult(int requestCode, int resultCode, Intent data) {


        if (resultCode != RESULT_OK) {

            Log.d("ImageLog", String.valueOf(data));
            return;
        }

        Log.d("ImageLog", String.valueOf(resultCode));
        Log.d("ImageLog", String.valueOf(requestCode));

        switch (requestCode) {
            case REQUEST_CODE_GALLERY:

                try {

                    Uri selectedImageUri = data.getData();
                    CropImage.activity(selectedImageUri)
                            .setGuidelines(CropImageView.Guidelines.ON)
                            .start(this);

                } catch (Exception e) {

                }
                break;

            case REQUEST_CODE_CAPTURE:
                Log.d("ImageLog", "Request Code Capture");
                try {

                    Uri selectedImageUri = getImageUri();

                    if (selectedImageUri == null) {

                        Toast.makeText(SecondActivity.this, "Error in loading image after capturing please try again!",
                                Toast.LENGTH_LONG).show();
                    }

                    CropImage.activity(selectedImageUri)
                            .setGuidelines(CropImageView.Guidelines.ON)
                            .start(this);

                } catch (Exception e) {

                    Log.e("ImageLog", "Error while creating temp file", e);
                }
                break;

            case CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE:
                Log.e("ImageLog", "Crop Image Activity Request Code");
                CropImage.ActivityResult result = CropImage.getActivityResult(data);
                Uri resultUri = result.getUri();
                SecondActivity.this.camerview.setImageURI(resultUri);
                break;

            case CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE:
                Log.e("ImageLog", "Crop Image Activity Result Error Code");
                Toast.makeText(SecondActivity.this, "Error in loading image by caputring please try again!", Toast.LENGTH_LONG).show();
                break;
            default:
                Log.d("ImageLog", "default");
                Toast.makeText(SecondActivity.this, "Error in loading image  by capture please try again!", Toast.LENGTH_LONG).show();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    public Uri getImageUri() {
        return imgUriPath;
    }

    public Uri setImageUri() {
        File file = new File(Environment.getExternalStorageDirectory()
                , "temp_ima" +
                "ge.png");
        Uri imgUri = Uri.fromFile(file);
        this.imgUriPath = imgUri;
        return imgUri;
    }

    //////////////save and share functions///////////////////////////////

    public void savingImages_for_share() {
        //    if (save1) {
        if (mergeBitmap == null) {
            SecondActivity.this.save_layout_button.setDrawingCacheEnabled(true);
            SecondActivity.this.mergeBitmap = Bitmap.createBitmap(SecondActivity.this.save_layout_button.getDrawingCache());
            SecondActivity.this.save_layout_button.setDrawingCacheEnabled(false);
        }
        storagePath = new File(
                Environment.getExternalStorageDirectory() + "/" + Ids.appDirectoryFolder + "/");
        storagePath.mkdirs();
        myImage = new File(storagePath, Long.toString(System.currentTimeMillis()) + ".jpg");
        try {
            FileOutputStream out = new FileOutputStream(myImage);
            mergeBitmap.compress(Bitmap.CompressFormat.JPEG, 80, out);

            out.flush();
            out.close();

//            if (mInterstitialAd.isLoaded()) {
//                mInterstitialAd.show();
//            }

        } catch (FileNotFoundException e) {
            Log.d("In Saving File", e + "");
        } catch (IOException e) {
            Log.d("In Saving File", e + "");
        }

//        Toast.makeText(CityImages.this, "Image Saved in" + " "
//                + Ids.appDirectoryFolder + "folder", Toast.LENGTH_LONG).show();

//        SecondActivity.this.replaceMap = new HashMap();
//        if (SecondActivity.this.  bitmap != null) {
//            SecondActivity.this.  bitmap.recycle();
//            SecondActivity.this.  bitmap = null;
//        }
        if (SecondActivity.this.mergeBitmap != null) {
            SecondActivity.this.mergeBitmap.recycle();
            SecondActivity.this.mergeBitmap = null;
        }


        MediaScannerConnection.scanFile(SecondActivity.this,
                new String[]{myImage.toString()}, null,
                new MediaScannerConnection.OnScanCompletedListener() {
                    public void onScanCompleted(String path, Uri uri) {
                        Log.i("ExternalStorage", "Scanned " + path + ":");
                        Log.i("ExternalStorage", "-> uri=" + uri);
                    }
                });


        //save1 = false;
//        } else
//            Toast.makeText(MainActivity.this, "Image is already saved", Toast.LENGTH_SHORT).show();

    }


    private Intent createShareIntent() {

        File file = Environment.getExternalStorageDirectory();
        storagePath = this.myImage;
        Uri uri = Uri.fromFile(myImage);
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("image/*");
        shareIntent.putExtra(Intent.EXTRA_STREAM, uri);

        try {
            startActivity(Intent.createChooser(shareIntent, "Share photo"));
        } catch (Exception e) {

//            Intent restart=new Intent(secondactivity.this, CameraOverview1.class);
//            startActivity(restart);
//            onBackPressed();
        }

//        Intent share = new Intent(android.content.Intent.ACTION_SEND);
//        share.setType("image/*");
//        share.putExtra(Intent.EXTRA_STREAM, uri);
//        try {
//            startActivity(Intent.createChooser(shareIntent, "Share photo"));
//        } catch (Exception e) {
//
//            Intent restart=new Intent(secondactivity.this, CameraOverview1.class);
//            startActivity(restart);
        //onBackPressed();
        //      }


        return shareIntent;


    }


    public void styleDialog() {

        final Dialog dialog = new Dialog(SecondActivity.this, R.style.CustomStyle);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.style_dialogue_my);
        dialog.setCanceledOnTouchOutside(false);
        TextView style_text1 = (TextView) dialog.findViewById(R.id.style1_arabman);
        TextView style_text2 = (TextView) dialog.findViewById(R.id.style2_arabman);
        TextView style_text3 = (TextView) dialog.findViewById(R.id.style3_arabman);
        TextView style_text4 = (TextView) dialog.findViewById(R.id.style4_arabman);
        TextView style_text5 = (TextView) dialog.findViewById(R.id.style5_arabman);
        TextView style_text6 = (TextView) dialog.findViewById(R.id.style6_arabman);
        TextView style_text7 = (TextView) dialog.findViewById(R.id.style7_arabman);
        TextView style_text8 = (TextView) dialog.findViewById(R.id.style8_arabman);
        TextView style_text9 = (TextView) dialog.findViewById(R.id.style9_arabman);
        TextView style_text10 = (TextView) dialog.findViewById(R.id.style10_arabman);
        TextView style_text11 = (TextView) dialog.findViewById(R.id.style11_arabman);
        TextView style_text12 = (TextView) dialog.findViewById(R.id.style12_arabman);
        TextView style_text13 = (TextView) dialog.findViewById(R.id.style13_arabman);
        TextView style_text14 = (TextView) dialog.findViewById(R.id.style14_arabman);
        TextView style_text15 = (TextView) dialog.findViewById(R.id.style15_arabman);


        Typeface blockFonts1 = Typeface.createFromAsset(getApplicationContext().getAssets(), "fonts/wheatland-demo.otf");
        style_text1.setTypeface(blockFonts1);

        Typeface blockFonts2 = Typeface.createFromAsset(getApplicationContext().getAssets(), "fonts/Wedding Chardonnay.ttf");
        style_text2.setTypeface(blockFonts2);
        Typeface blockFonts3 = Typeface.createFromAsset(getApplicationContext().getAssets(),
                "fonts/Autograf_PersonalUseOnly.ttf");
        style_text3.setTypeface(blockFonts3);
        Typeface blockFonts4 = Typeface.createFromAsset(getApplicationContext().getAssets(),
                "fonts/Smoothie Shoppe.ttf");
        style_text4.setTypeface(blockFonts4);
        Typeface blockFonts5 = Typeface.createFromAsset(getApplicationContext().getAssets(),
                "fonts/seriously.ttf");
        style_text5.setTypeface(blockFonts5);
        Typeface blockFonts6 = Typeface.createFromAsset(getApplicationContext().getAssets(),
                "fonts/MorrisRomanBlack.ttf");
        style_text6.setTypeface(blockFonts6);
        Typeface blockFonts7 = Typeface.createFromAsset(getApplicationContext().getAssets(),
                "fonts/Monthoers.ttf");
        style_text7.setTypeface(blockFonts7);
        // TODO Auto-generated method stub
        Typeface blockFonts8 = Typeface.createFromAsset(getApplicationContext().getAssets(),
                "fonts/James_Fajardo.ttf");
        style_text8.setTypeface(blockFonts8);
        Typeface blockFonts9 = Typeface.createFromAsset(getApplicationContext().getAssets(),
                "fonts/Florence-Regular.ttf");
        style_text9.setTypeface(blockFonts9);
        Typeface blockFonts10 = Typeface.createFromAsset(getApplicationContext().getAssets(),
                "fonts/Deadly Inked.ttf");
        style_text10.setTypeface(blockFonts10);
        Typeface blockFonts11 = Typeface.createFromAsset(getApplicationContext().getAssets(),
                "fonts/daniel.ttf");
        style_text11.setTypeface(blockFonts11);
        Typeface blockFonts12 = Typeface.createFromAsset(getApplicationContext().getAssets(),
                "fonts/carolingia.ttf");
        style_text12.setTypeface(blockFonts12);

        Typeface blockFonts13 = Typeface.createFromAsset(getApplicationContext().getAssets(),
                "fonts/Blazed.ttf");
        style_text13.setTypeface(blockFonts13);
        Typeface blockFonts14 = Typeface.createFromAsset(getApplicationContext().getAssets(),
                "fonts/Ardeco.ttf");
        style_text14.setTypeface(blockFonts14);
        Typeface blockFonts15 = Typeface.createFromAsset(getApplicationContext().getAssets(),
                "fonts/Anothershabby_trial.ttf");
        style_text15.setTypeface(blockFonts15);

        style_text1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub


                Typeface blockFonts = Typeface.createFromAsset(getApplicationContext().getAssets(),
                        "fonts/wheatland-demo.otf");
                seatxt_view.setTypeface(blockFonts);
                dialog.dismiss();

            }
        });
        style_text2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                Typeface blockFonts = Typeface.createFromAsset(getApplicationContext().getAssets(),
                        "fonts/Wedding Chardonnay.ttf");
                seatxt_view.setTypeface(blockFonts);
                dialog.dismiss();
            }
        });
        style_text3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                Typeface blockFonts = Typeface.createFromAsset(getApplicationContext().getAssets(),
                        "fonts/Autograf_PersonalUseOnly.ttf");
                seatxt_view.setTypeface(blockFonts);
                dialog.dismiss();
            }
        });
        style_text4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                Typeface blockFonts = Typeface.createFromAsset(getApplicationContext().getAssets(),
                        "fonts/Smoothie Shoppe.ttf");
                seatxt_view.setTypeface(blockFonts);
                dialog.dismiss();
            }
        });
        style_text5.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                Typeface blockFonts = Typeface.createFromAsset(getApplicationContext().getAssets(),
                        "fonts/seriously.ttf");
                seatxt_view.setTypeface(blockFonts);
                dialog.dismiss();
            }
        });
        style_text6.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                Typeface blockFonts = Typeface.createFromAsset(getApplicationContext().getAssets(),
                        "fonts/MorrisRomanBlack.ttf");
                seatxt_view.setTypeface(blockFonts);
                dialog.dismiss();
            }
        });
        style_text7.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                Typeface blockFonts = Typeface.createFromAsset(getApplicationContext().getAssets(),
                        "fonts/Monthoers.ttf");
                seatxt_view.setTypeface(blockFonts);
                dialog.dismiss();
            }
        });
        style_text8.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                Typeface blockFonts = Typeface.createFromAsset(getApplicationContext().getAssets(),
                        "fonts/James_Fajardo.ttf");
                seatxt_view.setTypeface(blockFonts);
                dialog.dismiss();
            }
        });
        style_text9.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                Typeface blockFonts = Typeface.createFromAsset(getApplicationContext().getAssets(),
                        "fonts/Florence-Regular.ttf");
                seatxt_view.setTypeface(blockFonts);
                dialog.dismiss();
            }
        });
        style_text10.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                Typeface blockFonts = Typeface.createFromAsset(getApplicationContext().getAssets(),
                        "fonts/Deadly Inked.ttf");
                seatxt_view.setTypeface(blockFonts);
                dialog.dismiss();
            }
        });
        style_text11.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                Typeface blockFonts = Typeface.createFromAsset(getApplicationContext().getAssets(),
                        "fonts/daniel.ttf");
                seatxt_view.setTypeface(blockFonts);
                dialog.dismiss();
            }
        });
        style_text12.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                Typeface blockFonts = Typeface.createFromAsset(getApplicationContext().getAssets(),
                        "fonts/carolingia.ttf");
                seatxt_view.setTypeface(blockFonts);
                dialog.dismiss();
            }
        });
        style_text13.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                Typeface blockFonts = Typeface.createFromAsset(getApplicationContext().getAssets(),
                        "fonts/Blazed.ttf");
                seatxt_view.setTypeface(blockFonts);
                dialog.dismiss();
            }
        });
        style_text14.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                Typeface blockFonts = Typeface.createFromAsset(getApplicationContext().getAssets(),
                        "fonts/Ardeco.ttf");
                seatxt_view.setTypeface(blockFonts);
                dialog.dismiss();
            }
        });
        style_text15.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                Typeface blockFonts = Typeface.createFromAsset(getApplicationContext().getAssets(),
                        "fonts/Anothershabby_trial.ttf");
                seatxt_view.setTypeface(blockFonts);
                dialog.dismiss();
            }
        });

        dialog.show();

    }

    public void drag(MotionEvent event, View v) {
        FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) v
                .getLayoutParams();

        switch (event.getAction()) {
            case MotionEvent.ACTION_MOVE: {
                params.topMargin = (int) event.getRawY() - (v.getHeight() / 2);
                params.leftMargin = (int) event.getRawX() - (v.getWidth() / 2);
                v.setLayoutParams(params);
                break;
            }
            case MotionEvent.ACTION_UP: {
                params.topMargin = (int) event.getRawY() - (v.getHeight() / 2);
                params.leftMargin = (int) event.getRawX() - (v.getWidth() / 2);
                v.setLayoutParams(params);
                break;
            }
            case MotionEvent.ACTION_DOWN: {
                v.setLayoutParams(params);
                break;
            }
        }
    }

    public void EditDialog() {

        final Dialog edit_dialog = new Dialog(SecondActivity.this, R.style.CustomStyle);
        edit_dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        edit_dialog.setContentView(R.layout.edittxt_custom_my);
        edit_dialog.setCanceledOnTouchOutside(false);
        final EditText ed = (EditText) edit_dialog.findViewById(R.id.edit_arabman);

        ImageView ok = (ImageView) edit_dialog.findViewById(R.id.ok_arabman);
        ImageView cancel = (ImageView) edit_dialog.findViewById(R.id.cancel_arabman);
        ed.setText("Enter Some Text!");

        cancel.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                edit_dialog.dismiss();
            }
        });

        ok.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                try {

                    String edname = ed.getText().toString();
                    seatxt_view.setText(edname);

                } catch (Exception e) {
                    // TODO: handle exception
                }
                edit_dialog.dismiss();
            }
        });

        edit_dialog.show();

    }

    private void DisplayFontDialog() {
        // TODO Auto-generated method stub
        final Dialog dialog = new Dialog(this, R.style.CustomStyle);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_fontsize_my);
        SeekBar font_seekbar = (SeekBar) dialog
                .findViewById(R.id.setting_font_seekbar);
        final TextView show_progress = (TextView) dialog
                .findViewById(R.id.Show_progress_view);
        final TextView sampleTextView = (TextView) dialog
                .findViewById(R.id.sampleText);

        font_seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,
                                          boolean fromUser) {
                show_progress.setText(Integer.toString(progress + 15));
                sampleTextView.setTextSize(progress + 15);
                prog1 = progress;
            }
        });

        Button ok = (Button) dialog.findViewById(R.id.bOk);

        Button cancel = (Button) dialog.findViewById(R.id.bCancel);

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog.dismiss();

            }
        });

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seatxt_view.setTextSize(prog1 + 15);

                dialog.dismiss();
            }
        });

        dialog.show();
    }

    public void FontColorDialog() {

        final Dialog font_color_dialog = new Dialog(SecondActivity.this, R.style.CustomStyle);
        font_color_dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        font_color_dialog.setContentView(R.layout.dialog_fontcolor_my);
        font_color_dialog.setCanceledOnTouchOutside(false);
        Button ok = (Button) font_color_dialog.findViewById(R.id.bok_arabman);
        Button cancel = (Button) font_color_dialog.findViewById(R.id.bcancel_arabman);

        color_picker = (ColorPicker) font_color_dialog.findViewById(R.id.picker_arabman);
        value_Bar = (ValueBar) font_color_dialog.findViewById(R.id.valuebar_arabman);

        color_picker.addValueBar(value_Bar);
        color_picker.setOnColorChangedListener(this);

        color_picker.setOldCenterColor(color_picker.getColor());

        cancel.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                font_color_dialog.dismiss();
            }
        });

        ok.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                try {

                    seatxt_view.setTextColor(color_picker.getColor());

                    color_picker.setOldCenterColor(color_picker.getColor());
                } catch (Exception e) {
                    // TODO: handle exception
                }
                font_color_dialog.dismiss();
            }
        });

        font_color_dialog.show();

    }


    @Override
    public void onColorChanged(int color) {

    }


    private void BannerAdmob() {
        // TODO Auto-generated method stub
        AdView adView = (AdView) this.findViewById(R.id.adView);
        adView.loadAd(new AdRequest.Builder().build());
    }

    private void BannerAdmob2() {
        // TODO Auto-generated method stub
        AdView adView = (AdView) this.findViewById(R.id.adView2);
        adView.loadAd(new AdRequest.Builder().build());
    }


    private void requestNewInterstitial() {
        // TODO Auto-generated method stub
        AdRequest adRequest = new AdRequest.Builder().build();

        mInterstitialAd.loadAd(adRequest);
    }

    @Override
    public void onBackPressed() {


        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        } else {

            super.onBackPressed();
        }
    }
}
