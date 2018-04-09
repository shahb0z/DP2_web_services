package it.polito.dp2.WF.sol4.client1;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import it.polito.dp2.WF.ProcessReader;
import it.polito.dp2.WF.WorkflowMonitor;
import it.polito.dp2.WF.WorkflowReader;
import it.polito.dp2.WF.sol4.jaxws.ActionStatusType;
import it.polito.dp2.WF.sol4.jaxws.ActionType;
import it.polito.dp2.WF.sol4.jaxws.GetProcessesInfoResponseType.InstanceInfo;
import it.polito.dp2.WF.sol4.jaxws.InfoType;
import it.polito.dp2.WF.sol4.jaxws.InstanceType;
import it.polito.dp2.WF.sol4.jaxws.UnknownInstance;
import it.polito.dp2.WF.sol4.jaxws.UnknownWorkflow;
import it.polito.dp2.WF.sol4.jaxws.WorkflowOperations;
import it.polito.dp2.WF.sol4.jaxws.WorkflowService;
import it.polito.dp2.WF.sol4.jaxws.WorkflowType;


public class MyMonitor implements WorkflowMonitor{

	private HashMap<String,MyWorkflow> wfs; //good for retrieving workflow by
											//its unique name identifier
	private LinkedHashSet<MyInstance> prs; //keeps insertion order
	
	WorkflowOperations proxy;
	
	public MyMonitor() {
		//monitor variables
		wfs = new HashMap<String, MyWorkflow>();
		prs = new LinkedHashSet<>();
		
		try {
			String su = System.getProperty("it.polito.dp2.WF.lab4.URL");
			URL url;
			if(su!=null)
				url = new URL(su);
			else
				url = new URL("http://localhost:7071/wfinfo");
			WorkflowService wfService = new WorkflowService(url);
			
			//process workflow data
			proxy = wfService.getWorkflowOperationsPort();
			boolean finished = false;
			int pageCount = 0;
			List<InfoType> infoList = new ArrayList<InfoType>();
			while(!finished){
				List<InfoType> tmp = proxy.getWorkflowNames(pageCount); 
				infoList.addAll(tmp);
				if(tmp.size()<40)
					finished = true;
				pageCount++;
			}
			
			if(!infoList.isEmpty()){
				finished = false;
				int itemCount=0;
				int length=infoList.size();
				
				List<WorkflowType> wfList = new ArrayList<WorkflowType>();
				int i = 0;
				while(!finished){
					if(length > 20){
						itemCount += 20;
						length -= 20;
					}
					else{ 
						itemCount += length;
						finished = true;
					}
					List<String> wfNames = new ArrayList<>();
					for(; i < itemCount ; i++ )
						wfNames.add(infoList.get(i).getName());
					List<WorkflowType> tmpList = proxy.getWorkflows(wfNames);
					wfList.addAll(tmpList);
					i = itemCount;
				}
				
				for(WorkflowType wt : wfList){
					MyWorkflow mw = new MyWorkflow(wt.getName());
					processWorkflow(mw, wt);
					wfs.put(mw.getName(), mw);
				}
			}
			
			//process instance data
			pageCount=0;
			finished = false;
			List<InstanceInfo> inInfoList = new ArrayList<InstanceInfo>();
			while(!finished){
				List<InstanceInfo> tmp = proxy.getProcessesInfo(pageCount);
				System.out.println("TMP_SIZE: " + tmp.size());
				if(tmp.size()!=0)
					inInfoList.addAll(tmp);
				if(tmp.size()<40)
					finished = true;
				pageCount++;
			}
			System.out.println("INFO_SIZE: " + inInfoList.size());
			if(!inInfoList.isEmpty()){
				finished = false;
				int itemCount=0;
				int length=inInfoList.size();
				
				List<InstanceType> instanceList = new ArrayList<InstanceType>();
				int i = 0;
				while(!finished){
					if(length > 20){
						itemCount += 20;
						length -= 20;
					}
					else{ 
						itemCount += length;
						finished = true;
					}
					List<InfoType> infos = new ArrayList<>();
					for(; i < itemCount ; i++ ){
						InfoType it = new InfoType();
						it.setName(inInfoList.get(i).getName());
						it.setModStartTime(inInfoList.get(i).getModStartTime());
						infos.add(it);
					}
					System.out.println("LIST_INFOS_SIZE: " + infos.size());	
					List<InstanceType> tmpList = proxy.getProcesses(infos);
					instanceList.addAll(tmpList);
					i = itemCount;
				}
				
				for(InstanceType it : instanceList){
					
					Calendar c = it.getStartTime().toGregorianCalendar();
					MyInstance mi = new MyInstance(c, it.getInstanceOf(),this);
					processInstance(mi,it);
					//add to monitor
					prs.add(mi);
					//add to workflow
					if(wfs.containsKey(it.getInstanceOf())){
						wfs.get(it.getInstanceOf()).addInstance(mi);
						
					}
						
				}
			}
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (UnknownWorkflow e) {
			e.printStackTrace();
		} catch (UnknownInstance e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	private void processInstance(MyInstance mi, InstanceType it) {
		List<ActionStatusType> statusList = it.getActionStatus();
		for(ActionStatusType at : statusList){
			Calendar c = null;
			if(at.isIsTerminated()){
				c = at.getTerminationTime().toGregorianCalendar();
			}
			ActionStatus as = new ActionStatus(at.getInstanceOf(), at.getActor(), c, 
					at.isIsTakenInCharge(), at.isIsTerminated(), (MyWorkflow) mi.getWorkflow()); 
			mi.addActionStatus(as);
		}
		
	}


	//processes single workflow
	private void processWorkflow(MyWorkflow wf, WorkflowType wType) {
		//get actions
		List<ActionType> actionList = wType.getAction();
		ActionType at;
		for(int i = 0; i < actionList.size(); i++){
			at = actionList.get(i);
			if(at.getActionWorkflow() == null){
				//create simple action
				MySimpleAction msa = new MySimpleAction(wf, at.getName(), at.getRole(), at.isIsAutomaticallyInstantiated());
				// get list of next action names and set them
				if(!at.getNextPossibleAction().isEmpty())
					msa.addNextActionNames(at.getNextPossibleAction());
				wf.addAction(at.getName(), msa);
				
			}else{
				MyProcessAction mpa = new MyProcessAction(wf, at.getName(), at.getRole(), at.isIsAutomaticallyInstantiated(), 
						at.getActionWorkflow(), this);
				
				wf.addAction(at.getName(), mpa);
			}
			
		}
		
	}
	@Override
	public Set<ProcessReader> getProcesses() {
		
		return new LinkedHashSet<ProcessReader>(prs);
	}

	@Override
	public WorkflowReader getWorkflow(String arg0) {
		return wfs.get(arg0);
	}

	@Override
	public Set<WorkflowReader> getWorkflows() {
		return new LinkedHashSet<WorkflowReader>(wfs.values());
	}

}
