package cn.bingoogolapple.gradle.todo.repository;

import cn.bingoogolapple.gradle.todo.model.ToDoItem;

import java.util.List;

/**
 * 作者:王浩 邮件:bingoogolapple@gmail.com
 * 创建时间:2017/7/10 下午10:19
 * 描述:
 */
public interface ToDoRepository {
    List<ToDoItem> findAll();
    ToDoItem findById(Long id);
    Long insert(ToDoItem toDoItem);
    void update(ToDoItem toDoItem);
    void delete(ToDoItem toDoItem);
}
