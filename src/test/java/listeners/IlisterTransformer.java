package listeners;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.annotations.ITestAnnotation;
import org.testng.internal.annotations.IAnnotationTransformer;

public class IlisterTransformer implements org.testng.IAnnotationTransformer{
	
	 public void transform(
		      ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		   
		 annotation.setRetryAnalyzer(IretryAnalyser.class);
		 
		  }

}
