import javax.swing.ImageIcon;

/**
 * A Movable GameObject
 * 
 * @author Elizabeth modified by Yuzhou
 * 
 */
public abstract class GameEntity extends GameObject implements Movable {
	// the initial location of the GameEntity
	private Location origin;
	// the direction the entity is facing
	private int facingDirection;

	/**
	 * Creates a GameEntity at the given location with the given image
	 * 
	 * @param location
	 *            the initial location of the entity
	 * @param image
	 *            the image of the entity to be drawn
	 */
	public GameEntity(Location location, ImageIcon image) {
		/* Your Code Goes Here */
		super(location, image);
		origin = location.clone();
		facingDirection = NORTH;
	}

	// move the Game enity by 1 unit in the direction it
	// is facing - remember, only move it if it results in
	// a valid location (ie, not a wall)
	@Override
	public void move(Level level) {
		/* Your Code Goes Here */
		Location newLoc = location.clone();
	    newLoc.moveByDirection(getFacingDirection());
		if (level.isValidLocation(newLoc)) {
			location.moveByDirection(getFacingDirection());
		}
	}

	@Override
	public boolean collide(GameObject object) {
		boolean collide = false;
		if (this.getLocation().equals(object.getLocation())) {
			collide = true;
		}

		return collide;
		/* Your Code Goes Here */
	}

	@Override
	public int getFacingDirection() {
		return facingDirection;
		/* Your Code Goes Here */
	}

	@Override
	public void setFacingDirection(int direction) {
		/* Your Code Goes Here */
		if (direction >= 0 && direction <= 3) {
			facingDirection = direction;
		}

	}

	/**
	 * Moves the GameEntity back to where it initially started
	 */
	public void moveToOrigin() {
		/* Your Code Goes Here */
		location = origin.clone();

	}

	/**
	 * Turns the GameEntity. A turn can be right or left, and results in a
	 * change of the Entity's facing direction. For example, if the GameEntity
	 * was facing North, and it executed a right turn, it should now be facing
	 * East.
	 * 
	 * @param right
	 */
	public void turn(boolean right) {
		/* Your Code Goes Here */
		if(right){
			turnRight();
		}else{
			turnRight();
			turnRight();
			turnRight();
		}

	}

	/*
	 * A helper methods for turning right - think about how you can use this
	 * method to execute both right and left turns
	 */
	private void turnRight() {
		switch (this.facingDirection) {
		case NORTH:
			facingDirection = EAST;
			break;
		case EAST:
			facingDirection = SOUTH;
			break;
		case SOUTH:
			facingDirection = WEST;
			break;
		case WEST:
			facingDirection = NORTH;
			break;
		}
		/* Your Code Goes Here */
	}
}
