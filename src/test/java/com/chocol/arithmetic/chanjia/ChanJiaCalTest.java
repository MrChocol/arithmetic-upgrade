package com.chocol.arithmetic.chanjia;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.Week;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

/**
 * Description:
 *
 * @author 陈力
 * @date 2021/6/8
 * @since
 */
@Slf4j
@SpringBootTest
public class ChanJiaCalTest {
    static final int NORMAL_DAYS = 158;
    static final int HARD_DAYS = 173;

    @Test
    public void test01() {
        DateTime start = DateUtil.parseDate("2024-06-07");
        DateTime end = DateUtil.parseDate("2024-07-31");
        long betweenDay = DateUtil.betweenDay(start, end, true);
        int maxNormalTotalNaturalDays = 0;
        int maxHardTotalNaturalDays = 0;
        for (int l = 0; l < betweenDay; l++) {
            Date newStart = DateUtil.offset(start, DateField.DAY_OF_YEAR, l);
            Result result = calculateMaternityLeave(newStart);
            maxNormalTotalNaturalDays = Math.max(result.getNormalTotalNaturalDays(), maxNormalTotalNaturalDays);
            maxHardTotalNaturalDays = Math.max(result.getHardTotalNaturalDays(), maxHardTotalNaturalDays);
            log.info("开始时间:[{}-{}]，计算出158天产假下自然日为[{}]天，结束日期为:[{}-{}]，173天产假下自然日为[{}]天，结束日期为:[{}-{}]",
                    newStart, DateUtil.dayOfWeekEnum(newStart).toChinese(),
                    result.getNormalTotalNaturalDays(), result.getNormalEndDate(), result.getNormalDayOfWeek(),
                    result.getHardTotalNaturalDays(),
                    result.getHardEndDate(), result.getHardDayOfWeek()
            );
        }
        System.out.println();
    }

    public Result calculateMaternityLeave(Date startDate) {
        int normalTotalDays = NORMAL_DAYS;
        int hardTotalDays = HARD_DAYS;
        Week sDateWeek = DateUtil.dayOfWeekEnum(startDate);
        if (Week.SATURDAY.equals(sDateWeek)) {
            normalTotalDays += 2;
            hardTotalDays += 2;
        } else if (Week.SUNDAY.equals(sDateWeek)) {
            normalTotalDays += 1;
            hardTotalDays += 1;
        }
        DateTime normalEndDate = DateUtil.offset(startDate, DateField.DAY_OF_YEAR, NORMAL_DAYS);
        DateTime hardEndDate = DateUtil.offset(startDate, DateField.DAY_OF_YEAR, HARD_DAYS);
        Week neDateWeek = DateUtil.dayOfWeekEnum(normalEndDate);
        if (Week.SATURDAY.equals(neDateWeek)) {
            normalTotalDays += 2;
        } else if (Week.SUNDAY.equals(sDateWeek)) {
            normalTotalDays += 1;
        }

        Week heDateWeek = DateUtil.dayOfWeekEnum(hardEndDate);
        if (Week.SATURDAY.equals(heDateWeek)) {
            hardTotalDays += 2;
        } else if (Week.SUNDAY.equals(heDateWeek)) {
            hardTotalDays += 1;
        }
        Result result = new Result();
        result.setNormalEndDate(normalEndDate);
        result.setNormalDayOfWeek(neDateWeek.toChinese());
        result.setHardEndDate(hardEndDate);
        result.setHardDayOfWeek(heDateWeek.toChinese());
        result.setNormalTotalNaturalDays(normalTotalDays);
        result.setHardTotalNaturalDays(hardTotalDays);

        return result;
    }


    @Data
    public static class Result {
        private Date normalEndDate;
        private String normalDayOfWeek;
        private Date hardEndDate;
        private String hardDayOfWeek;
        private int normalTotalNaturalDays;
        private int hardTotalNaturalDays;
    }

}
