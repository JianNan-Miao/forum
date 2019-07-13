package com.cheer.util;

import java.io.*;

public class IOUtils {
    public static void writeToFile(InputStream in, String dest) {
        BufferedInputStream bin = null;
        BufferedOutputStream bout = null;
        try {
            bin = new BufferedInputStream(in);
            bout = new BufferedOutputStream(new FileOutputStream(dest));
            int length;
            byte[] bytes = new byte[1024];
            while ((length = bin.read(bytes)) != -1) {
                bout.write(bytes, 0, length);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bout != null) {
                    bout.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (bin != null) {
                    bin.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void copy(String src, String dest) {
        try {
            writeToFile(new FileInputStream(src), dest);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
