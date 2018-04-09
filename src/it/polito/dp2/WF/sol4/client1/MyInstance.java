package it.polito.dp2.WF.sol4.client1;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import it.polito.dp2.WF.ActionStatusReader;
import it.polito.dp2.WF.ProcessReader;
import it.polito.dp2.WF.WorkflowReader;

public class MyInstance implements ProcessReader{
	private Calendar startTime;
	private List<ActionStatus> status;
	private MyWorkflow instanceOf;
	private String wfName;
	private MyMonitor mm;
	public MyInstance(Calendar c, String string, MyMonitor myMonitor) {
		startTime = (Calendar)c.clone();
		wfName = string;
		status = new ArrayList<ActionStatus>();
		this.mm = myMonitor;
	}
	@Override
	public Calendar getStartTime() {
		return startTime;
	}

	@Override
	public List<ActionStatusReader> getStatus() {
		return new ArrayList<ActionStatusReader>(status);
	}

	@Override
	public WorkflowReader getWorkflow() {
		if(instanceOf == null)
			instanceOf = (MyWorkflow)mm.getWorkflow(wfName);
		return instanceOf;
	}
	public void addActionStatus(ActionStatus as) {
		this.status.add(as);
	}

}
