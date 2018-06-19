package com.example.fox.besproject.files_dz4;

import android.content.Context;
import android.graphics.Canvas;
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
    private Paint pieColor;
    private int [] procent = {5,10,25,75,75}; //вбиваем цифры и получаем пирожочек

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

        pieColor = new Paint();
        pieColor.setAntiAlias(true); // сглаживание углов
    }


    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        rectF.left = getWidth() * 0.1f;
        rectF.right = getWidth() - rectF.left;
        rectF.top = getHeight() * 0.1f;
        rectF.bottom = getHeight() - rectF.top;
    }


    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //считаю сумму что узнать какая она для 100%
        float x = 0;
        for (int i = 0; i <= procent.length-1; i++){
            x = x+procent[i];
        }

        float c = -90; //исходная точка откуда рисуем
        for (int i = 0; i <= procent.length-1; i++){

            int random_number = 1 + (int) (Math.random() * 255);
            int random_number2 = 1 + (int) (Math.random() * 255);
            int random_number3 = 1 + (int) (Math.random() * 255);
            pieColor.setColor(Color.rgb(random_number, random_number2, random_number3));

            float g = (((100/x)*procent[i])/100)*360; // сколько % круга рисовать
            canvas.drawArc(rectF, c, g, true, pieColor);
            c = c+g; //сдвигает точку от куда рисовать
        }
    }
}
