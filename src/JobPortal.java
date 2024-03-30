import java.util.ArrayList;

public class JobPortal {
    private ArrayList<Employee> employees;
    private ArrayList<Employer> employers;
    private ArrayList<Job> jobs;
    private InputScanner input;
    private boolean userIsEmployer;

    public JobPortal() {
        this.employees = new ArrayList<Employee>();
        this.employers = new ArrayList<Employer>();
        this.jobs = new ArrayList<Job>();
        this.input = new InputScanner();
    }

    public void signUp() {
        String name = this.input.readStringInput("Enter your name");
        String password = this.input.readStringInput("Enter password");
        if (userExist(name, password)) {
            System.out.println("User Already Exist. Please Log In");
        }
        if (this.userIsEmployer) {
            this.employers.add(new Employer(
                    this.employers.size() + 1,
                    name,
                    password
            ));
            return;
        }
        this.employees.add(new Employee(
                this.employees.size() + 1,
                name,
                password
        ));
        return;
    }

    public boolean userExist(String name, String password) {
        if (userIsEmployer) {
            if (this.employers.isEmpty()) {
                return false;
            }
            for(Employer current: this.employers) {
                if (current.match(name, password)) {
                    return true;
                }
            }
            return false;
        }
        if (this.employees.isEmpty()) {
            return false;
        }
        for(Employee current: this.employees) {
            if (current.match(name, password)) {
                return true;
            }
        }
        return false;
    }

}
