package Ch6_Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q35AssignMeetingRoom {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        PriorityQueue<Meeting> q = new PriorityQueue<>((o1, o2) ->
        {
            if (o1.end > o2.end) {
                return 1;
            } else if (o1.end == o2.end) {
                return o1.start - o2.start; // end가 같을 때 start 가 작은 것이 먼저 queue에 입력 , 오름차순
            } else {
                return -1;
            }
        });

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            Meeting meeting = new Meeting(s, e);
            q.offer(meeting);

        }


        int cnt = 1;
        Meeting d = q.remove();
        int start = d.start;
        int end = d.end;

        while (!q.isEmpty()) {
            Meeting data = q.poll();
            int nextStart = data.start;
            int nextEnd = data.end;

            if (nextStart >= end) {
                cnt++;
                start = nextStart;
                end = nextEnd;
            }
        }

        System.out.println(cnt);
    }

    private static class Meeting {
        int start;
        int end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }

    }
}
