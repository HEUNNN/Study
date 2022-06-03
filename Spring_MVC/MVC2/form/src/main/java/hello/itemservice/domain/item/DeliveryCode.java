package hello.itemservice.domain.item;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor // private 필드를 생성하는 생성자를 자동으로 생성

/*
* FAST: 빠른 배송
* NORMAL: 일반 배송
* SLOW: 느린 배송
* */
public class DeliveryCode {

    private String code; // FAST, NORMAL, SLOW 등과 같이 시스템에서 전달하는 값
    private String displayName; // 빠른 배송, 일반 배송, 느린 배송 등과 같이 고객에게 보여주는 값
}
