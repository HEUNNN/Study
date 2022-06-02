package hello.servlet.web.frontcontroller;


import java.util.HashMap;
import java.util.Map;

public class ModelView {
    // Model을 직접 만들고 Controller부터 뷰의 논리이름을 받는 객체
    private String viewName; // View의 논리적 이름을 저장할 필드
    private Map<String, Object> model = new HashMap<>();

    public ModelView(String viewName) {
        this.viewName = viewName;
    }

    public String getViewName() {
        return viewName;
    }

    public void setViewName(String viewName) {
        this.viewName = viewName;
    }

    public Map<String, Object> getModel() {
        return model;
    }

    public void setModel(Map<String, Object> model) {
        this.model = model;
    }
}
