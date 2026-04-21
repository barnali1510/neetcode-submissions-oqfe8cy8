class Solution {
    public String decodeString(String s) {

        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();
        int num = 0;
        StringBuilder str = new StringBuilder();

        for(char ch : s.toCharArray()) {
            if(Character.isDigit(ch)) {
                num = num*10 + (ch - '0');
            } else if(ch == '[') {
                countStack.push(num);
                stringStack.push(str);

                num = 0;
                str = new StringBuilder();
            } else if(ch == ']') {
                int repeat = countStack.pop();
                StringBuilder decoded = stringStack.pop();

                for(int i=0; i<repeat; i++) {
                    decoded.append(str);
                }

                str = decoded;
            } else {
                str.append(ch);
            }
        }
        return str.toString();
    }
}