package view.report;

import javax.faces.event.ValueChangeEvent;

public class Grant_Approval_Report {
    
    private static String gotPhase = "";
    private static String gotCluster = "";
    private static String gotFarmer = "";
    private static String selectedReportType;
    
    public Grant_Approval_Report() {
    }
//    String param1;
//    String reportType;
//    

    public void get_selected_cluster(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        gotCluster = (valueChangeEvent.getNewValue()).toString();
        System.out.println("Selected Cluster is : " + gotCluster);
    }

    public void get_selected_phase(ValueChangeEvent valueChangeEvent) {
        // Add event code here...++
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
//        selectedReportType = getReportType();
//        if (selectedReportType == null) {
//            selectedReportType = "notSelected";
//        }
        OracleReportBean reportBean = new OracleReportBean("207.180.246.67", "9002", null);

        //        reportBean.setReportURLName("userid=ir19/ir19@orcl&domain=classicdomain&report=C:/ERP/ir19/REPORTS/ReportsGl/SALE_INVOICE&");
        String url = "";
        reportBean.setReportParameter("P_Phase_id",gotPhase);
        reportBean.setReportParameter("P_Cluster_id",gotCluster);
        reportBean.setReportParameter("P_farmer_reg_id",gotFarmer);
        
       
            System.out.println("default");
            reportBean.setReportURLName("userid=emfp/emfp@orcl&domain=classicdomain&report=C:/EMFP_Reports/Grant_Approval_Detail&");
            reportBean.setReportServerParam(OracleReportBean.RS_PARAM_DESTYPE,
                                            "CACHE"); // which will be one of the [cashe - file - mail - printer]
            reportBean.setReportServerParam(OracleReportBean.RS_PARAM_DESFORMAT,
                                            "PDF"); // Which will be onr of the [HTML - HTML CSS - PDF - SPREADSHEET- RTF].
            reportBean.setReportParameter("paramform", "no");
            
            url = reportBean.getReportServerURL();
            System.out.println("Url => " + url);
            reportBean.openUrlInNewWindow(url);
            System.out.println("defaulter bla bla bla report");
        
        return null;
    }
//    public void setParam1(String param1) {
//        this.param1 = param1;
//    }
//
//    public String getParam1() {
//        return param1;
//    }
//
//    public void setReportType(String reportType) {
//        this.reportType = reportType;
//    }
//
//    public String getReportType() {
//        return reportType;
//    }

}
