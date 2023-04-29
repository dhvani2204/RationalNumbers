/**Dhvani Uday Parekh
 * AIML-B3
 * 21070126126
 */
public class Main {
    public static void main(String[] args) {
        //Checks whether user has entered more than 2 numbers.
        if (args.length != 2) {
            System.out.println("Enter number in valid format.");
            return;
        }
        try {
            //splits the entered fraction in two parts numerator and denominator
            String[] parts1 = args[0].split("/");
            String[] parts2 = args[1].split("/");
            
            // creating 2 objects r1 and r2 of the RationNumber class to carry out the operations.
            RationalNumber r1 = new RationalNumber(Integer.parseInt(parts1[0]), Integer.parseInt(parts1[1]));
            RationalNumber r2 = new RationalNumber(Integer.parseInt(parts2[0]), Integer.parseInt(parts2[1]));
            
            System.out.println("r1 + r2 = " + r1.add(r2));
            System.out.println("r1 - r2 = " + r1.subtract(r2));
            System.out.println("r1 * r2 = " + r1.multiply(r2));
            
            //try and catch to check if the denominator is 0  
            try {
                System.out.println("r1 / r2 = " + r1.divide(r2));
                } catch (IllegalArgumentException e) {
                System.out.println("r1 / r2 = undefined (Cannot divide by zero)");
            }
            System.out.println("r1 compared to r2: " + r1.compareTo(r2));
            System.out.println("r1 as a double: " + r1.toDouble());
            System.out.println("r2 as a double: " + r2.toDouble());
            System.out.println("|r1| = " + r1.abs());
            System.out.println("|r2| = " + r2.abs());
        } 
        //catch methods display appropriate methods if invalid inputs entered. 
        catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter rational numbers in the format 'numerator/denominator'");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}