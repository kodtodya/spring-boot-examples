package com.kodtodya.practice.todo;

import com.kodtodya.practice.model.Todo;
import com.kodtodya.practice.todo.service.TodoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
//@SessionAttributes("name")
public class TodoController {

	@Autowired
	private TodoService service;

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, false));
	}

	@GetMapping(value = "/list-todos")
	public String showTodosList(ModelMap model) {
		model.addAttribute("todos", service.retrieveTodos("admin"));
		return "list-todos.jsp";
	}

	@RequestMapping(value = "/add-todo", method = RequestMethod.GET)
	public String showAddTodoPage(ModelMap model) {
		model.addAttribute("command", new Todo());
		//model.addAttribute("todo", new Todo());
		return "todo.jsp";
	}

	@PostMapping(value = "/add-todo")
	public String addTodo(ModelMap model, @Valid Todo todo, BindingResult result) {

		if (result.hasErrors())
			return "todo.jsp";

		service.addTodo("admin", todo.getDesc(), todo.getTargetDate(), false);
		model.clear();// to prevent request parameter "name" to be passed
		return "redirect:/list-todos";
	}

	@GetMapping(value = "/update-todo")
	public String showUpdateTodoPage(ModelMap model, @RequestParam int id) {
		//model.addAttribute("todo", service.retrieveTodo(id));
		model.addAttribute("command", service.retrieveTodo(id));
		return "todo.jsp";
	}

	@PostMapping(value = "/update-todo")
	public String updateTodo(ModelMap model, @Valid Todo todo,
			BindingResult result) {
		if (result.hasErrors())
			return "todo.jsp";

		todo.setUser("admin");
		service.updateTodo(todo);

		model.clear();// to prevent request parameter "name" to be passed
		return "redirect:/list-todos.jsp";
	}

	@RequestMapping(value = "/delete-todo", method = RequestMethod.GET)
	public String deleteTodo(@RequestParam int id) {
		service.deleteTodo(id);

		return "redirect:/list-todos.jsp";
	}
}