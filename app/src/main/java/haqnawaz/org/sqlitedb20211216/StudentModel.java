package haqnawaz.org.sqlitedb20211216;

public class StudentModel {
    private String name;
    private int age;
    private boolean isActive;
    private int id;
    public StudentModel(String name, int age, boolean isActive) {
        this.name = name;
        this.age = age;
        this.isActive = isActive;
     }
    public StudentModel(int id,String name, int age, boolean isActive) {
        this.id=id;
        this.name = name;
        this.age = age;
        this.isActive = isActive;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isActive() {
        return this.isActive;
    }

    public void setActive(boolean active) {
        this.isActive = active;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "StudentModel{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", isActive=" + isActive +
                ", id=" + id +
                '}';
    }
}
