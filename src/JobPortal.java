import java.util.ArrayList;

public class JobPortal {
    private ArrayList<Employee> employees;
    private ArrayList<Employer> employers;
    private ArrayList<Job> jobs;
    private InputScanner input;
    private User currentUser;
    private boolean userIsEmployer;
    private boolean isLoggedIn;

    public JobPortal() {
        this.employees = new ArrayList<Employee>();
        this.employers = new ArrayList<Employer>();
        this.jobs = new ArrayList<Job>();
        this.input = new InputScanner();
        this.isLoggedIn = false;
    }

    public boolean checkUserType() {
        String type = this.input.readStringInput("Enter y/n if you are an employer");
        if (type.length() > 1) {
            System.out.println("Unexpected Input");
            return false;
        }
        if (type.equalsIgnoreCase("y")) {
            this.userIsEmployer = true;
            return true;
        } else if (type.equalsIgnoreCase("n")) {
            this.userIsEmployer = false;
            return true;
        } else {
            System.out.println("Unexpected Input");
            return false;
        }
    }

    public void signIn() {
        this.checkUserType();
        int id = this.input.readIntegerInput("Enter your id");
        String name = this.input.readStringInput("Enter your name");
        String password = this.input.readStringInput("Enter password");
        if (!userExist(id, name, password)) {
            System.out.println("User does not Exist. Please try again");
            return;
        }
        this.isLoggedIn = true;
        this.currentUser.describe();
    }

    public void signUp() {
        if (!this.checkUserType()) {
            return;
        }
        String name = this.input.readStringInput("Enter your name");
        String password = this.input.readStringInput("Enter password");
        if (userExist(-1, name, password)) {
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

    public boolean userExist(int id, String name, String password) {
        if (userIsEmployer) {
            if (this.employers.isEmpty()) {
                return false;
            }
            for(Employer current: this.employers) {
                if (id != -1) {
                    if (current.match(id, name, password)) {
                        this.currentUser = current;
                        return true;
                    }
                } else {
                    if (current.match(name, password)) {
                        this.currentUser = current;
                        return true;
                    }
                }
            }
            return false;
        }
        if (this.employees.isEmpty()) {
            return false;
        }
        for(Employee current: this.employees) {
            if (id != -1) {
                if (current.match(id, name, password)) {
                    this.currentUser = current;
                    return true;
                }
            } else {
                if (current.match(name, password)) {
                    this.currentUser = current;
                    return true;
                }
            }
        }
        return false;
    }

}
