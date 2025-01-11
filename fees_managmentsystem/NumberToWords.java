/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fees_managmentsystem;

/**
 *
 * @author ankit
 */
public class NumberToWords {

    // Arrays to store word equivalents of numbers
    private static final String[] UNITS = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    private static final String[] TEENS = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private static final String[] TENS = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private static final String[] INDIAN_SCALES = {"", "Thousand", "Lakh", "Crore"};

    public static String convertNumberToWords(float number) {
        if (number == 0) {
            return "Zero";
        }

        int wholePart = (int) number;
        int fractionalPart = Math.round((number - wholePart) * 100);

        String words = convertWholeNumberToWords(wholePart);

        if (fractionalPart > 0) {
            words += " and " + convertWholeNumberToWords(fractionalPart) + " Paise";
        }

        return words.trim();
    }

    private static String convertWholeNumberToWords(int number) {
        if (number == 0) {
            return "Zero";
        }

        String words = "";

        // Handle Indian numbering system
        int crore = number / 10000000;
        number %= 10000000;
        if (crore > 0) {
            words += convertChunk(crore) + " Crore ";
        }

        int lakh = number / 100000;
        number %= 100000;
        if (lakh > 0) {
            words += convertChunk(lakh) + " Lakh ";
        }

        int thousand = number / 1000;
        number %= 1000;
        if (thousand > 0) {
            words += convertChunk(thousand) + " Thousand ";
        }

        int hundred = number / 100;
        number %= 100;
        if (hundred > 0) {
            words += convertChunk(hundred) + " Hundred ";
        }

        if (number > 0) {
            words += " " + convertChunk(number);
        }

        return words.trim();
    }

    private static String convertChunk(int number) {
        String chunkInWords = "";

        if (number >= 100) {
            chunkInWords += UNITS[number / 100] + " Hundred ";
            number %= 100;
        }

        if (number >= 10 && number <= 19) {
            chunkInWords += TEENS[number - 10] + " ";
        } else if (number >= 20) {
            chunkInWords += TENS[number / 10] + " ";
            number %= 10;
        }

        if (number >= 1 && number <= 9) {
            chunkInWords += UNITS[number] + " ";
        }

        return chunkInWords.trim();
    }
}
