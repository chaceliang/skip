package pointTo;

public class Question14SeparateEvenOdd {
	
    public static void callCommand(Command command, Object data) {
        command.execute(data);
    }

    public static void main(String[] args) {
    	int[] test1 = new int[] {1,2,3,4,5,6,7,8};
    	separateArray(test1, new CheckEvenCommand());
    	for (int i = 0; i < test1.length; i++) {
    		System.out.print(test1[i] + " ");
    	}
    }

	public static void separateArray(int[] input, CheckCommand command) {
		if (input == null || input.length <= 0) {
			return;
		}
		int begin = 0; 
		int end = input.length - 1;
		while (begin < end) {
			while (begin < end && !command.execute(input[begin])) {
				begin++;
			}
			while (begin < end && command.execute(input[end])) {
				end--;
			}
			if (begin < end) {
				int tmp = input[begin];
				input[begin] = input[end];
				input[end] = tmp;
				begin++; 
				end--;
			}
		}
	}
}

interface Command {
    public void execute(Object data);
}

interface CheckCommand {
	public boolean execute(Object data);
}

class PrintCommand implements Command {
    public void execute(Object data) {
        System.out.println(data.toString());
    }    
}

class CheckEvenCommand implements CheckCommand {

	@Override
	public boolean execute(Object data) {
		if ((Integer)data %2 != 1) {
			return true;
		}
		return false;
	}
}
