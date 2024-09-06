package com.solvd.eduncan;

import java.util.Arrays;
import java.util.TreeMap;

public final class Client {
    private final String clientId;
    private String name;
    private String industry;
    private Project[] currentClientProjects;
    private Project[] pastClientProjects;
    private final TreeMap<String, Project> projectMap;

    public Client(String clientId, String name, String industry, Project[] currentClientProjects, Project[] pastClientProjects) throws InvalidClientIdException {
        if (clientId == null || clientId.isEmpty()) {
            throw new InvalidClientIdException("Client id cannot be null or empty");
        }

        this.clientId = clientId;

        this.name = name;
        this.industry = industry;
        this.currentClientProjects = currentClientProjects;
        this.pastClientProjects = pastClientProjects;
        this.projectMap = new TreeMap<>();
    }

    public String getClientId() {
        return clientId;
    }

    public String getName() {
        return name;
    }

    public String getIndustry() {
        return industry;
    }

    public Project[] getClientProject() {
        return currentClientProjects;
    }

    public void setClientName(String clientName) {
        this.name = clientName;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public void setClientProject(Project[] currentClientProjects) {
        this.currentClientProjects = currentClientProjects;
    }

    public void setPastClientProject(Project[] pastClientProjects) {
        this.pastClientProjects = pastClientProjects;
    }

    public void addProject(String projectId, Project project) {
        projectMap.put(projectId, project);
    }

    public TreeMap<String, Project> getProjectMap() {
        return new TreeMap<>(projectMap);
    }

    @Override
    public String toString() {
        return clientId + " " + name + " " + industry + "\n" + Arrays.toString(currentClientProjects) + "\n" + Arrays.toString(pastClientProjects) ;
    }

}
