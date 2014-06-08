package heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by chace on 6/8/14.
 */
public class MeetingRoomArrangement {

    public static int numberOrMeetingRoom(Meeting[] meetings) {
        if (meetings == null) {
            throw new NullPointerException();
        }
        int num = 0;
        Arrays.sort(meetings);
        PriorityQueue<Meeting> queue = new PriorityQueue<Meeting>(1000, new MeetingComparator());
        for (int i = 0; i < meetings.length; i++) {
            if (queue.isEmpty() || meetings[i].start < queue.peek().end) {
                num++;
                queue.add(meetings[i]);
            } else if (meetings[i].start > queue.peek().end) {
                queue.poll();
                queue.add(meetings[i]);
            }
        }
        return num;
    }

    public static void main(String[] args) {
        Meeting[] meetings = new Meeting[6];
        for (int i = 0; i < meetings.length; i++) {
            Meeting m = new Meeting(i, i+2);
            meetings[i] = m;
            m.print();
        }
        System.out.println(numberOrMeetingRoom(meetings));
    }
}

class Meeting implements Comparable<Meeting> {
    double start;
    double end;

    public Meeting(double s, double e) {
        this.start = s;
        this.end = e;
    }

    public void print() {
        System.out.println("[" + start + ", " + end + "]");
    }

    @Override
    public int compareTo(Meeting meeting) {
        return (int)(this.start - meeting.start);
    }
}



class MeetingComparator implements Comparator<Meeting> {
    @Override
    public int compare(Meeting meeting1, Meeting meeting2) {
        return (int)(meeting1.end = meeting2.end);
    }
}
