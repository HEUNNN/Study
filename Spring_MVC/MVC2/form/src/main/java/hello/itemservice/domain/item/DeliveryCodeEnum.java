package hello.itemservice.domain.item;

public enum DeliveryCodeEnum {
    FAST("빠른 배송"), NORMAL("일반 배송"), ETC("기타");

    private final String description;

    DeliveryCodeEnum(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
