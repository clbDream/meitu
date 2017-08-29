package com.clb.meitu;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.ImageView;
import android.widget.SeekBar;

/**
 * Created by Administrator on 2017.08.29.0029.
 */

public class PrimaryActivity extends Activity implements SeekBar.OnSeekBarChangeListener{

    private ImageView img_show;
    private SeekBar seekBar_hue;
    private SeekBar seekBar_saturation;
    private SeekBar seekBar_lum;
    private static int MAX_VALUE = 255;
    private static int MID_VALUE = 127;
    private float mHue,mStaturation,mLum;
    private Bitmap bitmap;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primary);

        bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.test1);

        img_show = findViewById(R.id.img_show);
        seekBar_hue = findViewById(R.id.seekBar_hue);
        seekBar_saturation = findViewById(R.id.seekBar_saturation);
        seekBar_lum = findViewById(R.id.seekBar_lum);

        seekBar_hue.setOnSeekBarChangeListener(this);
        seekBar_saturation.setOnSeekBarChangeListener(this);
        seekBar_lum.setOnSeekBarChangeListener(this);

        seekBar_hue.setMax(MAX_VALUE);
        seekBar_saturation.setMax(MAX_VALUE);
        seekBar_lum.setMax(MAX_VALUE);

        seekBar_hue.setProgress(MID_VALUE);
        seekBar_saturation.setProgress(MID_VALUE);
        seekBar_lum.setProgress(MID_VALUE);

        img_show.setImageBitmap(bitmap);

    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

        switch (seekBar.getId()){
            case R.id.seekBar_hue:
                mHue = (i-MID_VALUE)*1.0f/MID_VALUE*180;

                break;
            case R.id.seekBar_saturation:
                mStaturation = i*1.0f/MID_VALUE;
                break;
            case R.id.seekBar_lum:
                mLum = i*1.0f/MID_VALUE;
                break;
        }
//        Log.e("yyyyyyyyy","哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈");
        img_show.setImageBitmap(ImageUtils.handleImageEffect(bitmap,mHue,mStaturation,mLum));
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
