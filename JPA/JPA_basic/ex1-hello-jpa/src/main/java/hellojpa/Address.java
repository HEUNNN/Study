package hellojpa;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.persistence.Embeddable;

@Getter
@Embeddable
@EqualsAndHashCode
public class Address {

    private String city;
    private String street;
    private String zipcode;

    // 기본 생성자 필요
    public Address() {
    }

    public Address(String city, String street, String zipcode) {
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }

/*    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address)) return false;
        Address address = (Address) o;
        return Objects.equals(getCity(), address.getCity()) && Objects.equals(getStreet(), address.getStreet()) && Objects.equals(getZipcode(), address.getZipcode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCity(), getStreet(), getZipcode());
    }*/
}
