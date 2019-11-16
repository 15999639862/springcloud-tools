package com.cwh.user.service;

import java.util.Map;

import org.dromara.hmily.annotation.Hmily;
import org.dromara.hmily.core.concurrent.threadlocal.HmilyTransactionContextLocal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cwh.user.mapper.AccountAddMapper;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AccountAddService {
	
	@Autowired
	private AccountAddMapper accountAddMapper;
	
	@Transactional
	@Hmily(confirmMethod = "confirm", cancelMethod = "cancel")
	public void addAmount(Map<String, Object> map) {
		String tid = HmilyTransactionContextLocal.getInstance().get().getTransId();
		log.error("try tid:{}",tid);
	}

	@Transactional
	public void confirm(Map<String, Object> map) {
		String tid = HmilyTransactionContextLocal.getInstance().get().getTransId();
		log.error("confirm tid:{}",tid);
		
		int t = accountAddMapper.existConfirmLog(tid);
		if(t > 0) {
			log.error("confirm is already execute,tid:{}",tid);
			return;
		}
		accountAddMapper.addAmount(map);
		accountAddMapper.addConfirmLog(tid);
	}

	
	public void cancel(Map<String, Object> map) {
		String tid = HmilyTransactionContextLocal.getInstance().get().getTransId();
		log.error("cancel tid:{}",tid);
	}

}
