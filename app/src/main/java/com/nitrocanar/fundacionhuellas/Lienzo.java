package com.nitrocanar.fundacionhuellas;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;


public class Lienzo extends View {

    private Path drawPath;
    private Paint drawPaint,canvasPaint;
    private int paintColor= 0xFF000000;

    private Canvas drawCanvas;
    private Bitmap canvasBitmap;




    public Lienzo(Context context, AttributeSet attrs) {
        super(context, attrs);
        setupDrawing();
    }

    private void setupDrawing(){
        drawPath = new Path();
        drawPaint = new Paint();
        drawPaint.setColor(paintColor);
        drawPaint.setAntiAlias(true);
        drawPaint.setStrokeWidth(10);
        drawPaint.setStyle(Paint.Style.STROKE);
        drawPaint.setStrokeJoin(Paint.Join.ROUND);
        drawPaint.setStrokeCap(Paint.Cap.ROUND);

        canvasPaint = new Paint(Paint.DITHER_FLAG);
    }

    @Override
    public boolean onTouchEvent(MotionEvent e) {
        float x = e.getX();
        float y = e.getY();

        switch (e.getAction()){
            case MotionEvent.ACTION_DOWN:
                drawPath.moveTo(x,y);
                break;

            case MotionEvent.ACTION_MOVE:
                drawPath.lineTo(x,y);
                break;

            case MotionEvent.ACTION_UP:
                drawPath.lineTo(x,y);
                drawCanvas.drawPath(drawPath,drawPaint);
                drawPath.reset();
                break;
        }
        //repintar
        invalidate();
        return true;
    }

    //pinta la vista sera llamada desde el OnTouchEvent
    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawBitmap(canvasBitmap,0,0,canvasPaint);
        canvas.drawPath(drawPath,drawPaint);
    }

    //tamaño asiganado a la vista

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        canvasBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        drawCanvas = new Canvas(canvasBitmap);
    }
}
