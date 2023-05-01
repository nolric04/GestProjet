package com.example.gestionprojet.ihm.ws.projet.task;

import com.example.gestionprojet.bll.manager.projet.task.ProjectTaskManager;
import com.example.gestionprojet.bo.ProjectTask;
import com.example.gestionprojet.ihm.ws.AbstractWsGeneric;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ws/task")
public class WsProjectTask extends AbstractWsGeneric<ProjectTask, ProjectTaskManager> implements  WsProjectTaskInterface{
}
