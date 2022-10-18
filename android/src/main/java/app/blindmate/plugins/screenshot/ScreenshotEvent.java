package app.blindmate.plugins.screenshot;

import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

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
    }

    public String echo(String value) {
        Log.i("Echo", value);
        return value;
    }

}
