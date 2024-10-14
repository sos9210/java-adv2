package io.buffered;

import java.io.FileInputStream;
import java.io.IOException;

import static io.buffered.BufferedConst.FILE_NAME;

//1Byte씩 읽기때문에 속도가 느리다.
public class ReadFileV1 {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream(FILE_NAME);
        long startTime = System.currentTimeMillis();

        int fileSize = 0;
        int data;
        while ((data = fis.read()) != -1) {
            fileSize++;
        }
        fis.close();
        long endTime = System.currentTimeMillis();

        System.out.println("File created: " + FILE_NAME);
        System.out.println("File Size: " + (fileSize / 1024 / 1024) + "MB");
        // 10MB 파일 읽는데 대략 9초걸렸음.
        System.out.println("Time taken: " + (endTime - startTime) + "ms");
    }
}
