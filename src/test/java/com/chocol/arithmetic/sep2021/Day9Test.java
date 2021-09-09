package com.chocol.arithmetic.sep2021;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

/**
 * Description:
 *
 * @author 陈力
 * @date 2021/6/8
 * @since
 */
@Slf4j
@SpringBootTest
public class Day9Test {

    @Test
    public void test01() {
        String[] words = {"ask","not","what","your","country","can","do","for","you","ask","what","you","can","do","for","your","country"};
        int maxWidth = 16;

        List<String> ans = fullJustify(words, maxWidth);

        System.out.println();
    }

    /**
     * 68. 文本左右对齐
     *
     * 给定一个单词数组和一个长度maxWidth，重新排版单词，使其成为每行恰好有maxWidth个字符，且左右两端对齐的文本。
     * 
     * 你应该使用“贪心算法”来放置给定的单词；也就是说，尽可能多地往每行中放置单词。必要时可用空格' '填充，使得每行恰好有 maxWidth个字符。
     * 
     * 要求尽可能均匀分配单词间的空格数量。如果某一行单词间的空格不能均匀分配，则左侧放置的空格数要多于右侧的空格数。
     * 
     * 文本的最后一行应为左对齐，且单词之间不插入额外的空格。
     * 
     * 说明:
     * 
     * 单词是指由非空格字符组成的字符序列。 <br/>
     * 每个单词的长度大于 0，小于等于maxWidth。 <br/>
     * 输入单词数组 words至少包含一个单词。<br/>
     * 
     * 链接：https://leetcode-cn.com/problems/text-justification
     * 
     * @return
     */
    public List<String> fullJustify(String[] words, int maxWidth) {
        // 遍历数组，寻找前n个单词实际长度length小于等于maxWidth-n-1(包含分隔符)
        // 计算(maxWidth-length)%(n-1)是否等于0，如果不等于0则将余数个空格追加到第一个单词后面
        // 如果当前行只有一个单词或者最后一行，则将空格补充到最后面

        List<String> ans = new ArrayList<>();
        List<String> memo = new ArrayList<>();
        int length = 0, start = 0;

        while (start < words.length) {
            memo.clear();
            length = 0;
            while (start < words.length && length + words[start].length() + memo.size() <= maxWidth) {
                memo.add(words[start]);
                length += words[start].length();
                start++;
            }

            // 如果是最后一行,需要把空格放到最右边
            if (start == words.length) {
                StringBuilder line = new StringBuilder(memo.get(0));
                if (memo.size() == 1) {
                    for (int j = 0; j < maxWidth - length; j++) {
                        line.append(" ");
                    }
                } else {
                    for (int i = 1; i < memo.size(); i++) {
                        line.append(" ");
                        line.append(memo.get(i));
                        length++;
                    }
                    for (int j = 0; j < maxWidth - length; j++) {
                        line.append(" ");
                    }
                }
                ans.add(line.toString());
            } else if (memo.size() == 1) {
                // 当前行只有一个单词
                StringBuilder line = new StringBuilder(memo.get(0));
                for (int j = 0; j < maxWidth - length; j++) {
                    line.append(" ");
                }
                ans.add(line.toString());
            } else {
                // 非第一行并且至少有两个单词,根据空格差一直往每个单词尾插入空格
                int redundant = (maxWidth - length) % (memo.size() - 1);
                int split = (maxWidth - length) / (memo.size() - 1);
                StringBuilder line = new StringBuilder(memo.get(0));
                for (int i = 1; i < memo.size(); i++) {
                    for (int j = 0; j < split; j++) {
                        // 均分下来的空格追加到单词尾
                        line.append(" ");
                    }
                    if (redundant-- > 0) {
                        line.append(" ");
                    }
                    line.append(memo.get(i));
                }
                ans.add(line.toString());
            }
        }
        return ans;
    }

}
