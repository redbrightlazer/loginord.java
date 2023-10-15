import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.*;

public class Main {
    static Scanner can = new Scanner(System.in);



    public static void main(String[] args) {
        ArrayList <String> dataBase = new ArrayList<>();
        //asdasdasd

        JOptionPane.showMessageDialog(null,"Welcome to the program!");

        JOptionPane.showMessageDialog(null," Here are your options:");

        while (true) {
            String mode = JOptionPane.showInputDialog("1. Register \n 2. Login \n 3. View registered users");



            switch (mode) {
                case "1":
                    registration(dataBase);
                    break;

                case "2":
                    login(dataBase);
                    break;

                case "3":
                    viewRegisteredUsers(database);
                    break;

                default:
                    JOptionPane.showMessageDialog(null,"nuh uh uh");
            }
        }
    }

    public static void registration(ArrayList<String> dataBase)
    {
            String role = "";
            String username = JOptionPane.showInputDialog("Enter your username to register");
            int coin = coincidence(dataBase, username);
            if (coin == -1) {
                String password = pass();
                dataBase.add(username);
                dataBase.add(password);
                Boolean adminEx = adminfinder(dataBase);
                if(!adminEx)
                {
                    role = (JOptionPane.showInputDialog("Do you reg as an admin?"));
                    switch(role)
                    {
                        case "y":
                            dataBase.add("A");

                        case "n":
                            dataBase.add("S");

                        default:
                            dataBase.add("S");
                }

                }
                else
                {
                    role = (JOptionPane.showInputDialog("Do you reg as an mod?"));
                    switch(role)
                    {
                        case "y":
                            dataBase.add("M");

                        case "n":
                            dataBase.add("S");

                        default:
                            dataBase.add("S");
                    }

                }
                JOptionPane.showMessageDialog(null,"Registration successful!");
            } else {
                String answer = JOptionPane.showInputDialog("Username already exists. Do you want to login instead? y/n?");
                if(answer.equals("y"))
                {
                    login(dataBase, username);
                }
                else if(answer.equals("n"))
                {
                    JOptionPane.showMessageDialog(null,"Operation cancelled.");

                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Input error");


                }
            }

    }

    public static void registration(ArrayList <String> dataBase, String username)
    {
        dataBase.add(username);
        dataBase.add(pass());

        JOptionPane.showMessageDialog(null,"User "+username+" has been successfully registered!");
    }


    public static void login(ArrayList <String> dataBase)
    {
        String username = JOptionPane.showInputDialog("What is your name?");
        int index = coincidence(dataBase, username);
        if (index != -1) {
            String enteredPassword = JOptionPane.showInputDialog("Enter your password");
            if (enteredPassword.equals(dataBase.get(index+1))) {
                JOptionPane.showMessageDialog(null,"Login successful!");
            } else {
                JOptionPane.showMessageDialog(null,"Incorrect password.");
            }
        } else {
            String answer = JOptionPane.showInputDialog("That user is not found, would you like to register it?");
            if(answer.equals("y"))
            {
                registration(dataBase, username);
            }
            else if(answer.equals("n"))
            {
                JOptionPane.showMessageDialog(null,"Operation cancelled.");

            }
            else
            {
                JOptionPane.showMessageDialog(null,"Input error");
            }
        }
    }

    public static void login(ArrayList <String> dataBase, String username)
    {
      int coin = coincidence(dataBase, username);
      String pass = JOptionPane.showInputDialog("Enter your password.");
      if(pass.equals(dataBase.get(coin+1)))
      {
          JOptionPane.showMessageDialog(null,"Successfully logged in!");
      }
      else
      {
          JOptionPane.showMessageDialog(null,"Password is incorrect");
      }



    }

    public static void viewRegisteredUsers(ArrayList <String> dataBase)
    {
        String anser = JOptionPane.showInputDialog("Would you like to see it in administrator mode? y/n");
        if(anser.equals("y"))
        {
            String username = JOptionPane.showInputDialog("Enter the username of the admin");

            String password = JOptionPane.showInputDialog("Enter the password of the admin");
            if(username.equals(dataBase.get(0)) && password.equals(dataBase.get(+1)))
            {
                JOptionPane.showMessageDialog(null, "Correct, here is the usernames and password:"+superlogin(users, passwords));
            }
        }
        else if(anser.equals("n"))
        {
            JOptionPane.showMessageDialog(null, "Registered users:\n "+logins(users, passwords));
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Input error");
        }

    }

    public static String logins(ArrayList <String> users, ArrayList <String> passwords)
    {
        String login = "";
        for (int i = 0; i < users.size(); i++)
        {
          if(users.get(i)==null)
          {
              break;
          }
          login+="\n"+users.get(i);
        }
        return login;
    }

    public static String superLogin(ArrayList <String> users, ArrayList <String> passwords)
    {
        String login = "";
        for (int i = 0; i < users.size(); i++)
        {
            if(users.get(i)==null)
            {
                break;
            }
            login+="\n Username: "+users.get(i)+" Password: "+passwords.get(i);
        }
        return login;
    }
    public static int coincidence(ArrayList <String> dataBase, String username) {
        for (int i = 0; i < dataBase.size(); i+=3) {
            if (dataBase.get(i) == null) {
                break;
            } else if (dataBase.get(i).equals(username)) {
                return i;
            }
        }
        return -1;
    }

    public static String pass() {
        String pass1 = JOptionPane.showInputDialog("Enter your password");

        String pass2 = JOptionPane.showInputDialog("Repeat your password");

        if (pass1.equals(pass2)) {
            return pass2;
        } else {
            JOptionPane.showMessageDialog(null,"Passwords don't match.");;
            return pass();
        }
    }
    public static Boolean adminFinder(ArrayList<String> dataBase)
    {
        for (int i = 2; i < dataBase.size(); i+=3)
        {
           if(dataBase.get(i).equals("A"))
           {
             return true;
           }

        }
        return false;

    }

}