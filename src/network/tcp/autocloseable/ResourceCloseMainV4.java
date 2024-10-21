package network.tcp.autocloseable;

public class ResourceCloseMainV4 {
    // try-with-resources 는 예외발생시 자원정리 먼저하고 catch를 수행
    public static void main(String[] args) {
        try {
            logic();
        } catch (CallException e) {
            System.out.println("CallException 예외 처리");
            
            //자원을 닫을때 발생한 예외(부가예외)를 핵심예외 안에 suppressed 로 담아서 반환함
            Throwable[] suppressed = e.getSuppressed();
            for (Throwable throwable : suppressed) {
                System.out.println("SuppressedEx: " + throwable);
            }
            
            throw new RuntimeException(e);
        } catch (CloseException e) {
            System.out.println("CloseException 예외 처리");
            throw new RuntimeException(e);
        }
    }

    private static void logic() throws CallException, CloseException {
        try(ResourceV2 resourceV1 = new ResourceV2("resourceV1");
            ResourceV2 resourceV2 = new ResourceV2("resourceV2")
            ) {
            resourceV1.call();
            resourceV2.callEx();

        }catch (CallException e) {
            System.out.println("ex: " + e);
            throw e;
        }
    }


}
