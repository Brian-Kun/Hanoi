package hanoi;

/**
 * A {@link ArrayBasedHanoiBoard} is a simple implementation of
 * {@link HanoiBoard}
 * 
 * @author jcollard
 * 
 */
public class ArrayBasedHanoiBoard implements HanoiBoard {
	/**
	 * Creates a {@link ArrayBasedHanoiBoard} with three empty {@link HanoiPeg}s
	 * and {@code n} rings on peg 0.
	 */
	StackBasedHanoiPeg[] pegArray = new StackBasedHanoiPeg[3];
	
	
	public ArrayBasedHanoiBoard(int n) {
		if(n < 0){
			throw new IllegalArgumentException();
		}
		pegArray[0] = new StackBasedHanoiPeg();
		pegArray[1] = new StackBasedHanoiPeg();
		pegArray[2] = new StackBasedHanoiPeg();
		
		for(int i = n ; i  > 0; i--){
			HanoiRing ring = new HanoiRing(i);
			pegArray[0].addRing(ring);
		}
		
	}

	@Override
	public void doMove(HanoiMove move) throws IllegalHanoiMoveException {
		if (!isLegalMove(move)) {
			throw new IllegalHanoiMoveException("Could not perform illegal move.");
		}
		HanoiRing ring = pegArray[move.getFromPeg()].remove();
		pegArray[move.getToPeg()].addRing(ring);
		
	}

	@Override
	public boolean isSolved() {
		return (!pegArray[0].hasRings() && !pegArray[1].hasRings());
	}

	@Override
	public boolean isLegalMove(HanoiMove move) {
		
		if(move == null ) throw new NullPointerException();
		
		if(move.getFromPeg() == move.getToPeg() || !pegArray[move.getFromPeg()].hasRings())
			return false;
		
		if(pegArray[move.getToPeg()].hasRings()){
			//gets the size of the rings in the "from and "to" pegs
			int fromPegSize = pegArray[move.getFromPeg()].getTopRing().getSize();
			int toPegSize = pegArray[move.getToPeg()].getTopRing().getSize();
			
			if(fromPegSize > toPegSize)
				return false;
		}
		
		
		
		
		return true;
	}
}
