package com.chocol.arithmetic.common;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.thread.ThreadUtil;
import cn.hutool.cron.CronUtil;
import cn.hutool.cron.task.Task;
import cn.hutool.http.HttpInputStream;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 *
 * @author 陈力
 * @date 2021/12/1
 * @since
 */
@Slf4j
@SpringBootTest
public class RobCoupons {
    private static final String URL_TEMP =
        "https://activity.dongfeng-honda.com/honda-activity-20210701/getPrize?vinNum=%s&openid=%s&prizeId=%s&activityNo=2&phone=%s";

    @Test
    public void test01() {
         DateTime target = DateUtil.parse("2021-12-02 11:00:00");
//        robCoupons();
//        DateTime target = DateUtil.parse("2021-12-01 15:31:00");
        while (DateUtil.date().getTime() - target.getTime() > -5 * 1000
            || DateUtil.date().getTime() - target.getTime() < 5 * 1000) {
            for (int i = 0; i < 10; i++) {
                robCoupons();
            }
        }
        System.out.println();
    }

    private void robCoupons() {
        // 1-免费机油升级 4-保养套餐
        int prizeId = 4;
        // 车序列号
        String vinNum = "LVHRW1864L7031132";
        String openid = "ocU71jtVOmAL-OpW6Qp5ljcJE9E4";
        String phone = "17671788757";
        String url = String.format(URL_TEMP, vinNum, openid, prizeId, phone);

        String cookie = "HWWAFSESID=214e87cc8e1536a904; HWWAFSESTIME=1638327826427; HONDA_WX_TOKEN=3c7c2e7327b54bd1a07109faed2fd18a; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%223c7c2e7327b54bd1a07109faed2fd18a%22%2C%22first_id%22%3A%2217d73f2c9cf7dd-0e75872abffe27-61263e23-1693734-17d73f2c9d0917%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E7%9B%B4%E6%8E%A5%E6%B5%81%E9%87%8F%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC_%E7%9B%B4%E6%8E%A5%E6%89%93%E5%BC%80%22%2C%22%24latest_referrer%22%3A%22%22%7D%2C%22%24device_id%22%3A%2217d73f2c9cf7dd-0e75872abffe27-61263e23-1693734-17d73f2c9d0917%22%7D";
        HttpResponse execute = HttpUtil.createGet(url).cookie(cookie).executeAsync();
        log.info("result:[{}]", execute.body());
    }
}
