package com.av;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProcessExecutor {
    public static void exec(String deviceId,String command) throws IOException {


        Process process = null;
        String commandString;
        if(deviceId != null) {
            commandString = String.format("%s", "adb -s " + deviceId + " shell " + command);
        }else
            commandString = String.format("%s", "adb shell " + command);

        System.out.print("Command is "+commandString+"\n");
        try {
            //ProcessBuilder pb = new ProcessBuilder("cmd.exe","/c",commandString);
            ProcessBuilder pb = new ProcessBuilder("cmd.exe","/c",commandString);
           // process = Runtime.getRuntime().exec(commandString);
            process = pb.start();
            process.waitFor();
        } catch (IOException | InterruptedException e) {
        }
//        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
//        String line;
//        while ((line = reader.readLine()) != null) {
//            System.out.print(line+"\n");
//        }
    }
}
