package com.example.myapplication;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.View;

import android.support.v7.app.AppCompatActivity;
//import androidx.appcompat.app.AppCompatActivity;

// Second step pag 126 New java class Draw1.java
public class Draw1 extends AppCompatActivity {

    public double func(double ac, double bc, double cc, double x) {
        return ac * x * x + bc * x + cc;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new myview(this));

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int[] widhei = new int[]{
                size.x, size.y
        };
    }

    class myview extends View {
        public myview(Draw1 context) {
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            Paint paint = new Paint();
            Paint pline = new Paint();
            paint.setColor(Color.GREEN);

            pline.setColor(Color.BLUE);
            pline.setStrokeWidth (5);

            canvas.drawLine(50, 50, 200, 200, pline);
            canvas.drawCircle(200, 300, 20, paint);

            float y[] = new float[]{4, 7, 2, 9, 7, 10};
            paint.setColor(Color.BLACK);
            float xLeft = 300, yt = 400, xRight = 330, yb = 400;

            for (int i = 0; i < 6; i++)
                canvas.drawRect(xLeft + i * 40, yt - y[i] * 20, xRight + i * 40, yb, paint);
            paint.setTextSize(30f);
            canvas.drawText("4", 200, 50, paint);

            Point size = new Point();
            double y0 = size.x / 2.0 + 20;
            float yy0 = Float.valueOf(String.valueOf(y0));
            canvas.drawLine(0, yy0, size.x, yy0, pline);

            double a = -3, b = 8, minx = -3, maxx = 8;
            int nmx = 12, dL = 30, dR = 30;
            double udpx = (size.x - dL - dR) / (maxx - minx);
            double hx = (b - a) / (nmx - 1);
            double x0 = -a * udpx + dL;
            y0 = size.x / 2. + 20;
            yy0 = Float.valueOf(String.valueOf(y0));
            double[] xx = new double[nmx + 2];
            canvas.drawLine(0, yy0, 720, yy0, pline);
            // draw vertical line markers
            for (int i = 0; i < nmx; i++) {
                xx[i] = x0 + (a + (i) * hx) * udpx;
                float xf = Float.valueOf(String.valueOf(xx[i]));
                canvas.drawLine(xf, yy0 - 5, xf, yy0 + 5, pline);
            }

            paint.setTextSize(20f);
            paint.setColor(Color.BLACK);
            for (int i = 0; i < nmx; i++) {
                String tt = String.valueOf(a + i * hx);
                Float xf = Float.valueOf(String.valueOf(xx[i]));
                canvas.drawText(tt, xf - 20, yy0 + 30, paint);
            }

            int nvx = 40;
            y0 = size.x / 2. + 20;
            x0 = -a * udpx + dL;
            double ap = 1, bp = -8, cp = 12;
            double udpy = udpx;

            paint.setColor(Color.RED);
            hx = (b - a) / nvx;
            for (int i = 0; i < nvx + 1; i++) {
                double v = Double.parseDouble(String.valueOf(i));
                double xv = a + v * hx;
                float xf = Float.parseFloat(String.valueOf(x0 + xv * udpx));
                double fv = func(ap, bp, cp, xv);
                float yf = Float.parseFloat(String.valueOf(y0 + (-fv) * udpy));

                if (yf < size.x + 40 && yf > 0)
                    canvas.drawCircle(xf, yf, 7, paint);
            }

            double[] xp = new double[]{2, 9, 13};
            double[] yp = new double[]{5, 11, 2};

            double maxy;
            double miny;
            maxx=-1E+5; minx=1E+5; maxy=-1E+5; miny=1E+5;
            for (int i = 0; i < 3; i++) {
                if (yp[i] < miny)
                    miny = yp[i];
                if (yp[i] > maxy)
                    maxy = yp[i];
                if (xp[i] < minx)
                    minx = xp[i];
                if (xp[i] > maxx)
                    maxx = xp[i];
            }

            udpx = (size.x - dL - dR) / (maxx - minx);
            udpy = udpx;
            y0 = size.x / 2 + 20 + 600;
            x0 = -minx * udpx + dL;

            for (int i = 0; i < 3; i++) {
                double xv = x0 + (xp[i]) * udpx;
                float x1 = Float.parseFloat(String.valueOf(xv));
                float y1 = Float.parseFloat(String.valueOf(y0 + (-yp[i]) * udpy));
                paint.setColor(Color.GREEN);
                canvas.drawCircle(x1, y1, 16, paint);
            }

            float x1, x2, x3, y1, y2, y3;
            udpy = udpx;
            double xv = x0 + (xp[0]) * udpx;
            x1 = Float.parseFloat(String.valueOf(xv));
            y1 = Float.parseFloat(String.valueOf(y0 + (-yp[0]) * udpy));
            xv = x0 + (xp[1]) * udpx;
            x2 = Float.parseFloat(String.valueOf(xv));
            y2 = Float.parseFloat(String.valueOf(y0 + (-yp[1]) * udpy));
            xv = x0 + (xp[2]) * udpx;
            x3 = Float.parseFloat(String.valueOf(xv));
            y3 = Float.parseFloat(String.valueOf(y0 + (-yp[2]) * udpy));

            paint.setColor(Color.MAGENTA);
            canvas.drawLine(x1, y1, x2, y2, paint);
            canvas.drawLine(x2, y2, x3, y3, paint);
            canvas.drawLine(x3, y3, x1, y1, paint);

            double xc1 = (xp[0] + xp[1]) / 2;
            double yc1 = (yp[0] + yp[1]) / 2;
            double xc2 = (xp[2] + xp[1]) / 2;
            double yc2 = (yp[2] + yp[1]) / 2;

            double k1 = -1 / ((yp[1] - yp[0]) / (xp[1] - xp[0]));
            double k2 = -1 / ((yp[2] - yp[1]) / (xp[2] - xp[1]));
            double xc = (yc2 - yc1 + k1 * xc1 - k2 * xc2) / (k1 - k2);
            double yc = yc1 + k1 * (xc - xc1);

            float xxc = Float.valueOf(String.valueOf(xc * udpx + x0));
            float yyc = Float.valueOf(String.valueOf(-yc * udpy + y0));

            paint.setColor(Color.GREEN);
            canvas.drawCircle((float) xc, (float) yc, 12, paint);

            //double x = 0;
            double r = Math.sqrt((xxc - xp[0]) * (xxc - xp[0]) + (yyc - yp[0]) * (yyc - yp[0]));
            float R = Float.parseFloat(String.valueOf(r * udpx));
            xv = x0 + xxc * udpx;
            float xbce = Float.parseFloat(String.valueOf(xv));
            xv = y0 - yyc * udpy;
            float ybce = Float.parseFloat(String.valueOf(xv));
            paint.setColor(Color.BLUE);
            canvas.drawCircle(xbce, ybce, R, paint);
            paint.setColor(Color.WHITE);
            canvas.drawCircle(xbce, ybce, R - 2, paint);
        }
    }
}
