package it.polito.dp2.WF.sol4.server;

import java.util.List;
import java.util.logging.Logger;

import javax.jws.WebService;

import it.polito.dp2.WF.sol4.jaxws.GetProcessesInfoResponseType.InstanceInfo;
import it.polito.dp2.WF.sol4.jaxws.InfoType;
import it.polito.dp2.WF.sol4.jaxws.InstanceType;
import it.polito.dp2.WF.sol4.jaxws.UnknownInstance;
import it.polito.dp2.WF.sol4.jaxws.UnknownInstanceType;
import it.polito.dp2.WF.sol4.jaxws.UnknownWorkflow;
import it.polito.dp2.WF.sol4.jaxws.UnknownWorkflowType;
import it.polito.dp2.WF.sol4.jaxws.WorkflowOperations;
import it.polito.dp2.WF.sol4.jaxws.WorkflowType;

@WebService(serviceName = "WorkflowService", targetNamespace = "http://www.example.org/Workflow",
endpointInterface="it.polito.dp2.WF.sol4.jaxws.WorkflowOperations", portName="WorkflowOperationsPort")
public class WorkflowOperationsImpl implements WorkflowOperations {
	private static Logger logger = Logger.getLogger(WorkflowOperationsImpl.class.getName());
    private MonitorManager manager;
	public WorkflowOperationsImpl(MonitorManager mm) {
		super();
		this.manager = mm;
	}

	@Override
	public List<WorkflowType> getWorkflows(List<String> wfName) throws UnknownWorkflow {
		List<WorkflowType> wList = null;
		//check request data
		logger.entering(logger.getName(), "getWorkflows");
		
		if(wfName==null || wfName.isEmpty()){
			UnknownWorkflowType uwt = new UnknownWorkflowType();
			uwt.setMessage("No names in the request!");
			UnknownWorkflow uw = new UnknownWorkflow("UnknownWorkflow: ", uwt);
			throw uw;
		}
		
		wList = manager.getWorkflows(wfName);
		//check if workflows exist
		if(wList.isEmpty()){
			UnknownWorkflowType uwt = new UnknownWorkflowType();
			uwt.setMessage("No such workflows!");
			UnknownWorkflow uw = new UnknownWorkflow("UnknownWorkflow: ", uwt);
			throw uw;
		}
		logger.exiting(logger.getName(), "getWorkflows");
		return wList;
	}

	@Override
	public List<InfoType> getWorkflowNames(int page) {
		List<InfoType> infoList = null;
		
		logger.entering(logger.getName(), "getWorkflowNames");
		
		infoList = manager.getWorkflowNames(page);
		
		logger.exiting(logger.getName(), "getWorkflowNames");
		
		return infoList;
	}

	@Override
	public List<InstanceType> getProcesses(List<InfoType> info) throws UnknownInstance {
		
		List<InstanceType> instanceList = null;
		
		logger.entering(logger.getName(), "getProcesses");
		//check request data
		if(info==null || info.isEmpty()){
			UnknownInstanceType uwt = new UnknownInstanceType();
			uwt.setMessage("No info in the request!");
			UnknownInstance uw = new UnknownInstance("UnknownInstance: ", uwt);
			throw uw;
		}
		instanceList = manager.getProcesses(info);
		
		if(instanceList.isEmpty()){
			UnknownInstanceType uwt = new UnknownInstanceType();
			uwt.setMessage("No such instances!");
			UnknownInstance uw = new UnknownInstance("UnknownInstance: ", uwt);
			throw uw;
		}
		logger.exiting(logger.getName(), "getProcesses");
		
		return instanceList;
	}

	@Override
	public List<InstanceInfo> getProcessesInfo(int page) {
		List<InstanceInfo> infoList = null;
		
		logger.entering(logger.getName(), "getProcessesInfo");
		
		infoList = manager.getProcessesInfo(page);
		
		logger.exiting(logger.getName(), "getProcessesInfo");
		
		return infoList;
	}

	

}
