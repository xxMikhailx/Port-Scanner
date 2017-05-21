package by.bsuir.portscanner.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;


public class PortScanner {

    private static final Logger log = LoggerFactory.getLogger(PortScanner.class);

    private int minPort = 1;
    private int maxPort = 65_535;
    private String host = "192.168.100.6";
    private int timeout = 100;
    private ArrayList<Integer> openPortsList = null;
    private long executionTime;

    public PortScanner(int minPort, int maxPort, String host, int timeout) {
        if (!(minPort == -1 && maxPort == -1)){
            if(!(maxPort == -1)) {
                this.minPort = minPort;
                this.maxPort = maxPort;
            } else {
                this.minPort = minPort;
                this.maxPort = minPort;
            }
        }
        this.host = host;
        this.timeout = timeout;
    }

    public String getHost() {
        return host;
    }

    public ArrayList<Integer> getOpenPortsList() {
        return openPortsList;
    }

    public long getExecutionTime() {
        return executionTime;
    }

    public ScannedHost scan() {
        log.info("----------------------------------------------------");
        log.info("Starting scan " + host + ":");
        log.info("Timeout " + timeout + "...");
        log.info("Scanning " + ((maxPort-minPort)+1) + " port(s) (" + minPort + "-" + maxPort + ")...");

        ScannedHost result = new ScannedHost();
        Date startTime = new Date();
        try {
            InetAddress ia = InetAddress.getByName(getHost());
            result.setOpenedPorts(scan(ia));
        } catch (IOException ioe) {
            openPortsList  = null;
        }
        Date endTime = new Date();
        result.setHost(host);
        result.setExecutionTime(endTime.getTime() - startTime.getTime());

        log.info("Execution time: " + result.getExecutionTime() + " millis.");

        return result;
    }

    private ArrayList<Integer> scan(InetAddress inetAddress) {
        ArrayList<Integer> openPortsList = new ArrayList<Integer>(0xFF);
        for (int port = minPort; port <= maxPort; port++) {
            try {
                log.info("Port: " + port);
                InetSocketAddress isa = new InetSocketAddress(inetAddress, port);
                Socket socket = new Socket();
                socket.connect(isa, timeout);
                openPortsList.add(port);
                socket.close();
            } catch (IOException ioe) {
            }
        }
        return openPortsList;
    }

    private void printOpenPorts() {
        if (openPortsList != null) {
            if (openPortsList.size() > 0) {
                System.out.println("List of opened ports:");
                for (Integer openedPort : openPortsList) {
                    System.out.println(openedPort);
                }
            } else {
                System.out.println("No opened ports!");
            }
        } else {
            System.out.println("Error happened!");
        }
    }
}
