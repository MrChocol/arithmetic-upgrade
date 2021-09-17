package com.chocol.arithmetic.sep2021;

import java.util.Arrays;

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
public class Day17Test {

    @Test
    public void test01() {

        char[][] board = {{'8', '3', '.', '.', '7', '.', '.', '.', '.'}, {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
            {'.', '9', '8', '.', '.', '.', '.', '6', '.'}, {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
            {'4', '.', '.', '8', '.', '3', '.', '.', '1'}, {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
            {'.', '6', '.', '.', '.', '.', '2', '8', '.'}, {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
            {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

        assert !isValidSudoku(board);
    }

    /**
     * 36. 有效的数独
     *
     * 请你判断一个9x9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。
     * 
     * 数字1-9在每一行只能出现一次。 数字1-9在每一列只能出现一次。 数字1-9在每一个以粗实线分隔的3x3宫内只能出现一次。 <br/>
     * （请参考示例图） 数独部分空格内已填入了数字，空白格用'.'表示。
     * 
     * 注意：
     * 
     * 一个有效的数独（部分已被填充）不一定是可解的。 只需要根据以上规则，验证已经填入的数字是否有效即可。
     * 
     * 链接：https://leetcode-cn.com/problems/valid-sudoku
     *
     * 提示：
     * 
     * board.length == 9 <br/>
     * board[i].length == 9 <br/>
     * board[i][j] 是一位数字或者 '.' <br/>
     *
     * @return
     */
    public boolean isValidSudoku(char[][] board) {
        // 记录每一行[1-9]第几个数出现过
        boolean[][] row = new boolean[9][10];
        // 记录每一列[1-9]第几个数出现过
        boolean[][] col = new boolean[9][10];
        // 记录每一个block[1-9]第几个数出现过
        boolean[][] block = new boolean[9][10];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] != '.') {
                    int u = board[i][j] - '0';
                    // 获取当前数字在那个单元块[0-8]
                    int idx = i / 3 * 3 + j / 3;
                    if (row[i][u] || col[j][u] || block[idx][u]) {
                        return false;
                    }
                    // 标记
                    row[i][u] = true;
                    col[j][u] = true;
                    block[idx][u] = true;
                }
            }
        }

        return true;
    }

}
