package by.bsuir.portscanner.client;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ScannedHost {

    private String host;
    private ArrayList<Integer> openedPorts;
    private long executionTime;

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

    @Override
    public String toString() {
        return "ScannedHost{" +
                "host='" + host + '\'' +
                ", openedPorts=" + openedPorts +
                ", executionTime=" + executionTime +
                '}';
    }
}
