package reflection;

import reflection.data.BasicData;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

public class MethodV2 {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        //일반적인 메서드 호출
        BasicData basicData = new BasicData();
        basicData.call();

        //리플렉션을 사용한 메서드 호출
        Class<? extends BasicData> basicDataClass = basicData.getClass();
        String methodName = "hello";

        //메서드 이름을 변수로 변경할 수 있다.
        Method declaredMethod = basicDataClass.getDeclaredMethod(methodName, String.class);
        Object returnValue = declaredMethod.invoke(basicData, "hi");
        System.out.println("returnValue = " + returnValue);
    }
}
