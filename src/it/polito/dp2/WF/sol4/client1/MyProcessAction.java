package it.polito.dp2.WF.sol4.client1;

import it.polito.dp2.WF.ProcessActionReader;
import it.polito.dp2.WF.WorkflowReader;

public class MyProcessAction extends MyAction implements ProcessActionReader {
	private String actionWorkflowName;

	private MyMonitor mm;
	public MyProcessAction(MyWorkflow mw, String s, String r, boolean b, String awn, MyMonitor myMonitor) {
		super(mw, s, r, b);
		actionWorkflowName = awn;
		mm = myMonitor;
	}

	@Override
	public WorkflowReader getActionWorkflow() {
		return mm.getWorkflow(actionWorkflowName);
	}

}
