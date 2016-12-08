package ua.com.spiritus.models;

import javax.persistence.*;

//@Entity
//@Table(name = "novaposhta")
public class NovaPoshta {
    /*@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "novaposhtaid")
    private Integer novaPoshtaId;
    @Column(name = "warehouse", columnDefinition = "TINYINT")
    private Integer warehouse;

    @ManyToOne
    @JoinColumn(name = "cityid", nullable = false)
    private City city;

    public NovaPoshta() {
    }

    public NovaPoshta(Integer warehouse, City city) {
        this.warehouse  = warehouse;
        this.city       = city;
    }

    public Integer getNovaPoshtaId() {
        return novaPoshtaId;
    }

    public void setNovaPoshtaId(Integer novaPoshtaId) {
        this.novaPoshtaId = novaPoshtaId;
    }

    public Integer getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Integer warehouse) {
        this.warehouse = warehouse;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NovaPoshta that = (NovaPoshta) o;

        if (!novaPoshtaId.equals(that.novaPoshtaId)) return false;
        if (!warehouse.equals(that.warehouse)) return false;
        return city.equals(that.city);

    }

    @Override
    public int hashCode() {
        int result = novaPoshtaId.hashCode();
        result = 31 * result + warehouse.hashCode();
        result = 31 * result + city.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "NovaPoshta{" +
                "warehouse=" + warehouse +
                ", city=" + city +
                '}';
    }*/
}
