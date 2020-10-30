package cz.spilar.factory;

import cz.spilar.exception.ParcelInfoException;
import cz.spilar.storage.Parcel;
import cz.spilar.validator.ParcelValidator;
import org.apache.commons.lang3.StringUtils;

public class ParcelFactory {

    public static Parcel createParcel(String weight, String postalCode) throws ParcelInfoException {
        ParcelValidator.validatePostalCode(postalCode);
        ParcelValidator.validateWeightString(weight);
        float floatWeight = Float.parseFloat(weight);
        return new Parcel(floatWeight, postalCode);
    }

    public static Parcel createParcel(String parcelData) {
        if (StringUtils.isNotBlank(parcelData)) {
            String[] parcelInput = parcelData.split(" ");
            if (parcelInput.length != 2) {
                throw new ParcelInfoException(ParcelInfoException.PARCEL_GENERAL_ERROR);
            }
            return createParcel(parcelInput[0], parcelInput[1]);
        } else {
            throw new ParcelInfoException(ParcelInfoException.PARCEL_GENERAL_ERROR);
        }
    }
}
