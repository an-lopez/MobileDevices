package com.escom.canvasexample;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.view.View;

public class Canva extends View {
    private Paint paint;
    private int width;
    private int height;

    public Canva(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint = new Paint();
        width = canvas.getWidth();
        height = canvas.getHeight();

        paint.setColor(Color.WHITE);
        canvas.drawPaint(paint);

        paint.setColor(Color.BLACK);
        paint.setTextSize(20);

        canvas.drawText("X0 = " + width/2 + ", Y0 = "+height/2, width/2 + 20, height/2 -20, paint);

        paint.setColor(Color.BLUE);
        canvas.drawLine(width/2, 0, width/2, height, paint);
        canvas.drawLine(0, height/2, width, height/2, paint);

        paint.setTextAlign(Paint.Align.LEFT);
        paint.setTypeface(Typeface.SANS_SERIF);
        canvas.drawText("Eje X", width -60, height/2 -10, paint);

        paint.setTextAlign(Paint.Align.CENTER);
        paint.setTypeface(Typeface.MONOSPACE);
        canvas.drawText("Eje Y", width/2 + 30, 20, paint);

        paint.setColor(Color.argb(100, 200, 100, 100));

        canvas.drawCircle(width/2-300, height/2+250, 200, paint);

        canvas.drawRect(new Rect(20, 40, 400, 420), paint);

        canvas.drawRoundRect(new RectF(width/2+20, 40, width/2+400, 420), 20, 20, paint);

        canvas.drawArc(new RectF(width/2+20, height/2+40, width/2+400, height/2+420), 0F, 90F, true, paint);

    }
}
