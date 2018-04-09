package it.polito.dp2.WF.sol4.server;

import java.util.concurrent.Executors;

import javax.xml.ws.Endpoint;

public class WorkflowServer {
	 public static void main(String[] args) {
		 	MonitorManager mm;
		 	try {
				mm = new MonitorManager();
				System.out.println("Publishing http://localhost:7071/wfinfo");
		        Endpoint endpoint = Endpoint.create(new WorkflowOperationsImpl(mm));
		        endpoint.setExecutor(Executors.newFixedThreadPool(10));
		   	    endpoint.publish("http://localhost:7071/wfinfo");
		        
		        System.out.println("Publishing http://localhost:7070/wfcontrol");
		        Endpoint endpoint2 = Endpoint.create(new ProcessOperationsImpl(mm));
		        endpoint2.setExecutor(Executors.newFixedThreadPool(10));
		   	    endpoint2.publish("http://localhost:7070/wfcontrol");
			} catch (ManagerInitializationFailException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
	    }
}
