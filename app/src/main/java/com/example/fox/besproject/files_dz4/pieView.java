package com.example.fox.besproject.files_dz4;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

public class pieView extends View {
    private RectF rectF;
    private Paint paintClock;

    public pieView(Context context) {
        super(context);
        init();
    }

    public pieView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public pieView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public pieView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        rectF = new RectF();

        paintClock = new Paint();
        paintClock.setColor(Color.rgb(166, 137, 101));
        paintClock.setAntiAlias(true); // сглаживание углов
    }
}
