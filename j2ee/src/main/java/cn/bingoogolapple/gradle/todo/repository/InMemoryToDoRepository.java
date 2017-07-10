package cn.bingoogolapple.gradle.todo.repository;

import cn.bingoogolapple.gradle.todo.model.ToDoItem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 作者:王浩 邮件:bingoogolapple@gmail.com
 * 创建时间:2017/7/10 下午10:21
 * 描述:
 */
public class InMemoryToDoRepository implements ToDoRepository {
    private AtomicLong currentId = new AtomicLong();
    private ConcurrentMap<Long, ToDoItem> toDos = new ConcurrentHashMap<>();

    @Override
    public List<ToDoItem> findAll() {
        List<ToDoItem> toDoItems = new ArrayList<>(toDos.values());
        Collections.sort(toDoItems);
        return toDoItems;
    }

    @Override
    public ToDoItem findById(Long id) {
        return toDos.get(id);
    }

    @Override
    public Long insert(ToDoItem toDoItem) {
        Long id = currentId.incrementAndGet();
        toDoItem.setId(id);
        toDos.putIfAbsent(id, toDoItem);
        return id;
    }

    @Override
    public void update(ToDoItem toDoItem) {
        toDos.replace(toDoItem.getId(), toDoItem);
    }

    @Override
    public void delete(ToDoItem toDoItem) {
        toDos.remove(toDoItem.getId());
    }
}
