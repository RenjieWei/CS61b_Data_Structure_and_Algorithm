public class Body{

	/* 6 instance variables*/
	public double xxPos, yyPos, xxVel, yyVel, mass;
	public String imgFileName;

	/* first constructor */
	public Body(double xP, double yP, double xV, double yV, double m, String img){
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
	}

	/* second constructor */
	public Body(Body b){
		b.xxPos = xxPos;
		b.yyPos = yyPos;
		b.xxVel = xxVel;
		b.yyVel = yyVel;
		b.mass = mass;
		b.imgFileName = imgFileName;
	}

	/* calculates the distance between two Bodys */
	public double calcDistance(Body c){
		double r;
		r = Math.sqrt((c.xxPos - xxPos)*(c.xxPos - xxPos) + (c.yyPos - yyPos)*(c.yyPos - yyPos));
		return r;
	}

	public double calcForceExertedBy(Body d){
		double r = this.calcDistance(d);
		double g = 6.67 * Math.pow(10,-11);
		double force = (g * this.mass * d.mass) /(r * r);
		return force;
	}

	public double calcForceExertedByX(Body e){
		double force = this.calcForceExertedBy(e);
		double r = this.calcDistance(e);
		double dx = e.xxPos - this.xxPos;
		double fx = force * dx / r;
		return fx;
	}

	public double calcForceExertedByY(Body f){
		double force = this.calcForceExertedBy(f);
		double r = this.calcDistance(f);
		double dy = f.yyPos - this.yyPos;
		double fy = force * dy / r;
		return fy;
	}

	public double calcNetForceExertedByX(Body[] bodies){
		double netForceByX = 0;	
		for (Body i:bodies){
			if (this.equals(i)){
				continue;
			}
			netForceByX += this.calcForceExertedByX(i);
		}
		return netForceByX;
	}

	public double calcNetForceExertedByY(Body[] bodies){
		double netForceByY = 0;	
		for (Body i:bodies){
			if (this.equals(i)){
				continue;
			}
			netForceByY += this.calcForceExertedByY(i);
		}
		return netForceByY;
	}

	public void update(double dt, double xForce, double yForce){
		double xAccel = xForce/mass;
		double yAccel = yForce/mass;
		xxVel += dt * xAccel;
		yyVel += dt * yAccel;
		xxPos += dt * xxVel;
		yyPos += dt * yyVel;
	}

}


