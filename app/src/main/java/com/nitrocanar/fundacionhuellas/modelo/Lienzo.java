package com.nitrocanar.fundacionhuellas.modelo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Xfermode;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.EventLog;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;


public class Lienzo extends View {

    private Path drawPath;
    private Paint drawPaint,canvasPaint;
    private int paintColor= 0xFF000000;
    private Canvas drawCanvas;
    private Bitmap canvasBitmap;
    float lapizTamanio;
    public static boolean borrador = false;



    private Context context;

    public Lienzo(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        setupDrawing();
    }

    private void setupDrawing(){
        drawPath = new Path();
        drawPaint = new Paint();
        drawPaint.setColor(paintColor);
        drawPaint.setAntiAlias(true);
        lapizTamanio = 10;
        drawPaint.setStrokeWidth(lapizTamanio);
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

    public void setLapiz(float nuevoTamanio){
        float pixel = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                nuevoTamanio, getResources().getDisplayMetrics());
        lapizTamanio = pixel;
        drawPaint.setStrokeWidth(lapizTamanio);

    }

    //set borrado
    public void  setBorrado(boolean estadoBorrador){
        borrador = estadoBorrador;
        if (borrador) drawPaint.setColor(Color.WHITE);
        //if (borrador) drawPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        //else drawPaint.setXfermode(null);
        else drawPaint.setColor(paintColor);
    }

    public void clear(boolean estado){

        if (estado) drawPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        else drawPaint.setXfermode(null);

    }
}
