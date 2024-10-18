package Recursion;

import java.util.Scanner;

public class TowerOfHanoi {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the Number Of Disc : ");

         int n = input.nextInt();
        callMove(n,'A','B','C');

    }
    public static void callMove(int n,char sourceTower,char destinationTower,char usingTower){
        if(n ==1){
            System.out.println("Move Disc "+ n+ " from  '"+sourceTower +"' to '"+ destinationTower+"' .");
        }
        else {
            callMove(n-1,sourceTower,usingTower,destinationTower);
            System.out.println("Move Disc "+ n+ " from  '"+sourceTower +"' to '"+ destinationTower+"' .");
            callMove(n-1,usingTower,destinationTower,sourceTower);
        }
    }
}
