//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

import java.util.*;

class Shares {
    public static int maxProfit(int[] prices) {

        int buyPrice = Integer.MAX_VALUE;
        int profit = 0;
        
        for(int i =0; i<prices.length-1;i++){
            if(prices[i]<buyPrice){
                for(int j =i+1; j<prices.length;j++){
                    if(prices[j] - prices[i] > profit){
                        buyPrice = prices[i];
                        profit = prices[j] - prices[i];
                    }
                }
            }
        }
        
        return profit;

    }

    public static void main(String[] args){
        int[] prices = {2,1,4};
        System.out.println(maxProfit(prices));

    }
}
