package hello.core.lifecycle;

public class NetworkClient {
    private String url;

    public NetworkClient() {
        System.out.println("생성자 호출, url = " + url);
        connect();
        call("초기화 연결 메시지");

    }

    public void setUrl(String url) {
        this.url = url;
    }

    // 서비스 시작시 호출되는 connect() method
    public void connect() {
        System.out.println("connect: " + url);
    }

    // 서비스 시작 후 연결이 된 상태에서 call -> 연결한 서버에 메시지를 던질 수 있다.
    public void call(String msg) {
        System.out.println("call: " + url + ", message: " + msg);
    }

    // 서비스 종료시 호출되는 disconnect() method
    public void disconnect() {
        System.out.println("disconnect: " + url);
    }
}
