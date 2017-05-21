package by.bsuir.portscanner.server;

import java.util.ArrayList;

public class ScannedHost {

    private String host;
    private ArrayList<Integer> openedPorts;
    private long executionTime;

    public ScannedHost(String host, ArrayList<Integer> openedPorts, long executionTime) {
        this.host = host;
        this.openedPorts = openedPorts;
        this.executionTime = executionTime;
    }

    public ScannedHost() {
    }

    public String getHost() {
        return host;
    }

    public ArrayList<Integer> getOpenedPorts() {
        return openedPorts;
    }

    public long getExecutionTime() {
        return executionTime;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public void setOpenedPorts(ArrayList<Integer> openedPorts) {
        this.openedPorts = openedPorts;
    }

    public void setExecutionTime(long executionTime) {
        this.executionTime = executionTime;
    }
}
