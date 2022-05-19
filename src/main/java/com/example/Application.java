package com.example;

import io.micronaut.configuration.picocli.PicocliRunner;
import io.micronaut.runtime.Micronaut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import picocli.CommandLine;

@CommandLine.Command(name = "divide", header = {
        "@|green A CLI for division |@",
        "@|green Pipe in your numerator and denominator |@",
        "@|green Get the result of the division in stdout |@"},
        description = "A command line division operator",
        exitCodeListHeading = "Exit Codes:%n",
        exitCodeList = { " 0:Successful program execution.",
                "64:Invalid input: an unknown option or invalid parameter was specified.",
                "70:Execution exception: an exception occurred while executing the business logic."})
public class Application implements Runnable {

    private static final Logger logger =LoggerFactory.getLogger(Application.class);
    public static void main(String[] args) {
        PicocliRunner.execute(Application.class, args);
    }

    public Application(){
        System.out.println("Creating application");
    }

    @Override
    public void run() {
        System.out.println("Running command");
        new CommandLine(this).usage(System.err);
        logger.error("Invalid args", new IllegalArgumentException());
        System.exit(64);
    }
}
