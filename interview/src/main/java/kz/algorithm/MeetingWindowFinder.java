package kz.algorithm;

import java.util.List;

public class MeetingWindowFinder {
  public static TimeWindow findMeetingWindow(List<TimeWindow> scheduleA, List<TimeWindow> scheduleB) {
    int pointerA = 0;
    int pointerB = 0;
    TimeWindow closestWindow = null;

    while (pointerA < scheduleA.size() && pointerB < scheduleB.size()) {
      TimeWindow windowA = scheduleA.get(pointerA);
      TimeWindow windowB = scheduleB.get(pointerB);

      if (windowA.getEnd() > windowB.getStart() && windowB.getEnd() > windowA.getStart()) {
        if (closestWindow == null || windowA.getStart() < closestWindow.getStart()) {
          int start = Math.max(windowA.getStart(), windowB.getStart());
          int end = Math.min(windowA.getEnd(), windowB.getEnd());
          closestWindow = new TimeWindow(start, end);
        }

        if (windowA.getEnd() < windowB.getEnd()) {
          pointerA++;
        } else {
          pointerB++;
        }
      } else if (windowA.getStart() > windowB.getStart()) {
        pointerB++;
      } else {
        pointerA++;
      }
    }

    return closestWindow;
  }

  public static void main(String[] args) {

    // Пример использования
    List<TimeWindow> scheduleA = List.of(new TimeWindow(1, 4));
    List<TimeWindow> scheduleB = List.of(new TimeWindow(2, 3));

    TimeWindow closestWindow = findMeetingWindow(scheduleA, scheduleB);

    if (closestWindow != null) {
      System.out.println("Ближайшее время для встречи: " + closestWindow.getStart() + " - " + closestWindow.getEnd());
    } else {
      System.out.println("Нет общего свободного времени для встречи.");
    }
  }
}
