package view;

import java.io.Serializable;

import javax.faces.event.ActionEvent;

import oracle.adf.controller.TaskFlowId;

public class TrainingSidebar implements Serializable {
    private String taskFlowId = "/WEB-INF/Task_Flows/Modules/Training/Training_TaskFlow.xml#Training_TaskFlow";

    public TrainingSidebar() {
    }

    public TaskFlowId getDynamicTaskFlowId() {
        return TaskFlowId.parse(taskFlowId);
    }

    public void setDynamicTaskFlowId(String taskFlowId) {
        this.taskFlowId = taskFlowId;
    }

    public void Training_Setup_Click(ActionEvent actionEvent) {
        // Add event code here...
        setDynamicTaskFlowId("/WEB-INF/Task_Flows/Modules/Training/Training_Setup_TaskFlow.xml#Training_Setup_TaskFlow");
    }

    public void Module_Setup_Click(ActionEvent actionEvent) {
        // Add event code here...
        setDynamicTaskFlowId("/WEB-INF/Task_Flows/Modules/Training/Module_Setup_TaskFlow.xml#Module_Setup_TaskFlow");
    }

    public void Topic_Setup_Click(ActionEvent actionEvent) {
        // Add event code here...
        setDynamicTaskFlowId("/WEB-INF/Task_Flows/Modules/Training/Topic_Setup_TaskFlow.xml#Topic_Setup_TaskFlow");
    }

    public void Team_Setup_Click(ActionEvent actionEvent) {
        // Add event code here...
        setDynamicTaskFlowId("/WEB-INF/Task_Flows/Modules/Training/Team_Setup_TaskFlow.xml#Team_Setup_TaskFlow");
    }

    public void Trainer_Click(ActionEvent actionEvent) {
        // Add event code here...
        setDynamicTaskFlowId("/WEB-INF/Task_Flows/Modules/Training/Trainer_TaskFlow.xml#Trainer_TaskFlow");
    }

    public void Team_Formation_Click(ActionEvent actionEvent) {
        // Add event code here...
        setDynamicTaskFlowId("/WEB-INF/Task_Flows/Modules/Training/Team_Formation_TaskFlow.xml#Team_Formation_TaskFlow");
    }

    public void Training_Schedule_Click(ActionEvent actionEvent) {
        // Add event code here...
        setDynamicTaskFlowId("/WEB-INF/Task_Flows/Modules/Training/Training_Sched_TaskFlow.xml#Training_Sched_TaskFlow");
    }

    public void Attendance_Detail_Click(ActionEvent actionEvent) {
        // Add event code here...
        setDynamicTaskFlowId("/WEB-INF/Task_Flows/Modules/Training/Att_Detail_TaskFlow.xml#Att_Detail_TaskFlow");
    }

    public void fragmentCall(ActionEvent actionEvent) {
        // Add event code here...
        String action = (String)actionEvent.getComponent().getAttributes().get("link");
        StringBuilder link = new StringBuilder();
        link.append("/WEB-INF/Task_Flows/Modules/Training/");
        link.append(action);
        link.append(".xml#");
        link.append(action);
        setDynamicTaskFlowId(link.toString());
    }
}
