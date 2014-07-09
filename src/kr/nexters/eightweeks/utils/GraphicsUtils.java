package kr.nexters.eightweeks.utils;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;

public class GraphicsUtils {

    public static Bitmap getCroppedBitmap(Bitmap bitmap) {
    	Bitmap output = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
    	Canvas canvas = new Canvas(output);

    	final Paint paint = new Paint();
    	final Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());

    	paint.setAntiAlias(true);
    	paint.setFilterBitmap(true);
    	paint.setDither(true);
    	canvas.drawARGB(0, 0, 0, 0);
    	paint.setColor(Color.parseColor("#BAB399"));
    	canvas.drawCircle(bitmap.getWidth() / 2 + 0.7f, bitmap.getHeight() / 2 + 0.7f, bitmap.getWidth() / 2 + 0.1f, paint);
    	paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    	canvas.drawBitmap(bitmap, rect, rect, paint);

    	return output;
    }
}
