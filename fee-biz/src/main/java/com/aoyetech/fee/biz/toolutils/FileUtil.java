package com.aoyetech.fee.biz.toolutils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileUtil {
	
	private static File file;

    public static void writerFile(String fileName, String record) throws IOException {
        FileWriter fw = null;
        try {
            file = new File(Constant.FILE_PATH + "\\" + fileName);
            if (!file.exists()) {
                file.createNewFile();
            }
            fw = new FileWriter(file, true);
            fw.write(record);
            fw.flush();
        } catch (Exception e) {
            if (fw != null) fw.close();
        }
    }
}
