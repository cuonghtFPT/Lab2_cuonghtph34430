package cuonghtph34430.poly.lab2application;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class CityModal {
    private String name;
    private String popular;

    public CityModal() {
    }

    public CityModal(String name, String popular) {
        this.name = name;
        this.popular = popular;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPopular() {
        return popular;
    }

    public void setPopular(String popular) {
        this.popular = popular;
    }
}
