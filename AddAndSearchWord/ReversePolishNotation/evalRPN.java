package ReversePolishNotation;

class Stack{
	private int[] stack;
	int i;
	
	public Stack(){
		stack = new int[1024];
		i=0;
	}
	
	public void push(int x){
		if(i<1024){
		    stack[i]=x;
		    i++;
		}
		else{
			System.out.println("stack overflow!");
		}
	}
	
	public int pop(){
		if(i<=0){
			System.out.println("no data!");
			return -111111;
		}
		else{
			i--;
			return stack[i];
		}
			
	}
	
}

public class evalRPN {
	
	public evalRPN(){
	}
	
	public int eval(String[] tokens){
		Stack s = new Stack();
		int result=0;
		for(int i=0;i<tokens.length;i++){
			String x = tokens[i];
			if(x.equals("+")||x.equals("-")||x.equals("*")
					||x.equals("/")){
				int op1 = s.pop();
				int op2 = s.pop();
				switch(x){
				case "+": result = op2+op1;
				          s.push(result);break;
				case "-": result = op2-op1;
		          s.push(result);break;
				case "*": result = op2*op1;
		          s.push(result);break;
				case "/": result = op2/op1;
		          s.push(result);break;
		        default:break;
				}
			}
			else{
				int temp =Integer.parseInt(x);
				s.push(temp);
			}
		}

		return s.pop();
	}
	
	public static void main(String[] args){
		String[] tokens ={"2", "1", "+", "3", "*"};
		evalRPN e = new evalRPN();
		System.out.println(e.eval(tokens));
	}
}
