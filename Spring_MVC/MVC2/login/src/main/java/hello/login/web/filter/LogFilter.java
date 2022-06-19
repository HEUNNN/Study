package hello.login.web.filter;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.UUID;

@Slf4j
public class LogFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("log filter init");
    }

    @Override
    public void destroy() {
        log.info("log filter destroy");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // logic을 넣는 부분

        log.info("log filter doFilter");

        HttpServletRequest httpRequest = (HttpServletRequest) request; // ServletRequest는 HttpServletRequest의 부모이다. 기능이 적기 때문에 casting 해준다.
        String requestURI = httpRequest.getRequestURI();

        String uuid = UUID.randomUUID().toString();

        try {
            log.info("REQUEST [{}][{}]", uuid, requestURI);
            chain.doFilter(request, response); // 여러 단의 필터를 사용할 수 있다. 따라서 다음 필터가 있을 수 있으니 불러줘야 한다. 다음 필터가 없으면 서블릿이 호출된다.
        } catch (Exception e) {
            throw e;
        } finally {
            log.info("RESPONSE [{}][{}]", uuid, requestURI);
        }

    }
}
