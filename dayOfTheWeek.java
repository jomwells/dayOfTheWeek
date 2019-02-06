import java.io.*;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

class dayOfTheWeek {
    static Scanner keyboard = new Scanner(System.in);
    static boolean isLeapYear(double year) {
        boolean isDivisibleBy4 = year % 4 == 0;
        boolean isDivisibleBy100 = year % 100 == 0;
        boolean isDivisibleBy400 = year % 400 == 0;
        boolean isLeapYear;
        if(isDivisibleBy4 == true && isDivisibleBy100 == false || isDivisibleBy400 == true) {
            isLeapYear = true;
        } else {
            isLeapYear = false;
        }
        return isLeapYear;
    }
    public static void main (String [] args )
    {
    String[] monthsArray = new String[]{"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    String[] datesArray = new String[]{ "1st", "2nd", "3rd", "4th", "5th", "6th", "7th", "8th", "9th", "10th", "11th", "12th", "13th", "14th", "15th", "16th", "17th", "18th", "19th", "20th", "21st", "22nd", "23rd", "24th", "25th", "26th", "27th", "28th", "29th", "30th", "31st" };
    String[] daysArray = new String[]{"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
    int[] doomsdayArray = new int[]{ 3,28,14,4,5,6,7,8,9,10,11,12 };
    int[] doomsdayLYArray = new int[]{ 4,29,14,4,5,6,7,8,9,10,11,12 };
    int[] ddCenturyArray = new int[]{ 3,2,0,5 };
    System.out.println("Day Of The Week Calculator");
    Date currentDate = new Date();
    String fullDateFormatString = "dd/MM/yyyy";
    SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
    SimpleDateFormat dayFormat = new SimpleDateFormat("dd");
    SimpleDateFormat monthFormat = new SimpleDateFormat("MM");
    boolean hasDate = false;
    boolean inFuture = false;
    Date givenDate = new Date();
    while(hasDate == false){
        SimpleDateFormat fullDateFormat = new SimpleDateFormat(fullDateFormatString);
        System.out.println("Please enter the Date in the form dd/MM/yyyy:");
        String givenDateString = keyboard.nextLine();
    try {
        givenDate = fullDateFormat.parse(givenDateString);
        hasDate = true;
        if(givenDate.after(currentDate)){
            //System.out.println("The date is in the future");
            inFuture = true;
        } else {
            //System.out.println("The date is in the past");
        }
      } catch (ParseException e) {
        System.out.println("Sorry, that didnt work, please enter in the correct format");
      }
    }
    int date = Integer.parseInt(dayFormat.format(givenDate));
    int month = Integer.parseInt(monthFormat.format(givenDate));
    int yearInt = Integer.parseInt(yearFormat.format(givenDate));
    double year = (double) yearInt;
    double decYear = Math.floor(year/100);
    double intDdCentury;
    if(decYear == 11.0 || decYear == 15.0 || decYear == 19.0 || decYear == 23.0){
        intDdCentury = 0;
    } else if(decYear == 12.0 || decYear == 16.0 || decYear == 20.0 || decYear == 24.0){
        intDdCentury = 1;
    } else if(decYear == 13.0 || decYear == 17.0 || decYear == 21.0 || decYear == 25.0){
        intDdCentury = 2;
    } else if(decYear == 14.0 || decYear == 18.0 || decYear == 22.0 || decYear == 26.0){
        intDdCentury = 3;
    } else {
        intDdCentury = 9;
    }
    if (intDdCentury == 9){
        System.out.println("Sorry, that year has not been coded for! :(");
    } else {

        int centuryDdIndex = ddCenturyArray[(int) Math.round(intDdCentury)];
        int monthKnownDd;
        boolean isLeapYear;
        isLeapYear = isLeapYear(year);
        if(isLeapYear == true){
            monthKnownDd = doomsdayLYArray[month-1];
        } else {
            monthKnownDd = doomsdayArray[month-1];
        }
        int dateDdDiff = date-monthKnownDd;
        if (dateDdDiff<0) {
            while (!(dateDdDiff>-7)){
                dateDdDiff = dateDdDiff+7;
            }
        } else {
            while (!(dateDdDiff<7)){
                dateDdDiff = dateDdDiff-7;
            }
        }
        System.out.println("Calculating...");
        double a =  centuryDdIndex;
        double yearLastTwoDigits = year - (decYear)*100;
        double yearLastTwoDigitsDivide12 = yearLastTwoDigits / 12;
        double b = Math.floor(yearLastTwoDigitsDivide12);
        double yearLastTwoDigitsDivide12Remainder = (yearLastTwoDigits-12*b);
        double c = Math.floor(yearLastTwoDigitsDivide12Remainder);
        int d = (int) (c/4);
        double e = dateDdDiff + a + b + c + d;
        while (!(e<7)){
            e = e-7;
        }
        String dayOfTheWeek;
        if (e<0) {
            dayOfTheWeek = daysArray[(7+(int) e)];
        } else {
            dayOfTheWeek = daysArray[(int) e];
        }
        if (inFuture == true){
            System.out.println("The " + datesArray[date-1] + " of " + monthsArray[month-1] + " " + yearInt + " will be a " + dayOfTheWeek);
        } else {
            System.out.println("The " + datesArray[date-1] + " of " + monthsArray[month-1] + " " + yearInt + " was a " + dayOfTheWeek);
        }
    } 
    }
}
