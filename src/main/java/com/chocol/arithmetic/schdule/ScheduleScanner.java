/*
  Copyright (C) 2018-2021 Zeyi information technology (Shanghai) Co., Ltd.
  <p>
  All right reserved.
  <p>
  This software is the confidential and proprietary
  information of Zeyi Company of China.
  ("Confidential Information"). You shall not disclose
  such Confidential Information and shall use it only
  in accordance with the terms of the contract agreement
  you entered into with Zeyi inc.
 */
package com.chocol.arithmetic.schdule;

import com.chocol.arithmetic.util.RobCouponsUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Description:
 *
 * @author 陈力
 * @date 2021/12/1
 * @since
 */
@Component
@Slf4j
public class ScheduleScanner {

    @Scheduled(cron = "0 0 0 * * ?")
    public void clearBakResult() {
        RobCouponsUtil.robCoupons();
    }
}
