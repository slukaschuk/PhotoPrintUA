package ua.com.spiritus.models;

import javax.persistence.*;

//@Entity
//@Table(name = "city")
public class City {
    /*@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cityid")
    private Integer cityId;
    @Column(name = "cityname")
    private String cityName;

    public City() {
    }

    public City(String cityName) {
        this.cityName = cityName;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        City city = (City) o;

        if (!cityId.equals(city.cityId)) return false;
        return cityName.equals(city.cityName);

    }

    @Override
    public int hashCode() {
        int result = cityId.hashCode();
        result = 31 * result + cityName.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "City{" +
                "cityName='" + cityName + '\'' +
                '}';
    }*/
}
