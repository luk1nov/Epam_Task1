package lukyanov.task.arrays.entity;

public abstract class AbstractArrayEntity {
    private long id;

    public AbstractArrayEntity() {
    }

    public AbstractArrayEntity(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
