package com.example.project;
public class LinearCalculator{
    //FOR EXTRA CREDIT 
    //you should copy and paste all of your code from the LinearCalculator class
    // but NOT printInfo(). Please update it below
    
    //INSTANCE VARIABLES 
    //4 INTEGER variables (name them: x1,x2,y1,y2) 
    private int x1;
    private int x2;
    private int y1;
    private int y2;


    //CONSTRUCTOR
    //1 constructor with 2 String parameters. Each parameter represents a coordinate. 
    //For example, "(1,2)" and "(3,4)" would be two parameter values 
    //You will have to parse the string into 4 integers, representing the 2 points.
    public LinearCalculator(String coor1, String coor2){ // <--add 2 string parameters to this constructor
        int idxCom= coor1.indexOf(","); 
        String coor1NumX= coor1.substring(1, idxCom);
        String coor1NumY= coor1.substring(idxCom+1, coor1.length()-1);
        x1 = Integer.parseInt(coor1NumX);
        y1 = Integer.parseInt(coor1NumY);
        int idxCom2=coor2.indexOf(",");
        String coor2NumX= coor2.substring(1, idxCom2);
        String coor2NumY= coor2.substring(idxCom2+1, coor2.length()-1);
        x2 = Integer.parseInt(coor2NumX);
        y2 = Integer.parseInt(coor2NumY);

    }



    //METHODS
    //getters and setters for the 4 instance variables (8 methods total) 
    public int getX1(){return x1;}
    public int getY1(){return y1;}
    public int getX2(){return x2;}
    public int getY2(){return y2;}
    public void setX1(int newX1){   //x-point for first coor
        x1 = newX1;
    }
    public void setY1(int newY1){   //y-point for first coor
        y1 = newY1;
    }
    public void setX2(int newX2){   //x-point for second coor
        x2 = newX2;
    }
    public void setY2(int newY2){   //y-point for second coor
        y2 = newY2;
    }


    //distance() -> returns a double. 
    //calculates the distance between the two points to the nearest HUNDREDTH and returns the value.
    public double distance(){
        double x1And2 = Math.pow((x2 - x1), 2); // (x2-x1)^2
        double y1And2 = Math.pow((y2 - y1), 2); //(y2-y1)^2
        return roundedToHundredth(Math.sqrt((x1And2+y1And2)));
    }
    //yInt() -> returns a double.
    //calculates the y intercept of the equation and returns the value to the nearest HUNDREDTH
    //if y-int if undefined, should return -999.99
    public double yInt(){
        if((x2-x1)==0){ // undef
            return -999.99;
        }
        return roundedToHundredth(y1-(slope()*x1));
    }
 
    //slope() -> returns a double. 
    //calculates the slope of the equations and returns the value to the nearest HUNDREDTH
    //if slope is undefined, should return -999.99
    public double slope(){
        if((x2-x1)==0){
            return -999.99;
        }
        double changeY = (y2-y1);
        double changeX = (x2-x1);
        return roundedToHundredth((double)changeY/changeX);
    }

    //equations() -> returns a String.
    //calculates the final equation in y=mx+b form and returns the string
    //if the equation has no slope, the equation should return -> "undefined"
    //HINT: You may need other custom methods to decrease the amount of code in the equations() method
    public String equation(){
        if (slope()==0.0){        // when slope=0, the equation is just the yint
            return "y=" + yInt();
        }
        if (yInt()==0.0) {       // when yint is 0, equation is just slope
            return "y=" +slope() + "x";
        }
        if (slope()!= -999.99){  
          if (yInt()>0) {
            return "y=" + slope() + "x+" + yInt();
          } else {
            return "y=" + slope() + "x" + yInt();
          }
        }
        return "undefined";
    }


    //roundedToHundredth(double x)-> returns double
    //calculates the input to the nearest hundredth and returns that value
    public double roundedToHundredth(double x){
        return (Math.round(x*100.0))/100.0 ;
    }

    //You will need to concatenate to the string 
    //the results from findSymmetry() and Midpoint()
    public String printInfo(){
            String str = "The two points are: (" + x1 + "," + y1  + ")";
            str += " and " + "(" + x2 + "," + y2 + ")";
            str += "\nThe equation of the line between these points is: " + equation() ;
            str += "\nThe slope of this line is: " + slope();
            str += "\nThe y-intercept of the line is: " + yInt();
            str += "\nThe distance between the two points is: " + distance();
            str += "\n" + findSymmetry();
            str += "\n" + Midpoint();
            return str;
    }

    //findSymmetry()-> returns a string 
    //the method should determine if there is symmetry between the two points
    // there should be  4 return statements 
    // return "Symmetric about the x-axis";
    // return "Symmetric about the y-axis";
    //return "Symmetric about the origin";
    //return "No symmetry";
    public String findSymmetry(){ 
        if (x1==x2 && -y1==y2) { // determines if points are symmetric about the x-axis
            return "Symmetric about the x-axis";
        } else {
            if (-x1==x2 && y1==y2) { //determines if points are symmertric about the y-axis
                return "Symmetric about the y-axis";
            } else { 
                if (-x1==x2 && -y1==y2) { //determines if points are symmertric about the origin
                    return "Symmetric about the origin";
                } else { //if all else is false, determines that there is no symmetry
                    return "No symmetry";
                }
            }
        }
    }

    //Midpoint()->return a string 
    //the method should calculate the midpoint between the two points
    //it should return "The midpoint of this line is: (0,0)";
    public String Midpoint(){ 
        double XMidpoint= ((x1+x2)/2);
        double YMidpoint= ((y1+y2)/2);
        return "The midpoint of this line is: (" + XMidpoint + "," + YMidpoint + ")";
    }

}



