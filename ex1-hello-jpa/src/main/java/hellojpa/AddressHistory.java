package hellojpa;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Table;

@Entity
@Table(name = "ADDRESS")
public class AddressHistory {

    @Id @GeneratedValue
    private Long Id;

    private Address address;

    public AddressHistory() {
    }

    public AddressHistory(Address address) {
        this.address = address;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
