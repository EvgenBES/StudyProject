package com.example.fox.besproject;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.ReplaySubject;

public class Dz8Activity extends FragmentActivity {
    int numberView = 0;

    TextView textNumberView;
    Toolbar myToolbar;

    public ReplaySubject<Integer> subject = ReplaySubject.createWithSize(100);
    Disposable disposable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTitle("Нажми сюда..");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dz8);

        textNumberView = findViewById(R.id.textNumberView);

        myToolbar = findViewById(R.id.toolbar_actionbar);
        myToolbar.setTitle("Нажми сюда..");
        myToolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                subject.onNext(numberView++);
                Log.e("AAQQ", "CLICK TITLE");
            }
        });

        observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    Observable<Long> observable = Observable
            .interval(1, TimeUnit.SECONDS)
            .filter(integer -> integer % 2 == 0);


    Observer<Long> observer = new Observer<Long>() {
        @Override
        public void onSubscribe(Disposable d) {
            disposable = d;
        }

        @Override
        public void onNext(Long s) {
            numberView += 2;
            textNumberView.setText("" + numberView);
        }

        @Override
        public void onError(Throwable e) {

        }

        @Override
        public void onComplete() {

        }
    };

    @Override
    protected void onStop() {
        super.onStop();
        subject.onComplete();
        if (disposable != null && !disposable.isDisposed()) {
            disposable.dispose();
        }
        Log.e("AAQQ", "onStop: " + numberView);
    }
}
