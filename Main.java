public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Wrong syntax.");
            System.exit(0);
        }
        Helper hp = new Helper();
        switch (args[0]) {
            case "1":
                StudentLinkedList sm = hp.readFile("input\\Students.txt");
                hp.writeFile("Req1.txt", sm);
                break;
            case "2":
                StudentLinkedList sm1 = hp.readFile("input\\Students.txt");
                sm1.deleteStudent(51502010);
                sm1.deleteStudent(51803002);
                sm1.deleteStudent(51903001);
                sm1.deleteStudent(51201010);
                hp.writeFile("Req2.txt", sm1);
                break;
            case "3":
                StudentLinkedList sm2 = hp.readFile("input\\Students.txt");
                sm2.modifyName(51903001, "Tran Nguyen Gia Hao");
                hp.writeFile("Req3.txt", sm2);
                break;
            case "4":
                StudentLinkedList sm3 = hp.readFile("input\\Students.txt");
                hp.writeFile("Req4.txt", sm3.getHighestScore());
                break;
            case "5":
                StudentLinkedList sm4 = hp.readFile("input\\Students.txt");
                hp.writeFile("Req5.txt", sm4.getGraduateStudents(2018));
                break;
            case "6":
                StudentLinkedList sm5 = hp.readFile("input\\Students.txt");
                hp.writeFile("Req6.txt", sm5.findByName("Quang"));
                break;
            case "7":
                StudentLinkedList sm6 = new StudentLinkedList();
                sm6.addStudent(new Student(51403039, "Nguyen Van A", 2014, 9.0));
                sm6.addStudent(new Student(51800196, "Tran Nguyen B", 2018, 7.0));
                sm6.addStudent(new Student(51503110, "Vuong Van D", 2015, 7.0));
                sm6.addStudent(new Student(51503112, "Nguyen Thi E", 2015, 8.0));
                sm6.undo();
                sm6.undo();
                sm6.addStudent(new Student(11703001, "Hoang Thi C", 2017, 7.0));
                sm6.deleteStudent(11703001);
                sm6.deleteStudent(51800196);
                sm6.undo();
                hp.writeFile("Req7.txt", sm6);
                break;
            default:
                System.out.println("Wrong number of arguments");
        }
    }
}
