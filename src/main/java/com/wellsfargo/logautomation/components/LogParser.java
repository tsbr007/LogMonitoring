package com.wellsfargo.logautomation.components;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.print.attribute.standard.Severity;

import com.wellsfargo.logautomation.model.LogEntry;

public class LogParser {
	private static final String TIMESTAMP_REGEX = "\\[(.*?)\\]";
	private static final String MESSAGE_REGEX = "\\{([^\\{\\}]*)\\}";
	private static final String SEVERITY_REGEX = "\\((.*?)\\)";

	public static LogEntry parseLogEntry(String logLine) {
		Pattern pattern = Pattern.compile(TIMESTAMP_REGEX + "\\s+" + MESSAGE_REGEX + "\\s+" + SEVERITY_REGEX);
		Matcher matcher = pattern.matcher(logLine);

		if (matcher.find()) {
			String timestampString = matcher.group(1);
			String message = matcher.group(2);
			String severity = matcher.group(3);

			// Parse the timestamp
			// You may need to customize the parsing logic based on the timestamp format in
			// your log
			// For simplicity, this example assumes the timestamp is in ISO-8601 format
			LocalDateTime timestamp = LocalDateTime.parse(timestampString, DateTimeFormatter.ISO_DATE_TIME);

			return new LogEntry(timestamp, message, severity);
		}

		return null;
	}

	public static List<LogEntry> parseLogEntries(List<String> logLines) {
		List<LogEntry> logEntries = new ArrayList<>();

		for (String logLine : logLines) {
			LogEntry logEntry = parseLogEntry(logLine);
			if (logEntry != null) {
				logEntries.add(logEntry);
			}
		}

		return logEntries;
	}
	
	public static List<LogEntry> parseLogEntries(File file) {
        List<LogEntry> logEntries = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;

            while ((line = reader.readLine()) != null) {
                // Parse each line of the log file and create a LogEntry object
                LogEntry logEntry = parseLogEntry(line);
                logEntries.add(logEntry);
            }
        } catch (IOException e) {
            // Handle any IO errors
            e.printStackTrace();
        }

        return logEntries;
    }
	
	public static List<LogEntry> parseLogEntriesFiles(List<File> files) {
        List<LogEntry> logEntries = new ArrayList<>();

        for(File file : files) {
        	logEntries.addAll(parseLogEntries(file));
        }

        return logEntries;
    }

    

	
}
