package it.polito.dp2.WF.sol4.client1;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import it.polito.dp2.WF.ActionReader;
import it.polito.dp2.WF.SimpleActionReader;

public class MySimpleAction extends MyAction implements SimpleActionReader{
	private boolean nextActionsTaken = false;
	private Set<ActionReader> nextActions;
	private List<String> nextActionNames;
	public MySimpleAction(MyWorkflow mw, String s, String r, boolean b) {
		super(mw, s, r, b);
		nextActions = new LinkedHashSet<ActionReader>();
		nextActionNames = new ArrayList<String>();
	}
	@Override
	public Set<ActionReader> getPossibleNextActions() {		
		if(nextActionsTaken == false){
			MyWorkflow w = (MyWorkflow) this.getEnclosingWorkflow();
			for(int i=0; i < this.nextActionNames.size(); i++ ){
				ActionReader ar = w.getAction(nextActionNames.get(i));
				if(ar != null)
					this.nextActions.add(ar);
			}
			nextActionsTaken = true;
		}
		return new LinkedHashSet<ActionReader>(nextActions);
	}
	public void addNextActionNames(List<String> itemList) {
		this.nextActionNames.addAll(itemList);
	}
	
}
