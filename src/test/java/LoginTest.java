import org.testng.annotations.*;

public class LoginTest {

    @BeforeSuite
    public static void suiteSetUp() {
        System.out.println("- this is suite setup");
    }

    @AfterSuite
    public static void suiteTearDown() {
        System.out.println("- this is suite tear down");
    }

    @BeforeTest
    public static void testSetUp() {
        System.out.println("- this is test setup");
    }

    @AfterTest
    public static void testTearDown() {
        System.out.println("- this is test tear down");
    }

    @BeforeGroups({"smoke", "regression"})
    public void groupsSetUp() {
        System.out.println("- this is group setup");
    }

    @AfterGroups({"smoke"})
    public void groupsTearDown() {
        System.out.println("- this is group tear down");
    }

    @BeforeClass
    public void classSetUp() {
        System.out.println("- this is class setup");
    }

    @AfterClass
    public void classTearDown() {
        System.out.println("- this is class teardown");
    }

    @BeforeMethod
    public void methodSetUp() {
        System.out.println("- this is method setup");
    }

    @AfterMethod
    public void methodTearDown() {
        System.out.println("- this is method teardown");
    }

    @Test(groups = "smoke", timeOut = 5000)
    public static void myFirstTest() {
        System.out.println("Hello! 1st test");
    }

    @Test(groups = "regression", enabled = false)
    public static void mySecondTest() {
        System.out.println("Hello! 2st test");
    }

    @Test(groups = "regression")
    public static void myThirdTest() {
        System.out.println("Hello! 3st test");
    }

    @Test
    @Parameters()
    public void loginTest(String login, String password){
        System.out.println();
    }
}
