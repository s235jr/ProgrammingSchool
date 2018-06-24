package src.main.java.pl.s235jr;

import src.main.java.pl.s235jr.model.Solution;
import src.main.java.pl.s235jr.model.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class AppForSolutionDB {

    public static void main(String[] args) {

        try (Connection connection = DriverManager.getConnection
                ("jdbc:mysql://localhost:3306/programming_school?useSSL=false", "root", "coderslab")) {

            while (true) {

                //Solution.loadAll(connection);
                Scanner scanner = new Scanner(System.in);
                System.out.println("What you want to do: add/edit/view/delete user or quit");
                String userChoice = scanner.nextLine();
                Solution solution = new Solution();

                switch (userChoice) {

                    case "add":

                        System.out.println("Data created?");
                        solution.setCreated(scanner.nextLine());
                        System.out.println("Data Updated?");
                        solution.setUpdated(scanner.nextLine());
                        System.out.println("Description?");
                        solution.setDescription(scanner.nextLine());
                        System.out.println("Exercise Id?");
                        solution.setExercise_id(Integer.parseInt(scanner.nextLine()));
                        System.out.println("User Id?");
                        solution.setUsers_id(Integer.parseInt(scanner.nextLine()));
                        solution.saveToDB(connection);
                        break;

                    case "edit":

                        System.out.println("ID?");
                        solution = Solution.loadById(connection, Integer.parseInt(scanner.nextLine()));
                        System.out.println("Data created?");
                        solution.setCreated(scanner.nextLine());
                        System.out.println("Data Updated?");
                        solution.setUpdated(scanner.nextLine());
                        System.out.println("Description?");
                        solution.setDescription(scanner.nextLine());
                        System.out.println("Exercise Id?");
                        solution.setExercise_id(Integer.parseInt(scanner.nextLine()));
                        System.out.println("User Id?");
                        solution.setUsers_id(Integer.parseInt(scanner.nextLine()));
                        solution.saveToDB(connection);
                        break;

                    case "view":

                        System.out.println("ID?");
                        int id = Integer.parseInt(scanner.nextLine());
                        Solution.loadAllByUserId(connection, id);
                        break;

                    case "delete":

                        System.out.println("ID?");
                        id = Integer.parseInt(scanner.nextLine());
                        Solution.deleteByID(connection, id);
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
