package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import main.java.Dom;
import main.java.Element;
import main.java.Root;
import main.java.elements.AtomicElement;
import main.java.elements.CompositeElement;
import main.java.elements.atomic.*;
import main.java.elements.composite.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class TestDom {
	
	/* Creating instance of all the classes */
	private static Dom dom;
	private static CompositeElement root;
	private static CompositeElement div1;
	private static CompositeElement div2;
	private static CompositeElement div3;
	private static AtomicElement a;
	private static AtomicElement img3;
	private static AtomicElement img1;
	private static AtomicElement img2;
	
	/**
	 *  Operations to be performed before the class execution 
	 */
	@BeforeClass
	 public static void doBefore() {
		root = new Root("0","root");
		dom = new Dom(root);						//Creating a new DOM
		div1 = new Div ("1", "abc");				//Creating new Div with certain Attributes
		div2 = new Div ("0", "abc");				//Creating new Div with certain Attributes
		a = new A ("9", "ab", "asa");			//Creating new Anchor with certain Attributes
		div3 = new Div ("4", "abcd");			//Creating new Div with certain Attributes
		img3 = new Img ("6", "ab", "abcd");		//Creating new Img with certain Attributes
		img1 = new Img ("3", "ab", "abc"); 		//Creating new Img with certain Attributes
		img2 = new Img ("8", "ab", "abcd"); 		//Creating new Img with certain Attributes
		root.add(div1);							//Adding Div1 to Dom
		div1.add(div2);							//Adding Div2 under Div1
		div2.add(a);							//Adding anchor under Div2
		div2.add(div3);							//Adding Div3 under Div2
		div3.add(img3);							//Adding Img3 under Div3
		root.add(img1);							//Adding Img1 in Dom
		div1.add(img2);							//Adding Img2 under Div1
	}
	
	/**
	 * This test case tests if all the elements with the given class name is returned.
	 */
	@Test
	public void test1() {
		
		List<Element> actual2 = dom.findElementsByClass("abcd");
		List<String> result = new ArrayList<String>();
		
		for ( Element listElement : actual2) {
 			result.add ( listElement.getClass().getSimpleName() );
 		}
		List<String> expected = new ArrayList<String>();
		expected.addAll ( Arrays.asList("Div","Img","Img") );
		assertEquals(expected,result);
	}
	
	/**
	 * This test case test if the type of the element searched for using 
	 * it's id is correct.
	 */
	@Test
	public void test2() {
		String actual = dom.findElementByID("3").getClass().getSimpleName();
		String expected = "Img" ;
		assertEquals(expected,actual);
	}
	
	/**
	 * This test checks the Dom hierarchy
	 */
	@Test
	public void test3() {
		
		List<String> expected= new ArrayList<String>();
		expected.addAll(Arrays.asList("<Div id='1'>",
									  "    <Div id='0'>",
									  "        <A id='9'>",
									  "        <Div id='4'>",
									  "            <Img id='6'>",
									  "        </Div>",
									  "    </Div>",
									  "    <Img id='8'>",
									  "</Div>",
									  "<Img id='3'>" ));
		List<String> actual = dom.displayDOM();
		assertEquals(expected,actual);
	}

}
