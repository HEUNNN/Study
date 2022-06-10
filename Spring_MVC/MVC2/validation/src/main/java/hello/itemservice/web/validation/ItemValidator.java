package hello.itemservice.web.validation;

import hello.itemservice.domain.item.Item;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ItemValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        // 파라미터로 넘어오는 클래스가 Item 지원이 되는지 판단
        // item == clazz
        // clazz가 item의 자식이여도 supports 메서드 통과
        return Item.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) { // 실제로 validate하는 메서드
        Item item = (Item) target; // type casting
        // Errors는 BindingResult의 부모클래스이다. 다형성 덕분에 BindingResult를 Errors가 받아서 사용할 수 있다.

        // 검증 로직 → 필드 단위 에러
        if (!StringUtils.hasText(item.getItemName())) {
            errors.rejectValue("itemName", "required");
            // bindingResult의 rejectValue를 사용함으로써 얻을 수 있는 messageCodes(검증 해야할 객체와 객체의 이름은 bindingResult에서 이미 알고 있다.)
            // required.item.itemName, required.itemName, required.java.lang.String, required
        }

        if (item.getPrice() == null || item.getPrice() < 1000 || item.getPrice() > 1000000) {
            errors.rejectValue("price", "range", new Object[]{1000, 1000000}, null);
        }

        if (item.getQuantity() == null || item.getQuantity() >= 9999) {
            errors.rejectValue("quantity", "max", new Object[]{9999}, null);
        }

        // 특정 필드가 아닌 복합 룰 검증 → 필드 단위 에러 X
        if (item.getPrice() != null && item.getQuantity() != null) {
            int resultPrice = item.getPrice() * item.getQuantity();
            if (resultPrice < 10000) {
                errors.reject("totalPriceMin", new Object[]{10000, resultPrice}, null);
            }
        }

    }
}
