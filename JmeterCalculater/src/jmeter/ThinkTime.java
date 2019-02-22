package jmeter;

public class ThinkTime {

	public int ThinkTimeCalculater(int intervel) {

		if (intervel >= 500) {
			return 0;
		} else {
			return (500 - intervel);
		}
	}
}
