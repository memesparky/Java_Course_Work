// Fig. 8.5: Time2.java
// Time2 class declaration with overloaded constructors.

public class Time2 {
  private int secondsSinceMidnight;

   // Time2 no-argument constructor:
   // initializes each instance variable to zero
   public Time2() {
      this(0, 0, 0); // invoke constructor with three arguments
   }

   // Time2 constructor: hour supplied, minute and second defaulted to 0
   public Time2(int hour) {
      this(hour, 0, 0); // invoke constructor with three arguments
   }

   // Time2 constructor: hour and minute supplied, second defaulted to 0
   public Time2(int hour, int minute) {
      this(hour, minute, 0); // invoke constructor with three arguments
   }

   // Time2 constructor: hour, minute and second supplied
   public Time2(int hour, int minute, int second) {
      if (hour < 0 || hour >= 24) {
         throw new IllegalArgumentException("hour must be 0-23");
      }

      if (minute < 0 || minute >= 60) {
         throw new IllegalArgumentException("minute must be 0-59");
      }

      if (second < 0 || second >= 60) {
         throw new IllegalArgumentException("second must be 0-59");
      }
      this.secondsSinceMidnight = secondMemory(hour,minute,second);
   }
  public int secondMemory(int hour, int min, int sec)
  {
    return (hour * 3600) + (min * 60) + sec;
  }

   // Time2 constructor: another Time2 object supplied
   public Time2(Time2 time) {
      // invoke constructor with three arguments
      this(time.getHour(),time.getMinute(),time.getSecond());
   }

   // Set Methods
   // set a new time value using universal time;
   // validate the data
   public void setTime(int hour, int minute, int second) {
      if (hour < 0 || hour >= 24) {
         throw new IllegalArgumentException("hour must be 0-23");
      }

      if (minute < 0 || minute >= 60) {
         throw new IllegalArgumentException("minute must be 0-59");
      }

      if (second < 0 || second >= 60) {
         throw new IllegalArgumentException("second must be 0-59");
      }
      this.secondsSinceMidnight = secondMemory(hour,minute,second);
   }

   // validate and set hour
   public void setHour(int hour) {
      if (hour < 0 || hour >= 24) {
         throw new IllegalArgumentException("hour must be 0-23");
      }
      this.secondsSinceMidnight = (this.secondsSinceMidnight - (this.secondsSinceMidnight / 3600)) + (hour * 3600);
   }

   // validate and set minute
   public void setMinute(int minute) {
      if (minute < 0 || minute >= 60) {
         throw new IllegalArgumentException("minute must be 0-59");
      }

      this.secondsSinceMidnight = (this.secondsSinceMidnight - (this.secondsSinceMidnight / 60)) + (minute * 60);
   }

   // validate and set second
   public void setSecond(int second) {
      int h, m;
      if (second < 0 || second >= 60) {
         throw new IllegalArgumentException("second must be 0-59");
      }
      h = this.secondsSinceMidnight/3600;
      m = this.secondsSinceMidnight/60;
      this.secondsSinceMidnight = 0;
      this.secondsSinceMidnight = second + h+ m;
   }

   // Get Methods
   // get hour value
   public int getHour() {return this.secondsSinceMidnight/3600;}

   // get minute value
   public int getMinute() {
     int h = this.secondsSinceMidnight/3600;

     return ((this.secondsSinceMidnight - (h*3600))/60);}

   // get second value
   public int getSecond() {
     int h = this.secondsSinceMidnight/3600;
     return (this.secondsSinceMidnight - (h*3600))%60;}

   // convert to String in universal-time format (HH:MM:SS)
   public String toUniversalString() {
      return String.format(
         "%02d:%02d:%02d", getHour(), getMinute(), getSecond());
   }

   // convert to String in standard-time format (H:MM:SS AM or PM)
   public String toString() {
      return String.format("%d:%02d:%02d %s",
         ((getHour() == 0 || getHour() == 12) ? 12 : getHour() % 12),
         getMinute(), getSecond(), (getHour() < 12 ? "AM" : "PM"));
   }

   public void tick(){
     if(this.secondsSinceMidnight == 86399)
      this.secondsSinceMidnight = 0;
     else
      this.secondsSinceMidnight+=1;
   }

   public void incrementMinute(){
     if(this.secondsSinceMidnight >= 86340)
      this.secondsSinceMidnight = this.getSecond();
     else
      this.secondsSinceMidnight+=60;
   }

   public void incrementHour(){
     if(this.secondsSinceMidnight >= 82800)
      this.secondsSinceMidnight = (this.getMinute() * 60) + this.getSecond();
     else
      this.secondsSinceMidnight+=3600;
   }
}


/**************************************************************************
 * (C) Copyright 1992-2018 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/
