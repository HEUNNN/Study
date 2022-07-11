package hellojpa;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = "ADDRESS")
public class AddressEntity { // 값 타입을 감싼 entity

    @Id
    @GeneratedValue
    private int id;

    private Address address; // 값 타입

    public AddressEntity() {

    }

    public AddressEntity(String city, String street, String zipcode) {
        this.address = new Address(city, street, zipcode);
    }


    @Override
    public boolean equals(Object obj) {
        AddressEntity obj1 = (AddressEntity) obj;
        return this.id == obj1.getId();
    }
}
