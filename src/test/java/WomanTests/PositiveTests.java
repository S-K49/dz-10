package WomanTests;

import org.example.Man;
import org.example.Woman;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class PositiveTests {


    Man man = new Man("Garry", "Black", 65, false);
    Woman woman = new Woman("Hellen", "Smith", 60, false);
    SoftAssert softAssert = new SoftAssert();


    @Test(groups={"regression"})
    public void testPositiveIsRetired() {

        softAssert.assertTrue(woman.isRetired(), woman.getFirstName() + " is not retired yet, because she did not reach 60 yet. She is " + woman.getAge());
        softAssert.assertAll();
    }

    @Test(groups={"regression"})
    public void testPositiveRegisterPartner() {

        woman.registerPartnership(man);

        softAssert.assertEquals(woman.getPartner(), man, woman.getPartner() + " is not the same as expected.");
        softAssert.assertEquals(woman.getLastName(), man.getLastName(), "Woman's last name is not changed after marriage to " + man.getLastName());
        softAssert.assertEquals(woman.getMarriageStatus(), true, "Woman is not married yet");

        softAssert.assertAll();
    }


    @Test(groups={"regression"})
    public void testPositiveDeregisterPartner() {

        woman.deregisterPartnership(true);

        softAssert.assertEquals(woman.getPartner(),  null, woman.getFirstName() + "'s partner is not changed after divorce");
        softAssert.assertEquals(woman.getLastName(), woman.getPreviousLastName(), woman.getFirstName() + " is not returned to the previous last name");
        softAssert.assertEquals(woman.getMarriageStatus(), false, "Woman is still married");

        softAssert.assertAll();
    }
}
