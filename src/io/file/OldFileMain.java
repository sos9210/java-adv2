package io.file;

import java.io.File;
import java.io.IOException;
import java.util.Date;

// 옛날 방식 파일 다루는 방법
public class OldFileMain {
    public static void main(String[] args) throws IOException {
        File file = new File("temp/example.txt");
        File directory = new File("temp/exampleDir");

        //1. 파일과 디렉토리 존재여부
        System.out.println("File exists : " + file.exists());

        //2. 새로운 파일 생성
        boolean created = file.createNewFile();
        System.out.println("File created : " + created);

        //3. 새로운 디렉토리 생성
        boolean dirCreated = directory.mkdir();
        System.out.println("Directory created : " + dirCreated);
        //4. 파일 또는 디렉토리 삭제
        //boolean delete = file.delete();
        //System.out.println("File deleted : " + delete);

        //5.파일인지 확인
        System.out.println("Is file : " + file.isFile());
        //6. 디렉토리인지 확인
        System.out.println("Is directory : " + directory.isDirectory());
        //7. 파일명 확인
        System.out.println("File Name : " + file.getName());
        //8. 파일사이즈 확인
        System.out.println("File Size : " + file.length());

        File newFile = new File("temp/example.txt");
        
        //파일의 이름변경 또는 위치 이동
        boolean renamed = file.renameTo(newFile);
        System.out.println("File renamed : " + renamed);
        
        //마지막 수정시간 반환
        long lastModified = newFile.lastModified();
        System.out.println("Last modified : " + new Date(lastModified));
    }
}
