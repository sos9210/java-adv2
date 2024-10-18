package io.file.text;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

public class ReadTextFileV2 {
    private static final String PATH = "temp/hello2.txt";
    public static void main(String[] args) throws IOException {
        String writeString = "abc\n가나다";
        System.out.println("==== write String ====");
        Path path = Path.of(PATH);

        //파일에 쓰기
        Files.writeString(path, writeString, StandardCharsets.UTF_8);
        //파일에서 읽기
        String readString = Files.readString(path, StandardCharsets.UTF_8);
        System.out.println("==== read String ====");

        Stream<String> lines = Files.lines(path, StandardCharsets.UTF_8);
        lines.forEach(System.out::println);
/*
        //한줄씩 읽기
        List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
        for (int i = 0; i < lines.size(); i++) {
            System.out.println((i + 1)+ " : " + lines.get(i));
        }
 */
    }
}
