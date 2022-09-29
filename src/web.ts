import { WebPlugin } from '@capacitor/core';

import type { ScreenshotEventPlugin } from './definitions';

export class ScreenshotEventWeb
  extends WebPlugin
  implements ScreenshotEventPlugin
{
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
}
