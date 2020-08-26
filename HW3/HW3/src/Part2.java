/**
 * Simple class that takes infix expression,
 * converts it postfix and calculates the expression value.
 *
 * @author Yusuf Can
 */
public class Part2 {

    String infix;

    /**
     * Simple constructor that takes infix expression.
     * @param infix Infix expression.
     */
    public Part2(String infix){
        this.infix = infix;
    }

    /**
     * Converts infix expressiton to postfix.
     * @return postfix expression.
     */
    public String postfix(){

        MyStack<String> stack1 = new MyStack<String>();/*Holds the paranthesis.*/
        MyStack<String> stack2 = new MyStack<String>();/*Holds the operators.*/
        MyStack<String> stack3 = new MyStack<String>();/*Holds the operands.*/

        String result = new String();

        /*It looks all expression and organize it.*/
        for(int i=0;i<infix.length();i+=2){

            if(infix.charAt(i) == '('){
                stack1.push(infix.charAt(0)+"");
            }
            else if(infix.charAt(i) == '+' || ( (infix.charAt(i) == '-') && (infix.charAt(i+1) == ' ') ) ||
                    infix.charAt(i) == '/' || infix.charAt(i) == '*'){
                stack2.push(infix.charAt(i)+"");
            }
            else if(infix.charAt(i) == 'c' && infix.charAt(i+1) == 'o'){
                String c = "cos";
                stack2.push(c);
                i++;
            }
            else if(infix.charAt(i) == 's' && infix.charAt(i+1) == 'i'){
                String c = "sin";
                stack2.push(c);
                i++;
            }
            else if(infix.charAt(i) == 'a' && infix.charAt(i+1) == 'b'){
                String c = "abs";
                stack2.push(c);
                i++;
            }
            else if(infix.charAt(i)==')'){

                if(stack3.empty() != true){
                    result += stack3.pop();
                    result+=" ";
                }

                if(stack2.empty() != true){
                    result+= stack2.pop();
                    result+=" ";
                }

                stack1.pop();

                if(stack2.empty() != true &&( (stack2.peek()).equals("sin") ||
                        (stack2.peek()).equals("cos") || (stack2.peek()).equals("abs"))){
                    result += stack2.pop();
                    result+= " ";
                }
                if(stack1.empty()==true){
                    while(stack2.empty() != true){
                        result+= stack2.pop();
                        result+=" ";
                    }
                }
            }
            else{
                if(infix.charAt(i-2) == '('){
                    int a =i;
                    int counter =0;
                    while(infix.charAt(a)!=' '){
                        result += infix.charAt(a);
                        a++;
                        counter++;
                    }
                    result+= " ";
                    i+=(counter-1);

                }
                else{
                    int a =i;
                    int counter =0;
                    String c = new String();
                    while(a<infix.length() && infix.charAt(a)!=' '){
                        c += infix.charAt(a);
                        a++;
                        counter++;
                    }

                    stack3.push(c);
                    i+=(counter-1);
                }

            }

            if(stack1.empty()== true && stack2.empty()== false && stack3.empty()==false ){
                result += stack3.pop();
                result+= " ";
                result += stack2.pop();
                result+= " ";
            }

        }

        if(stack2.empty() == false){
            while(stack2.empty()!= true){
                result+= stack2.pop();
                result+= " ";
            }
        }
        return result;
    }

    /**
     * It calculates the postfix expression and returns the expression value.
     * @return Expression value.
     */
    public double calculatePosfix(){

        /*First it converts infix to postfix.*/
        String postfix =postfix();

        MyStack<Double> operand = new MyStack<>();

        /*It split all arguments.*/
        String[] tokens =postfix.split("\\s+");

        /*For mathematical expressions.*/
        Math math = new Math();
        double left,right;
        for(String tokenn : tokens){

            /*If expression is operator, it calculates it with operand and pushs it to the operand stack.*/
            if(tokenn.equals("+")){
                right=operand.pop();
                left=operand.pop();

                operand.push(left+right);
            }
            else if(tokenn.equals("-")){
                right=operand.pop();
                left=operand.pop();

                operand.push(left-right);

            }
            else if(tokenn.equals("/")){
                right=operand.pop();
                left=operand.pop();

                operand.push(left/right);
            }
            else if(tokenn.equals("*")){
                right=operand.pop();
                left=operand.pop();

                operand.push(left*right);
            }
            else if(tokenn.equals("cos")){

                right=operand.pop();
                operand.push(math.cos(right));

            }
            else if(tokenn.equals("sin")){

                right=operand.pop();
                operand.push(math.sin(right));

            }
            else if(tokenn.equals("abs")){
                right=operand.pop();
                operand.push(math.abs(right));
            }
            else{

                /*If expression is operand it push it to stack.*/
                operand.push( Double.parseDouble(tokenn) );
            }
        }

        return operand.pop();
    }




}
