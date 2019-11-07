package com.test.spring;

import java.util.concurrent.atomic.AtomicBoolean;

public abstract class CronTask  implements Runnable {

	private CronTab cronTab;
	
	private AtomicBoolean runing=new AtomicBoolean(false);
	
	public abstract void proc();

	
	public void setCronTab(CronTab cronTab) {
		this.cronTab = cronTab;
	}
	
	public CronTab getCronTab() {
		return cronTab;
	}

	@Override
	public void run() {
		try {
			runing.set(true);
			
			//设置
			proc();
			
		}finally {
			runing.set(false);
			cronTab.freeTask(this);
		}
	}

	public boolean runing() {
		return runing.get();
	}
	
	

}
