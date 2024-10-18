package io.file;

import java.io.File;
import java.io.IOException;

// 옛날 방식 파일 경로
public class OldFilePath {
    public static void main(String[] args) throws IOException {
        File file = new File("temp/..");
        System.out.println("path = " + file.getPath());

        //절대경로
        System.out.println("Absolute Path = " + file.getAbsolutePath());

        //정규경로
        System.out.println("Canonical Path = " + file.getCanonicalPath());

        // 해당 경로 파일 및 디렉토리 목록
        File[] files = file.listFiles();
        for (File f : files) {
            System.out.println((f.isFile() ? "F" : "D") + " | " + f.getName());
        }


    }
}
