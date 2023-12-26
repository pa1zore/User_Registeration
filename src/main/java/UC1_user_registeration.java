import org.w3c.dom.ls.LSOutput;
class User1
{
    private String firstName;
    private String lastName;
    public void setFirstName(String firstName)
    {
        this.firstName=firstName;
    }
    public void setLastName(String lastName)
    {
        this.lastName=lastName;
    }
    public String getFirstName()
    {
        return  this.firstName;
    }
    public String getlastName()
    {
        return  this.lastName;
    }



    public User1(String firstName,String lastName)
    {
        this.firstName=firstName;
        this.lastName=lastName;
    }
    public Boolean isValidFirstName()
    {
        if(firstName.matches("[A-Z]{1,}[A-Za-z]{2,}"))
        {
            System.out.println("name is valid");
            return true;
        }
        System.out.println("invalid first name");

        return false;
    }
    public Boolean isValidLastName()
    {
        if(lastName.matches("[A-Z]{1,}[A-Za-z]{2,}"))
        {
            System.out.println("last name is valid");
            return true;
        }
        System.out.println("invalid last name");
        return false;

    }



}

public class UC1_user_registeration {
    public static void main(String[] args) {
        System.out.println("welcome to user registration program");
        User1 user= new User1("Pavan","Zore");
        System.out.println(user.isValidFirstName());
        System.out.println(user.isValidLastName());
    }
}
