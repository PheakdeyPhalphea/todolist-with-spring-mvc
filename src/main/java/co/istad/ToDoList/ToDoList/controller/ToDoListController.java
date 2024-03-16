package co.istad.ToDoList.ToDoList.controller;

import co.istad.ToDoList.ToDoList.model.ToDoList;
import co.istad.ToDoList.ToDoList.service.ToDoListService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class ToDoListController {
    private final ToDoListService toDoListService;
    @GetMapping("/todo")
    public String index(Model model){
        List<ToDoList> toDoLists = toDoListService.getAllToDoList();
        model.addAttribute("toDoListItem", toDoLists);
        return "index";
    }
    @GetMapping("/todo/{id}")
    public String getItemById (@PathVariable("id") Integer id, Model model){
        model.addAttribute("toDoListItem",   toDoListService.getListItemByID(id));
        return "index";
    }

    @GetMapping("/todo/new")
    public String addNewtoDoList (Model model){
        ToDoList toDoList = new ToDoList();
        model.addAttribute("newListItem", toDoList );
        return "add";
    }
    @PostMapping("/todo/new")
    public String addNewList (@ModelAttribute("newListItem") ToDoList toDoList){
        toDoList.setCreatedAt(LocalDate.now());
        toDoList.setIsDone(false);
        toDoListService.addNewItem(toDoList);
        return "redirect:/todo";
    }
    @GetMapping("/edit/{id}")
    public String updateProduct(@PathVariable("id") Integer id, Model model) {
        ToDoList foundItem = toDoListService.getListItemByID(id);
        model.addAttribute("foundItem", foundItem);
        return "edit";
    }
    @PostMapping("/edit")
    public String updateProduct(@ModelAttribute("foundItem") ToDoList toDoList) {
        toDoListService.updateItemById(toDoList);
        return "redirect:/todo";
    }
    @GetMapping("/todo/delete/{id}")
    public String deleteItemById ( @PathVariable("id") Integer id ){
        toDoListService.deleteItemById(id);
        return "redirect:/todo";
    }
    @GetMapping("/todo/search")
    public String searchItem(@RequestParam(required = false) String task,
                             @RequestParam(required = false) boolean isDone,
                             Model model) {
        List<ToDoList> searchResults = toDoListService.seachToDoby(task, isDone);
        model.addAttribute("searchResults", searchResults);
        if(searchResults.isEmpty()){
            return "notFoundItem";
        }else {
            return "redirect:/todo";
        }
    }

}
