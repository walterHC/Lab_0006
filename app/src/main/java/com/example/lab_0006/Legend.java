package com.example.lab_0006;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class Legend extends View {
    private float mWidth;                   // Custom view width.
    private float mHeight;                  // Custom view height.
    private Paint mTextPaint;               // For text in the view.
    private Paint mFigurePaint;             // For rect in the view.

    ArrayList<Country> listCountries;

    public Legend(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        mFigurePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mTextPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mTextPaint.setColor(Color.BLACK);
        mTextPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        mTextPaint.setTextAlign(Paint.Align.CENTER);
        mTextPaint.setTextSize(35f);

        listCountries = Country.countries;

        // TODO: Set up onClick listener for this view.

    }
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        mWidth = w;
        mHeight = h;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        float x = mWidth/4;
        float y = mHeight/8;
        float side = 20;

        String text = "";

        for(int i = 0; i < listCountries.size(); i++){

            mFigurePaint.setColor(Color.parseColor(listCountries.get(i).getColor()));
            canvas.drawRect(x-side,y-side,x+side,y+side,mFigurePaint);

            text = listCountries.get(i).getName();
            canvas.drawText(text, 0, text.length(), x+120, y+10, mTextPaint);

            y+=60;
        }
    }
}
