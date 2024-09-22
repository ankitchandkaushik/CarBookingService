package model;

public class Slot {
  int startDate;
  int endDate;

  public Slot(int start, int end) {
    this.startDate = start;
    this.endDate = end;
  }

  public int getStartDate() {
    return startDate;
  }

  public int getEndDate() {
    return endDate;
  }

  //  public boolean equals(Object o) {
//    if(o)
//  }
}
