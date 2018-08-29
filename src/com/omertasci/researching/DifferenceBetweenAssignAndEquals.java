package com.omertasci.researching;

/**
 * 1) == is used to compare primitives and object addresses.
 * 2) equals() is used to compare objects' contents.
 * 3) In case of object and primitive comparison, object will unboxing to primitive type.
 */

public class DifferenceBetweenAssignAndEquals {

	public static void main(String[] args) {

		int a = 3;
		int b = 3;

		System.out.println("Primitive comparision : a == b : " + (a == b) );
				
		/**
		 * Primitives cannot call equals() method.
		 * 
			System.out.println("Primitive comparision : a == b :" + a.equals(b));
		*/
		
		System.out.println("Primitive comparision : 3 == b :" + "3".equals(b));
		
/*-------------------------------------------------------------------*/		
		
		/**
		 * NOT: Primitives cannot be initialized as null. 
		 * So comparision of primitives must be with real values.
		 * 
		int c = null;//Compile error

		System.out.println("Primitive comparision : a == c :" + (a == c));
		
		*/
/*-------------------------------------------------------------------*/		
		Integer objectA = new Integer("3");
		Integer objectB = new Integer("3");
		Integer objectC =null;
		
		System.out.println("Wrapper class comparison: objectA == objectB :" + (objectA == objectB));
		
		System.out.println("Wrapper class comparison: objectA.equals(objectB) :" + (objectA.equals(objectB)));
				
		System.out.println("Wrapper class comparison with null: objectA == objectC :" + (objectA == objectC));
		
		System.out.println("Wrapper class comparison with null: objectC == objectC :" + (objectC == null));
/*-------------------------------------------------------------------*/
		/**
		 *NOT:A wrapper class instance with not-null value and primitives can be compared with ==. 
		 *This is provided with Unboxing.
		 */
		System.out.println("Wrapper class and primitive comparison: objectA == a :" + (objectA == a));
		
/*-------------------------------------------------------------------*/
		/**
		 *NOT:A wrapper class instance with null value and primitives cannot be compared with ==. 
		System.out.println("Wrapper class and primitive comparison: objectC == a : " + objectC == a);		
		*/	
		
/*-------------------------------------------------------------------*/
		/**
		 *NOT:A wrapper class instance with not-null value and primitives can be compared with equals() method. 
		 */	
		System.out.println("Wrapper class and primitive comparison: objectA equals a :" + objectA.equals(a));
		
/*-------------------------------------------------------------------*/
		/**
		 *NOT:A wrapper class instance with null value and primitives cannot be compared with equals() method. 
		 
		 System.out.println("Wrapper class and primitive comparison: objectC equals a :" + objectC.equals(a));
	
		*/	
/*-------------------------------------------------------------------*/
		Person p1 = new Person("Ali");
		Person p2 = new Person("Ali");

		System.out.println("p1 == p2 : " + (p1 == p2) );

		
/*-------------------------------------*/
		
		System.out.println("p1 equals p2 :" + p1.equals(p2));
		
/*-------------------------------------------------------------------*/
		
		Animal a1 = new Animal("Dog");
		Animal a2 = new Animal("Dog");
		
		System.out.println("a1 equals a2 :" + a1.equals(a2));
		
	}
}

class Person {
	String name;

	public Person(String name) {
		this.name = name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}
}
class Animal {
	String name;

	public Animal(String name) {
		this.name = name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}
	
	@Override
	public boolean equals(Object o){
		// If the object is compared with itself then return true  
        if (o == this) {
            return true;
        }
 
        /* Check if o is an instance of Complex or not
          "null instanceof [type]" also returns false */
        if (!(o instanceof Animal)) {
            return false;
        }
         
        // typecast o to Complex so that we can compare data members 
        Animal a = (Animal) o;
         
        // Compare the data members and return accordingly 
        return name.equals( a.name );
		
	}
}
