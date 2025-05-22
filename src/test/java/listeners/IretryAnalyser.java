package listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class IretryAnalyser implements IRetryAnalyzer{
	
	int min = 1;
    int max=2;

	@Override
	public boolean retry(ITestResult result) {
		
		while (min<=max) {
			min++;
			return true;
			
		}


		return false;
	}

}
