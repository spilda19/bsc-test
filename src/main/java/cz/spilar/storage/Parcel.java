package cz.spilar.storage;

import cz.spilar.exception.ParcelInfoException;
import cz.spilar.factory.ParcelFactory;
import org.apache.commons.lang3.StringUtils;

public class Parcel {

    private float weight;
    private String postalCode;

    public Parcel(float weight, String postalCode) {
        this.weight = weight;
        this.postalCode = postalCode;
    }

    public Parcel(String parcelData) throws ParcelInfoException {
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {

        this.postalCode = postalCode;
    }

    @Override
    public String toString() {
        return postalCode + " " + String.format("%.3f", weight);
    }
}
