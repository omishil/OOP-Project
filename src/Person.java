abstract class Person {

    private String name;
    private int id;
    private int age;

    Person(String name, int id, int age) {
        this.name = name;
        this.id = id;
        this.age = age;
    }

    String getName() {
        return name;
    }

    int getId() {
        return id;
    }

    int getAge() {
        return age;
    }

    abstract void displayInfo();
}