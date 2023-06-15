package ManTests;

import org.example.Man;
import org.example.Woman;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class PositiveTests {

    Man man = new Man("Garry", "Black", 65, false);

    Woman woman = new Woman("Hellen", "Smith", 35, false);
    SoftAssert softAssert = new SoftAssert();

    @Test(groups={"regression"})
    public void testPositiveIsRetired() {

        softAssert.assertTrue(man.isRetired(), man.getFirstName() + " is not retired yet, because he did not reach 65 yet. He is " + man.getAge());

        softAssert.assertAll();
    }

    @Test(groups={"regression"})
    public void testPositiveRegisterPartner() {

        man.registerPartnership(woman);

        softAssert.assertEquals(man.getPartner(), woman, man.getPartner() + " is not the same as expected.");
        softAssert.assertEquals(man.getMarriageStatus(), true, man.getFirstName() + " is not married yet.");

        softAssert.assertAll();
    }

    @Test(groups={"regression"})
    public void testPositiveDeregisterPartner() {

        man.deregisterPartnership(false);

        softAssert.assertEquals(man.getPartner(),  null, man.getFirstName() + "'s partner is not changed after divorce");
        softAssert.assertEquals(man.getMarriageStatus(), false, man.getFirstName() + " is still has a married status after divorce.");

        softAssert.assertAll();
    }
}

