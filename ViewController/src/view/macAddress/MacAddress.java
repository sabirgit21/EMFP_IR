package view.macAddress;

import java.net.InetAddress;

import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;

import javax.swing.JApplet;

public class MacAddress extends JApplet{
    public MacAddress() {
        super();
    }
    private String macAddr;
    
    private void jbInit() throws Exception {
        
        InetAddress ip;
        
        try {

            ip = InetAddress.getLocalHost();
            System.out.println("Current IP Address : " + ip.getHostAddress());

            NetworkInterface network = NetworkInterface.getByInetAddress(ip);

            byte[] mac = network.getHardwareAddress();

            System.out.println("Current MAC Address : ");

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < mac.length; i++) {
                sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
            }
            System.out.println(sb.toString());
            macAddr = sb.toString();
        } catch (UnknownHostException uhe) {
            // TODO: Add catch code
            uhe.printStackTrace();
        } catch (SocketException se) {
            // TODO: Add catch code
            se.printStackTrace();
        }
    }
}
