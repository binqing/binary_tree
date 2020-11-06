/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package trees;

/**
 * @author Binqing Zheng
 * CIS 3130 Fall 2019
 * Assignment 4 
 * Brooklyn College
 * 
 */
import java.util.Scanner;
import java.io.*;

public class IntegerTreeNode {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)throws IOException {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter file name: (InputFile.txt)");
        String f = sc.next();
        readData(f);
	}        
    
    public static void readData(String f) throws IOException {
  		Scanner sc;
  		String s;
  		int count = 0;
  		try {
  			 sc=new Scanner (new File(f));
             while (sc.hasNextLine()) {
  				s = sc.nextLine();
  				count++;
  				createTree(s, count);
  			 } 
  		 }
  		 catch(FileNotFoundException e){
             System.out.println("File does not exit please, enter the file name again");    
         }	
  	}
  	
  	public static void createTree(String s, int count) {
  		
        Scanner sc=new Scanner(s);
        IntegerBinaryTree t= new IntegerBinaryTree();
        int n;
         
       	while (sc.hasNext()) {
            n = Integer.parseInt(sc.next());
            if (n==-999) 
            	break;
            t.insert(n);               
        }
        
        printTree(t);
        updateTree(t,count);
        printTree(t);
        t.freeTree();
		   t = null;           
        sc.close();
    }
   
   public static void printTree(IntegerBinaryTree t) {
   		
   		System.out.println("Tree in inorder:"); 
    	t.inOrder(); 
      System.out.println();
    	System.out.println("Tree in preorder:");
    	t.preOrder();
      System.out.println();
    	System.out.println("Tree in postorder: ");
   		t.postOrder();
         System.out.println();
   		
   		int count = t.count();
   		System.out.println("Total number of nodes in the tree: " + count);
   		
         count = t.children()-1;
   		System.out.println("Number of children node in the tree has: " + count);
   		           
    }
    
	public static void updateTree(IntegerBinaryTree t, int routine) {
		
		if (routine == 1) {
			t.insert(21);
			t.delete(1);
			t.insert(0);
			t.delete(10);
			t.delete(11);
			t.delete(5);
			t.delete(2);
			t.insert(10);
		}
		
		if (routine == 2) {
			t.delete(3);
			t.delete(1);
		}
		
		if (routine == 3) {
			t.delete(15);
			t.insert(30);
			t.insert(5);
			t.insert(10);
			t.insert(20);
			t.delete(20);
			t.delete(10);
			t.delete(5);
			t.delete(15);
			t.delete(30);
		}
		
		if (routine == 4) {
			t.delete(2);
		}
		
		if (routine == 5) {
			t.delete(37);
			t.delete(15);
			t.insert(40);
			t.insert(99);
		}
	
	}
	
    
}
