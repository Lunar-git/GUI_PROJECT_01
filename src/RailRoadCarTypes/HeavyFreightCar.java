package RailRoadCarTypes;

import Exceptions.LoadException;

public class HeavyFreightCar extends RailRoadCar {
    private static int currentLoad;
    private static final int maxCapacity;
    static {
        maxCapacity = 60000;
        currentLoad = 0;
    }
    public HeavyFreightCar(String shipper) {
        super(shipper);
        type = "Heavy";
        grossWeight = Math.round(Math.random()*120000 + 150000);
        securityInfo = "Locks and Seals: Basic freight railroad cars should be equipped with secure locks and seals" +
                " to prevent unauthorized access or tampering. The seals can be used to indicate if the car" +
                " has been opened or not since the last time it was checked.\n" +
                "\n" +
                "Monitoring: Railroad companies should regularly monitor the status of their basic" +
                " freight railroad cars to ensure that they are in good condition and secure." +
                " This can be done using GPS tracking devices or other remote monitoring technologies.\n" +
                "\n" +
                "Inspection: Before loading or unloading, it's important to inspect the " +
                "basic freight railroad cars for signs of damage or tampering." +
                " This can help prevent potential safety hazards or security breaches.\n" +
                "\n" +
                "Employee Training: Railroad companies should provide their employees with training" +
                " on how to handle and secure basic freight railroad cars. Employees should be trained" +
                " on how to recognize and report any suspicious activities or potential security threats.\n" +
                "\n" +
                "Risk Assessment: Railroad companies should conduct regular risk assessments to identify" +
                " any potential security vulnerabilities in their basic freight railroad cars." +
                " This can help them develop and implement security protocols to prevent security breaches.\n" +
                "\n" +
                "Communication: It's important for railroad companies to maintain clear communication" +
                " with law enforcement agencies and other relevant authorities." +
                " This can help them quickly respond to any security incidents and minimize potential damages.";
    }
    public void load(int amount) throws LoadException {
        if(currentLoad + amount > maxCapacity) {
            throw new LoadException("Cannot load more than capacity");
        }
        this.currentLoad += amount;
    }

    public void unload(int amount) throws LoadException {
        if(currentLoad <= 0) {
            throw new LoadException("The Railroad Car is empty, there is nothing to unload");
        }
        this.currentLoad -= amount;
    }

    public double getCurrentLoad() {
        return currentLoad;
    }

    @Override
    public String toString() {
        return "Type: Heavy Freight Car " + " ID " + this.getID() + " Current Weight Load " + this.grossWeight + " kilos";
    }
}
