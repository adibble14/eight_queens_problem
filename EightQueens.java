public class EightQueens {
	public static boolean done = false;
	public static Queen[] position;
	public static void main(String[] args) { //main method
		int row = 0;
		position = new Queen[8]; //array of queens
		
		isSafe(row); //calling the method
		
		System.out.println("The positions for the 8 queens are:");
		System.out.println("ROW  COL");
		System.out.println("--------");
		
		for(int i = 0; i < 8; i++) { //output of coordinates
			int r = position[i].row + 1;
			int c = position[i].col + 1;
			System.out.println(" ("+r+","+ c+")");
		}
	}

	public static void isSafe(int row) { //method to determine where it is safe to place the queens
		
		for(int column = 0; column < 8; column++) {
			if(done) { //checks to see if all the Queens have been found
				break;
			}
			position[row] = new Queen(row,column);//adding a new element to array
			boolean safe = true;
			
			for(int queen = 0;queen<row;queen++) { //checking to see if it meets the requirements
				if(position[queen].col == column || position[queen].row - position[queen].col == row - column ||
						position[queen].col + position[queen].row == row + column) {
					safe = false;
				}
			}
			
			if(safe == true && row == 7){//checks to see if all the Queens have been found
				done = true;
				break;
			}
			else{
				if(safe == true) {
					isSafe(row+1); //recursion and backtracking
				}
			}
		}
	}
}
class Queen extends EightQueens { //class that contains the placement of the queen 
	public int row=0,col=0;
	
	public Queen() {	
	}
	
	public Queen(int x, int y) {
		super();
		this.row = x;
		this.col = y;
	}
}