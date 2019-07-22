package view;

import java.io.Serializable;

import javax.faces.event.ActionEvent;

import oracle.adf.controller.TaskFlowId;

public class MonitoringSidebar implements Serializable {
    private String taskFlowId = "/WEB-INF/Task_Flows/Modules/Monitoring/Monitoring_TaskFlow.xml#Monitoring_TaskFlow";

    public MonitoringSidebar() {
    }

    public TaskFlowId getDynamicTaskFlowId() {
        return TaskFlowId.parse(taskFlowId);
    }

    public void setDynamicTaskFlowId(String taskFlowId) {
        this.taskFlowId = taskFlowId;
    }

    public void Project_Comp_Click(ActionEvent actionEvent) {
        // Add event code here...
        setDynamicTaskFlowId("/WEB-INF/Task_Flows/Modules/Monitoring/Project_Comp_TaskFlow.xml#Project_Comp_TaskFlow");
    }

    public void Output_Ind_Click(ActionEvent actionEvent) {
        // Add event code here...
        setDynamicTaskFlowId("/WEB-INF/Task_Flows/Modules/Monitoring/Output_Ind_TaskFlow.xml#Output_Ind_TaskFlow");
    }

    public void Monitoring_Param_Click(ActionEvent actionEvent) {
        // Add event code here...
        setDynamicTaskFlowId("/WEB-INF/Task_Flows/Modules/Monitoring/Monitoring_Param_TaskFlow.xml#Monitoring_Param_TaskFlow");
    }
    
    public void fragmentCall(ActionEvent actionEvent) {
        // Add event code here...
        String action = (String)actionEvent.getComponent().getAttributes().get("link");
        StringBuilder link = new StringBuilder();
        link.append("/WEB-INF/Task_Flows/Modules/Monitoring/");
        link.append(action);
        link.append(".xml#");
        link.append(action);
        setDynamicTaskFlowId(link.toString());
    }
}
