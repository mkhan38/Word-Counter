import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

//**************************************************************************************************
//
//wordcount.java    Created by Mohammad Khan 
//
//**************************************************************************************************

public class wordcount {
	public static void main(String[] args){
		BufferedReader input;
		StringTokenizer line;
		String fileName; 
		String inputLine;
		int wordCount = 0;
		int lineCount = 0;
		int charCount = 0;
		int sentenceCount = 0;
		int vowelCount = 0;
		int punctuationCount = 0;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Please enter name of file");
		fileName = scan.nextLine(); //File must be present in project folder
		                            
		try{
			input = new BufferedReader(new FileReader(fileName));
			while((inputLine = input.readLine()) != null){
				line = new StringTokenizer(inputLine);
				wordCount += line.countTokens(); //Counts the number of words in the line
				lineCount++; 
				
				while(line.hasMoreTokens()){ //While words are available on the line, continues to run
					String s = line.nextToken();
					charCount += s.length(); //Counts the number of characters in the current word
					for(int i = 0;i<s.length();i++){ //Counts the number of vowels in the current word(both uppercase and lowercase)
						if(s.charAt(i)=='a'|s.charAt(i)== 'e'|s.charAt(i)=='i'|s.charAt(i)=='o'|s.charAt(i)=='u'|s.charAt(i)=='A'|s.charAt(i)== 'E'|s.charAt(i)=='I'|s.charAt(i)=='O'|s.charAt(i)=='U'){
							vowelCount++;
						}
					}
					//Check to see if word ends with question mark, exclamation mark, or period
					if(s.charAt(s.length()-1)=='!'|s.charAt(s.length()-1)=='.'|s.charAt(s.length()-1)=='?'){
						sentenceCount++;
						punctuationCount++;
					}
				}
			}
			input.close();
		}
		catch (IOException e){
			System.out.println(e);
			System.exit(1);
		}
		//Check to see if file is empty or not
		if(wordCount!=0&&lineCount!=0&&charCount!=0&&vowelCount!=0&&sentenceCount!=0&&punctuationCount!=0){
			System.out.println("The number of words is: "+wordCount);
			System.out.println("The number of lines is: "+lineCount);
			System.out.println("The number of characters is: "+charCount);
			System.out.println("The number of vowels is: "+vowelCount);
			System.out.println("The number of sentences is: "+sentenceCount);
			System.out.println("The number of punctuation marks is: "+punctuationCount);
		}
		else
			System.out.println("The input file is empty");
		
		//Create output file
		try{
			PrintWriter output = new PrintWriter(new FileWriter("output.txt"));
			if(wordCount!=0&&lineCount!=0&&charCount!=0&&vowelCount!=0&&sentenceCount!=0&&punctuationCount!=0){
				output.println("The number of words is: "+wordCount);
				output.println("The number of lines is: "+lineCount);
				output.println("The number of characters is: "+charCount);
				output.println("The number of vowels is: "+vowelCount);
				output.println("The number of sentences is: "+sentenceCount);
				output.println("The number of punctuation marks is: "+punctuationCount);
			}
			else
				output.println("The input file is empty");
		}
		catch(IOException e){
			System.out.println(e);
			System.exit(1);
		}
	}
}
