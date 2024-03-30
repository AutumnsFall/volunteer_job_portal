public class Employee extends User{
    private Job currentJob;

    public Employee(int id, String name, String password) {
        super(id, name, password);
    }

    public boolean hasJob() {
        return this.currentJob != null;
    }

}
