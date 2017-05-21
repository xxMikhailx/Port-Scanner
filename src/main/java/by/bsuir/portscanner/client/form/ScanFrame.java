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
import javax.swing.text.MaskFormatter;
import java.awt.event.ActionEvent;
import java.text.ParseException;
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
    private JSeparator jSeparator1;
    private ArrayList<Integer> openPortsList;
    private JLabel jLabel7;
    private JLabel jLabel6;
    private JLabel jLabel5;
    private JLabel jLabel4;
    private JLabel jLabel3;
    private JLabel jLabel2;
    private JLabel jLabel1;
    private JFormattedTextField jFormattedTextField1;
    private JFormattedTextField jFormattedTextField2;
    private JFormattedTextField jFormattedTextField3;
    private JFormattedTextField jFormattedTextField4;
    private ScannedHost resultExternal;
    private ScannedHost resultLocal;

    public ScanFrame() {
        super("Port Scanner");
        openPortsList = null;
        MaskFormatter formatPort = null;
        MaskFormatter formatTimeout = null;
        try {
            formatPort = new MaskFormatter ("#####");
            formatTimeout = new MaskFormatter ("###");
        } catch (ParseException e) {
        }
        openPortsList = null;
        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jFormattedTextField1 = new javax.swing.JFormattedTextField(formatPort);
        jFormattedTextField2 = new javax.swing.JFormattedTextField(formatPort);
        jFormattedTextField3 = new javax.swing.JFormattedTextField(formatTimeout);
        jFormattedTextField4 = new javax.swing.JFormattedTextField(formatTimeout);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Scan");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setToolTipText("");
        jScrollPane1.setViewportView(jTextArea1);

        jLabel1.setText("Port's range");

        jLabel2.setText("Min port:");

        jLabel3.setText("Max port:");

        jLabel4.setText("IP to scan:");

        jLabel5.setText("Result");

        jLabel6.setText("Loc. tmeout:");

        jLabel7.setText("Glob. timeout:");


        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jSeparator1)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jLabel6)
                                                                        .addComponent(jLabel4)
                                                                        .addComponent(jLabel2))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jTextField1)
                                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                                .addComponent(jFormattedTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                                                                                .addComponent(jLabel7)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                .addComponent(jFormattedTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                                .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                .addComponent(jLabel3)
                                                                                .addGap(18, 18, 18)
                                                                                .addComponent(jFormattedTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(146, 146, 146)
                                                .addComponent(jLabel1)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(163, 163, 163)
                                                                .addComponent(jLabel5))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(134, 134, 134)
                                                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel3)
                                        .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jFormattedTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel7)
                                        .addComponent(jFormattedTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jFormattedTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(15, 15, 15)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
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
        int portFrom;
        int portTo;
        int timeoutLoc;
        int timeoutGlob;
        try {
            portFrom = Integer.parseInt(jFormattedTextField1.getText());
            portTo = Integer.parseInt(jFormattedTextField2.getText());
            timeoutLoc = Integer.parseInt(jFormattedTextField3.getText());
            timeoutGlob = Integer.parseInt(jFormattedTextField4.getText());
        } catch (Exception ex) {
            portFrom = 1;
            portTo = 1000;
            timeoutLoc = 50;
            timeoutGlob = 50;
        }

        int i = portFrom;
        long time=0;
        jTextArea1.setText(jTextArea1.getText() + "\nScanning ports("+portFrom+"-"+portTo+")...\nHost:  " + jTextField1.getText() + "\nList of opened ports:\n");
        jTextArea1.update(jTextArea1.getGraphics());
        while(i < portTo){
            if(i+100 < portTo){
                resultLocal = new PortScanner( i ,i+100,jTextField1.getText(), timeoutLoc).scan();
                log.info("Local result: " + resultLocal.toString());
                resultExternal = restTemplate.getForObject(buildURI(i, i+100, jTextField1.getText(), timeoutGlob), ScannedHost.class);
                log.info("External result: " + resultExternal.toString());
                jTextArea1.setText(jTextArea1.getText() + PortListToStr(resultLocal.getOpenedPorts(), resultExternal.getOpenedPorts()));
                time += resultLocal.getExecutionTime() + resultExternal.getExecutionTime();
                i +=100;
                jTextArea1.update(jTextArea1.getGraphics());
            }else{
                resultLocal = new PortScanner(i, portTo, jTextField1.getText(), timeoutLoc).scan();
                log.info("Local result: " + resultLocal.toString());
                resultExternal = restTemplate.getForObject(buildURI(i, portTo, jTextField1.getText(), timeoutGlob), ScannedHost.class);
                log.info("External result: " + resultExternal.toString());
                jTextArea1.setText(jTextArea1.getText() + PortListToStr(resultLocal.getOpenedPorts(), resultExternal.getOpenedPorts()));
                time += resultLocal.getExecutionTime() + resultExternal.getExecutionTime();
                i = portTo;
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
