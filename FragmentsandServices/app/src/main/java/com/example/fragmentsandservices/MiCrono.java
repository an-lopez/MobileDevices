package com.example.fragmentsandservices;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;

import java.util.Timer;
import java.util.TimerTask;

public class MiCrono extends Service {
    private Timer timer = new Timer();
    private static final long INTERVALO_ACTUALIZACION = 10;
    public static Ejercicio4Activity UPDATE_LISTENER;
    private double n = 0;
    private Handler handler;

    public static void setUpdateListener(Ejercicio4Activity sta) {
        UPDATE_LISTENER = sta;
    }

    public MiCrono() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                UPDATE_LISTENER.refreshCrono(n);
            }
        };
        iniciarCronometro();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        pararCronometro();
    }



    private void iniciarCronometro() {
        timer.scheduleAtFixedRate(new TimerTask() {

            @Override
            public void run() {
                if(UPDATE_LISTENER.isCount()){
                    n += 0.01;
                }
                handler.sendEmptyMessage(0);
            }
        }, 0, INTERVALO_ACTUALIZACION);
    }

    private void pararCronometro() {
        if (timer != null)
            timer.cancel();
    }
}