package it.polito.dp2.WF.sol4.client1;

import it.polito.dp2.WF.ActionReader;
import it.polito.dp2.WF.WorkflowReader;

public class MyAction implements ActionReader {
	private MyWorkflow workflow;
	private String name;
	private String role;
	private boolean isAI;
	public MyAction(MyWorkflow mw, String s, String r,boolean b) {
		workflow = mw;
		name = s;
		role = r;
		isAI = b;
	}
	@Override
	public WorkflowReader getEnclosingWorkflow() {
		return this.workflow;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getRole() {
		
		return role;
	}

	@Override
	public boolean isAutomaticallyInstantiated() {
		return isAI;
	}
	public void setRole(String role2) {
		this.role = role2;
	}
	public void isAutomaticallyInstantiated(boolean auto) {
		this.isAI = auto;
	}
	
}
