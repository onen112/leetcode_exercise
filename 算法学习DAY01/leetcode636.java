/**
 * 函数的独占时间
 * 
 * https://leetcode.cn/problems/exclusive-time-of-functions/
 * 
 * 1. 思路：
 * 遇到start入栈、遇到end出栈，在出栈时判断是否为空，不为空则说明该函数是在别的函数中调用的，用调用函数的时间减去该函数的执行时间
 */

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<String> stack = new Stack<>();
        int[] ret = new int[n];
        for(String s : logs){
            if(s.contains("start")){
                stack.push(s);
            }else{
                int t = Integer.valueOf(s.split(":")[2]) - Integer.valueOf(stack.pop().split(":")[2]) + 1;
                ret[Integer.valueOf(s.split(":")[0])] += t;
                if(!stack.isEmpty()){
                   ret[Integer.valueOf(stack.peek().split(":")[0])] -= t;
                }
                
            }
        }
        return ret;
    }
}