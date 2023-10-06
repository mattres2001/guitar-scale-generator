package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.Character;
import java.util.ArrayList;

public class Helper {

	protected static int indexOf(char[] arr, char target) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == (target))
				return i;
		}

		return -1; // if not found
	}
	
	protected static int indexOf(Object[] arr, Object target) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].equals(target))
				return i;
		}
		
		return -1;
	}
	
	protected static String findFormula(String target) {
		String fileName = "C:\\Users\\matth\\eclipse-workspace\\ScaleGeneratorApp\\src\\resources\\ScaleFormulasNoIntervals.txt";
		String formula = "";
		
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                int index = line.indexOf(target);
                if (index != -1) {
                    formula = line.substring(index + 1 + target.length());
                    break; // Stop searching after the first instance is found
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return formula;
    }
	
}
