package com.gradingStudent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
 HackerLand University has the following grading policy:

Every student receives a  in the inclusive range from  to .
Any  less than  is a failing grade.
Sam is a professor at the university and likes to round each student's  according to these rules:

If the difference between the  and the next multiple of  is less than , round  up to the next multiple of .
If the value of  is less than , no rounding occurs as the result will still be a failing grade.
For example,  will be rounded to  but  will not be rounded because the rounding would result in a number that is less than .

Given the initial value of  for each of Sam's  students, write code to automate the rounding process.

Function Description

Complete the function gradingStudents in the editor below. It should return an integer array consisting of rounded grades.

gradingStudents has the following parameter(s):

grades: an array of integers representing grades before rounding
Input Format

The first line contains a single integer, , the number of students.
Each line  of the  subsequent lines contains a single integer, , denoting student 's grade.

Constraints

Output Format

For each , print the rounded grade on a new line.

Sample Input 0

4
73
67
38
33
Sample Output 0

75
67
40
33
Explanation 0

image

Student  received a , and the next multiple of  from  is . Since , the student's grade is rounded to .
Student  received a , and the next multiple of  from  is . Since , the grade will not be modified and the student's final grade is .
Student  received a , and the next multiple of  from  is . Since , the student's grade will be rounded to .
Student  received a grade below , so the grade will not be modified and the student's final grade is .
 */

public class gradingStudent {

	public static void main(String[] args) {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int gradesCount;
		try {
			gradesCount = Integer.parseInt(bufferedReader.readLine().trim());
		

        List<Integer> grades = IntStream.range(0, gradesCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }).map(String::trim)
          .map(Integer::parseInt)
          .collect(Collectors.toList());

        List<Integer> result = gradingStudents(grades);
        System.out.println(result);
        bufferedReader.close();
        } catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}

       
	}

	 public static List<Integer> gradingStudents(List<Integer> grades) {
		
		List<Integer> op = new ArrayList<Integer>();
		for(int i=0;i<grades.size();i++) {
			if((grades.get(i)%5) == 0) {
				op.add(grades.get(i));
				continue;
			}
			int val = Math.floorDiv(Math.abs(grades.get(i)),5);
			int val1 = (val+1) * 5;
			if(((grades.get(i)) < 38) || ((val1 - grades.get(i)) == 3) || ((val1 - grades.get(i)) > 3)) {
				op.add(grades.get(i));
			} else if((val1 - grades.get(i)) < 3) {
				op.add(val1);
			}
		}
		 
		return op;
    }

}
