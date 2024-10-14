package io.buffered;

import java.io.FileOutputStream;
import java.io.IOException;

import static io.buffered.BufferedConst.*;

//1Byte씩 전달하기때문에 속도가 느리다.
public class CreateFileV1 {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream(FILE_NAME);
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < FILE_SIZE; i++) {
            fos.write(1);
        }
        fos.close();
        long endTime = System.currentTimeMillis();

        System.out.println("File created: " + FILE_NAME);
        System.out.println("File Size: " + (FILE_SIZE / 1024 / 1024) + "MB");
        // 10MB 파일 만드는데 대략 17초걸렸음.
        System.out.println("Time taken: " + (endTime - startTime) + "ms");
    }
}
