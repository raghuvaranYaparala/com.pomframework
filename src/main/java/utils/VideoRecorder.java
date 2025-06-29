/*import java.io.File;

import org.monte.media.Format;
import org.monte.media.FormatKeys;
import org.monte.screenrecorder.ScreenRecorder;

public class VideoRecorder {
    private static ScreenRecorder screenRecorder;

    public static void startRecording(String testName) throws Exception {
        File file = new File("videos/");
        screenRecorder = new ScreenRecorder(GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration(),
                file, new Format(FormatKeys.MediaTypeKey, FormatKeys.MediaType.FILE,
                FormatKeys.MimeTypeKey, Registry.getInstance().getMimeType(FormatKeys.MimeTypeKey)),
                new Format(FormatKeys.MediaTypeKey, FormatKeys.MediaType.VIDEO, FormatKeys.EncodingKey, "black",
                FormatKeys.CompressorNameKey, "black"), null);
        screenRecorder.start();
    }

    public static void stopRecording() throws Exception {
        screenRecorder.stop();
    }
}*/
