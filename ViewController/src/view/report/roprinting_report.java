package view.report;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import view.DatabaseConnection.DatabaseConnection;

public class roprinting_report {
    
    private static String gotprinting = "";
    
    
    public roprinting_report() {
    }

    public String gen_ro_printing_report() {
        // Add event code here...
        if (gotprinting == null) {
            gotprinting = "notSelected";
        }
        
        DatabaseConnection dbconnect = new DatabaseConnection();
        OracleReportBean reportBean = new OracleReportBean(dbconnect.getUipReport(), dbconnect.getUportReport(), null);


        //        reportBean.setReportURLName("userid=ir19/ir19@orcl&domain=classicdomain&report=C:/ERP/ir19/REPORTS/ReportsGl/SALE_INVOICE&");
        String url = "";
        reportBean.setReportParameter("appr_det_id",gotprinting);
        
        switch (gotprinting) {
        case "notSelected":
        showMessage("Please Select Report Type");
        break;
        case "null":
        showMessage("Please Select Report Type");
        break;
        default:
            System.out.println("default");
            reportBean.setReportURLName("userid=emfp/emfp@orcl&domain=classicdomain&report=C:/EMFP_Reports/RO_Voucher&");
            reportBean.setReportServerParam(OracleReportBean.RS_PARAM_DESTYPE,
                                            "CACHE"); // which will be one of the [cashe - file - mail - printer]
            reportBean.setReportServerParam(OracleReportBean.RS_PARAM_DESFORMAT,
                                            "PDF"); // Which will be onr of the [HTML - HTML CSS - PDF - SPREADSHEET- RTF].
            reportBean.setReportParameter("paramform", "no");
            
            url = reportBean.getReportServerURL();
            System.out.println("Url => " + url);
            reportBean.openUrlInNewWindow(url);
            System.out.println("default ro printing report");
        break;
        }
            
        return null;
    }

    public void get_ro_printing_name(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        gotprinting = (valueChangeEvent.getNewValue()).toString();
        System.out.println("Selected Printing is : " + gotprinting);
    }
    
    public String showMessage(String msgs) {
        String messageText = msgs;
        FacesMessage fm = new FacesMessage(messageText);
        /**
             * set the type of the message.
             * Valid types: error, fatal,info,warning
             */
        fm.setSeverity(FacesMessage.SEVERITY_INFO);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, fm);
        return null;
    }
}
