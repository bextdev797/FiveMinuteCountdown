package com.brandonang.fiveminutecountdown;

// Activities & Context
import android.app.Activity;
import android.content.Context;
import android.os.CountDownTimer;

// Runtimes and annotations
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.runtime.AndroidNonvisibleComponent;
import com.google.appinventor.components.runtime.ComponentContainer;

// Countdown imports
import com.google.appinventor.components.runtime.AndroidViewComponent;
import android.view.View;
import android.widget.TextView;
import android.widget.FrameLayout;

public class FiveMinuteCountdown extends AndroidNonvisibleComponent {

    private Activity activity;
    private Context context;
    private boolean isCountingDown;

    // Timer variables for 5 minutes and 10 minutes countdowns
    private CountDownTimer timer5Mins;
    private CountDownTimer timer10Mins;
    private CountDownTimer timer15Mins;

    public FiveMinuteCountdown(ComponentContainer container) {
        super(container.$form());
        this.context = container.$context();
    }

    @SimpleFunction(description = "Create 5 mins timer.")
    public void Create5MinsCountdown(AndroidViewComponent layout) {
        View view = layout.getView();
        TextView textView = new TextView(this.context);
        FrameLayout frameLayout = (FrameLayout) view;
        frameLayout.addView(textView);

        timer5Mins = new CountDownTimer(300000, 1000) {
            public void onTick(long millisFinish) {
                int minutes = (int) (millisFinish / 1000) / 60;
                int seconds = (int) (millisFinish / 1000) % 60;
                String timeFormatted = String.format("%02d:%02d", minutes, seconds);
                textView.setText(timeFormatted);
            }

            public void onFinish() {
                textView.setText("Timer's done");
            }
        }.start();
        isCountingDown = true;
    }

    @SimpleFunction(description = "Create 10 mins timer.")
    public void Create10MinsCountdown(AndroidViewComponent layout) {
        View view = layout.getView();
        TextView textView = new TextView(this.context);
        FrameLayout frameLayout = (FrameLayout) view;
        frameLayout.addView(textView);

        timer10Mins = new CountDownTimer(600000, 1000) {
            public void onTick(long millisFinish) {
                int minutes = (int) (millisFinish / 1000) / 60;
                int seconds = (int) (millisFinish / 1000) % 60;
                String timeFormatted = String.format("%02d:%02d", minutes, seconds);
                textView.setText(timeFormatted);
            }

            public void onFinish() {
                textView.setText("Timer's done");
            }
        }.start();
        isCountingDown = true;
    }

    @SimpleFunction(description = "Create 15 mins timer.")
    public void Create15MinsCountdown(AndroidViewComponent layout) {
        View view = layout.getView();
        TextView textView = new TextView(this.context);
        FrameLayout frameLayout = (FrameLayout) view;
        frameLayout.addView(textView);

        timer15Mins = new CountDownTimer(900000, 1000) {
            public void onTick(long millisFinish) {
                int minutes = (int) (millisFinish / 1000) / 60;
                int seconds = (int) (millisFinish / 1000) % 60;
                String timeFormatted = String.format("%02d:%02d", minutes, seconds);
                textView.setText(timeFormatted);
            }

            public void onFinish() {
                textView.setText("Timer's done");
            }
        }.start();
        isCountingDown = true;
    }

    @SimpleFunction(description = "Stop 5 mins timer.")
    public void Stop5MinsCountdown() {
        if (timer5Mins != null) {
            timer5Mins.cancel();
            isCountingDown = false;
        }
    }

    @SimpleFunction(description = "Stop 10 mins timer.")
    public void Stop10MinsCountdown() {
        if (timer10Mins != null) {
            timer10Mins.cancel();
            isCountingDown = false;
        }
    }

    @SimpleFunction(description = "Stop 15 mins timer.")
    public void Stop15MinsCountdown() {
        if (timer15Mins != null) {
            timer15Mins.cancel();
            isCountingDown = false;
        }
    }
}