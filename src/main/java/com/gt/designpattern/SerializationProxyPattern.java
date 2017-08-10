package com.gt.designpattern;

import java.io.InvalidObjectException;
import java.io.Serializable;

public class SerializationProxyPattern {

	// Serialization Proxy pattern is a way to achieve greater security with
	// Serialization. In this pattern, an inner private static class is used as
	// a proxy class for serialization purpose. This class is designed in the
	// way to maintain the state of the main class. This pattern is implemented
	// by properly implementing readResolve()and writeReplace() methods.
	private static class DataProxy implements Serializable {
		DataProxy(SerializationProxyPattern d) {

		}

		private static final long serialVersionUID = 8333905273185436744L;
		private String dataProxy;
		private static final String PREFIX = "ABC";
		private static final String SUFFIX = "DEFG";

		public DataProxy(Data d) {
			// obscuring data for security
			this.dataProxy = PREFIX + d.data + SUFFIX;
		}

		private Object readResolve() throws InvalidObjectException {
			if (dataProxy.startsWith(PREFIX) && dataProxy.endsWith(SUFFIX)) {
				return new Data(dataProxy.substring(3, dataProxy.length() - 4));
			} else
				throw new InvalidObjectException("data corrupted");
		}
	}

	// replacing serialized object to DataProxy object
	private Object writeReplace() {
		return new DataProxy(this);
	}
}

class Data {
	Data(String data) {
		this.data = data;
	}

	String data;

}