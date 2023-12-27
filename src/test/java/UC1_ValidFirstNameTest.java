import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class UC1_ValidFirstNameTest {
    User1 user;
    @BeforeEach
    void setup()
    {//setting constructor with two values to validate
        user=  new User1("Pavan","Zore","pavanzore345@gmail.com","8766839783","password");
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
        user.setFirstName("Pavan");
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

//parameterized test to check each time the fucntion is working correctily or not
    @CsvSource(value = {"abc@yahoo.com","abc-100@yahoo.com","abc.100@yahoo.com","abc111@abc.com","abc-100@abc.net","abc.100@abc.com.au","abc@1.com","abc@gmail.com.com","abc+100@gmail.com"})
    @ParameterizedTest
    void should_return_true_after_giving_all_valid_emails (String useremail)
    {
        //given
        user.setEmail(useremail);
        //when

        boolean actual =user.isValidEmail();
        //then
        Assertions.assertTrue(actual);

    }
    //parameterized test to check each time the fucntion is working correctily or not
    @CsvSource(value = {"abc","abc@.com.my","abc123@gmail.a","abc123@.com","abc123@.com.com",".abc@abc.com","abc()*@gmail.com","abc@%*.com","abc..2002@gmail.com","abc.@gmail.com","abc@gmail.com.aa.au","abc@gmail.com.1a"})
    @ParameterizedTest
    void should_return_false_after_giving_all_valid_emails (String useremail)
    {
        //given
        user.setEmail(useremail);
        //when
        boolean actual =user.isValidEmail();
        //then
        Assertions.assertFalse(actual);

    }
    @Test
    void should_return_true_after_entering_valid_mobile_number()
    {
        //given
        user.setMobileNumber("91 5849304495");
        //when
        boolean actual=user.isValidMobileNumber();

        //then
        Assertions.assertTrue(actual);
    }

    @Test
    void should_return_false_after_entering_invalid_mobile_number()
    {
        //given
        user.setMobileNumber("91 49304495");
        //when
        boolean actual=user.isValidMobileNumber();

        //then
        Assertions.assertFalse(actual);
    }
    @Disabled//we desabled this line because we have modified code with at least 1 uppercase alphabates
    @Test
    void should_return_true_after_entering_valid_password()
    {
        //given
        user.setPassword("password");
        //when
        boolean actual=user.isValidPassword();

        //then
        Assertions.assertTrue(actual);
    }
    @Test
    void should_return_false_after_entering_Invalid_password()
    {
        //given
        user.setPassword("ssword");
        //when
        boolean actual=user.isValidPassword();

        //then
        Assertions.assertFalse(actual);
    }
    @Test
    void should_return_true_after_entering_password_with8char_and_Atleast_1Uppercase()
    {
        //given
        user.setPassword("Password");
        //when
        boolean actual=user.isValidPassword();

        //then
        Assertions.assertTrue(actual);
    }
    @Test
    void should_return_false_after_entering_password_with8char_and_no_1Uppercase()
    {
        //given
        user.setPassword("password");
        //when
        boolean actual=user.isValidPassword();

        //then
        Assertions.assertFalse(actual);
    }

}
