import org.w3c.dom.ls.LSOutput;
class User1
{
    private String firstName;
    User1(String firstName)
    {
        this.firstName=firstName;
    }
    public Boolean isValidFirstName()
    {
        if(firstName.matches("[A-Z]{1,}[A-Za-z]{2,}"))
        {
            System.out.println("name is valid");
            return true;
        }
        return false;
    }


}

public class UC1_user_registeration {
    public static void main(String[] args) {
        System.out.println("welcome to user registration program");
        User1 user= new User1("Pavan");
        System.out.println(user.isValidFirstName());
    }
}
