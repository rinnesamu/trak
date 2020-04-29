package usingjcapi;

import java.util.Comparator;

public class BalanceComparator implements Comparator<Object> {

	@Override
	public int compare(Object o1, Object o2) {
		TrafficCard card1 = (TrafficCard)o1;
		TrafficCard card2 = (TrafficCard)o2;
		return (int)(card1.mBalance-card2.mBalance);
	}

}
