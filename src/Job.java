import java.util.ArrayList;

public class Job {
    private int id;
    private String name;
    private Employer owner;
    private boolean isActive;
    private int requiredEmployeeCount;
    private ArrayList<Integer> acceptedEmployeeIds;
    private ArrayList<Integer> pendingEmployeeIds;



    public Job() {
        this.acceptedEmployeeIds = new ArrayList<Integer>();
        this.pendingEmployeeIds = new ArrayList<Integer>();
    }

    public void applyJob(int newEmployeeId) {
        this.pendingEmployeeIds.add(newEmployeeId);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getNameSmallLetter() {
        return name.toLowerCase();
    }

    public Employer getOwner() {
        return owner;
    }

    public boolean isActive() {
        return isActive;
    }

    public int getRequiredEmployeeCount() {
        return requiredEmployeeCount;
    }

    public ArrayList<Integer> getAcceptedEmployeeIds() {
        return acceptedEmployeeIds;
    }

    public boolean isSearchable() {
        return this.isActive();
    }

    public ArrayList<Integer> getPendingEmployeeIds() {
        return pendingEmployeeIds;
    }
}
