//declear class to find valid and invalid enteries
   interface  Checkexpression
{
    void check() throws Myexception;
}
class Myexception extends Exception
{
    public Myexception(String str)
    {
        super(str);
    }
}
class User1 {
    // all data member are set as private with getter setter method called as encapsulation
    private String firstName;
    private String lastName;
    private String email;
    private String mobileNumber;
    private String password;
    public User1()
    {

    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    //parameterized constructor to  initialised objects
    public User1(String firstName, String lastName, String email, String mobileNumber, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.password = password;
    }

    //method to check First  name is valid or not
    public Boolean isValidFirstName() throws Myexception {
        if(firstName==null || firstName.length()==0)
        {
            throw new Myexception("InvalidFirstNameException");
        }
        if (firstName.matches("[A-Z]{1,}[A-Za-z]{2,}")) {
            System.out.println("name is valid");
            return true;
        }
        System.out.println("invalid first name");

        return false;
    }

    //method to check last name is valid or not
    public Boolean isValidLastName() throws Myexception {
        if(lastName==null || lastName.length()==0)
        {
            throw new Myexception("InvalidLastNameException");
        }
        if (lastName.matches("[A-Z]{1,}[A-Za-z]{2,}")) {
            System.out.println("last name is valid");
            return true;
        }
        System.out.println("invalid last name");
        return false;

    }

    //method to check given emails is valid or not
    public boolean isValidEmail() throws Myexception {
        if(email==null || email.length()==0)
        {
            throw new Myexception("InvalidEmailException");
        }
        if (email.matches("^[a-z]+[-_.+]{0,1}[[0-9]*[a-z]*]+[@][[0-9]*[a-z]*]+.[a-z]+[a-z]+.[a-z]+[a-z]+$")) {
            System.out.println("valid email");
            return true;
        } else if (email.matches("^[a-z]+[-_.+]{0,1}[[0-9]*[a-z]*]+[@][[0-9]*[a-z]*]+.[a-z]+[a-z]+$")) {
            System.out.println("valid email");

            return true;

        }

        System.out.println(" Invalid email");

        return false;
    }

    public boolean isValidMobileNumber() throws Myexception{
        if(mobileNumber==null || mobileNumber.length()==0)
        {
            throw new Myexception("InvalidMobileNumberException");
        }
        if (mobileNumber.matches("[0-9]{2} [0-9]{10}")) {
            System.out.println(":valid mobile number");
            return true;
        }
        return false;
    }

    public boolean isValidPassword() throws Myexception {
        if(password==null || password.length()==0)
        {
            throw new Myexception("InvalidPasswordException");
        }
        if(password.matches("(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*()-_=+{}|;:'<>,./?]).{8,}")) {
            System.out.println("valid password");
            return true;

        }
        return false;
    }
}
public class UC1_user_registeration {
    public static void main(String[] args) {
        System.out.println("welcome to user registration program");
        //created object and passed parameter to constructor
        User1 user = new User1("Pavan", "Zore", "pavanzore345@gmail.com", "91 8766839783", "");
        try {
            Checkexpression validate = user::isValidFirstName;
            validate.check();
        } catch (Myexception e) {
            System.out.println("Caught the exception");
            System.out.println("Exception occured"+e);
        }
        try {
            Checkexpression validate = user::isValidLastName;
            validate.check();
        } catch (Myexception e) {
            System.out.println("Caught the exception");
            System.out.println("Exception occured"+e);
        }
        try {
            Checkexpression validate = user::isValidEmail;
            validate.check();
        } catch (Myexception e) {
            System.out.println("Caught the exception");
            System.out.println("Exception occured"+e);
        }
        try {
            Checkexpression validate = user::isValidMobileNumber;
            validate.check();        } catch (Myexception e) {
            System.out.println("Caught the exception");
            System.out.println("Exception occured"+e);
        }
        try {
            Checkexpression validate = user::isValidPassword;
            validate.check();        } catch (Myexception e) {
            System.out.println("Caught the exception");
            System.out.println("Exception occured"+e);
        }
    }
}
