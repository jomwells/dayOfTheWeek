# dayOfTheWeek calculator
A simple Java command line application to determine the day of the week for a given date

### Enter a date in the form '*dd/MM/yyyy*' and the day of the week will be calculated
Note - this program is capable of claulcating dates between the years 1100-2699 AD, although extending this range is trivial [lines 61-70]

This program works through the *The Doomsday Method*.
In Summary, applying the Doomsday algorithm involves three steps:
- Determination of the anchor day for the century.
- Calculation of the doomsday for the year from the anchor day.
- Selection of the closest date out of those that always fall on the doomsday, e.g., 4/4 and 6/6, and count of the number of days (modulo 7) between that date and the date in question to arrive at the day of the week.

For more information on how it works, see [wikipedia](https://en.wikipedia.org/wiki/Doomsday_rule)
