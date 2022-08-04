import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SizeOfUniverse {
    public static void main(String[] args) {
        // The diameter of the observable universe in 2022 is 93 billion light years.
        // 93ly = 8.798480e+14km

        // Define a scanner for user input.
        Scanner scanner = new Scanner(System.in);

        // Define variables to warn the user.
        boolean mb128Confirm = false;
        boolean gb1Confirm = false;
        boolean gb4Confirm = false;
        boolean gb8Confirm = false;
        boolean gb16Confirm = false;
        boolean gb32Confirm = false;

        try {
            // Define output file path.
            String outputPath = "output.txt";

            // Open and identify the output file.
            FileWriter fileWriter = new FileWriter(outputPath);
            
            // Define to read output file size.
            Path path = Paths.get(outputPath);

            // Calculate 10 to the 14th power.
            double base = 10;
            double power = 14;
            double result = Math.pow(base, power);

            // Define variable to store file size.
            long bytes = 0;
            String bytesInString;
            char choice;

            // Write the initial data of the file manually.
            fileWriter.write("8.7984801");

            // Start the timer.
            Instant start = Instant.now();

            // Define a loop that will loop 10 to the 14th power.
            // Stop at certain file sizes to warn the user and notify the user.
            // Ask if the user wants to continue.
            // If the user wants to continue, provide the current condition and continue.
            // If the user doesn't want to continue, break the loop there.
            int i;
            for (i = 0; i < result; ++i) {
                if (!mb128Confirm) {
                    if (i % 10000 == 0) {
                        bytes = Files.size(path);

                        bytesInString = Long.toString(bytes);
                        if (bytesInString.length() == 9 && bytesInString.charAt(0) == '1' && bytesInString.charAt(1) == '3') {
                            System.out.print("[WARNING] File size exceeded 128 MB! Do you want to continue [y/n]: ");
                            choice = scanner.next().toLowerCase().charAt(0);
                            if (choice == 'y') {
                                mb128Confirm = true;
                            } else {
                                break;
                            }
                        }
                    }
                } else if (!gb1Confirm) {
                    if (i % 1000000 == 0) {
                        bytes = Files.size(path);

                        bytesInString = Long.toString(bytes);
                        if (bytesInString.length() == 10 && bytesInString.charAt(0) == '1') {
                            System.out.print("[WARNING] File size exceeded 1 GB! Do you want to continue [y/n]: ");
                            choice = scanner.next().toLowerCase().charAt(0);
                            if (choice == 'y') {
                                gb1Confirm = true;
                            } else {
                                break;
                            }
                        }
                    }
                } else if (!gb4Confirm) {
                    if (i % 1000000 == 0) {
                        bytes = Files.size(path);

                        bytesInString = Long.toString(bytes);
                        if (bytesInString.length() == 10 && bytesInString.charAt(0) == '4') {
                            System.out.print("[WARNING] File size exceeded 4 GB! Do you want to continue [y/n]: ");
                            choice = scanner.next().toLowerCase().charAt(0);
                            if (choice == 'y') {
                                gb4Confirm = true;
                            } else {
                                break;
                            }
                        }
                    }
                } else if (!gb8Confirm) {
                    if (i % 1000000 == 0) {
                        bytes = Files.size(path);

                        bytesInString = Long.toString(bytes);
                        if (bytesInString.length() == 10 && bytesInString.charAt(0) == '8') {
                            System.out.print("[WARNING] File size exceeded 8 GB! Do you want to continue [y/n]: ");
                            choice = scanner.next().toLowerCase().charAt(0);
                            if (choice == 'y') {
                                gb8Confirm = true;
                            } else {
                                break;
                            }
                        }
                    }
                } else if (!gb16Confirm) {
                    if (i % 1000000 == 0) {
                        bytes = Files.size(path);

                        bytesInString = Long.toString(bytes);
                        if (bytesInString.length() == 11 && bytesInString.charAt(0) == '1' && bytesInString.charAt(1) == '7') {
                            System.out.print("[WARNING] File size exceeded 16 GB! Do you want to continue [y/n]: ");
                            choice = scanner.next().toLowerCase().charAt(0);
                            if (choice == 'y') {
                                gb16Confirm = true;
                            } else {
                                break;
                            }
                        }
                    }
                } else if (!gb32Confirm) {
                    if (i % 1000000 == 0) {
                        bytes = Files.size(path);

                        bytesInString = Long.toString(bytes);
                        if (bytesInString.length() == 11 && bytesInString.charAt(0) == '3' && bytesInString.charAt(1) == '4') {
                            System.out.print("[WARNING] File size exceeded 32 GB! Do you want to continue [y/n]: ");
                            choice = scanner.next().toLowerCase().charAt(0);
                            if (choice == 'y') {
                                gb32Confirm = true;
                            } else {
                                break;
                            }
                        }
                    }
                }

                // Write the zeros, which is the main purpose of the program.
                fileWriter.write("0");
            }

            // Stop the timer and calculate elapsed time.
            Instant end = Instant.now();
            Duration timeElapsed = Duration.between(start, end);
            long seconds = timeElapsed.toMillis() / 1000;
            bytes = Files.size(path);
            System.out.println(String.format("It took %d seconds to put %d '0's in a file.", seconds, i));
            System.out.println(String.format("File size with other data: %d", bytes));

            // Write 'km' at the end of the file.
            fileWriter.write(" km");

            // Close the file and remove it from RAM.
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        // Close the Scanner and remove it from RAM.
        scanner.close();
    }
}
