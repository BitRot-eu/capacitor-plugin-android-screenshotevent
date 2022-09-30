package app.blindmate.plugins.screenshot;

import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.util.Log;

import androidx.annotation.Nullable;

public class ScreenshotEvent extends ContentObserver {

    public ScreenshotEvent(Handler handler) {
        super(handler);
    }

    @Override
    public void onChange(boolean selfChange, @Nullable Uri uri) {
        super.onChange(selfChange, uri);
    }

    public String echo(String value) {
        Log.i("Echo", value);
        return value;
    }

}
