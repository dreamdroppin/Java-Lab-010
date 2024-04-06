class Date {
    int year, month, day;

    //Take No parameters and initialize a default date
    Date() {
        //Default, 01/01/2024
        this.year = 2024;
        this.month = 01;
        this.day = 01;
    }

    //Take parameters named year
    Date(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }
}

    //Birthday in Main

//Relational
class Rational {
    int numerator, denominator;

    //Numerator to 0 and denominator to 1.
    Rational() {
        this.numerator = 0;
        this.denominator = 1;
    }

    //Constructor with parameters
    Rational(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    //printRational in a format
    void printRational() {
        System.out.println(numerator + "/" + denominator);
    }

    //toString method for Rational
    public String toString() {
        return numerator + "/" + denominator;
    }

    //Write a second constructor that takes two arguments and uses them to initialize the instance variables.

    //Negate: reverses the sign of a rational number
    void negate() {
        this.numerator = -this.numerator;
    }

    //Invert: that swaps the numerator and denominator.
    //It should be a modifier.
    void invert() {
        int temp = this.numerator;
        this.numerator = this.denominator;
        this.denominator = temp;
    }

    //toDouble: that converts the rational number to a double
    double toDouble() {
        //Returns
        return (double) numerator / denominator;
    }

    //Greatest common divisor (GCD)
    int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    Rational reduce() {
        int commonDivisor = gcd(this.numerator, this.denominator);
        return new Rational(this.numerator / commonDivisor, this.denominator / commonDivisor);
    }

    //Add: two Rational numbers
    Rational add(Rational other) {
        int resultNumerator = this.numerator * other.denominator + other.numerator * this.denominator;
        int resultDenominator = this.denominator * other.denominator;
        return new Rational(resultNumerator, resultDenominator).reduce();
    }
}

public class TestingOperations {
    public static void main(String[] args) {
        //Birthdate: February 8, 2005
        Date birthday = new Date(2005, 2, 8);
        System.out.println("Birthday: " + birthday.year + "-" + birthday.month + "-" + birthday.day);

        //Testing printRational
        Rational rationalNumber = new Rational(2, 3);
        System.out.print("Rational Number: ");
        rationalNumber.printRational();

        //Testing toString
        System.out.println("Rational Number as String: " + rationalNumber.toString());

        //Testing negate
        rationalNumber.negate();
        System.out.println("Negated Rational Number: " + rationalNumber.toString());

        //Testing invert
        rationalNumber.invert();
        System.out.println("Inverted Rational Number: " + rationalNumber.toString());

        //Testing toDoubled
        System.out.println("Rational Number as Double: " + rationalNumber.toDouble());

        //Testing reduce
        Rational rationalNumber2 = new Rational(6, 8);
        Rational reducedNumber = rationalNumber2.reduce();
        System.out.println("Reduced Rational Number: " + reducedNumber.toString());

        //Testing add
        Rational rationalNumber1 = new Rational(1, 2);
        Rational result = rationalNumber1.add(new Rational(1, 3));
        System.out.println("Addition result: " + result.toString());
    }
}