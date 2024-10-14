package io.buffered;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import static io.buffered.BufferedConst.*;

// 일반적으로 V3 를 사용(buffered클래스) 해도 무방하나 성능 최적화가 중요하다면 직접 버퍼를 구현해서 사용하자 (V2)
public class CreateFileV3 {
    public static void main(String[] args) throws IOException {
        // 기본스트림 :FileOutputStream
        FileOutputStream fos = new FileOutputStream(FILE_NAME);
        // 보조스트림 :BufferedOutputStream
        BufferedOutputStream bos = new BufferedOutputStream(fos,BUFFER_SIZE);

        //BufferedOutputStream 에 write할때 BUFFER_SIZE 만큼 byte가 가득차면 버퍼를 내보낸다.
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < FILE_SIZE; i++) {
            bos.write(1);
        }
        bos.close();
        long endTime = System.currentTimeMillis();

        System.out.println("File created: " + FILE_NAME);
        System.out.println("File Size: " + (FILE_SIZE / 1024 / 1024) + "MB");
        // 10MB 파일 만드는데 대략 52ms 걸렸음.
        System.out.println("Time taken: " + (endTime - startTime) + "ms");
    }
}
