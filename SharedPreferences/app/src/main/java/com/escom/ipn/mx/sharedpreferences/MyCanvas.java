package com.escom.ipn.mx.sharedpreferences;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

public class MyCanvas extends View {
    Paint paint;
    String path;

    public MyCanvas(Context context, String path) {
        super(context);
        paint = new Paint();
        this.path = path;
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        Bitmap bitMap = BitmapFactory.decodeFile(path);
        Rect rect = canvas.getClipBounds();
        Bitmap bm = Bitmap.createScaledBitmap(bitMap, rect.width(), rect.height(), true);

        canvas.drawBitmap(bm, 0, 0, paint);
    }
}
