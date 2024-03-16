package co.istad.ToDoList.ToDoList.repository;

import co.istad.ToDoList.ToDoList.ToDoListApplication;
import co.istad.ToDoList.ToDoList.model.ToDoList;
import lombok.Data;
import lombok.Getter;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Repository
@Data
public class ToDoListRepository {
    private  List<ToDoList> toDoLists = new ArrayList<>();
    public  ToDoListRepository (){
        toDoLists.add(new ToDoList(1, "homework001", "fetch api with react", true, LocalDate.now()));
        toDoLists.add(new ToDoList(2, "homework002", "fetch api with next", false, LocalDate.now()));
        toDoLists.add(new ToDoList(3, "homework003", "fetch api with js", true, LocalDate.now()));
        toDoLists.add(new ToDoList(4, "homework004", "spring with Thymeleaf ", false, LocalDate.now()));
    }
}