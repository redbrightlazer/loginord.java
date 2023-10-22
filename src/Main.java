import java.util.ArrayList;
import javax.swing.*;

public class Main {




    public static void main(String[] args) {
        ArrayList <String> dataBase = new ArrayList<>();
        boolean exit = false;
        JOptionPane.showMessageDialog(null,"Welcome to the program!");

        JOptionPane.showMessageDialog(null," Here are your options:");

        while (!exit) {
            String mode = JOptionPane.showInputDialog("1. Register \n 2. Login \n 3. View registered users \n 4. Exit");



            switch (mode) {
                case "1" -> registration(dataBase);
                case "2" -> login(dataBase);
                case "3" -> viewRegisteredUsers(dataBase);
                case "4" -> exit = true;
                default -> JOptionPane.showMessageDialog(null,"nuh uh uh");
            }
        }
    }

    public static void registration(ArrayList<String> dataBase)
    {
            String role;
            String username = JOptionPane.showInputDialog("Enter your username to register");
            int coin = coincidence(dataBase, username);
            if (coin == -1) {
                String password = pass();
                dataBase.add(username);
                dataBase.add(password);
                Boolean adminEx = adminFinder(dataBase);
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
        String answer = JOptionPane.showInputDialog("Would you like to see it in administrator mode? y/n");
        if(answer.equals("y"))
        {
            String username = JOptionPane.showInputDialog("Enter the username of the admin");

            String password = JOptionPane.showInputDialog("Enter the password of the admin");
            if(username.equals(dataBase.get(0)) && password.equals(dataBase.get(1)))
            {
                JOptionPane.showMessageDialog(null, "Correct, here is the usernames and password:"+superLogin(dataBase));
            }
        }
        else if(answer.equals("n"))
        {
            JOptionPane.showMessageDialog(null, "Registered users:\n "+logins(dataBase));
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Input error");
        }

    }

    public static String logins(ArrayList <String> dataBase)
    {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < dataBase.size(); i+=3)
        {
          if(dataBase.get(i)==null)
          {
              break;
          }
            sb.append("\n").append(dataBase.get(i));
        }
        return sb.toString();
    }

    public static String superLogin(ArrayList <String> dataBase)
    {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < dataBase.size(); i+=3)
        {
            if(dataBase.get(i)==null)
            {
                break;
            }
            sb.append("\n Username: ").append(dataBase.get(i)).append(" Password: ").append(dataBase.get(i+1));
        }
        return sb.toString();
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
            JOptionPane.showMessageDialog(null,"Passwords don't match.");
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