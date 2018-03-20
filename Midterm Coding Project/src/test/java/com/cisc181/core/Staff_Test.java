package com.cisc181.core;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cisc181.eNums.eTitle;

public class Staff_Test {
	
	private static Date Date(int year, int month, int day) {
		Calendar date = Calendar.getInstance();
		date.set(year, month - 1, day);
		return date.getTime();
	}
	private static ArrayList<Staff> staff = new ArrayList<Staff>();
	
	@BeforeClass
	public static void setup() throws PersonException 
	{	
		staff.add(new Staff("Marry","K","Allen",Date(1981,1,1),"Chicago","302-111-1111","Marry@yahoo.com","8-1",1,20000,Date(2010,1,1),eTitle.MRS));
		staff.add(new Staff("Kim","Den","Kay",Date(1982,1,1),"New York","302-111-1112","Kim@yahoo.com","12-4",2,18000,Date(2011,1,1),eTitle.MS));
		staff.add(new Staff("Boo","E","Bee",Date(1983,1,1),"Atlanta","302-111-1113","Boo@yahoo.com","11-12",3,17000,Date(2012,1,1),eTitle.MR));
		staff.add(new Staff("Hi","H","Bye",Date(1984,1,1),"San Diego","302-111-1114","Hi@yahoo.com.com","1-4",4,15000,Date(2013,1,1),eTitle.MR));
		staff.add(new Staff("Zin","Kim","Nel",Date(1985,1,1),"San Francisco","302-111-1115","Zin@yahoo.com","9-3",5,13000,Date(2014,1,1),eTitle.MS));
	}	
	@Test
	public void testAverageSalary(){
		int s = 0; 
		for(Staff Staff: staff)
		{
			s += Staff.getSalary();
		}
		int SalaryAverage =  (s / staff.size());
		int Actual = 16600;
		assertEquals(Actual,SalaryAverage);
	}	
	
	@Test
	public void testDOBException() throws PersonException{
		boolean Exception = true;
		boolean thrown= false;
		try{
			staff.get(1).setDOB(Date(1800,1,1));
		} catch(PersonException e){
			thrown = true;
		}
		assertEquals(Exception, thrown);
	}
	
	@Test
	public void testPhoneException() throws PersonException{
		boolean Exception = true;
		boolean thrown= false;
		try
		{
			staff.get(2).setPhone("1000000000000");
		} catch(PersonException e){
			thrown = true;
		}
		assertEquals(Exception, thrown);
	}
}