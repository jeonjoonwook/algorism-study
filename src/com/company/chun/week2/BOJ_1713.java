package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static LinkedList<Student> list = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0 ; i < T ; i++){
            int recommendedStudent = Integer.parseInt(st.nextToken());
            int idx = contains(recommendedStudent);
            if(idx == -1 && list.size() == N){
                list.sort(Comparator.comparingInt(Student::getCnt)
                        .thenComparing(Student::getWhen));
                list.removeFirst();
            }
            if(idx != -1){
                list.get(idx).vote();
            }else {
                list.add(new Student(recommendedStudent, 1, i));
            }
        }
        list.sort(Comparator.comparingInt(Student::getIdx));
        System.out.println(list.toString());
    }

    public static int contains(int idx){
        for(int i = 0 ; i < list.size() ; i++){
            if(list.get(i).idx == idx)
                return i;
        }
        return -1;
    }


    private static class Student {
        int idx, cnt, when;

        public Student(int idx, int cnt, int when) {
            this.idx = idx;
            this.cnt = cnt;
            this.when = when;
        }

        public void vote(){
            this.cnt++;
        }

        public int getIdx() {
            return idx;
        }

        public int getCnt() {
            return cnt;
        }

        public int getWhen() {
            return when;
        }

        @Override
        public String toString() {
            return String.valueOf(idx);
        }
    }
}