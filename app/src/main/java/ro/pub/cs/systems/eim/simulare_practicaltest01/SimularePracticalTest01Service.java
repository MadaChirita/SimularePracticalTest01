package ro.pub.cs.systems.eim.simulare_practicaltest01;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;


public class SimularePracticalTest01Service extends Service {

    ProcessingThread processingThread = null;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        int firstNumber = intent.getIntExtra("firstNumber", -1);
        int secondNumber = intent.getIntExtra("secondNumber", -1);
        processingThread = new ProcessingThread(this, firstNumber, secondNumber);
        processingThread.start();
        return Service.START_REDELIVER_INTENT;
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        processingThread.stopThread();
    }
}