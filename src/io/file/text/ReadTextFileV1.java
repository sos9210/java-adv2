package io.file.text;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class ReadTextFileV1 {
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
        System.out.println(readString);

    }
}
