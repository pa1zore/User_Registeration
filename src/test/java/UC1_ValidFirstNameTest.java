import org.junit.jupiter.api.*;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class UC1_ValidFirstNameTest  {
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
    void should_return_true_after_giving_First_capital_alphabates() throws Myexception {
        //given
        user.setFirstName("Pavan");
        //when

        Boolean actual=user.isValidFirstName();

        //then
        Assertions.assertTrue(actual);
    }
    @Test//negative test case
    void should_return_false_after_giving_First_capital_alphabates() throws Myexception {
        //given
        user.setFirstName("pavan");
        //when

        Boolean actual=user.isValidFirstName();

        //then
        Assertions.assertFalse(actual);
    }
    @Test//positive test case
    void should_return_true_after_giving_first_capital_alphabates() throws Myexception {
        //given
        //we Entered "Zore" as last name
        //when
        Boolean actual=user.isValidLastName();

        //then
        Assertions.assertTrue(actual);
    }
    @Test// negative test case
    void should_return_false_after_giving_first_letter_small() throws Myexception {
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
    void should_return_true_after_giving_all_valid_emails (String useremail) throws Myexception {
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
    void should_return_false_after_giving_all_valid_emails (String useremail) throws Myexception {
        //given
        user.setEmail(useremail);
        //when
        boolean actual =user.isValidEmail();
        //then
        Assertions.assertFalse(actual);

    }
    @Test
    void should_return_true_after_entering_valid_mobile_number() throws Myexception {
        //given
        user.setMobileNumber("91 5849304495");
        //when
        boolean actual=user.isValidMobileNumber();

        //then
        Assertions.assertTrue(actual);
    }

    @Test
    void should_return_false_after_entering_invalid_mobile_number() throws Myexception {
        //given
        user.setMobileNumber("91 49304495");
        //when
        boolean actual=user.isValidMobileNumber();

        //then
        Assertions.assertFalse(actual);
    }
    @Disabled//we desabled this line because we have modified code with at least 1 uppercase alphabates
    @Test
    void should_return_true_after_entering_valid_password() throws Myexception {
        //given
        user.setPassword("password");
        //when
        boolean actual=user.isValidPassword();

        //then
        Assertions.assertTrue(actual);
    }
    @Test
    void should_return_false_after_entering_Invalid_password() throws Myexception {
        //given
        user.setPassword("ssword");
        //when
        boolean actual=user.isValidPassword();

        //then
        Assertions.assertFalse(actual);
    }
    @Disabled
    @Test // we need to disable this test becasue now we are modifing the code with at least 1 numeric number
    void should_return_true_after_entering_password_with8char_and_Atleast_1Uppercase() throws Myexception {
        //given
        user.setPassword("Password");
        //when
        boolean actual=user.isValidPassword();

        //then
        Assertions.assertTrue(actual);
    }
    @Test
    void should_return_false_after_entering_password_with8char_and_no_1Uppercase() throws Myexception {
        //given
        user.setPassword("password");
        //when
        boolean actual=user.isValidPassword();

        //then
        Assertions.assertFalse(actual);
    }
    @Disabled // because now we are adding 1 special character also in password
    @Test
    void should_return_true_after_entering_password_with8char_and_Atleast_1Uppercase_and_1_numeric_value() throws Myexception {
        //given
        user.setPassword("Passwor1");
        //when
        boolean actual=user.isValidPassword();

        //then
        Assertions.assertTrue(actual);
    }
    @Test
    void should_return_false_after_entering_password_with8char_and_no_1Uppercase_with_no_numeric_value() throws Myexception {
        //given
        user.setPassword("Password");
        //when
        boolean actual=user.isValidPassword();

        //then
        Assertions.assertFalse(actual);
    }



    @Test
    void should_return_true_after_entering_password_with8char_and_Atleast_1Uppercase_and_1_numeric_value_special_char() throws Myexception {
        //given
        user.setPassword("Pass@wor1");
        //when
        boolean actual=user.isValidPassword();

        //then
        Assertions.assertTrue(actual);
    }
    @Test
    void should_return_false_after_entering_password_with8char_and_no_1Uppercase_with_no_numeric_value_no_special_char() throws Myexception {
        //given
        user.setPassword("Password");
        //when
        boolean actual=user.isValidPassword();

        //then
        Assertions.assertFalse(actual);
    }
    @Test
    void should_ThrowMyexception_when_given_invalid_details()
    {  //given null values in constructor
        user =new User1();
        //when calling function with null value should throw exception
        Executable executable1= () -> user.isValidFirstName();
        Executable executable2= () -> user.isValidLastName();
        Executable executable3= () -> user.isValidMobileNumber();
        Executable executable4= () -> user.isValidEmail();
        Executable executable5= () -> user.isValidPassword();
        //then checking exception is occur or not
        Assertions.assertThrows(Myexception.class,executable1);
        Assertions.assertThrows(Myexception.class,executable2);
        Assertions.assertThrows(Myexception.class,executable3);
        Assertions.assertThrows(Myexception.class,executable4);
        Assertions.assertThrows(Myexception.class,executable5);




    }

}
