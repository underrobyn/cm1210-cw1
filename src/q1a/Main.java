/*
 *	Module: CM1210 CW1
 *	Question: 1a
 *	Name: Jake Mcneill
 *	Student Number: c1931370
 */

public class Main {

	public static void main(String[] args) {
		int userSquareSize = getSquareSize();

		// Create square class with size user specified
		Square magic = new Square(userSquareSize);

		// Generate magic square
		int max 	= (int) Math.pow(userSquareSize, 2),
			loopX 	= 1,
			loopY	= ((userSquareSize + 1) / 2);

		magic.setPos(loopX, loopY, 1);

		for (int i = 2; i <= max; i++) {
			if (magic.getPos(loopX - 1, loopY - 1) == 0) {
				loopX--;
				loopY--;
			} else {
				loopX++;
			}

			magic.setPos(loopX, loopY, i);
			loopX = magic.updatePos(loopX);
			loopY = magic.updatePos(loopY);
		}

		System.out.println("Here's that magic square you wanted: \n" + magic.toString());
	}

	private static int getSquareSize(){
		Input in = new Input();

		int squareSize;
		boolean isAllowed;

		// Keep requesting a square size until we get a valid one
		do {
			squareSize = in.getInt("Please enter an odd integer");
			isAllowed = isOddNumber(squareSize) && 0 < squareSize;
			if (!isAllowed){
				System.out.println("You have entered an invalid number. The number must be greater than 0 and odd.");
			}
		} while (!isAllowed);

		return squareSize;
	}

	private static boolean isOddNumber(int n) {
		return Math.floorMod(n, 2) != 0;
	}

}
