package src.main.java.pl.s235jr;

import src.main.java.pl.s235jr.model.Exercise;
import src.main.java.pl.s235jr.model.Group;
import src.main.java.pl.s235jr.model.Solution;
import src.main.java.pl.s235jr.model.User;

import java.sql.*;
import java.util.Random;

public class Boot {

    public static void main(String[] args) {

        try (Connection connection = DriverManager.getConnection
                ("jdbc:mysql://localhost:3306/programming_school?useSSL=false", "root", "coderslab")) {

            //User user = User.loadById(connection, 1);
            //System.out.println(user);

            //User basia = new User("basia", "basia" + new Random().nextInt() +"@wp.pl", "password");
            //basia.saveToDB(connection);
            //User jan = User.loadById(connection, 1);
            //jan.setPassword("modPass");
            //jan.saveToDB(connection);

            //User.loadAll(connection);
            //User.deleteByID(connection, 6);

            //Group group = Group.loadById()
            //Group group1 = new Group("WARSZAWA");
            //group1.saveToDB(connection);
            //Group group = Group.loadById(connection, 1);
            //System.out.println(group);
            //group.setName("Grupa Java");
            //group.saveToDB(connection);
            //Group.loadAll(connection);
            //Group.deleteByID(connection, 3);
            //Group.loadAll(connection);

            //Exercise exercise = new Exercise("Zadanie 3", "Opis do zadania 2");
            //exercise.saveToDB(connection);
            //exercise = Exercise.loadById(connection,3);
            //exercise.setDescription("Opis do zadania 3");
            //exercise.saveToDB(connection);
            //Exercise.deleteByID(connection, 3);
            //Exercise.loadAll(connection);

            //Solution solution = new Solution("2008-11-09 15:45:21", null, "opis rozwiązania", 5, 2);
            //solution.saveToDB(connection);
            //Solution solution1 = Solution.loadById(connection, 2);
            //System.out.println(solution1);
            //Solution.deleteByID(connection, 6);
            //solution1.setDescription("Dodatowy opis zadania");
            //solution1.setUpdated("2008-11-09 19:43:21");
            //solution1.saveToDB(connection);

            //Solution.loadAllByUserId(connection, 2);
            //Solution.loadAllByExerciseId(connection, 1);

            //Solution.loadAll(connection);
            User.loadAllByGrupId(connection, 1);


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}