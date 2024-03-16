package co.istad.ToDoList.ToDoList.service;

import co.istad.ToDoList.ToDoList.model.ToDoList;

import java.util.List;
import java.util.Optional;

public interface ToDoListService {
    List<ToDoList>  getAllToDoList();
    ToDoList getListItemByID(Integer id);
    void addNewItem (ToDoList toDoList);
   void updateItemById (ToDoList toDoList);
    void deleteItemById (Integer id);
    List<ToDoList> seachToDoby(String task , Boolean isDone);
}
