package com.myb.framework.util.warning;

import java.util.ArrayList;

public class WarningDriver {
	private ArrayList<IWarning> warningList;

	public ArrayList<IWarning> getWarningList() {
		return warningList;
	}

	public void setWarningList(ArrayList<IWarning> warningList) {
		this.warningList = warningList;
	}
	
	public void send(String subject,String body) {
		if(warningList!=null)
		{
			for(int i=0;i<warningList.size();i++)
			{
				warningList.get(i).send(subject, body);
			}
		}
	}

}
