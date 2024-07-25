
/*
Physics, Chemistry, Biology, and Math are the four primary topics taught in schools. The 
results were reviewed by the faculty and kept in two text files: "PCM.txt" with the student's
information (Name, Register number) and aggregate marks for Physics, Chemistry, and 
Mathematics, and "PCB.txt" with the student's information and aggregate marks for 
Physics, Chemistry and Biology. The results are saved in another text file called 
"Results.txt," which contains the students' information, average marks in five subjects 
(Physics, Chemistry, Mathematics, Biology, and English) as well as their eligibility status. 
The student will be eligible if (s)he gets >= 50% in all four subjects. Write a Java program 
to implement the above.

*/
import java.io.*;
import java.util.*;

public class PAT {
    public static void main(String[] args) {
        int Phy, Chem, Math, Bio, Eng;
        String Name, Reg_no;
        Scanner sc = new Scanner(System.in);
        char st = 'N';
        String eligibility_status;
        try {
            FileWriter pcm = new FileWriter("PCM.txt");
            FileWriter pcb = new FileWriter("PCB.txt");
            FileWriter res = new FileWriter("Results.txt");
            do {
                System.out.println("Enter the name, register no., marks scored(out of 100) by student in Physics, Chemistry, Maths, Biology and English");
                Name = sc.next();
                Reg_no = sc.next();
                Phy = sc.nextInt();
                Chem = sc.nextInt();
                Math = sc.nextInt();
                Bio = sc.nextInt();
                Eng = sc.nextInt();
                
                int pcm_aggregate = Phy + Chem + Math;
                pcm.write(Name + " " + Reg_no + " " + pcm_aggregate + "\n");

                int pcb_aggregate = Phy + Chem + Bio;
                pcb.write(Name + " " + Reg_no + " " + pcb_aggregate + "\n");

                double avg = (Phy + Chem + Math + Bio + Eng) / 5;
                if (Phy >= 50 && Chem >= 50 && Math >= 50 && Bio >= 50 && Eng >= 50){ 
                    eligibility_status = "Eligible";
                } else {
                    eligibility_status = "Not Eligible";
                }
                res.write(Name + " " + Reg_no + " " + avg + " " + eligibility_status + "\n");

                System.out.println("Do you want to Enter marks of another student? (Y / N)");
                st = sc.next().charAt(0);
            } while (st == 'Y');
            pcm.close();
            pcb.close();
            res.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
