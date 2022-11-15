package com.example.lab_0006;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class TituloView extends View {

    private String text;
    private Paint mTextPaint;

    public TituloView(Context context, @Nullable AttributeSet attrs) {
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
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        text = "Tasa de Natalidad";
        canvas.drawText(text, 0,text.length(),500,50,mTextPaint);
    }
}
