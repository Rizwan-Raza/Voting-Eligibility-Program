import java.io.*;
class MyFileWriter {
	public static void main(String[] args) throws IOException {
		FileWriter fw = new FileWriter("Abc.txt");
		fw.write(112);
		fw.write("rolog \n Academy");
		fw.write("\n");
		fw.write('a');
		fw.flush();
		fw.close();
	}
}