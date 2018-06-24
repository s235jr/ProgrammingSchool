package src.main.java.pl.s235jr;

import src.main.java.pl.s235jr.model.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class AppForUsersDB {

    public static void main(String[] args) {

        try (Connection connection = DriverManager.getConnection
                ("jdbc:mysql://localhost:3306/programming_school?useSSL=false", "root", "coderslab")) {

            while (true) {

                User.loadAll(connection);
                Scanner scanner = new Scanner(System.in);
                System.out.println("What you want to do: add/edit/delete user or quit");
                String userChoice = scanner.nextLine();
                User user = new User();

                switch (userChoice) {

                    case "add":

                        System.out.println("Name?");
                        user.setUsername(scanner.nextLine());
                        System.out.println("Email?");
                        user.setEmail(scanner.nextLine());
                        System.out.println("Password?");
                        user.setPassword(scanner.nextLine());
                        user.saveToDB(connection);
                        break;

                    case "edit":
                        System.out.println("ID?");
                        user = User.loadById(connection, Integer.parseInt(scanner.nextLine()));
                        System.out.println("Name?");
                        user.setUsername(scanner.nextLine());
                        System.out.println("Email?");
                        user.setEmail(scanner.nextLine());
                        System.out.println("Password?");
                        user.setPassword(scanner.nextLine());
                        user.saveToDB(connection);
                        break;

                    case "delete":

                        System.out.println("ID?");
                        int id = Integer.parseInt(scanner.nextLine());
                        User.deleteByID(connection, id);
                        break;

                    case "quit":
                        System.out.println("End Programm");
                        return;
                }

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
