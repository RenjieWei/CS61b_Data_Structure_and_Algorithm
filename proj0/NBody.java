public class NBody{
	/** 
	first method:return a double corresponding to the radius of the universe in that file
	*/
	public static double readRadius(String fileName){
		In in = new In(fileName);

		int n = in.readInt();
		double radius = in.readDouble();

		return radius;
	}

	/**
	Given a file name, it should return an array of Bodys corresponding 
	to the bodies in the file
	*/
	public static Body[] readBodies(String fileName){
		In in = new In(fileName);

		int n = in.readInt();
		double radius = in.readDouble();

		Body [] bodies = new Body[n];

		for(int i = 0; i < n; i++){
			double xP = in.readDouble();
			double yP = in.readDouble();
			double xV = in.readDouble();
			double yV = in.readDouble();
			double m = in.readDouble();
			String img = in.readString();
			bodies[i] = new Body(xP,yP,xV,yV,m,img);
		}
		return bodies;
	}

	/**
	main method:
	1. Store the 0th and 1st command line arguments as doubles named T and dt. 
	2. Store the 2nd command line argument as a String named filename.
	3. Read in the bodies and the universe radius from the file described by filename
	*/
	public static void main(String[] args) {
		/**collecting all needed input*/
		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String filename = args[2];
		Body[] bodies = readBodies(filename);
		double radius = readRadius(filename);
		
		/**Draw the background*/
		StdDraw.setCanvasSize(radius*2, radius*2);
		StdDraw.picture(0,0,"images/starfield.jpg");
		
		/**Draw more than one body*/
		for(int i = 0; i < bodies.length; i++){
		bodies[i].draw();
		}	
	}






} 
