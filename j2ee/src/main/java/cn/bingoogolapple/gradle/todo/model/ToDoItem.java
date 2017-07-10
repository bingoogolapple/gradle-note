package cn.bingoogolapple.gradle.todo.model;

/**
 * 作者:王浩 邮件:bingoogolapple@gmail.com
 * 创建时间:2017/7/10 下午10:16
 * 描述:
 */
public class ToDoItem implements Comparable<ToDoItem> {
    private Long id;
    private String name;
    private Boolean completed;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean isCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    @Override
    public int compareTo(ToDoItem o) {
        return id - o.id > 0 ? 1 : -1;
    }
}
