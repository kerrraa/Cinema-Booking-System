import java.io.*;

public class FileService {
    public int[][] loadHall(String fileName) {
        int[][] matrix = new int[10][10];
        int rowCount = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] splited = line.split(" ");
                for (int colCount = 0; colCount < splited.length; colCount++) {
                    matrix[rowCount][colCount] = Integer.parseInt(splited[colCount]);

                }
                rowCount++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return matrix;
    }

    public void saveHall(String fileName, int[][] matrix){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))){
            for (int i = 0; i < matrix.length; i++){
                for (int j = 0; j < matrix[i].length; j++) {
                    writer.write(String.valueOf(matrix[i][j]) + " ");
                }
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
