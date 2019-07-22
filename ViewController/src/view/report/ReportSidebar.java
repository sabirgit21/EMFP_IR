package view.report;

import java.io.Serializable;

import javax.faces.event.ActionEvent;

import oracle.adf.controller.TaskFlowId;

public class ReportSidebar implements Serializable {
    private String taskFlowId = "/WEB-INF/Task_Flows/Reports/Reports_TaskFlow.xml#Reports_TaskFlow";

    public ReportSidebar() {
    }

    public TaskFlowId getDynamicTaskFlowId() {
        return TaskFlowId.parse(taskFlowId);
    }

    public void setDynamicTaskFlowId(String taskFlowId) {
        this.taskFlowId = taskFlowId;
    }

    public void ClusterDetailReport_OnClick(ActionEvent actionEvent) {
        // Add event code here...
        setDynamicTaskFlowId("/WEB-INF/Task_Flows/Reports/Cluster_Detail_Report_TaskFlow.xml#Cluster_Detail_Report_TaskFlow");
    }
    
    public void FarmerReport_OnClick(ActionEvent actionEvent) {
        // Add event code here...
        setDynamicTaskFlowId("/WEB-INF/Task_Flows/Reports/Farmer_TaskFlow.xml#Farmer_TaskFlow");
    }
    

    public TaskFlowId getDynamicTaskFlowId1() {
        return TaskFlowId.parse(taskFlowId);
    }

    public void setDynamicTaskFlowId1(String taskFlowId) {
        this.taskFlowId = taskFlowId;
    }
    
    public void fragmentCall(ActionEvent actionEvent) {
        // Add event code here...
        String action = (String)actionEvent.getComponent().getAttributes().get("link");
        StringBuilder link = new StringBuilder();
        link.append("/WEB-INF/Task_Flows/Reports/");
        link.append(action);
        link.append(".xml#");
        link.append(action);
        setDynamicTaskFlowId(link.toString());
    }

}
