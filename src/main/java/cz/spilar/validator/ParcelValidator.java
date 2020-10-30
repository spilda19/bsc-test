package cz.spilar.validator;

import cz.spilar.exception.ParcelInfoException;
import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParcelValidator {

    public static void validatePostalCode(String postalCode) throws ParcelInfoException {
        if (StringUtils.isBlank(postalCode)) {
            throw new ParcelInfoException(ParcelInfoException.POSTAL_CODE_ERROR_MESSAGE_BLANK);
        }
        Pattern fiveDigitsPattern = Pattern.compile("^\\d{5}$");
        Matcher matcher = fiveDigitsPattern.matcher(postalCode);
        if (!matcher.find()) {
            throw new ParcelInfoException(ParcelInfoException.POSTAL_CODE_ERROR_MESSAGE_FORMAT);
        }
    }

    public static void validateWeightString(String weight) throws ParcelInfoException {
        Pattern weightPattern = Pattern.compile("^[0-9]+\\.[0-9]{3}$");
        Matcher matcher = weightPattern.matcher(weight);
        if (!matcher.find()) {
            throw new ParcelInfoException(ParcelInfoException.WEIGHT_ERROR_MESSAGE_FORMAT);
        }
        try {
            Float.parseFloat(weight);
        } catch (NumberFormatException e) {
            throw new ParcelInfoException(ParcelInfoException.WEIGHT_ERROR_MESSAGE_OUT_OF_RANGE);
        }
    }
}
