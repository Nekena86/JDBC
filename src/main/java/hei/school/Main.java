package hei.school;

import hei.school.entity.Student;
import hei.school.repository.StudentRepository;

public class Main {
    public static void main(String[] args) {

        StudentRepository repo = new StudentRepository();

        // INSERT
        repo.insert(new Student(1, "Nekena", 20));
        repo.insert(new Student(2, "Alice", 18));

        // SELECT
        System.out.println("Liste des étudiants :");
        repo.findAll().forEach(s ->
                System.out.println(s.getId() + " - " + s.getName() + " - " + s.getAge())
        );

        // UPDATE
        repo.updateName(1, "Nekena Andria");

        // DELETE
        repo.delete(2);
    }
}