import java.io.*;

public class Helper {
    public StudentLinkedList readFile(String path) {
        StudentLinkedList sm = new StudentLinkedList();
        try {
            FileReader reader = new FileReader(path);
            BufferedReader fReader = new BufferedReader(reader);
            String data;
            while ((data = fReader.readLine()) != null) {
                String[] spl = data.split(" - ");
                Student stu = new Student(Integer.parseInt(spl[0]), spl[1], Integer.parseInt(spl[2]),
                        Double.parseDouble(spl[3]));
                sm.addStudent(stu);
            }

            fReader.close();
            reader.close();
        } catch (Exception e) {
            System.out.println("Cannot load file");
        }
        return sm;
    }

    public <E> boolean writeFile(String path, E data) {
        try {
            FileWriter writer = new FileWriter(path);
            writer.write(data.toString());
            writer.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("Error.");
            return false;
        }
        return true;
    }
}