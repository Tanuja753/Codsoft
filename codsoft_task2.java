import java.util.*;
class studentGradeCalculator{
    public static void main(String []args){
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter how many subjects do you have?");
        int noOfSubjects = sc.nextInt();
        int arr[]=new int[noOfSubjects];
        for(int i=0; i < noOfSubjects; i++){
            System.out.println("enter marks out of 100 for subject"+ (i+1));
            arr[i]=sc.nextInt();
        }
        int sum=0;
        for(int j=0; j<arr.length;j++){
            sum=sum+arr[j];
        }
        float avg;
        avg = (float)sum/noOfSubjects;
        char grade;
        if(avg <=100 && avg>=90){
            grade = 'A';
        }else if(avg <90 && avg>=80){
            grade = 'B';
        }else if(avg <80 && avg>=70){
            grade = 'C';
        }else if(avg <70 && avg>=60){
            grade = 'D';
        }else if(avg >=30){
            grade = 'E';
        }else{
            grade = 'F';
        }
        System.out.println("Total Marks Obtained : "+sum);
        System.out.println("percentage Obtained : "+avg);
        System.out.println("Grade Obtained : "+grade);
        sc.close();
    }
}