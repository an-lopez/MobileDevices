package com.escom.canvasexample;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.View;

public class Canva2 extends View {

    private Paint paint;
    private int width;
    private int height;
    private int x0;
    private int y0;
    private Path path;

    public Canva2(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint = new Paint();
        path = new Path();
        width = getWidth();
        height = getHeight();
        x0 = width / 2;
        y0 = height / 2;

        paint.setColor(Color.WHITE);
        canvas.drawPaint(paint);

        paint.setColor(Color.BLACK);
        paint.setTextSize(20);
        canvas.drawText("0,0", x0 + 5, y0 + 20, paint);

        paint.setColor(Color.BLUE);
        canvas.drawLine(width / 2, 0, width / 2, height, paint);
        canvas.drawLine(0, height / 2, width, height / 2, paint);

        paint.setColor(Color.BLUE);
        canvas.drawText("senA", 20, 20, paint);
        paint.setColor(Color.RED);
        canvas.drawText("cosA", 20, 50, paint);

        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(2);
        paint.setAntiAlias(true);

        path = new Path();
        width = getMeasuredWidth();
        path.moveTo(0, 0);
        paint.setColor(Color.BLUE);
        for (int i = 1; i < width; i++)
            path.lineTo(i, (float) Math.sin(i / 100f) * (-200f));
        path.offset(-5, y0);
        canvas.drawPath(path, paint);

        path = new Path();
        path.moveTo(0, 0);
        paint.setColor(Color.RED);
        for(int i=1; i<width; i++)
            path.lineTo(i, (float) Math.cos(i / 50f) * (-400f));
        path.offset(-5, y0);
        canvas.drawPath(path, paint);
    }
}
