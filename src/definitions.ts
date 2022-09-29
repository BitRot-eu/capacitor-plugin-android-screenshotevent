export interface ScreenshotEventPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
}
