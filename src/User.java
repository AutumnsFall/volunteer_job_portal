public abstract class User {
    protected int id;
    protected String name;
    protected String password;
    protected boolean isDeleted;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(int id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.isDeleted = false;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean match(int id, String name, String password) {
        return this.id == id && match(name, password);
    }

    public boolean match(String name, String password) {
        return this.name.equals(name) && this.password.equals(password);
    }

    public void describe() {
        System.out.println("Id: " + this.id);
        System.out.println("Name" + this.name);
    }

    public void deleteAccount() {
        this.isDeleted = true;
    }
}
