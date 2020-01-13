package de.xrammit.insecurecode.model;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public final class PersonUtils {      // class not package-private, violates EXTEND-1
    public static File PROFILE_PICTURE_BASE_DIRECTORY = new File("profilePictures");    // non-final, violates MUTABLE-9

    public static void storeProfilePictureWithFilename(String filename, byte[] payload) {   // method not package-private, violates EXTEND-1
        File fullProfilePictureFilePath = new File(PROFILE_PICTURE_BASE_DIRECTORY, filename);
        if (fullProfilePictureFilePath.exists()) {
            throw new IllegalArgumentException("A file with the path " + fullProfilePictureFilePath.getAbsolutePath() + " does already exist.");    // violates CONFIDENTIAL-1
        }
        writeProfilePicturePayloadToFile(fullProfilePictureFilePath, payload);
    }

    static void writeProfilePicturePayloadToFile(File targetFile, byte[] payload) {     // method not private, violates EXTEND-1
        try {
            // FileOutputStream is not closed, violates DOS-2
            FileOutputStream out = new FileOutputStream(targetFile);
            for (byte b : payload) {
                out.write(b);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
