package com.example.lab_0006;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class Title extends View {
    private float mWidth;
    private float mHeight;
    private String text;
    private Paint mTextPaint;

    public Title(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        mTextPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mTextPaint.setColor(Color.BLACK);
        mTextPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        mTextPaint.setTextAlign(Paint.Align.CENTER);
        mTextPaint.setStrokeWidth(5);
        mTextPaint.setTextSize(70f);

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

        float x = mWidth / 2;
        float y = mHeight * 2 / 3;
        text = "Tasa de Natalidad";
        canvas.drawText(text, 0,text.length(),x,y,mTextPaint);
    }
}
