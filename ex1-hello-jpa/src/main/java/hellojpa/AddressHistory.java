package hellojpa;

import jakarta.persistence.*;

@Entity
@Table(name = "ADDRESS")
public class AddressHistory {

    @Id
    @GeneratedValue
    @Column(name = "HISTORY_ID")
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
