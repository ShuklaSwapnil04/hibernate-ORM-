package inherit;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="B")
public class B  extends A{
private String valueONE;

    public String getValueONE() {
        return valueONE;
    }

    public void setValueONE(String valueONE) {
        this.valueONE = valueONE;
    }
}
