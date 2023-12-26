import org.junit.jupiter.api.*;

public class UC1_ValidFirstNameTest {
    User1 user;
    @BeforeEach
    void setup()
    {//setting constructor with two values to validate
        user=  new User1("Pavan","Zore");
    }
    @AfterEach
    void end()
    {
        System.out.println("test run successfully");
    }
    @Test//positive test case
    void should_return_true_after_giving_First_capital_alphabates()
    {
        //given
        //we entered"Pavan"
        //when

        Boolean actual=user.isValidFirstName();

        //then
        Assertions.assertTrue(actual);
    }
    @Test//negative test case
    void should_return_false_after_giving_First_capital_alphabates()
    {
        //given
        user.setFirstName("pavan");
        //when

        Boolean actual=user.isValidFirstName();

        //then
        Assertions.assertFalse(actual);
    }
    @Test//positive test case
    void should_return_true_after_giving_first_capital_alphabates()
    {
        //given
        //we Entered "Zore" as last name
        //when
        Boolean actual=user.isValidLastName();

        //then
        Assertions.assertTrue(actual);
    }
    @Test// negative test case
    void should_return_false_after_giving_first_letter_small()
    {
        //given
        user.setLastName("zore");
        //we Entered "Zore" as last name
        //when
        Boolean actual=user.isValidLastName();

        //then
        Assertions.assertFalse(actual);
    }

}
