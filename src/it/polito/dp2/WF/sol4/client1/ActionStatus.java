package it.polito.dp2.WF.sol4.client1;

import java.util.Calendar;

import it.polito.dp2.WF.ActionStatusReader;
import it.polito.dp2.WF.Actor;

public class ActionStatus implements ActionStatusReader {
	private String instanceOf;
	private MyActor actor;
	private String actorName;
	private Calendar terminationTime;
	private boolean inExecution;
	private boolean finished;
	private boolean isActorTaken = false;
	private MyWorkflow workflowRef;
	public ActionStatus(String an, String ac, Calendar c, boolean e, boolean f, MyWorkflow wf) {
		instanceOf = an;
		if(e == true){
			actorName = ac;
			inExecution = true;
		}else
			inExecution = false;
		if(f == true){
			terminationTime = (Calendar)c.clone();
			finished = true;
		}else
			finished = false;
		workflowRef = wf;
		
	}
	@Override
	public String getActionName() {
		return this.instanceOf;
	}

	@Override
	public Actor getActor() {
		if(isActorTaken == false){
			MyAction mac = (MyAction)workflowRef.getAction(this.instanceOf); 
			MyActor ma = new MyActor(actorName, mac.getRole());
			this.actor = ma;
			isActorTaken = true;
		}
		return this.actor;
	}

	@Override
	public Calendar getTerminationTime() {
		return this.terminationTime;
	}

	@Override
	public boolean isTakenInCharge() {
		return this.inExecution;
	}

	@Override
	public boolean isTerminated() {
		return this.finished;
	}

}
