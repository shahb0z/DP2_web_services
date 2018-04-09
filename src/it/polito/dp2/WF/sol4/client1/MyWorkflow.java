package it.polito.dp2.WF.sol4.client1;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Set;

import it.polito.dp2.WF.ActionReader;
import it.polito.dp2.WF.ProcessReader;
import it.polito.dp2.WF.WorkflowReader;

public class MyWorkflow implements WorkflowReader{
	private HashMap<String, MyAction> as;
	private LinkedHashSet<MyInstance> prs;
	private String name;
	
	public MyWorkflow(String name) {
		this.name = name;
		as = new HashMap<String, MyAction>();
		prs = new LinkedHashSet<MyInstance>();
	}
	
	
	@Override
	public ActionReader getAction(String arg0) {
		return as.get(arg0);
	}

	@Override
	public Set<ActionReader> getActions() {
		return new LinkedHashSet<ActionReader>(as.values());
	}

	@Override
	public String getName() {
		
		return this.name;
	}

	@Override
	public Set<ProcessReader> getProcesses() {
		return new LinkedHashSet<ProcessReader>(prs);
	}


	public void addAction(String name2, MyAction sa) {
		
		this.as.put(name2, sa);
	}


	public void addInstance(MyInstance mi) {
		this.prs.add(mi);
	}
	
}
