public class RationalNumber {
    private int num;
    private int denom;

    public RationalNumber(int num, int denom) {
        //checks if the denominator is zero and returns message.
        if (denom == 0) {
            throw new IllegalArgumentException("Denominator cannot be zero");
        }
        //gcd is calculated to simply the fractions
        int gcd = gcd(Math.abs(num), Math.abs(denom));
        this.num = num / gcd;
        this.denom = denom / gcd;
        if (this.denom < 0) {
            this.num *= -1;
            this.denom*= -1;
        }
    }
//get() methods to get numerator and denominator
    public int getNumerator() {
        return num;
    }

    public int getDenominator() {
        return denom;
    }
    
//methods to add, subtract, multiply, divide, compare, convert to float and absolute of the two entered rational numbers.
    public RationalNumber add(RationalNumber other) {
        int n = this.num* other.denom + other.num * this.denom;
        int d = this.denom * other.denom;
        return new RationalNumber(n, d);
    }
    public RationalNumber subtract(RationalNumber other) {
        int n = this.num * other.denom - other.num * this.denom;
        int d = this.denom * other.denom;
        return new RationalNumber(n, d);
    }

    public RationalNumber multiply(RationalNumber other) {
        int n = this.num  * other.num ;
        int d = this.denom* other.denom;
        return new RationalNumber(n,d);
    }

    public RationalNumber divide(RationalNumber other) {
        if (other.num == 0) {
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        int n= this.num * other.denom ;
        int d = this.denom * other.num;
        return new RationalNumber(n, d);
    }

    public int compareTo(RationalNumber other) {
        int num1 = this.num  * other.denom ;
        int num2 = other.num  * this.denom ;
        return Integer.compare(num1, num2);
    }

    public double toDouble() {
        return (double) this.num  / this.denom;
    }

    public RationalNumber abs() {
        return new RationalNumber(Math.abs(this.num), this.denom);
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    //toString method to display output in correct format.
  @Override
    public String toString() {
        if (this.denom == 1) {
            return Integer.toString(this.num);
        }
        return this.num + "/" + this.denom;
    }
}
