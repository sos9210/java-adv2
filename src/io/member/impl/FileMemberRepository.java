package io.member.impl;

import io.member.Member;
import io.member.MemberRepository;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import static java.nio.charset.StandardCharsets.*;

public class FileMemberRepository implements MemberRepository {

    private static final String FILE_PATH = "temp/members-txt.dat";
    private static final String DELIMITER = ",";

    @Override
    public void add(Member member) {
        //append:true 파일내용을 덮어씌우지 않고 append한다.
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH, UTF_8, true))){
            bw.write(member.getId() + DELIMITER + member.getName() + DELIMITER + member.getAge());
            bw.newLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<Member> findAll() {
        List<Member> members = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH, UTF_8))) {
            String line;
            while ((line = br.readLine()) != null) {
                // id1, name1, 30
                String[] memberData = line.split(DELIMITER);
                members.add(new Member(memberData[0],memberData[1],Integer.parseInt(memberData[2])));
            }
            return members;
        }catch (FileNotFoundException e) {
            return new ArrayList<>();
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
