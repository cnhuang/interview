package interview.amazon;

import java.util.HashSet;
import java.util.Random;

public class NumberWithOddNumberOccurrence {

	static Random rand = new Random(System.currentTimeMillis());

	// Find numbers with odd number of occurrences in a given integer array
	// Return a integer array of numbers with odd number of occurrences
	public static int[] FindNumbersOccurOddTimes(int[] input) {
		if (null == input)
			return new int[0];
		if (input.length <= 1)
			return input;

		HashSet<Integer> hs = new HashSet<Integer>();

		for (int i : input) {
			if (!hs.remove(i))
				hs.add(i);
		}

		int[] output = new int[hs.size()];

		int count = 0;
		for (int i : hs) {
			output[count++] = i;
		}

		return output;
	}

	// The method used to validate the test result
	public static boolean Validate(int[] result, int[] answer) {

		if ((result == null || result.length == 0)
				&& (answer == null || answer.length == 0)) {
			return true;
		}

		HashSet<Integer> hs = new HashSet<Integer>();
		for (int i : answer)
			hs.add(i);

		for (int i : result)
			if (!hs.remove(i))
				return false;

		return hs.size() == 0;
	}

	// Test cases: only 1 number with odd number of occurrences
	public static void TestCase_HappyPath() {

		int[] input = { 1, 1, 2, 2, 3 };
		int[] answer = { 3 };
		assert Validate(FindNumbersOccurOddTimes(input), answer) == true : "TestCase_HappyPath Failed";
	}

	// Test cases: input is null
	public static void TestCase_NullInput() {
		int[] input = null;
		int[] answer = {};
		assert Validate(FindNumbersOccurOddTimes(input), answer) == true : "TestCase_NullInput Failed";
	}

	// Test cases: input is empty
	public static void TestCase_EmptyInput() {
		int[] input = {};
		int[] answer = {};
		assert Validate(FindNumbersOccurOddTimes(input), answer) == true : "TestCase_EmptyInput Failed";
	}

	// Test cases: input has only 1 element
	public static void TestCase_SingleElement() {
		int[] input = { 1 };
		int[] answer = { 1 };
		assert Validate(FindNumbersOccurOddTimes(input), answer) == true : "TestCase_SingleElement Failed";
	}

	// Test cases: input with 0 number with odd number of occurrences
	public static void TestCase_NoNumbersWithOddOccurences() {
		int[] input = { 1, 1, 2, 2 };
		int[] answer = {};
		assert Validate(FindNumbersOccurOddTimes(input), answer) == true : "TestCase_NoNumbersWithOddOccurences Failed";
	}

	// Test cases: input with all numbers with odd number of occurrences
	// Test cases: all input numbers are with odd number of occurrences
	public static void TestCase_AllNumbersWithOddOccurences() {
		int[] input = { 1, 2, 3, 4, 5 };
		int[] answer = { 1, 2, 3, 4, 5 };
		assert Validate(FindNumbersOccurOddTimes(input), answer) == true : "TestCase_AllNumbersWithOddOccurences Failed";
	}

	// Test cases: Maximize the size of input and answer to detect overload /
	// out of memory exceptions
	// need 8G memory for input and answer array each
	public static void TestCase_LargeInputSize() {
		int[] input = new int[Integer.MAX_VALUE];
		int[] answer = new int[Integer.MAX_VALUE];

		for (int i = 0; i < Integer.MAX_VALUE; i++) {
			input[i] = i;
			answer[i] = i;
		}

		assert Validate(FindNumbersOccurOddTimes(input), answer) == true : "TestCase_LargeInputSize Failed";
	}

	// Test cases: Generate random data
	public static void TestCase_FuzzyTest() {
		TestCase_FuzzyTest(Integer.MAX_VALUE);
	}

	// Test cases: Generate random data
	public static void TestCase_FuzzyTest(int maxInputSize) {

		// Generate input size and answer size randomly
		int inputSize = rand.nextInt(maxInputSize);
		int numberOfAnswers = 0;

		do {
			numberOfAnswers = rand.nextInt(inputSize + 1);
		} while (inputSize % 2 != numberOfAnswers % 2);

		System.out.println(String.format(
				" Fuzzy Test: input size = %d, number of answer numbers = %d",
				inputSize, numberOfAnswers));

		// Generate input and answer data
		int[] input = new int[inputSize];
		int[] answer = new int[numberOfAnswers];

		HashSet<Integer> answerHs = new HashSet<Integer>();
		int index = 0;

		while (answerHs.size() < numberOfAnswers) {
			int num = rand.nextInt();
			if (!answerHs.contains(num)) {
				answerHs.add(num);
				answer[index] = num;
				input[index] = num;
				index++;
			}
		}

		while (index < inputSize) {
			int num = rand.nextInt();
			int occur = 0;
			do {
				occur = rand.nextInt(inputSize - index) + 1;
			} while (occur % 2 != 0);

			for (int i = 0; i < occur; i++)
				input[index++] = num;
		}

		// Randomize the input array is case the order of input numbers makes
		// different.

		for (int i = input.length - 1; i > 0; i--) {
			int tmpIndex = rand.nextInt(i);
			int tmp = input[i];
			input[i] = input[tmpIndex];
			input[tmpIndex] = tmp;
		}

		assert Validate(FindNumbersOccurOddTimes(input), answer) == true : "TestCase_FuzzyTest Failed";

	}

	// entry point
	public static void main(String[] args) {
		TestCase_HappyPath();
		TestCase_NullInput();
		TestCase_EmptyInput();
		TestCase_SingleElement();
		TestCase_NoNumbersWithOddOccurences();
		TestCase_AllNumbersWithOddOccurences();
		TestCase_FuzzyTest();
		TestCase_LargeInputSize();
		System.out.println("Test cases are all passed");
	}

}
