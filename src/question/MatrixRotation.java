package question;

import java.util.Arrays;

import org.junit.Test;

public class MatrixRotation
{

	//Crack code interview p101
	@Test
	public void RotationTest()
	{
		int N = 5;
		int[][] data = new int[N][N];

		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++)
				data[i][j] = N * i + j + 1;

		System.out.println("Before Rotation");
		for (int i = 0; i < N; i++)
			System.out.println(Arrays.toString(data[i]));

		Rotation(data, N);

		System.out.println("After Rotation");
		for (int i = 0; i < N; i++)
			System.out.println(Arrays.toString(data[i]));
	}

	public void Rotation(int[][] data, int N)
	{
		for (int row = 0; row < N / 2; row++)
		{
			for (int col = row; col < N - row - 1; col++)
			{
				int width = N - 1;

				int tmp = data[row][col];
				data[row][col] = data[width - col][row];
				data[width - col][row] = data[width - row][width - col];
				data[width - row][width - col] = data[col][width - row];
				data[col][width - row] = tmp;
			}
		}
	}
}
