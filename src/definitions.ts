import type { PluginListenerHandle } from '@capacitor/core';

export interface ScreenshotEvent { }
export type ScreenshotListener = (state: ScreenshotEvent) => void;


export interface ScreenshotEventPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;

  addListener(
    eventName: 'screenshot',
    listenerFunc: ScreenshotListener): Promise<PluginListenerHandle> & PluginListenerHandle;
}
