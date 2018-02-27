package com.trs.estimation;

public class TaskEffort {
    private String name;
    private int effortInHours;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEffortInHours() {
        return effortInHours;
    }

    public void setEffortInHours(int effortInHours) {
        this.effortInHours = effortInHours;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TaskEffort{");
        sb.append("name='").append(name).append('\'');
        sb.append(", effortInHours='").append(effortInHours).append('\'');
        sb.append('}');
        return sb.toString();
    }
}

