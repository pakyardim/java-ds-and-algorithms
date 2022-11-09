public class StackOperations {

    public Stack removeSmallest(Stack stack) {
        Stack tempStack = new Stack(stack.size());

        int smallestValue = stack.peek();
        while(!stack.isEmpty()){
            if (!stack.isEmpty() && smallestValue > stack.peek()){
                smallestValue = stack.peek();
            }
            tempStack.push(stack.peek());
            stack.pop();
        }
        while (!tempStack.isEmpty()){
            if(tempStack.peek() != smallestValue){
                stack.push(tempStack.peek());
            }
            tempStack.pop();
        }

        return stack;
    }
    public Stack removeMin(Stack stack) {
        Stack tempStack = new Stack(stack.size());
        int minVal = stack.peek();

        while (stack.size() > 0) {
            System.out.println(stack.size());
            if (stack.size() > 0 && stack.peek() < minVal) {
                minVal = stack.peek();
            }
            tempStack.push(stack.peek());
            stack.pop();
        }

        while (tempStack.size() > 0) {
            System.out.println(tempStack.size());
            if (tempStack.peek() != minVal) {
                stack.push(tempStack.peek());
                tempStack.pop();
            }
            tempStack.pop();
        }
        return stack;
    }


    public Stack mergeStacks(Stack stack1, Stack stack2){
        Stack mergedStack = new Stack(stack1.size() + stack2.size());
        Stack tempStack = new Stack(stack1.size() + stack2.size());

        while(!stack1.isEmpty()){
            mergedStack.push(stack1.peek());
            stack1.pop();
        }
        while(!stack2.isEmpty()){
            mergedStack.push(stack2.peek());
            stack2.pop();
        }


        while(!mergedStack.isEmpty()){
            int temp = mergedStack.peek();
            mergedStack.pop();

            while (!tempStack.isEmpty() && tempStack.peek() > temp){
                mergedStack.push(tempStack.peek());
                tempStack.pop();
            }
            tempStack.push(temp);
        }
        return tempStack;
    }
}
