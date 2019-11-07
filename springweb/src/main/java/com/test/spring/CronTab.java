package com.test.spring;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CronTab  implements Runnable{

	@Autowired
	private ExecutorService executorService;
	
	private ConcurrentLinkedQueue<CronTask>  cronTaskEvents=new ConcurrentLinkedQueue<CronTask>();
	
	@Autowired
	private List<CronTask>  list=new ArrayList<CronTask>();
	
	private boolean run=false;
	
	
	@PostConstruct
	public void init() {
		run=true;
		cronTaskEvents.addAll(list);
		executorService.execute(this);
	}

	
	public void freeTask(CronTask cronTask) {
		cronTaskEvents.add(cronTask);
	}

	@Override
	public void run() {
		while(run) {
			//先处理修改事件,修改时间规则
			event();
			CronTask cronTask=cronTaskEvents.poll();
			if(cronTask!=null) {
				boolean published=false;
				try {
					//计算时间，如果时间符合要求，那么发布事件
					if(!cronTask.runing()&&true) {
						executorService.execute(cronTask);
						published=true;
					}
				}finally {
					if(!published) {
						//如果没有发布释放
						freeTask(cronTask);
					}
				}
				
			}
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
			
		}
	}
	
	
	private void event() {
		
	}


	@PreDestroy
	public void destroy() {
		run=false;
	}
	
	

}
