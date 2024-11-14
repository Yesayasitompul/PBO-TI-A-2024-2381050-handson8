import config.Database;
import entities.TodoList;
import repositories.TodoListRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class TodoListRepositoryDblmpl  implements TodoListRepository {
    private final Database database;

    public  TodoListRepositoryDblmpl(final Database database) {
        this.database = database;
    }
    @Override
    public TodoList[] getAll(){
        Connection connection = database.getConnection();
        String sqlStatement = "SELECT * FROM todos";
        list<TodoList> todoList = new ArrayList<>();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sqlStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                TodoList todoList = new TodoList();
                Integer id - resultSet.getInt(1);
                String todo = resultSet.getNString(2);
                todoList.setTodo(todo);
                todoList.setId();
                todoList.add(todoList);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return todoList.toArray(todoList[]::new);
    }

    @Override
    public void add(TodoList todoList) {

    }

    @Override
    public Boolean remove(Integer id) {
        return null;
    }

    @Override
    public Boolean edit(TodoList todoList) {
        return null;
    }
}
