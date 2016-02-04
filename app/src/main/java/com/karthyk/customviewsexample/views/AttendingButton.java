package com.karthyk.customviewsexample.views;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

public class AttendingButton extends Drawable {

  Paint paint;
  public AttendingButton(int color) {
    paint = new Paint();
    paint.setColor(color);
    paint.setStyle(Paint.Style.STROKE);
    paint.setFlags(Paint.ANTI_ALIAS_FLAG);
    paint.setStrokeWidth(8f);
  }
  @Override public void draw(Canvas canvas) {
    RectF rect = new RectF(getBounds());
    canvas.drawCircle(195, 50, 46, paint);
  }

  @Override public void setAlpha(int alpha) {
    paint.setAlpha(alpha);
  }

  @Override public void setColorFilter(ColorFilter colorFilter) {
    paint.setColorFilter(colorFilter);
  }

  @Override public int getOpacity() {
    return PixelFormat.TRANSLUCENT;
  }
}
