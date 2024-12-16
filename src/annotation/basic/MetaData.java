package annotation.basic;

@AnnoMeta //타입에 적용
public class MetaData {

    //@AnnoMeta // 필드는 컴파일 에러
    private String id;

    @AnnoMeta //메서드적용
    public void call() {}

    public static void main(String[] args) throws NoSuchMethodException {
        AnnoMeta annotation1 = MetaData.class.getAnnotation(AnnoMeta.class);
        System.out.println("annotation1 = " + annotation1);

        AnnoMeta annotation2 = MetaData.class.getMethod("call").getAnnotation(AnnoMeta.class);
        System.out.println("annotation2 = " + annotation2);
    }
}
