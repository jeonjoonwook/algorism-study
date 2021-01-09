package com.company.hongyeongjune.secondweek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    public static LinkedList<Student> students = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int recommend = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<recommend; i++) {
            int student = Integer.parseInt(st.nextToken());
            int index = contains(student);

            if(index == -1 && students.size() == N) {
                students.sort(Comparator
                        .comparing(Student::getRecommend)
                        .thenComparing(Student::getTime)
                );
                students.removeFirst();
            }

            if(index != -1) students.get(index).recommend += 1;
            else students.add(new Student(student, 1, i));
        }

        students.sort(Comparator.comparingInt(Student::getStudent));

        for(int i=0; i<students.size(); i++) {
            System.out.print(students.get(i).student + " ");
        }

    }

    public static int contains(int student) {
        for(int i=0; i<students.size(); i++) {
            if(students.get(i).student == student)
                return i;
        }

        return -1;
    }


    public static class Student {
        int student;
        int recommend;
        int time;

        public int getStudent() {
            return student;
        }

        public int getRecommend() {
            return recommend;
        }

        public int getTime() {
            return time;
        }

        public Student(int student, int recommend, int time) {
            this.student = student;
            this.recommend = recommend;
            this.time = time;
        }
    }
}
