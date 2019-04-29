package com.vz.intrada.charge.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


public  class MapperBase {
	
	

	protected String getNextSequenceNumber(DataSource ds,String SEQUENCE_NAME, boolean IS_SEQUENCE_PADDED, int SEQUENCE_LENGTH)
			throws Exception {
		final String METHOD_NAME = "getNextSequenceNumber()";

		String newSequence = null;
		ResultSet theResult = null;
		String theSQL = "Select " + SEQUENCE_NAME + ".nextval from dual";
		PreparedStatement thePreparedStatement = getPreparedStatement(ds,theSQL);

		try {

			theResult = thePreparedStatement.executeQuery();

			// Get sequence value from the ResultSet
			if (theResult.next()) {
				newSequence = theResult.getString(1);
			}

			// If the sequence is a CHAR field, left pad with zeroes.
			if ((newSequence != null) && (IS_SEQUENCE_PADDED)) {
				newSequence = padLeft(newSequence, SEQUENCE_LENGTH, '0');
			}
		} catch (SQLException sqle) {
			throw sqle;
		} finally {
			closeDatabaseResources(theResult);
		}

		return newSequence;
	}

	protected String padLeft(String val, int fieldLength, char padChar) {
		return (padStringLeft(val, fieldLength, padChar));
	}

	protected String padStringLeft(String inString, int fieldLength, char padChar) {
		if (inString == null) {
			inString = "";
		}

		int lengthToPad = fieldLength - inString.length();

		// If there is room to pad (also ensures that if the string passed in
		// is longer than the desired length that this doesn't make garbage out of it.
		if (lengthToPad > 0) {
			StringBuffer buffer = new StringBuffer(fieldLength);

			for (int i = 0; i < lengthToPad; i++) {
				buffer.append(padChar);
			}

			buffer.append(inString);

			inString = buffer.toString();
		}

		return inString;
	}

	protected void closeDatabaseResources(ResultSet theResultSet) {
		try {
			if (theResultSet != null) {

				theResultSet.close();
			}
		} catch (Exception e) {

		}

		return;
	}
	
	public static PreparedStatement getPreparedStatement(DataSource ds,String theSQL) throws Exception {

		try {
			System.out.println("ds============"+ds);
			return (ds.getConnection().prepareStatement(theSQL));
		} catch (SQLException e) {
			throw e;
		}

	}

}
