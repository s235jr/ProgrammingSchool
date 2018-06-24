package src.main.java.pl.s235jr;

import src.main.java.pl.s235jr.model.Exercise;
import src.main.java.pl.s235jr.model.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class AppForExerciseDB {

    public static void main(String[] args) {

        try (Connection connection = DriverManager.getConnection
                ("jdbc:mysql://localhost:3306/programming_school?useSSL=false", "root", "coderslab")) {

            while (true) {

                Exercise.loadAll(connection);
                Scanner scanner = new Scanner(System.in);
                System.out.println("What you want to do: add/edit/delete user or quit");
                String userChoice = scanner.nextLine();
                Exercise exercise = new Exercise();

                switch (userChoice) {

                    case "add":

                        System.out.println("Name?");
                        exercise.setTitle(scanner.nextLine());
                        System.out.println("Description?");
                        exercise.setDescription(scanner.nextLine());
                        exercise.saveToDB(connection);
                        break;

                    case "edit":
                        System.out.println("ID?");
                        exercise = Exercise.loadById(connection, Integer.parseInt(scanner.nextLine()));
                        System.out.println("Name?");
                        exercise.setTitle(scanner.nextLine());
                        System.out.println("Email?");
                        exercise.setTitle(scanner.nextLine());
                        exercise.saveToDB(connection);
                        break;

                    case "delete":

                        System.out.println("ID?");
                        int id = Integer.parseInt(scanner.nextLine());
                        Exercise.deleteByID(connection, id);
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
