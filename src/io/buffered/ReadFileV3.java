package io.buffered;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

import static io.buffered.BufferedConst.BUFFER_SIZE;
import static io.buffered.BufferedConst.FILE_NAME;
// 일반적으로 V3 를 사용(buffered클래스) 해도 무방하나 성능 최적화가 중요하다면 직접 버퍼를 구현해서 사용하자 (V2)
public class ReadFileV3 {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream(FILE_NAME);
        BufferedInputStream bis = new BufferedInputStream(fis, BUFFER_SIZE);
        long startTime = System.currentTimeMillis();

        int fileSize = 0;
        int data;
        while ((data = bis.read()) != -1) {
            fileSize++;
        }
        bis.close();
        long endTime = System.currentTimeMillis();

        System.out.println("File created: " + FILE_NAME);
        System.out.println("File Size: " + (fileSize / 1024 / 1024) + "MB");
        // 10MB 파일 읽는데 대략 53ms 걸렸음.
        System.out.println("Time taken: " + (endTime - startTime) + "ms");
    }
}
