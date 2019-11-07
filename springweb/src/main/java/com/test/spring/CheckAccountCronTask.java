package com.test.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CheckAccountCronTask extends CronTask {

	@Override
	@Autowired
	public void setCronTab(CronTab cronTab) {
		System.out.println(cronTab);
		super.setCronTab(cronTab);
	}
	
	@Override
	public void proc() {

	}

}
