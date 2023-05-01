package com.example.gestionprojet.ihm.ws.client;

import com.example.gestionprojet.bll.manager.client.ClientManager;
import com.example.gestionprojet.bo.Client;
import com.example.gestionprojet.ihm.ws.AbstractWsGeneric;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ws/client")
public class WsClient extends AbstractWsGeneric<Client, ClientManager> implements WsClientInterface{
}
