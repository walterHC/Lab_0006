package com.example.lab_0006;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class PieChart extends View {
    private float mWidth;                   // Custom view width.
    private float mHeight;                  // Custom view height.
    private Paint mTextPaint;               // For text in the view.
    private Paint mFigurePaint;             // For arc and circle in the view.
    private float mRadius;                  // Radius of the circle.

    ArrayList<Country> listCountries;

    private final float[] mTempResult = new float[2];

    public PieChart(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        mFigurePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mTextPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mTextPaint.setColor(Color.WHITE);
        mTextPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        mTextPaint.setTextAlign(Paint.Align.CENTER);
        mTextPaint.setTextSize(35f);

        listCountries = Country.countries;

        // TODO: Set up onClick listener for this view.

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        // Calculate the radius from the width and height.
        mWidth = w;
        mHeight = h;
        mRadius = (float) (Math.min(mWidth, mHeight) / 2 * 0.9);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        float cx = mWidth/2;
        float cy = mHeight/2;
        float startAngle = 270;
        float sweepAngle = 0;

        float totalBirthRate = calculateTotalBirthRate(listCountries);
        int percentage, accumulatedPercentage = 0;
        float labelRadius = mRadius - 50;
        String text = "";

        for(int i = 0; i < listCountries.size(); i++){

            //Drawing arcs
            sweepAngle = calculateSweepAngle(listCountries.get(i), totalBirthRate);
            mFigurePaint.setColor(Color.parseColor(listCountries.get(i).getColor()));
            canvas.drawArc(cx-mRadius,cy-mRadius,cx+mRadius,cy+mRadius,startAngle,sweepAngle,true,mFigurePaint);

            //Drawing text percentage
            float[] xyData = computeXYForPosition(startAngle,sweepAngle, labelRadius);
            float x = xyData[0];
            float y = xyData[1];
            percentage = calculatePercentage(listCountries.get(i), totalBirthRate, accumulatedPercentage);
            text = percentage + "%";
            canvas.drawText(text, 0, text.length(), x, y, mTextPaint);

            startAngle += sweepAngle;
            accumulatedPercentage += percentage;

        }

        //Drawing central circle
        mFigurePaint.setColor(Color.parseColor("#dcdcdc"));
        canvas.drawCircle(cx, cy, mRadius-150, mFigurePaint);
    }

    private float[] computeXYForPosition(float startAngle, float sweepAngle, float radius) {
        float[] result = mTempResult;

        double initialAngle = (startAngle + sweepAngle/2) * Math.PI/180;
        double quadrantAngle;
        double angle = 0.0;
        double cosx, senx = 0.0;

        if(initialAngle > 2 * Math.PI){
            quadrantAngle = 2 * Math.PI;
            angle = initialAngle - quadrantAngle;

            cosx = Math.cos(angle);
            senx = Math.sin(angle);

        }else {
            quadrantAngle = Math.PI * (3/2d);
            angle = initialAngle - quadrantAngle;

            cosx = Math.sin(angle);
            senx = -Math.cos(angle);
        }

        result[0] = (float) (radius * cosx + (mWidth / 2));
        result[1] = (float) (radius * senx + (mHeight / 2));

        return result;
    }

    private float calculateTotalBirthRate(ArrayList<Country> list) {
        float sum = 0;
        for (Country country: list) {
            sum += country.getBirthRate();
        }
        return sum;
    }

    private float calculateSweepAngle(Country country, float tbr) {
        return Math.round(country.getBirthRate() * 360 / tbr);

    }

    private int calculatePercentage(Country country, float tbr, int ap) {
        int angle = Math.round(country.getBirthRate() * 100 / tbr);
        int auxAngle = ap + angle;
        return (auxAngle > 100) ? angle - auxAngle % 100 : angle;

    }
}
