package com.example.springretrofit;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.List;

@RestController
public class TodoController {
    String apiUrl = "https://jsonplaceholder.typicode.com/";
    Retrofit retrofit =
            new Retrofit.Builder().baseUrl(apiUrl).addConverterFactory(GsonConverterFactory.create()).build();
    TodoService service = retrofit.create(TodoService.class);

    @GetMapping("/todos")
    public List<Todo> getAllTodos() throws IOException {
        Call<List<Todo>> call = service.getAllTodos();
        Response<List<Todo>> response = call.execute();
        return response.body();
    }

    @GetMapping("/todos/1")
    public Todo getTodosById() throws IOException {
        Call<Todo> call = service.getTodosById(1);
        Response<Todo> response = call.execute();
        return response.body();
    }

}
