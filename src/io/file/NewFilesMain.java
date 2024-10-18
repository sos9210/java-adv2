package io.file;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

// 최신 방식 파일 다루는 방법
public class NewFilesMain {
    public static void main(String[] args) throws IOException {
        Path file = Path.of("temp/example.txt");
        Path directory = Path.of("temp/exampleDir");

        System.out.println("File exists : " + Files.exists(file));

        try {
            // 파일 생성
            Files.createFile(file);
            System.out.println("File Created");
        } catch (FileAlreadyExistsException e) {
            // 파일이 이미 존재함
            System.out.println(file + " File already exists");
        }

        try {
            // 디렉토리 생성
            Files.createDirectory(directory);
        } catch (FileAlreadyExistsException e) {
            // 디렉토리가 이미 존재함
            System.out.println(directory + " Directory already exists");
        }
        // 파일 삭제
        //Files.delete(file);
        //System.out.println("File deleted");

        // 파일인지 여부
        System.out.println("Is regular file : " + Files.isRegularFile(file));
        // 디렉토리인지 여부
        System.out.println("Is directory : " + Files.isDirectory(directory));
        // 파일명
        System.out.println("File name : " + file.getFileName());
        // 파일사이즈
        System.out.println("File size : " + Files.size(file) + "Bytes");

        // 파일이름변경
        Path newFile = Path.of("temp/newExample.txt");
        // 파일을 이동 ( file -> newFile)  StandardCopyOption.REPLACE_EXISTING ( 파일을 교체한다 )
        Files.move(file, newFile, StandardCopyOption.REPLACE_EXISTING);

        // 파일 최근 변경시간
        System.out.println("Last modified : " + Files.getLastModifiedTime(newFile));

        // 파일의 기본 속성들을 한번에 읽는다.
        BasicFileAttributes attrs = Files.readAttributes(newFile, BasicFileAttributes.class);
        System.out.println("======== Attributes ========");
        System.out.println("Creation Time : " + attrs.creationTime());
        System.out.println("Is Directory : " + attrs.isDirectory());
        System.out.println("Is RegularFile : " + attrs.isRegularFile());
        System.out.println("Is SymbolicLink : " + attrs.isSymbolicLink());
        System.out.println("Is Size: " + attrs.size());
    }
}
