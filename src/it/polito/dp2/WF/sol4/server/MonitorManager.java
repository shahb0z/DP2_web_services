package it.polito.dp2.WF.sol4.server;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Logger;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import it.polito.dp2.WF.ActionReader;
import it.polito.dp2.WF.ActionStatusReader;
import it.polito.dp2.WF.ProcessActionReader;
import it.polito.dp2.WF.ProcessReader;
import it.polito.dp2.WF.SimpleActionReader;
import it.polito.dp2.WF.WorkflowMonitor;
import it.polito.dp2.WF.WorkflowMonitorException;
import it.polito.dp2.WF.WorkflowMonitorFactory;
import it.polito.dp2.WF.WorkflowReader;
import it.polito.dp2.WF.sol4.jaxws.ActionStatusType;
import it.polito.dp2.WF.sol4.jaxws.ActionType;
import it.polito.dp2.WF.sol4.jaxws.GetProcessesInfoResponseType.InstanceInfo;
import it.polito.dp2.WF.sol4.jaxws.InfoType;
import it.polito.dp2.WF.sol4.jaxws.InstanceType;
import it.polito.dp2.WF.sol4.jaxws.UnknownInstance;
import it.polito.dp2.WF.sol4.jaxws.UnknownInstanceType;
import it.polito.dp2.WF.sol4.jaxws.WorkflowType;


public class MonitorManager {

    
    private static Logger logger = Logger.getLogger(MonitorManager.class.getName());
    
    private HashMap<String,WorkflowType> wfs; //good for retrieving workflow by
    
    private Map<String,InstanceType> instanceQueue;
    
