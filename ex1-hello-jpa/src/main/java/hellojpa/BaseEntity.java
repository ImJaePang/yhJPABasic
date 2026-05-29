package hellojpa;

import jakarta.persistence.Inheritance;
import jakarta.persistence.MappedSuperclass;

import java.time.LocalDateTime;

@MappedSuperclass
public abstract class BaseEntity {

    private LocalDateTime regDt;
    private String register;
    private LocalDateTime modiDt;
    private String modifier;

    public LocalDateTime getRegDt() {
        return regDt;
    }

    public void setRegDt(LocalDateTime regDt) {
        this.regDt = regDt;
    }

    public String getRegister() {
        return register;
    }

    public void setRegister(String register) {
        this.register = register;
    }

    public LocalDateTime getModiDt() {
        return modiDt;
    }

    public void setModiDt(LocalDateTime modiDt) {
        this.modiDt = modiDt;
    }

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
    }
}
