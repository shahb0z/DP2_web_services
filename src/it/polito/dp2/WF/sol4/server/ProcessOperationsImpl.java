package it.polito.dp2.WF.sol4.server;

import java.util.logging.Logger;

import javax.jws.WebService;

import it.polito.dp2.WF.sol4.jaxws.NoAccesRightFault;
import it.polito.dp2.WF.sol4.jaxws.NoAccesRightFaultType;
import it.polito.dp2.WF.sol4.jaxws.ProcessOperations;
import it.polito.dp2.WF.sol4.jaxws.StatusInfo;
import it.polito.dp2.WF.sol4.jaxws.UnknownAction;
import it.polito.dp2.WF.sol4.jaxws.UnknownInstance;
import it.polito.dp2.WF.sol4.jaxws.UnknownInstanceType;
@WebService(serviceName = "ProcessService", targetNamespace = "http://www.example.org/Workflow",
endpointInterface="it.polito.dp2.WF.sol4.jaxws.ProcessOperations", portName="ProcessOperationsPort")
public class ProcessOperationsImpl implements ProcessOperations {
	private static Logger logger = Logger.getLogger(WorkflowOperationsImpl.class.getName());
    private MonitorManager manager;
	public ProcessOperationsImpl(MonitorManager mm) {
		super();
		this.manager = mm;
	}

	@Override
	public boolean takeAction(StatusInfo action) throws UnknownAction, UnknownInstance {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean terminateAction(StatusInfo action) throws UnknownAction, UnknownInstance {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean createProcess(String instanceOf, String userIDType) throws NoAccesRightFault, UnknownInstance {
		
		logger.entering(logger.getName(), "createProcess");
		//check request data
		if(instanceOf == null || userIDType == null){
			UnknownInstanceType uwt = new UnknownInstanceType();
			uwt.setMessage("No info in the request!");
			UnknownInstance uw = new UnknownInstance("UnknownInstance: ", uwt);
			throw uw;
		}
		//check user type
		if(userIDType.compareTo("Premium")!=0){
			NoAccesRightFaultType nat = new NoAccesRightFaultType();
			nat.setMessage("No Access Right, not Premium member!");
			NoAccesRightFault nar = new NoAccesRightFault("NoAccesRightFault", nat);
			throw nar;
		}
		//now we can create process
		boolean res = manager.createProcess(instanceOf);
		
		logger.exiting(logger.getName(), "createProcess");
		
		
		return res;
	}

}
