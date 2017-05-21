package by.bsuir.portscanner.server;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ScanController {

    @RequestMapping("/scan")
    public ScannedHost scan(@RequestParam(value="host", required=true) String host,
                            @RequestParam(value="minPort", defaultValue = "-1") String minPort,
                            @RequestParam(value="maxPort", defaultValue = "-1") String maxPort,
                            @RequestParam(value="timeout", defaultValue = "100") String timeout) {
        return new PortScanner(Integer.parseInt(minPort),
                Integer.parseInt(maxPort),
                host,
                Integer.parseInt(timeout))
                .scan();
    }
}
