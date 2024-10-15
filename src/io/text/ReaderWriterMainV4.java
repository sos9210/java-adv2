package io.text;

import java.io.*;

import static io.text.TextConst.FILE_NAME;
import static java.nio.charset.StandardCharsets.UTF_8;

public class ReaderWriterMainV4 {
    private static final int BUFFER_SIZE = 8192;
    public static void main(String[] args) throws IOException {
        String writeString = "ABC\n가나다";
        System.out.println("== write String ==");
        System.out.println(writeString);

        // 파일에 쓰기
        FileWriter fw = new FileWriter(FILE_NAME, UTF_8);
        BufferedWriter bw = new BufferedWriter(fw, BUFFER_SIZE);
        bw.write(writeString);
        bw.close();

        // 파일에서 읽기
        StringBuilder content = new StringBuilder();
        FileReader fr = new FileReader(FILE_NAME, UTF_8);
        BufferedReader br = new BufferedReader(fr, BUFFER_SIZE);


        // 문자열을 한줄씩 읽는다.
        String line;
        while ((line = br.readLine()) != null) {    // 파일의 끝이면 NULL
            content.append(line).append("\n");
        }
//        int ch;
//        while ((ch = br.read()) != -1) {
//            content.append((char) ch);
//        }
        br.close();
        System.out.println("== Read String ==");
        System.out.println(content);
    }
}
