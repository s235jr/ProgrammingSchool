package src.main.java.pl.s235jr;

import src.main.java.pl.s235jr.model.Exercise;
import src.main.java.pl.s235jr.model.Group;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class AppForGroupDB {

    public static void main(String[] args) {

        try (Connection connection = DriverManager.getConnection
                ("jdbc:mysql://localhost:3306/programming_school?useSSL=false", "root", "coderslab")) {

            while (true) {

                Group.loadAll(connection);
                Scanner scanner = new Scanner(System.in);
                System.out.println("What you want to do: add/edit/delete user or quit");
                String userChoice = scanner.nextLine();
                Group group = new Group();

                switch (userChoice) {

                    case "add":

                        System.out.println("Name?");
                        group.setName(scanner.nextLine());
                        group.saveToDB(connection);
                        break;

                    case "edit":
                        System.out.println("ID?");
                        group = Group.loadById(connection, Integer.parseInt(scanner.nextLine()));
                        System.out.println("Name?");
                        group.setName(scanner.nextLine());
                        System.out.println("Email?");
                        group.saveToDB(connection);
                        break;

                    case "delete":

                        System.out.println("ID?");
                        int id = Integer.parseInt(scanner.nextLine());
                        Group.deleteByID(connection, id);
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