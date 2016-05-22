package interviewquestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Meetings {
    private Meeting[] meetings;

    public Meetings(Meeting[] meetings) {
        this.meetings = meetings;
    }

    public static void main(String[] args) {

        Meeting[] times1 = new Meeting[5];
        times1[0] = new Meeting(0, 1);
        times1[3] = new Meeting(3, 5);
        times1[2] = new Meeting(4, 8);
        times1[4] = new Meeting(9, 10);
        times1[1] = new Meeting(10, 12);

        Meetings meetings = new Meetings(times1);

        System.out.println(meetings.condenseMeetingTimes());

        Meeting[] times2 = new Meeting[5];
        times2[0] = new Meeting(0, 13);
        times2[1] = new Meeting(10, 12);
        times2[3] = new Meeting(3, 5);
        times2[2] = new Meeting(4, 8);
        times2[4] = new Meeting(9, 10);

        meetings = new Meetings(times2);

        System.out.println(meetings.condenseMeetingTimes());

    }

    public Meetings condenseMeetingTimes() {
        if (meetings.length == 0) {
            return new Meetings(meetings);
        }

        Arrays.sort(meetings);

        List<Meeting> condensedList = new ArrayList<>();
        int condensedStart = meetings[0].startTime;
        int condensedEnd = meetings[0].endTime;

        for (int i = 1; i < meetings.length; i++) {
            int start = meetings[i].startTime;
            int end = meetings[i].endTime;

            if (start > condensedEnd) {
                condensedList.add(new Meeting(condensedStart, condensedEnd));
                condensedStart = start;
                condensedEnd = end;
            } else if (start <= condensedEnd && end > condensedEnd) {
                condensedEnd = end;
            }

            if ((i + 1) == meetings.length) {
                if (end > condensedEnd) {
                    condensedList.add(new Meeting(condensedStart, end));
                } else {
                    condensedList.add(new Meeting(condensedStart, condensedEnd));
                }
            }

        }

        Meeting[] condensedMeetings = new Meeting[condensedList.size()];
        condensedMeetings = condensedList.toArray(condensedMeetings);

        return new Meetings(condensedMeetings);
    }

    @Override
    public String toString() {
        return "Meetings{" +
                "meetings=" + Arrays.toString(meetings) +
                '}';
    }

    public static class Meeting implements Comparable<Meeting> {
        int startTime;
        int endTime;

        public Meeting(int startTime, int endTime) {
            // number of 30 min blocks past 9:00 am
            this.startTime = startTime;
            this.endTime   = endTime;
        }

        public String toString() {
            return String.format("(%d, %d)", startTime, endTime);
        }

        @Override
        public int compareTo(Meeting o) {
            if (this.equals(o)) {
                return 0;
            } else if (startTime > o.startTime) {
                return 1;
            } else {
                return -1;
            }
        }
    }
}
