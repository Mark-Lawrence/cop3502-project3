//Michael Arboleda

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LucyTattooParlorTest {

	TattooCustomer[][] testC = new TattooCustomer[3][4];
	TattooCustomer[][] tC = new TattooCustomer[3][4];
	
	TattooCustomer jim = new TattooCustomer("Jim", "A", 60);
	TattooCustomer oscar = new TattooCustomer("Ocsar", "D", 15);
	TattooCustomer angela = new TattooCustomer("Angela", "F", 5);
	//2nd row
	TattooCustomer pam = new TattooCustomer("Pam", "B", 40);
	TattooCustomer kevin = new TattooCustomer("Kevin", "E", 10);
	//3rd row
	TattooCustomer creed = new TattooCustomer("Creed", "C", 20);
	
	
	
	@Before
	public void initialize(){
		//sets all to null (after each run to clear any mistakes)
		for(int i = 0; i < tC.length; i++){
			for(int j = 0; j < tC[i].length; j++){
				tC[i][j] = null;
			}
		}
		
		//1st row
		tC[0][0] = jim;
		tC[0][1] = oscar;
		tC[0][2] = angela;
		testC[0][0] = jim;
		testC[0][1] = oscar;
		testC[0][2] = angela;
		
		//2nd row
		tC[1][0] = pam;
		tC[1][1] = kevin;
		testC[1][0] = pam;
		testC[1][1] = kevin;
		
		//3rd row
		tC[2][0] = creed;
		testC[2][0] = creed;
	}
	
	//Tests the return for ComputeMinutesOfWork
	@Test
	public void testComputeMinutesOfWork() {
		TattooCustomer[] x = new TattooCustomer[5];
		int ans = 78;
		
		String[] a = {"Tom", "Mary", "Jones"};
		String[] b = {"Charmander", "Bulbasaur", "Squirtle"};
		int[] c = {21, 47, 10};
		for(int i = 0; i < 3 ;i++ ){
			x[i] = new TattooCustomer(a[i], b[i], c[i]);
		}
		int students = LucyTattooParlor.computeMinutesOfWork(x);
		assertTrue(("Expected: " + ans + "Recived from student: " + students), ans == students);
		
	}
	
	
	//This ONLY checks the return type for addCustomer()
	@Test
	public void testAddCustomerInt() {
		boolean student;
		String error = "Returned false, should have been true";
		
		TattooCustomer andy = new TattooCustomer("Andy", "G", 20);
		testC[0][3] = andy;
		
		student = LucyTattooParlor.addCustomer(tC, andy, 0);
		assertTrue(error, student);
	}

	//This checks both the return, AND makes sure all the elements in the 2D array are the same
	@Test
	public void testAddCustomerIntFull() {
		boolean student;
		String error = "\n";
		
		TattooCustomer andy = new TattooCustomer("Andy", "G", 20);
		testC[0][3] = andy;
		
		student = LucyTattooParlor.addCustomer(tC, andy, 0);
		
		for(int i = 0; i < testC.length; i++){
			for(int j = 0; j < testC[i].length; j++){
				student = (student && (testC[i][j] == tC[i][j]));
				if(testC[i][j] != tC[i][j]){
					error += ("Not same element at [" + i + "][" + j + "]\n");
				}
			}
		}
		
		//for reusable testing purposes
		testC[0][3] = null;
		tC[0][3] = null;
		
		//returns if all reference are same
		assertTrue(error, student);
	}
	
	//This checks both the return, AND makes sure all the elements in the 2D array are the same
	@Test
	public void testAddCustomerIntFullFails() {
		boolean student;
		String error = "\n";
		
		TattooCustomer andy = new TattooCustomer("Andy", "G", 460);
		testC[2][1] = andy;
		tC[2][1] = andy;
		
		TattooCustomer michael = new TattooCustomer("Michael Scott", "H", 1);
		student = LucyTattooParlor.addCustomer(tC, michael, 2);
		
		for(int i = 0; i < testC.length; i++){
			for(int j = 0; j < testC[i].length; j++){
				student = (student && (testC[i][j] == tC[i][j]));
				if(testC[i][j] != tC[i][j]){
					error += ("Not same element at [" + i + "][" + j + "]\n");
				}
			}
		}
		
		//for reusable testing purposes
		testC[2][1] = null;
		tC[2][1] = null;
		
		//returns if all reference are true
		assertFalse(error, student);
	}
	
	//This checks both the return, AND makes sure all the elements in the 2D array are the same
	@Test
	public void testAddCustomerFull() {
		boolean student;
		String error = "";
		
		TattooCustomer andy = new TattooCustomer("Andy", "G", 20);
		testC[2][1] = andy;
		
		student = LucyTattooParlor.addCustomer(tC, andy);
		
		for(int i = 0; i < testC.length; i++){
			for(int j = 0; j < testC[i].length; j++){
				student = (student && (testC[i][j] == tC[i][j]));
				if(testC[i][j] != tC[i][j]){
					error += ("Not same element at [" + i + "][" + j + "]\n");
				}
			}	
		}
		
		//for reusable testing purposes
		testC[2][1] = null;
		tC[2][1] = null;
		
		//returns if all reference are true
		assertTrue(error, student);
	}

}
