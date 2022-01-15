package com.web.mockito.spy;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ListTest {
	
	@Spy
	List<String> myList=new ArrayList<String>();
	

	@Test
	void test() {
		myList.add("A");
		myList.add("B");
		
		Mockito.doReturn(3).when(myList).size();
		Assertions.assertSame(3, myList.size());
	}

}
