import java.util.Scanner;
import java.util.function.IntFunction;

class Clock {

    // Conversion methods
    public double SecondstoMinutes(int s) { 
        return s / 60.0;
    }
    public double SecondstoHours(int s) { 
        return s / 3600.0; 
    }
    public int MinutestoSeconds(int min) { 
        return min * 60; 
    }
    public double MinutestoHours(int min) { 
        return min / 60.0; 
    }
    public int HourstoSeconds(int hr) { 
        return hr * 3600;
    }
    public int HourstoMinutes(int hr) { 
        return hr * 60; 
    }
}

public class AgregadoPonegal_Lab3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Clock clock = new Clock();
        char continueConversion;

        // Conversion labels and corresponding methods
        String[] conversions = {"Seconds to Minutes", "Seconds to Hours", "Minutes to Seconds", "Minutes to Hours", "Hours to Seconds", "Hours to Minutes"};

        // Array of lambda functions for conversions
        IntFunction<?>[] methods = {
            clock::SecondstoMinutes, clock::SecondstoHours, clock::MinutestoSeconds,
            clock::MinutestoHours, clock::HourstoSeconds, clock::HourstoMinutes
        };

        do {
            for (int i = 0; i < conversions.length; i++) {
                System.out.println("[" + (i + 1) + "] " + conversions[i]);
            }
            System.out.print("Choose the conversion: ");
            int choice = scanner.nextInt() - 1;

            if (choice >= 0 && choice < conversions.length) {
                System.out.print("Enter Value: ");
                int inputValue = scanner.nextInt();
                
                Object result = methods[choice].apply(inputValue);    // Call the appropriate conversion method

                // Display result
                System.out.println(conversions[choice] + ": " + result);
            } else {
                System.out.println("Invalid choice. Please try again.");
            }

            // Ask if the user wants to perform another conversion
            System.out.print("Do you want to convert time again? (Y/N): ");
            continueConversion = scanner.next().toUpperCase().charAt(0);

        } while (continueConversion == 'Y');

        scanner.close();
    }
}