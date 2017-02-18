import java.util.Random;

/**
 * A Ghost in the game of Pacman.
 * 
 * @author Elizabeth modified by Yuzhou
 * 
 */
public class Ghost extends GameEntity {
	private Random rand;

	/**
	 * Creates a Ghost at the specified location
	 * 
	 * @param location
	 *            the location at which the Ghost is created
	 */
	public Ghost(Location location) {
		/* Your Code Here */
		super(location, PacmanGamePanel.GHOST_IMAGE);
		rand = new Random();
	}

	/*
	 * handle what happens when a ghost runs into pacman
	 * 
	 * if pacman is invincible, the ghost should be moved back to it's origin
	 * point.
	 */
	@Override
	public boolean collide(GameObject object) {
		/* Your Code Here */

		if (super.collide(object)) {// if it collides
			if (object instanceof Pacman) {
				if (((Pacman) object).isInvincible()) {
					super.moveToOrigin();
				}
			}
		}
		return super.collide(object);
	}

	/*
	 * Ghosts move in a special way, so we need to override the move defined in
	 * GameEntity.
	 * 
	 * When move is called, a Ghost should have an 80% chance of actually
	 * moving.
	 * 
	 * If it can continue going in the direction it is facing, it should move
	 * that way.
	 * 
	 * If not, it should pick a way to turn (right or left), and turn until it
	 * can move in the direction it is facing.
	 */
	@Override
	public void move(Level level) {
		/* Your Code Here */

		int chance = rand.nextInt(100);
		if (chance >= 20) {//80% chance of moving
			Location originLoc = location.clone();
			super.move(level);

			//if the location didn't change, then turn left or right randomly
			if (originLoc.equals(getLocation()) ){
				boolean turn = rand.nextBoolean();
				this.turn(turn);
			}
		}

	

	}

}
