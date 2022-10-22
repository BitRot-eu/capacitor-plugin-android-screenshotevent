package app.blindmate.plugins.screenshot;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Handler;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class ScreenshotEvent {
    interface ScreenshotEventListener {
        void onScreenshotEvent(String event, int size);
    }

    private AppCompatActivity activity;

    @Nullable
    public ScreenshotEventListener getScreenshotEventListener() {
        return screenshotEventListener;
    }

    public void setScreenshotEventListener(@Nullable ScreenshotEventListener keyboardEventListener) {
        this.screenshotEventListener = keyboardEventListener;
    }

    @Nullable
    private ScreenshotEventListener screenshotEventListener;

    public ScreenshotEvent(AppCompatActivity activity) {
        this.activity = activity;

        final Handler h = new Handler();
        final int delay = 3000; //milliseconds
        final ActivityManager am = (ActivityManager) this.activity.getSystemService(Context.ACTIVITY_SERVICE);

        h.postDelayed(new Runnable(){
            public void run(){

                List<ActivityManager.RunningServiceInfo> rs=am.getRunningServices(200);

                for(ActivityManager.RunningServiceInfo ar:rs){
                    if(ar.process.equals("com.android.systemui:screenshot")){
                        Log.i("Screenshot", "captured");
                        if (screenshotEventListener != null) {
                            screenshotEventListener.onScreenshotEvent("foo", 1);
                        }
                    }
                }
                h.postDelayed(this, delay);
            }
        }, delay);
    }

    public String echo(String value) {
        Log.i("Echo", value);
        return value;
    }

}
