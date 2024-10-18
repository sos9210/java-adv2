package io.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

// 최신 파일 경로
public class NewFilesPath {
    public static void main(String[] args) throws IOException {
        Path path = Path.of("temp/..");
        System.out.println("path = " + path);

        // 절대경로
        System.out.println("Absolute Path = " + path.toAbsolutePath());

        // 정규경로
        System.out.println("Canonical Path = " + path.toRealPath());

        // 해당 경로 파일 및 디렉토리 목록
        Stream<Path> pathStream = Files.list(path);
        List<Path> list = pathStream.toList();
        pathStream.close();
        for (Path p : list) {
            System.out.println((Files.isRegularFile(p) ? "F" : "D") + " | " + p.getFileName());
        }

    }
}
