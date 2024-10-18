package Practice_Question;

public class RationalNumber {
    public static void main(String[] args) {
        Rational rational1 =new Rational(1,2);
        Rational rational2 =new Rational(1,2);
        System.out.println(rational1.addRationalNumber(rational2));
        System.out.println(rational1.subtractRationalNumber(rational2));


        Rational product = rational1.multiplyRationalNumber(rational2);

        System.out.println(product.getNumerator()+"/"+ product.getDenominator());


        Rational divideResult = rational1.divideRationalNumber(rational2);

        System.out.println(divideResult.getNumerator()+"/"+ divideResult.getDenominator());
    }
}

class Rational {
    private float numerator;
    private float denominator;

    Rational() {
        this.numerator = 0;
        this.denominator = 1;

    }

    Rational(float numerator) {
        this.numerator = numerator;
        this.denominator = 1;
    }

    Rational(float numerator, float denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public void setDenominator(float denominator) {
        this.denominator = denominator;
    }

    public float getDenominator() {
        return denominator;
    }

    public void setNumerator(float numerator) {
        this.numerator = numerator;
    }

    public float getNumerator() {
        return numerator;
    }

    public float addRationalNumber(Rational otherRational) {
        float sum = 0;
        float a = this.numerator;
        float b = this.denominator;
        float c = otherRational.numerator;
        float d = otherRational.denominator;
        sum = (a * d + c * b) / (b * d);
        return sum;
    }

    public float subtractRationalNumber(Rational otherRational) {
        float difference = 0;
        float a = this.numerator;
        float b = this.denominator;
        float c = otherRational.numerator;
        float d = otherRational.denominator;
        difference = (a * d - c * b) / (b * d);
        return difference;

    }

    public Rational multiplyRationalNumber(Rational otherRational) {

        float a = this.numerator;
        float b = this.denominator;
        float c = otherRational.numerator;
        float d = otherRational.denominator;

        return new Rational (a*c,b*d);
    }

    public Rational divideRationalNumber(Rational otherRational) {

        float a = this.numerator;
        float b = this.denominator;
        float c = otherRational.numerator;
        float d = otherRational.denominator;

        return new Rational (a*d,c*b);
    }
}




