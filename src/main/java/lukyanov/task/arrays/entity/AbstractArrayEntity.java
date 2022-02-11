package lukyanov.task.arrays.entity;

public abstract class AbstractArrayEntity {
    private int id;

    public AbstractArrayEntity() {
    }

    public AbstractArrayEntity(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
