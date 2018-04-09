package it.polito.dp2.WF.sol4.client2;

import java.net.MalformedURLException;
import java.net.URL;

import it.polito.dp2.WF.sol4.jaxws.NoAccesRightFault;
import it.polito.dp2.WF.sol4.jaxws.ProcessOperations;
import it.polito.dp2.WF.sol4.jaxws.ProcessService;
import it.polito.dp2.WF.sol4.jaxws.UnknownInstance;

public class WFControlClient {
	
	ProcessOperations proxy;
	public WFControlClient(String url, String name) throws MalformedURLException, NoAccesRightFault, UnknownInstance{
		ProcessService procServ = new ProcessService(new URL(url));
		proxy = procServ.getProcessOperationsPort();
		String userType = "Premium";
		boolean res = proxy.createProcess(name, userType);
		System.out.println("DONE: " + res);
	}
	public static void main(String[] args) {
		if(args.length == 2){
			try {
				WFControlClient wfc = new WFControlClient(args[0],args[1]);
				System.exit(0);
			} catch (MalformedURLException e) {
				e.printStackTrace();
				System.exit(2);
			} catch (NoAccesRightFault e) {
				e.printStackTrace();
				System.exit(1);
			} catch (UnknownInstance e) {
				e.printStackTrace();
				System.exit(1);
			}
		}
	}

}
