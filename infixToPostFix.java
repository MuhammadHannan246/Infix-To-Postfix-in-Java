package LAB11;

import java.util.Scanner;
import java.util.Stack;

class stack{
	
    public int precedence(char dh){
		switch(dh){
        case '+':
        case '-':
            return 1;
        case '*':
        case '/':
            return 2;
        case '^':
            return 3;
    }
    return -1;
}

    public String infixToPostFix(String expression){

        String result = "";
        Stack<Character> stack = new Stack<>();
        for (int d = 0; d <expression.length() ; d++) {
            char dh = expression.charAt(d);


            if(precedence(dh)>0){
                while(stack.isEmpty()==false && precedence(stack.peek())>=precedence(dh)){
                    result += stack.pop();
                }
                stack.push(dh);
            }else if(dh==')'){
                char h = stack.pop();
                while(h!='('){
                    result += h;
                    h = stack.pop();
                }
            }else if(dh=='('){
                stack.push(dh);
            }else{
                result += dh;
            }
        }
        for (int d = 0; d <=stack.size() ; d++) {
            result += stack.pop();
        }
        return result;
}
}
public class LAB_TASK01 {

	public static void main(String[] args) {

		String exp="A+(B*C-(D/E|F)*G)*H";
		stack dh=new stack();
		System.out.println("the infix into postfix is:");
		System.out.println(dh.infixToPostFix(exp));

		
	}

}
