package GetterSetterTests;

import org.example.Man;
import org.example.Person;
import org.example.Woman;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class PositiveTests {

    Man man = new Man("Garry", "Black", 65, true);
    Woman woman = new Woman("Hellen", "Smith", 35, true);

    @Test(groups={"smoke"})
    public void testGetters() {

        Assert.assertEquals(woman.getFirstName(), "Hellen", "First name was not returned");
        Assert.assertEquals(man.getLastName(), "Black", "Last name was not returned");
        Assert.assertEquals(man.getAge(), 65, "Age is not returned");
        Assert.assertEquals(woman.getPreviousLastName(), "Smith", "Previous name is not returned");
        Assert.assertEquals(woman.getMarriageStatus(), true, "Marriage Status is not returned");
    }

    @Test(groups={"smoke"})
    public void testSetFirstName() {

        woman.setFirstName("Galya");

        Assert.assertEquals(woman.getFirstName(), "Galya", "First name is not set");
    }


    @Test(groups={"smoke"})
    public void testSetLastName() {
        man.setLastName("Last name");

        Assert.assertEquals(man.getLastName(), "Last name", "Last name was not set");

    }

    @Test(groups={"smoke"})
    public void testSetAge() {
        woman.setAge(55);

        Assert.assertEquals(woman.getAge(), 55, "Age was not set");

    }

    @Test(groups={"smoke"})
    public void testSetPartner() {
        man.setPartner(woman);

        Assert.assertEquals(man.getPartner(), woman, "Partner was not set");

    }
}
