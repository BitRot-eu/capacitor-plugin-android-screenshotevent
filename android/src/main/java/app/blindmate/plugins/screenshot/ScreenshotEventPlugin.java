package app.blindmate.plugins.screenshot;

import android.os.Handler;
import android.os.Looper;

import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;

@CapacitorPlugin(name = "ScreenshotEvent")
public class ScreenshotEventPlugin extends Plugin {

    private ScreenshotEvent implementation;

    @Override
    public void load() {
        execute(
                () -> {
                    implementation = new ScreenshotEvent(getActivity());
                    implementation.setScreenshotEventListener(this::onScreenshotEvent);
                }
        );
    }

    private void onScreenshotEvent(String event, int size) {
        JSObject ssData = new JSObject();
        ssData.put("screenshot", "captured");
        ssData.put("data1", event);
        ssData.put("data2", size);
        notifyListeners(event, ssData);
    }

    @Override
    protected void handleOnDestroy() {
        implementation.setScreenshotEventListener(null);
    }
    @PluginMethod
    public void echo(PluginCall call) {
        String value = call.getString("value");

        JSObject ret = new JSObject();
        ret.put("value", implementation.echo(value));
        call.resolve(ret);
    }
}
