package com.example.lab_0006.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CustomView extends View {

    private Rect mRectSquare;
    private Paint mPaintSquare;
    private Paint textPaint;
    private Paint linesPaint;

    //double [] datos = {5, 10, 2.5, 5, 8.2, 10, 6.1, 4.7, 6, 10,1.5,9,0.1};
    //11 datos
    private ArrayList<String> countryList;
    private ArrayList<Double> dataList;

    public CustomView(Context context) {
        super(context);

        init();
    }

    public CustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        init();
    }

    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void init(){

        mRectSquare = new Rect();
        mPaintSquare = new Paint(Paint.ANTI_ALIAS_FLAG);
        textPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        linesPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        dataList = new ArrayList<>();
        countryList = new ArrayList<>();
    }

    @Override
    protected void onDraw(Canvas canvas) {

        mPaintSquare.setColor(Color.BLUE);
        textPaint.setColor(Color.BLACK);
        linesPaint.setColor(Color.MAGENTA);

        int totalValues = dataList.size();
        double maxValue = findMaxValue();
        double barWidth = (getWidth() * 0.45) / (totalValues + 1);
        //double spacing = barWidth/totalValues;
        double screenHeight = getMeasuredHeight() * 0.8;
        int granularity = calculateMaxValueOnXAxis(maxValue, totalValues);

        int x = 125;
        int y = (int) (screenHeight *0.9);
        float paddingBars;

        //Drawing Lines
        int startX = 100, stopX = getMeasuredWidth()-50;
        int position = y, startY, stopY;

        int startAxisPosition = 50;
        int finalAxisPosition = y;
        int xAxisValues = 0;

        for(int i = 0; i < totalValues; i++){
            startY = stopY = position;
            canvas.drawText(String.valueOf(xAxisValues), (float) startAxisPosition, (float) finalAxisPosition, textPaint);
            canvas.drawLine(startX, startY, stopX, stopY, linesPaint);
            finalAxisPosition = position -= y/totalValues;
            xAxisValues += granularity/totalValues;
        }

        //Drawing Bar Char
        for(int i = 0; i < totalValues; i++ ){
            mRectSquare.left = x;
            mRectSquare.top = y;
            mRectSquare.right = (int)(mRectSquare.left + barWidth);
            double barHeight = -((dataList.get(i) * y) / granularity);
            mRectSquare.bottom = (int) (mRectSquare.top + barHeight);
            x += 2* barWidth;
            paddingBars = (float) (x-1.4* barWidth);
            //paddingBars = (float) (x-(barWidth/2));
            //canvas.drawText(paises.get(i), (float) (paddingBars), (float) (screenHeight), textPaint);
            canvas.drawRect(mRectSquare, mPaintSquare);
            canvas.rotate((float) -90, (float) (paddingBars), (float) (screenHeight));
            canvas.drawText(countryList.get(i), (float) (paddingBars), (float) (screenHeight), textPaint);
            canvas.rotate(90F, (float) (paddingBars), (float) (screenHeight));
        }
    }

    protected double findMaxValue(){
        double maxValue=0;
        for(int i = 0; i < dataList.size(); i++)
            maxValue = (maxValue < dataList.get(i)) ? dataList.get(i) : maxValue;

        return maxValue;
    }

    protected int calculateMaxValueOnXAxis(double maxValue, int totalValues){
        return (int)(maxValue + (totalValues - (maxValue % totalValues)));
    }

    public void addData(String country, double value){
        countryList.add(country);
        dataList.add(value);
    }
}
