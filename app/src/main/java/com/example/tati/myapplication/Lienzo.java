package com.example.tati.myapplication;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class Lienzo extends View {

    private Path drawPath;//GUARDAR TRAZO PARA MOSTRARLO EN PANTALLA (guarda cada posicion por la que se arrastra el dedo)
    private Paint drawPaint,canvasPaint;//CONFIGUURACION DEL PINCEL PARA PINTAR formato del pincel
    private int paintColor= Color.BLUE;//COLOR INICIAL POR DEFECTO
    private Canvas drawCanvas;//OBJETO EN EL QUE SE VA A PINTAR ES DECIR EL FONDO
    private Bitmap canvasBitmap;

    public Lienzo(Context context, AttributeSet attrs){
        super(context, attrs);
        inicializadorDrawing();
    }

    private  void inicializadorDrawing(){
        drawPath=new Path();
        drawPaint=new Paint();
        drawPaint.setColor(paintColor);
        drawPaint.setAntiAlias(true);
        drawPaint.setStrokeWidth(30);//ancho
        drawPaint.setStyle(Paint.Style.STROKE);//estylo borde
        drawPaint.setStrokeJoin(Paint.Join.ROUND);
        drawPaint.setStrokeCap(Paint.Cap.ROUND);
        canvasPaint = new Paint();//objeto co en el que se va a pintar al cual le pasamos un parametro que permite pintar mas difuminado
    }

    public int getPaintColor() {
        return paintColor;
    }

    public void setPaintColor(int paintColor) {
        this.paintColor = paintColor;
        drawPaint.setColor(this.paintColor);
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawBitmap(canvasBitmap,0,0,canvasPaint);//ponemos en memoria el dibujo
        canvas.drawPath(drawPath,drawPaint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {//se ejecutara cada vez que ocurra un evento tactil
        float touchX=event.getX(),touchY=event.getY();//guardamos las coortdenadas del dedo
        //Ahora dependiendo del tipo de  evento tactil que  haya generado el usuario
        switch (event.getAction()){
            case MotionEvent.ACTION_MOVE://el dedo se mueve por la pantalla
                drawPath.lineTo(touchX,touchY);

                break;
            case MotionEvent.ACTION_DOWN://el dedo toca la pantalla
                drawPath.moveTo(touchX,touchY);
                break;
            case  MotionEvent.ACTION_UP://el dedo deja de tocar la pantalla
                drawPath.lineTo(touchX,touchY);
                drawCanvas.drawPath(drawPath,drawPaint);//se le asigna el path
                // al canvas para dibujar el camino o recorrido que ha seguido
                //el dedo del usuario

                drawPath.reset();//se vacia el path
                break;
            default:return false;
        }
        invalidate();
        return true;
    }

    @Override //tamaño asignado a la zona de dibujo
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        canvasBitmap=Bitmap.createBitmap(w,h,Bitmap.Config.ARGB_8888);//creamos un bitmap con los datos de la vista asignados
        drawCanvas=new Canvas(canvasBitmap);
    }

}
