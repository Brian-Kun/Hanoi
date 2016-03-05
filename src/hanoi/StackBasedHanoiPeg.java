package hanoi;

import structures.LinkedStack;

/**
 * A {@link StackBasedHanoiPeg} is an implementation of {@link HanoiPeg}.
 * 
 * @author jcollard
 */
public class StackBasedHanoiPeg implements HanoiPeg {
	
	LinkedStack<HanoiRing> pegStack;

	/**
	 * Creates a new {@link StackBasedHanoiPeg} that has no rings.
	 *
	 */
	public StackBasedHanoiPeg() {
		pegStack = new LinkedStack<HanoiRing>();
	}

	@Override
	public void addRing(HanoiRing ring) throws IllegalHanoiMoveException {
		if(!pegStack.isEmpty() && pegStack.peek().getSize()<ring.getSize())
			throw new IllegalHanoiMoveException("");
		if(!pegStack.isEmpty() && pegStack.peek().getSize() == ring.getSize())
			throw new IllegalHanoiMoveException("");
		pegStack.push(ring);
		
			
	}

	@Override
	public HanoiRing remove() throws IllegalHanoiMoveException {
		if(pegStack.isEmpty())
			throw new IllegalHanoiMoveException("");
		return pegStack.pop();
	}

	@Override
	public HanoiRing getTopRing() throws IllegalHanoiMoveException {
		if(pegStack.isEmpty())
			throw new IllegalHanoiMoveException("");
		return pegStack.peek();
	}

	@Override
	public boolean hasRings() {
			return (!(pegStack.getSize() == 0));
	}
}
