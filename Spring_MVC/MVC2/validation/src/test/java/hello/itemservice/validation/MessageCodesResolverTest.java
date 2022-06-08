package hello.itemservice.validation;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.validation.DefaultMessageCodesResolver;
import org.springframework.validation.MessageCodesResolver;

import static org.assertj.core.api.Assertions.*;

public class MessageCodesResolverTest {

    MessageCodesResolver codesResolver = new DefaultMessageCodesResolver(); // MessageCodesResolver -> Interface, DefaultMessageCodesResolver -> implements (구현체)

    @Test
    void messageCodesResolverObject() {
        String[] messageCodes = codesResolver.resolveMessageCodes("required", "item");
        // errorCode "required" 에 해당하는 에러 메시지들이 String 배열에 담긴다.
        for (int i = 0; i < messageCodes.length; i++) {
            System.out.println("messageCodes: " + messageCodes[i]);
        }

        assertThat(messageCodes).containsExactly("required.item", "required");
    }
    
    @Test
    void messageCodesResolverField() {
        String[] messageCodes = codesResolver.resolveMessageCodes("required", "item", "itemName", String.class);
        for (int i = 0; i < messageCodes.length; i++) {
            System.out.println(messageCodes[i]);
        }
        assertThat(messageCodes).containsExactly(
                "required.item.itemName",
                "required.itemName",
                "required.java.lang.String",
                "required"
        );
    }
}
