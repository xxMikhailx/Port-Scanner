package by.bsuir.portscanner.client.form;

import by.bsuir.portscanner.client.action.PortScanner;
import by.bsuir.portscanner.client.domain.ScannedHost;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;


public class ScanFrame extends JFrame {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    Environment environment;

    private static final Logger log = LoggerFactory.getLogger(ScanFrame.class);

    private JTextField jTextField1;
    private JButton jButton1;
    private JScrollPane jScrollPane1;
    private JTextArea jTextArea1;
    private JTextField jTextField2;
    private JTextField jTextField3;
    private JSeparator jSeparator1;
    private ArrayList<Integer> openPortsList;
    private JLabel jLabel5;
    private JLabel jLabel4;
    private JLabel jLabel3;
    private JLabel jLabel2;
    private JLabel jLabel1;
    private ScannedHost resultExternal;
    private ScannedHost resultLocal;

    public ScanFrame() {
        super("Port Scanner");
        openPortsList = null;
        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Test");
        jButton1.addActionListener(this::jButton1ActionPerformed);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setToolTipText("");
        jScrollPane1.setViewportView(jTextArea1);

        jTextField2.setToolTipText("");

        jTextField3.setToolTipText("");

        jLabel1.setText("Port's Range");

        jLabel2.setText("Min port:");

        jLabel3.setText("Max port:");

        jLabel4.setText("IP to scan:");

        jLabel5.setText("Result");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jSeparator1)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(88, 88, 88)
                                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(88, 88, 88)
                                                .addComponent(jLabel1))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(113, 113, 113)
                                                .addComponent(jLabel5))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                        .addContainerGap()
                                                        .addComponent(jTextField1))
                                                .addGroup(layout.createSequentialGroup()
                                                        .addGap(11, 11, 11)
                                                        .addComponent(jLabel2)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(jLabel4)
                                                                .addGroup(layout.createSequentialGroup()
                                                                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                        .addComponent(jLabel3)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2)
                                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel3))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(jLabel5)
                                .addGap(10, 10, 10)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1)
                                .addContainerGap())
        );

    }

    private String PortListToStr(ArrayList<Integer> openPortsListLocal, ArrayList<Integer> openPortsListExternal) {
        String Text = "";
        if (openPortsListLocal != null) {
            if (openPortsListLocal.size() > 0) {
                for (Integer openedPort : openPortsListLocal) {
                    if (openPortsListExternal.contains(openedPort)) {
                        Text += openedPort + "+" + "\n";
                    } else {
                        Text += openedPort + "\n";
                    }
                }
            }
        } else {
            Text += "\nError happened!\n";
        }
        return Text;
    }

    private void jButton1ActionPerformed(ActionEvent evt) {
        int port1;
        int port2;
        int i;
        long time=0;
        try {
            port1 = Integer.parseInt(jTextField2.getText());
        } catch (Exception ex) {
            port1 = 1;
        }
        try {
            port2 = Integer.parseInt(jTextField3.getText());
        } catch (Exception ex) {
            port2 = 1000;
        }
        i = port1;
        jTextArea1.setText(jTextArea1.getText() + "\nScanning ports("+port1+"-"+port2+")...\nHost:  " + jTextField1.getText() + "\nList of opened ports:\n");
        jTextArea1.update(jTextArea1.getGraphics());
        while(i < port2){
            if(i+100 < port2){
                resultLocal = new PortScanner( i ,i+100,jTextField1.getText(), 50).scan();
                log.info("Local result: " + resultLocal.toString());
                resultExternal = restTemplate.getForObject(buildURI(i, i+100, jTextField1.getText(), 100), ScannedHost.class);
                log.info("External result: " + resultExternal.toString());
                jTextArea1.setText(jTextArea1.getText() + PortListToStr(resultLocal.getOpenedPorts(), resultExternal.getOpenedPorts()));
                time += resultLocal.getExecutionTime() + resultExternal.getExecutionTime();
                i +=100;
                jTextArea1.update(jTextArea1.getGraphics());
            }else{
                resultLocal = new PortScanner(i, port2, jTextField1.getText(), 50).scan();
                log.info("Local result: " + resultLocal.toString());
                resultExternal = restTemplate.getForObject(buildURI(i, port2, jTextField1.getText(), 100), ScannedHost.class);
                log.info("External result: " + resultExternal.toString());
                jTextArea1.setText(jTextArea1.getText() + PortListToStr(resultLocal.getOpenedPorts(), resultExternal.getOpenedPorts()));
                time += resultLocal.getExecutionTime() + resultExternal.getExecutionTime();
                i = port2;
                jTextArea1.update(jTextArea1.getGraphics());
            }
        }
        jTextArea1.setText(jTextArea1.getText() +"Execution time:  " + time + " ms\n");
        }

    private String buildURI(int minPort, int maxPort, String host, long timeout) {
        return UriComponentsBuilder.newInstance()
                .scheme("http")
                .host(environment.getRequiredProperty("server.address"))
                .path("/scan")
                .queryParam("host", host)
                .queryParam("minPort", minPort)
                .queryParam("maxPort", maxPort)
                .queryParam("timeout", timeout)
                .build()
                .toUriString();
    }
}
