package com.nandulabs.springmvc.configuration;

import java.io.PrintWriter;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nandulabs.springmvc.model.User;
import com.opencsv.CSVWriter;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvException;

public class WriteCsvToResponse {

	private static final Logger LOGGER = LoggerFactory.getLogger(WriteCsvToResponse.class);

	public static void writeUsers(PrintWriter writer, List<User> users) {

		try {

			ColumnPositionMappingStrategy mapStrategy = new ColumnPositionMappingStrategy();

			mapStrategy.setType(User.class);
			mapStrategy.generateHeader();

			String[] columns = new String[] { "id", "name", "age", "salary" };
			mapStrategy.setColumnMapping(columns);

			StatefulBeanToCsv btcsv = new StatefulBeanToCsvBuilder(writer).withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
					.withMappingStrategy(mapStrategy).withSeparator(',').build();

			btcsv.write(users);

		} catch (CsvException ex) {

			LOGGER.error("Error mapping Bean to CSV", ex);
		}
	}

	public static void writeUser(PrintWriter writer, User user) {

		try {

			ColumnPositionMappingStrategy mapStrategy = new ColumnPositionMappingStrategy();

			mapStrategy.setType(User.class);

			String[] columns = new String[] { "id", "name", "age", "salary" };
			mapStrategy.setColumnMapping(columns);

			StatefulBeanToCsv btcsv = new StatefulBeanToCsvBuilder(writer).withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
					.withMappingStrategy(mapStrategy).withSeparator(',').build();

			btcsv.write(user);

		} catch (CsvException ex) {

			LOGGER.error("Error mapping Bean to CSV", ex);
		}
	}
}