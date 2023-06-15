package WomanTests;

import org.example.Man;
import org.example.Woman;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class NegativeTests {

    Man man = new Man("Garry", "Black", 65, false);
    Woman woman = new Woman("Hellen", "Smith", 59, false);
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void testNegativeIsRetired() {

        softAssert.assertFalse(woman.isRetired(), woman.getFirstName() + " is retired, because she reach 60. She is " + woman.getAge());
        softAssert.assertAll();
    }

    @Test
    public void testNegativeRegisterPartner() {

        softAssert.assertEquals(woman.getPartner(), null, "Negative test failed. " + "The partner is: " + woman.getPartner() + ", but it should not be set.");
        softAssert.assertEquals(woman.getMarriageStatus(), false, "Negative test failed. Woman is still married");
        softAssert.assertAll();
    }


    @Test(groups={"regression"})
    public void testNegativeChangeLastName() {

        woman.registerPartnership(man);

        woman.setLastName("Smith");

        softAssert.assertEquals(woman.getLastName(), woman.getPreviousLastName(), "Negative test failed. " + woman.getFirstName() + " changed her last name to man's last name");

        softAssert.assertAll();
    }

    @Test(groups={"regression"})
    public void testNegativeDeregisterPartner() {

        woman.deregisterPartnership(false);
        woman.setPartner(man);

        softAssert.assertEquals(woman.getPartner(),  man, "Negative test failed. " + woman.getFirstName() + "'s partner changed after divorce, but it should not.");

        softAssert.assertAll();
    }

    @Test(groups={"regression"})
    public void testNegativeReturnToPreviousLastName() {
        woman.deregisterPartnership(false);

        softAssert.assertEquals(woman.getLastName(), "Smith", "Negative test failed. " + woman.getFirstName() + " is returned to the previous last name after divocre.");

        softAssert.assertAll();
    }
}
