package com.cwh.score.service;

import java.util.Map;

import org.dromara.hmily.annotation.Hmily;
import org.dromara.hmily.core.concurrent.threadlocal.HmilyTransactionContextLocal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cwh.score.feign.AccountAddFeignClient;
import com.cwh.score.mapper.AccountMapper;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AccountService {

	@Autowired
	private AccountMapper accountMapper;

	@Autowired
	private AccountAddFeignClient accountAddFeignClient;

	@Transactional
	@Hmily(confirmMethod = "confirm", cancelMethod = "cancel")
	public void transfer(Map<String, Object> map) {
		String tid = HmilyTransactionContextLocal.getInstance().get().getTransId();
		log.error("transfer tid:{}", tid);
		int t = accountMapper.existTryLog(tid);
		if (t > 0) {
			log.error("try is alreay execute,tid:{}", tid);
			return;
		}
		t = accountMapper.existCancelLog(tid);
		int t1 = accountMapper.existConfirmLog(tid);
		if (t > 0 || t1 > 0) {
			log.error("cancel or confirm is alreay execute,can not execute try,tid:{}", tid);
			return;
		}
		t = accountMapper.decAmount(map);
		if (t <= 0) {
			throw new RuntimeException("扣减余额失败.");
		}
		accountMapper.addTryLog(tid);

		// 远程调用转账
		long result = 0;
		try {
			double amount = (double)map.get("amount");
			result = accountAddFeignClient.addAmount(amount);
		} catch (Exception e) {
			log.error("转账失败.tid:{"+tid+"}", e);
			throw e;
		}
		if (result <= 0) {
			log.error("转账失败.tid:{}", tid);
			throw new RuntimeException("转账失败.");
		}
	}

	public void confirm(Map<String, Object> map) {
		String tid = HmilyTransactionContextLocal.getInstance().get().getTransId();
		log.error("confirm tid:{}", tid);
	}

	@Transactional
	public void cancel(Map<String, Object> map) {
		String tid = HmilyTransactionContextLocal.getInstance().get().getTransId();
		// 冪等性判断
		int t = accountMapper.existCancelLog(tid);
		if (t > 0) {
			log.error("cancel is alreay execute,can not execute again,tid:{}", tid);
			return;
		}
		// 空回滚
		t = accountMapper.existTryLog(tid);
		if (t <= 0) {
			log.error("try is not execute,can not execute cancel,tid:{}", tid);
			return;
		}
		accountMapper.addAmount(map);
		accountMapper.addCancelLog(tid);
	}

}
