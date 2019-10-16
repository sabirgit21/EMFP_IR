package view.report;

import javax.faces.event.ValueChangeEvent;

public class Grant_Approval_Report {
    
    private static String gotPhase = "";
    private static String gotCluster = "";
    private static String gotFarmer = "";
    
    
    public Grant_Approval_Report() {
    }

    public void get_selected_cluster(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        gotCluster = (valueChangeEvent.getNewValue()).toString();
        System.out.println("Selected Cluster is : " + gotCluster);
    }

    public void get_selected_phase(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        gotPhase = (valueChangeEvent.getNewValue()).toString();
        System.out.println("Selected Phase is : " + gotPhase);
    }

    public void get_selected_farmer(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        gotFarmer = (valueChangeEvent.getNewValue()).toString();
        System.out.println("Selected Farmer is : " + gotFarmer);
    }

    public String gen_Report() {
        // Add event code here...
        return null;
    }
}
