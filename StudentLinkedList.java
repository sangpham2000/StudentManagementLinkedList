import java.util.NoSuchElementException;
import java.util.Stack;

public class StudentLinkedList {
    private Node head;
    private Stack<Pair> actions;

    public StudentLinkedList() {
        this.head = null;
        actions = new Stack<Pair>();
    }

    // Requirement 1
    public boolean addStudent(Student sv) {
        // code here
        if (head == null || head.getData().getId() > sv.getId()) {
            head = new Node(sv, head);
            return true;
        } else {
            Node curr = head;
            Node tempCheck = head;
            while (tempCheck.getNext() != null) {
                if (tempCheck.getData().getId() == sv.getId()) {
                    return false;
                }
                tempCheck = tempCheck.getNext();
            }
            while (curr.getNext() != null && curr.getNext().getData().getId() < sv.getId()) {
                curr = curr.getNext();
            }
            curr.setNext(new Node(sv, curr.getNext()));
            actions.push(new Pair(new Node(sv, curr.getNext()), "addStudent"));
            return true;
        }
    }

    public boolean addStudent2(Student sv) {
        if (head == null || head.getData().getId() > sv.getId()) {
            head = new Node(sv, head);
            return true;
        } else {
            Node curr = head;
            Node tempCheck = head;
            while (tempCheck.getNext() != null) {
                if (tempCheck.getData().getId() == sv.getId()) {
                    return false;
                }
                tempCheck = tempCheck.getNext();
            }
            while (curr.getNext() != null && curr.getNext().getData().getId() < sv.getId()) {
                curr = curr.getNext();
            }
            curr.setNext(new Node(sv, curr.getNext()));
            return true;
        }
    }

    // Requirement 2
    public boolean deleteStudent(int id) {
        // code here
        Node curr = head;
        if (head == null) {
            return false;
        }

        if (head.getData().getId() == id) {
            head = head.getNext();
            return true;
        }

        while (curr.getNext() != null) {
            Node next = curr.getNext();
            if (next.getData().getId() == id) {
                curr.setNext(next.getNext());
                actions.push(new Pair(next, "deleteStudent"));
                return true;
            }
            curr = next;
        }
        return false;
    }

    public boolean deleteStudent2(int id) {
        // code here
        Node curr = head;
        if (head == null) {
            return false;
        }

        if (head.getData().getId() == id) {
            head = head.getNext();
            return true;
        }

        while (curr.getNext() != null) {
            Node next = curr.getNext();
            if (next.getData().getId() == id) {
                curr.setNext(next.getNext());
                return true;
            }
            curr = next;
        }
        return false;
    }

    // Requirement 3
    public boolean modifyName(int id, String name) {
        // code here
        Node curr = head;
        if (head == null) {
            return false;
        }

        if (head.getData().getId() == id) {
            head.getData().setName(name);
            return true;
        }

        while (curr != null) {
            if (curr.getData().getId() == id) {
                curr.getData().setName(name);
                return true;
            }
            curr = curr.getNext();
        }
        return false;
    }

    // Requirement 4
    public Student getHighestScore() {
        // code here
        double max = 0.0;
        Node curr = head;
        Student result = new Student();
        if (head == null) {
            return null;
        }
        while (curr != null) {
            if (curr.getData().getGpa() > max) {
                max = curr.getData().getGpa();
                result = curr.getData();
            }
            curr = curr.getNext();
        }
        return result;
    }

    // Requirement 5
    public StudentLinkedList getGraduateStudents(int year) {
        // code here
        StudentLinkedList student = new StudentLinkedList();
        Node curr = head;
        while (curr != null) {
            if (year - curr.getData().getEnrollmentYear() > 4) {
                student.addStudent(curr.getData());
            }
            curr = curr.getNext();
        }
        return student;
    }

    // Requirement 6
    public StudentLinkedList findByName(String str) {
        // code here
        StudentLinkedList student = new StudentLinkedList();
        Node curr = head;
        while (curr != null) {
            if (curr.getData().getName().endsWith(str)) {
                student.addStudent(curr.getData());
            }
            curr = curr.getNext();
        }
        return student;
    }

    // Requirement 7
    public boolean undo() {
        Pair temp = actions.pop();
        switch (temp.getAction()) {
            case "addStudent":
                return this.deleteStudent2(temp.getNode().getData().getId());
            case "deleteStudent":
                return this.addStudent2(temp.getNode().getData());
            default:
                break;
        }
        return true;
    }

    // Student don't modify the methods below

    public String toString() {
        String result = "";
        if (head == null) {
            return "No item";
        }
        Node temp = head;
        while (temp.getNext() != null) {
            result += temp.getData() + "\n";
            temp = temp.getNext();
        }
        return result += temp.getData();
    }

    public boolean isEmpty() {
        if (head == null) {
            return true;
        }
        return false;
    }
}
