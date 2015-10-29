package vietnamworks.com.pal.services;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.alexbbb.uploadservice.AllCertificatesAndHostsTruster;
import com.alexbbb.uploadservice.MultipartUploadRequest;
import com.alexbbb.uploadservice.UploadService;

import vietnamworks.com.pal.R;
import vietnamworks.com.pal.activities.TimelineActivity;

/**
 * Created by duynk on 10/26/15.
 */
public class FileUploadService {
    public static void init() {
        AllCertificatesAndHostsTruster.apply();
        UploadService.NAMESPACE = "vietnamworks.com.pal";
    }

    public static void upload(final Context context, String id, String server, String filepath, String server_file_name) {
        final MultipartUploadRequest request = new MultipartUploadRequest(context, id, server);
        request.addFileToUpload(filepath,
                "parameter-name",
                server_file_name,
                "content-type");

        request.setMaxRetries(2);

        request.setNotificationConfig(R.mipmap.ic_launcher,
                "Upload audio file",
                "Uploading ...",
                "Upload successful",
                "Fail to upload audio",
                true);

        request.setNotificationClickIntent(new Intent(context, TimelineActivity.class));

        try {
            request.startUpload();

        } catch (Exception exc) {
            Log.e("AndroidUploadService", exc.getLocalizedMessage(), exc);
        }
    }
}
