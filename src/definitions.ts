import type { PluginListenerHandle } from '@capacitor/core';
export interface ScreenshotEventPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;

  addListener(
    eventName: 'screenshot',
    listenerFunc: (orientation: { type: OrientationType }) => void,
  ): Promise<PluginListenerHandle> & PluginListenerHandle;
}
