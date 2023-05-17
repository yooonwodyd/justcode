

import java.io.*;
import java.util.*;

class Main {

    static class Lecture implements Comparable<Lecture>{
        int st;
        int end;
        public Lecture(int st,int end){
            this.st = st;
            this.end = end;
        }
        @Override
        public int compareTo(Lecture o) {
            return this.st - o.st;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        ArrayList<Lecture> le = new ArrayList<>();


        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            le.add(new Lecture(s,t));
        }
        Collections.sort(le);

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.add(le.get(0).end);
        int count = 1;
        for(int i = 1; i < N; i++){

            if(pq.peek() <= le.get(i).st){
                pq.poll();
                pq.add(le.get(i).end);
                continue;
            }
            pq.add(le.get(i).end);
            count++;

        }
        // 수업 시작 날짜가 빠른 순으로 정렬하자.
        // 수업 시작 날짜가 빠른 순으로 정렬하기
        // 다음 수업 시작 순서가 그전 수업이 끝나는 시간보다 작다면? -> 강의실 +1
        // 크다면? 상관없음
        System.out.println(count);
    }
}
/*
8
1 8
9 16
3 7
8 10
10 14
5 6
6 11
11 12
 */

