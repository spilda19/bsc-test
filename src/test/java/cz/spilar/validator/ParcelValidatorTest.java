package cz.spilar.validator;

import cz.spilar.exception.ParcelInfoException;
import org.junit.Test;

public class ParcelValidatorTest {

    @Test(expected = ParcelInfoException.class)
    public void parcelWeightTest1(){
        ParcelValidator.validateWeightString("asdf.asd");
    }

    @Test(expected = ParcelInfoException.class)
    public void parcelWeightTest2(){
        ParcelValidator.validateWeightString("1.asd");
    }

    @Test(expected = ParcelInfoException.class)
    public void parcelWeightTest3(){
        ParcelValidator.validateWeightString("asdf.123");
    }

    @Test
    public void parcelWeightTest4(){
        ParcelValidator.validateWeightString("1234.123");
    }
}
