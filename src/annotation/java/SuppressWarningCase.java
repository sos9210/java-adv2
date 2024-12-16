package annotation.java;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SuppressWarningCase {
    //사용되지 않는 변수 경고 억제
    @SuppressWarnings("unused")
    public void multipleWarnings() {
        int unusedVariable = 10;
    }

    //더이상 사용되지 않는 메서드 호출 경고 억제
    @SuppressWarnings("deprecation")
    public void deprecatedMethod() {
        Date date = new Date();
        int date1 = date.getDate();
    }

    //제네릭 타입 캐스팅 경고 억제
    @SuppressWarnings({"rawtypes","unchecked"})
    public void uncheckedCast() {
        List objects = new ArrayList<>();
        List<String> stringList = (List<String>)objects;
    }

    //모든 경고 억제
    @SuppressWarnings("all")
    public void suppressAllWarnings() {

        Date date = new Date();
        int date1 = date.getDate();
        List objects = new ArrayList<>();

        List<String> stringList = (List<String>)objects;
    }
}
