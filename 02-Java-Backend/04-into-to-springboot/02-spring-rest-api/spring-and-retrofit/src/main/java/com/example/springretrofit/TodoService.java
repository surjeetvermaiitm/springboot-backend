package com.example.springretrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.List;

public interface TodoService {
    // List all todos
    @GET("/todos")
    Call<List<Todo>> getAllTodos();

    // List todos based on ID
    @GET("/todos/{id}")
    Call<Todo> getTodosById(@Path("id") int todoId);


}
