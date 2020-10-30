package cz.spilar.exception;

public class ParcelInfoException extends RuntimeException {

    public static final String POSTAL_CODE_ERROR_MESSAGE_BLANK = "Postal code must not be empty.";
    public static final String POSTAL_CODE_ERROR_MESSAGE_FORMAT = "Postal code must consist of 5 digits only.";
    public static final String WEIGHT_ERROR_MESSAGE_FORMAT = "Weight must be a number and have 3 decimal places.";
    public static final String WEIGHT_ERROR_MESSAGE_OUT_OF_RANGE = "Weight is too large.";
    public static final String PARCEL_GENERAL_ERROR = "Enter the parcel data in a proper format.";

    public ParcelInfoException(String message) {
        super(message);
    }
}
