package ManTests;

import org.example.Man;
import org.example.Woman;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class NegativeTests {

    Man man = new Man("Garry", "Black", 64, false);
    Woman woman = new Woman("Hellen", "Smith", 35, false);
    SoftAssert softAssert = new SoftAssert();

    @Test(groups={"regression"})
    public void testNegativeIsRetired() {

        softAssert.assertFalse(man.isRetired(), "Negative test failed. " + man.getFirstName() + " is retired, because his age is " + man.getAge());

        softAssert.assertAll();
    }

    @Test(groups={"regression"})
    public void testNegativeRegisterPartner() {

        softAssert.assertEquals(man.getPartner(), null, "Negative test failed. " + man.getPartner() + " is not empty.");
        softAssert.assertEquals(man.getMarriageStatus(), false, "Negative test failed. " + man.getFirstName() + " is still married.");

        softAssert.assertAll();
    }
}
