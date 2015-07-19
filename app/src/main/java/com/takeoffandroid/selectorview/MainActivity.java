package com.takeoffandroid.selectorview;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;


public class MainActivity extends ActionBarActivity {

        private Button btnBgSelector;
        private Button btnTxtSelector;

        @Override
        protected void onCreate (Bundle savedInstanceState) {
            super.onCreate (savedInstanceState);
            setContentView (R.layout.activity_main);
            findViews ();
        }


        private void findViews() {
            btnBgSelector = (Button)findViewById( R.id.btn_bg_selector );
            btnTxtSelector = (Button)findViewById( R.id.btn_txt_selector );


            if(Build.VERSION.SDK_INT >= 16) {

                btnBgSelector.setBackground(selectorBackgroundColor(this, getResources().getColor(R.color.blue), getResources().getColor(R.color.orange)));

            } else {

                btnBgSelector.setBackgroundDrawable (selectorBackgroundColor(this, getResources().getColor(R.color.blue), getResources().getColor(R.color.orange)));

            }

            btnTxtSelector.setTextColor (selectorText (this, getResources ().getColor (R.color.white), getResources ().getColor (R.color.orange)));
        }


        private   StateListDrawable selectorBackgroundColor (Context context, int normal,int pressed) {
            StateListDrawable states = new StateListDrawable ();
            states.addState (new int[]{ android.R.attr.state_pressed }, new ColorDrawable (pressed));
            states.addState (new int[]{ }, new ColorDrawable(normal));
            return states;
        }

        private  ColorStateList selectorText(Context context, int normal,int pressed) {
            ColorStateList colorStates = new ColorStateList(
                    new int[][]{
                            new int[]{android.R.attr.state_pressed},
                            new int[]{}
                    },
                    new int[]{
                            pressed,
                            normal});


            return colorStates;
        }


}
