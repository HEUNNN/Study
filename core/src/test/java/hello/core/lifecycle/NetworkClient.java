package hello.core.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class NetworkClient implements InitializingBean, DisposableBean { // InitializingBean은 초기화 콜백을 위함이고, DisposableBean은 소멸전 콜백을 위한 인터페이스이다.

    private String url;

    public NetworkClient() {
        System.out.println("생성자 호출, url = " + url);
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

    @Override
    public void afterPropertiesSet() throws Exception { // 의존관계 주입이 끝나면 초기화 완료, 초기화 완료되면 호출
        System.out.println("NetworkClient.afterPropertiesSet");
        connect();
        call("초기화 연결 메시지");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("NetworkClient.destroy");
        disconnect();
    }
}
