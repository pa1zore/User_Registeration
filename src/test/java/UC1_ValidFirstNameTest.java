import org.junit.jupiter.api.*;

public class UC1_ValidFirstNameTest {

    @BeforeEach
    void setup()
    {

    }
    @AfterEach
    void end()
    {
        System.out.println("test run successfully");
    }
    @Test
    void should_return_true_after_giving_First_capital_alphabates()
    {
        //given
        String str="Pavan";
        //when
        User1 user=  new User1(str);
        Boolean actual=user.isValidFirstName();

        //then
        Assertions.assertTrue(actual);
    }
    @Test
    void should_return_false_after_giving_first_capital_small()
    {
        //given
        String str="pavan";
        //when
        User1 user=  new User1(str);
        Boolean actual=user.isValidFirstName();

        //then
        Assertions.assertFalse(actual);
    }

}
