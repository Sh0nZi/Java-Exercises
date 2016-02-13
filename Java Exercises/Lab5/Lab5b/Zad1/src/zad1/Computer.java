/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad1;

/**
 *
 * @author sstoyanov
 */
public class Computer {

    private String type;
    private double procSpeed;
    private String[] files;

    public Computer()  {
        this("Lenovo", 2.6, new String[] { "Sample.dll" });
    }

    public Computer(String type, double procSpeed, String[] files) {
        this.setType(type);
        this.setProcSpeed(procSpeed);
        this.setFiles(files);
    }

    public Computer(Computer computer){
        this(computer.getType(), computer.getProcSpeed(),computer.getFiles());
    }

    public String getType() {
        return this.type;
    }

    public final void setType(String type) {
        if (type == null || "".equals(type)) {
            throw new IllegalArgumentException("Computer type should not be null or empty");
        }
        this.type = type;
    }

    public double getProcSpeed() {
        return this.procSpeed;
    }

    public final void setProcSpeed(double procSpeed) {
        if (procSpeed <= 0) {
            throw new IllegalArgumentException("Computer processor speed should be positive!");
        }
        this.procSpeed = procSpeed;
    }

    public String[] getFiles() {
        return this.files;
    }

    public final void setFiles(String[] files) {
        if (files == null) {
            throw new IllegalArgumentException("Computer files cannot be null!");
        }

        for (String f : files) {
            if (f == null || "".equals(f)) {
                throw new IllegalArgumentException("Computer cannot containg file with null or empty name!");
            }
        }

        this.files = files;
    }

    @Override
    public String toString() {
        String filesList = "";
        for (int i = 0; i < this.getFiles().length; i++) {
            filesList +=  (i > 0 ? "; " : "") + this.getFiles()[i];
        }

        return String.format("Type: %1s; CPU: %2s\n Files: %3s",
                this.getType(), this.getProcSpeed(), filesList);
    }
}
