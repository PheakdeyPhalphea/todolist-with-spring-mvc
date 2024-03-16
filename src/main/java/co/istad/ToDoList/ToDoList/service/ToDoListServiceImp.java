package co.istad.ToDoList.ToDoList.service;

import co.istad.ToDoList.ToDoList.model.ToDoList;
import co.istad.ToDoList.ToDoList.repository.ToDoListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ToDoListServiceImp implements ToDoListService {
    private final ToDoListRepository toDoListRepository;
    @Override
    public List<ToDoList> getAllToDoList() {
        return toDoListRepository.getToDoLists();
    }

    @Override
    public ToDoList getListItemByID(Integer id) {
        return toDoListRepository.getToDoLists().stream().filter(e -> e.getId().equals(id)).findFirst().orElse(null);
    }


    @Override
    public void addNewItem(ToDoList toDoList) {
        toDoListRepository.getToDoLists().add(toDoList);
    }

    @Override
    public  void updateItemById(ToDoList toDoList) {
          toDoListRepository.getToDoLists()
                .stream()
                .filter(itemId -> itemId.getId().equals(toDoList.getId())).forEach(p -> {
            p.setTask(toDoList.getTask());
            p.setIsDone(toDoList.getIsDone());
            p.setDescription(toDoList.getDescription());
        });
    }


    @Override
    public void deleteItemById(Integer id) {
        toDoListRepository.getToDoLists()
                .stream()
                .filter(e -> e.getId()
                        .equals(id)).findFirst()
                .ifPresent(toDoList -> toDoListRepository.getToDoLists().remove(toDoList));
    }

    @Override
    public List<ToDoList> seachToDoby(String task, Boolean isDone) {
        return toDoListRepository.getToDoLists().stream()
                .filter(todo -> todo.getTask().equalsIgnoreCase(task) && todo.getIsDone() == isDone).toList();
    }
}
