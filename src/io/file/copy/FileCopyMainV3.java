package io.file.copy;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

// Files.copy(source,target, StandardCopyOption.REPLACE_EXISTING); 파일 복사 방법3
public class FileCopyMainV3 {

    public static void main(String[] args) throws IOException {
        long startTime = System.currentTimeMillis();

        Path source = Path.of("temp/copy.dat");
        Path target = Path.of("temp/copy_new.dat");

        Files.copy(source,target, StandardCopyOption.REPLACE_EXISTING);

        long endTime = System.currentTimeMillis();
        System.out.println("Time taken : " + (endTime - startTime) + "ms");
    }
}