    public MonitorManager() throws ManagerInitializationFailException{
    	instanceQueue = new ConcurrentHashMap<String,InstanceType>();
    	wfs = new HashMap<String, WorkflowType>();
		initialize();
    }
	private void initialize() throws ManagerInitializationFailException{
		logger.fine("Initializing data!");
		try {
			WorkflowMonitorFactory factory = WorkflowMonitorFactory.newInstance();
			WorkflowMonitor monitor = factory.newWorkflowMonitor();
			Set<WorkflowReader> set = monitor.getWorkflows();
			for (WorkflowReader wfr: set) {
				//create workflowtype element and add to map			
				WorkflowType wType = new WorkflowType();
				wType.setName(wfr.getName());
				//set last modification time 
				wType.setLastModTime(getDate(Calendar.getInstance()));
				wfs.put(wType.getName(), wType);
				
				//get actions and add them to root tree
				Set<ActionReader> setAct = wfr.getActions();
				for (ActionReader ar: setAct) {
					//simple action
					ActionType at = new ActionType();
					at.setName(ar.getName());
					at.setRole(ar.getRole());
					at.setIsAutomaticallyInstantiated(ar.isAutomaticallyInstantiated());
					if (ar instanceof SimpleActionReader){
						//get next possible actions
						Set<ActionReader> setNxt = ((SimpleActionReader)ar).getPossibleNextActions();
						for (ActionReader nAct: setNxt){
							at.getNextPossibleAction().add(nAct.getName());
						}
					//process action
					}else if (ar instanceof ProcessActionReader){
						at.setActionWorkflow(((ProcessActionReader) ar).getActionWorkflow().getName());
					}
					wType.getAction().add(at);
				}
			}
			//get a set of instances and process them
			Set<ProcessReader> instances = monitor.getProcesses();
			
			for (ProcessReader pr: instances) {
				//add instance to workflow
				InstanceType iType = new InstanceType();
				iType.setStartTime(getDate((GregorianCalendar)pr.getStartTime()));
				//get status
				List<ActionStatusReader> statusSet = pr.getStatus();
				for (ActionStatusReader asr : statusSet) {
					ActionStatusType asType = new ActionStatusType();
					if(asr.isTakenInCharge())
						asType.setActor(asr.getActor().getName());
					asType.setInstanceOf(asr.getActionName());
					asType.setIsTakenInCharge(asr.isTakenInCharge());
					asType.setIsTerminated(asr.isTerminated());
					if(asr.isTerminated())
						asType.setTerminationTime(getDate(asr.getTerminationTime()));
					iType.getActionStatus().add(asType);
				}
				iType.setLastModTime(getDate(Calendar.getInstance()));
				iType.setInstanceOf(pr.getWorkflow().getName());
				String key = iType.getInstanceOf()+iType.getStartTime().toString();
				
				instanceQueue.put(key,iType);
			}
		} catch (WorkflowMonitorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.fine("Initialization done!");
	}
	private static XMLGregorianCalendar getDate(Calendar c) {
		try {
			GregorianCalendar gg = new GregorianCalendar();
			gg.setTimeInMillis(c.getTimeInMillis());
		    return DatatypeFactory.newInstance().newXMLGregorianCalendar(gg);
		} catch (DatatypeConfigurationException e) {
		    throw new Error(e);
		}
	}
	public List<WorkflowType> getWorkflows(List<String> wfName) {
		List<WorkflowType> list = new ArrayList<WorkflowType>();
		for(String s: wfName){
			if(wfs.containsKey(s))
				list.add(wfs.get(s));
		}
		return list;
	}
	public List<InfoType> getWorkflowNames(int page) {
		ArrayList<String> values = new ArrayList<>(wfs.keySet());
		
		int length;
		if(values.size()>(page+1)*40)
			length = (page+1)*40;
		else
			length = values.size();
		List<InfoType> list = new ArrayList<InfoType>();
		for(int i = page*40; i < length; i++)
		{
			InfoType it = new InfoType();
			it.setName(values.get(i));
			it.setModStartTime(wfs.get(values.get(i)).getLastModTime());
			list.add(it);
		}
		return list;
	}
	public List<InstanceType> getProcesses(List<InfoType> info) {
		List<InstanceType> list = new ArrayList<InstanceType>();
		for(InfoType i : info){
			String key = i.getName()+i.getModStartTime().toString();
			
			InstanceType iType = instanceQueue.get(key);
			if(iType != null)
				list.add(iType);
		}
		
		return list;
	}
	public List<InstanceInfo> getProcessesInfo(int page) {
		
		ArrayList<InstanceType> values = new ArrayList<>(instanceQueue.values());
		
		int length;
		if(values.size()>(page+1)*40)
			length = (page+1)*40;
		else
			length = values.size();
		List<InstanceInfo> list = new ArrayList<InstanceInfo>();
		for(int i = page*10; i < length; i++)
		{
			InstanceInfo inf = new InstanceInfo();
			inf.setName(values.get(i).getInstanceOf());
			inf.setModStartTime(values.get(i).getStartTime());
			inf.setLastModTime(values.get(i).getLastModTime());
			list.add(inf);
		}
		return list;
	}
	public boolean createProcess(String instanceOf) throws UnknownInstance{
		//check if such workflow exists
		if(!wfs.containsKey(instanceOf)){
			UnknownInstanceType uwt = new UnknownInstanceType();
			uwt.setMessage("No workflow with given name!");
			UnknownInstance uw = new UnknownInstance("UnknownInstance: ", uwt);
			throw uw;
		}
		InstanceType it = new InstanceType();
		WorkflowType wf = wfs.get(instanceOf);
		it.setInstanceOf(wf.getName());
		it.setStartTime(getDate(Calendar.getInstance()));
		it.setLastModTime(getDate(Calendar.getInstance()));
		
		List<ActionType> acList = wf.getAction();
		for(ActionType a : acList){
			if(a.isIsAutomaticallyInstantiated()){
				ActionStatusType as = new ActionStatusType();
				as.setInstanceOf(a.getName());
				as.setIsTerminated(false);
				as.setIsTakenInCharge(false);
				it.getActionStatus().add(as);
			}
		}
		String key = it.getInstanceOf()+it.getStartTime().toString();
		instanceQueue.put(key, it);
		return true;
	}
}
