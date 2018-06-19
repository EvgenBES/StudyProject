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
import android.widget.ImageView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ClockView extends View {
    private RectF rectF;
    private Paint paintClock;
    private Paint paintClockBorder;
    private Paint paintLineTime;
    private Paint paintText;
    private Paint paintLineHM;

    Calendar c = Calendar.getInstance();


      public ClockView(Context context) {
        super(context);
        init();

    }

    public ClockView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ClockView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public ClockView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }


    private void init() {
        rectF = new RectF();

        paintClock = new Paint();
        paintClock.setColor(Color.rgb(166, 137, 101));
        paintClock.setAntiAlias(true); // сглаживание углов

        paintClockBorder = new Paint();
        paintClockBorder.setColor(Color.rgb(122, 100, 74));
        paintClockBorder.setAntiAlias(true); // сглаживание углов

        paintLineTime = new Paint();
        paintLineTime.setStrokeWidth(6); //толщина линии
        paintLineTime.setColor(Color.rgb(156, 112, 9));
        paintLineTime.setAntiAlias(true); // сглаживание углов

        paintText = new Paint();
        paintText.setTextSize(18);
        paintText.setColor(Color.rgb(51, 51, 51));
        paintText.setAntiAlias(true); // сглаживание углов

        paintLineHM = new Paint();
        paintLineHM.setColor(Color.rgb(255, 255, 255));
        paintLineHM.setAntiAlias(true); // сглаживание углов

    }



    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


        canvas.drawRect(rectF, paintClockBorder);
        canvas.drawCircle(getWidth() / 2, getHeight() /  2, Math.min(getWidth(), getHeight() /  2f), paintClockBorder); // нарисовали бордера

        canvas.drawRect(rectF, paintClock);
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, Math.min(getWidth(), getHeight() / 2.1f), paintClock); // нарисовали круг


        //делаем разметку часов 3-6-9-12ч
        for (float i = 0; i <= 360; i = i + 90) {
            canvas.drawLine(getWidth() / 2, getHeight() / 10, getWidth() / 2, 7, paintLineTime);
            canvas.rotate(i, getWidth() / 2, getHeight() / 2);
        }


//      разметка минут 5-10/20-25/35-40/50-55
        paintLineTime.setStrokeWidth(3); // толщина минутной линии
        for (float i = 0; i < 4; i++) {
            for (float b = 0; b < 2; b++) {
                canvas.rotate(30, getWidth() / 2, getHeight() / 2);
                canvas.drawLine(getWidth() / 2, getHeight() / 20, getWidth() / 2, 7, paintLineTime);
            }
            canvas.rotate(30, getWidth() / 2, getHeight() / 2);
        }


        //разметка текста часов
        canvas.rotate(180, getWidth() / 2, getHeight() / 2);
        canvas.drawText("12",getWidth()/2.12f, getHeight() /6 ,paintText);
        canvas.drawText("6",getWidth()/2.06f, getHeight() /1.13f ,paintText);
        canvas.drawText("3",getWidth()/1.40f, getHeight() /1.92f ,paintText);
        canvas.drawText("9",getWidth()/4f, getHeight() /1.9f ,paintText);



        SimpleDateFormat dateformatM = new SimpleDateFormat("mm");
        String datetime = dateformatM.format(c.getTime());
        float timeM = Integer.parseInt(datetime)*6;

        SimpleDateFormat dateformatH = new SimpleDateFormat("HH");
        String datetimeH = dateformatH.format(c.getTime());
        float timeH = Integer.parseInt(datetimeH)*30+timeM/6*0.5f;



//Поворот часовой стрелки
        canvas.rotate(timeH, getWidth() / 2, getHeight() / 2);
//Часовая стрелка показывает на 12ч.
        paintLineHM.setStrokeWidth(4);
        canvas.drawLine(getWidth() / 2, getHeight() / 2, getWidth() / 2, getHeight() / 6, paintLineHM);

//Поворот минуткой стрелки
        canvas.rotate(-timeH, getWidth() / 2, getHeight() / 2);
        canvas.rotate(timeM, getWidth() / 2, getHeight() / 2);
//Минутная стрелка показывает на 12ч.
        paintLineHM.setStrokeWidth(2);
        canvas.drawLine(getWidth() / 2, getHeight() / 2, getWidth() / 2, getHeight() / 8, paintLineHM);

//Кнопка которая держит стрелки
        canvas.drawRect(rectF, paintLineHM);
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, Math.min(getWidth(), getHeight() / 40f), paintLineHM); // нарисовали круг

    }
}
