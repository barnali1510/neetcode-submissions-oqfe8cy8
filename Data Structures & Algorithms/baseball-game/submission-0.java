class Solution {
    public int calPoints(String[] operations) {

        Deque<Integer> stack = new ArrayDeque<>();

        for(String op : operations) {
            if(op.equals("+")) {
                int a = stack.pop();
                int b = stack.peek();
                int sum = a+b;
                stack.push(a);
                stack.push(sum);
            } else if(op.equals("D")) {
                int prev = stack.peek();
                stack.push(prev*2);
            } else if(op.equals("C")) {
                stack.pop();
            } else {
                stack.push(Integer.parseInt(op));
            }
        }

        int total = 0;
        for(int v : stack) {
            total += v;
        }
        return total;
        
    }
}