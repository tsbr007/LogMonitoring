package com.wellsfargo.logautomation.components;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import com.wellsfargo.logautomation.config.LogCollectorConfig;

public class LogCollector {
    private String serverAddress;
    private int port;

    
    
    public LogCollector() {
		super();
	}

	public LogCollector(String serverAddress, int port) {
        this.serverAddress = serverAddress;
        this.port = port;
    }
    
    private LogCollectorConfig config;

    public LogCollector(LogCollectorConfig config) {
        this.config = config;
    }

    public List<String> collectLogStrings() {
        List<String> logLines = new ArrayList<>();

        try (Socket socket = new Socket(serverAddress, port);
             BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            String line;
            while ((line = reader.readLine()) != null) {
                logLines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return logLines;
    }
    
    
    public List<File> collectLogs() {
        List<File> logFiles = new ArrayList<>();

        // Logic to collect the log files based on the configuration
        // Example:
        File logDirectory = new File(config.getLogDirectoryPath());
        File[] files = logDirectory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile() && file.getName().endsWith(".log")) {
                    logFiles.add(file);
                }
            }
        }

        return logFiles;
    }
}


