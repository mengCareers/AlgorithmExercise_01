/*
Given an array of scores that are non-negative integers. 
Player 1 picks one of the numbers from either end of the array followed by the player 2 and then player 1 and so on. Each time a player picks a number, that number will not be available for the next player. 
This continues until all the scores have been chosen. The player with the maximum score wins.
Given an array of scores, predict whether player 1 is the winner. 
You can assume each player plays to maximize his score.
 * Thought Process:
 * 
 */
package Recursion.Min_Max;

import java.util.Arrays;

/**
 *
 * @author xinrong
 */
public class PredicttheWinner {

    public boolean PredictTheWinner(int[] nums) {
        return winner(1, 0, nums.length - 1, nums) >= 0;
    }

    private int winner(int turn, int s, int e, int[] nums) {
        if (s == e) {
            return turn * nums[s];
        }
        int choiceS = turn * nums[s] + winner(-turn, s + 1, e, nums);
        int choiceE = turn * nums[e] + winner(-turn, s, e - 1, nums);
        return turn * Math.max(turn * choiceS, turn * choiceE);
    }
}
