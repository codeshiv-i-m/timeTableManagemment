import java.util.*;
class Schedule {
    private ArrayList<Class> classes;

    public Schedule() {
        classes = new ArrayList<>();
    }

    public void addClass(Class newClass) {
        classes.add(newClass);
    }

    public void removeClass(String className) {
        for (Class c : classes) {
            if (c.getName().equals(className)) {
                classes.remove(c);
                break;
            }
        }
    }
    
    public void sortSchedule() {
            Collections.sort(classes, new Comparator<Class>() {
                 @Override
            public int compare(Class c1, Class c2) {
                     return c1.getTime().compareTo(c2.getTime());
            }
        });
    }

    public void displaySchedule() {
            System.out.println("-----------------------------------------------------------------------");
            System.out.println("| Class Name |  Subject   |     Teacher     |    Room    |    Time    |");
            System.out.println("-----------------------------------------------------------------------");
    for (Class c : classes) {
            System.out.printf("| %-10s | %-10s | %-15s | %-10s | %-10s |\n", c.getName(), c.getSubject(), c.getTeacher(), c.getRoom(), c.getTime());
    }
            System.out.println("-----------------------------------------------------------------------");
}

}

class Class {
    private String name;
    private String subject;
    private String teacher;
    private String room;
    private String time;

    public Class(String name, String subject, String teacher, String room, String time) {
        this.name = name;
        this.subject = subject;
        this.teacher = teacher;
        this.room = room;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public String getSubject() {
        return subject;
    }

    public String getTeacher() {
        return teacher;
    }

    public String getRoom() {
        return room;
    }

    public String getTime() {
        return time;
    }
}

class Subject {
    private String name;
    private String description;
    private String materials;

    public Subject(String name, String description, String materials) {
        this.name = name;
        this.description = description;
        this.materials = materials;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getMaterials() {
        return materials;
    }
}

class Teacher {
    private String name;
    private String contactInfo;

    public Teacher(String name, String contactInfo) {
        this.name = name;
        this.contactInfo = contactInfo;
    }

    public String getName() {
        return name;
    }

    public String getContactInfo() {
        return contactInfo;
    }
}


public class Main
{
	public static void main(String[] args) {
   Scanner input = new Scanner(System.in);
Schedule schedule = new Schedule();

while (true) {
    System.out.println("Choose an option:");
    System.out.println("1. Add a class");
    System.out.println("2. Remove a class");
    System.out.println("3. Display Time-Table");
    System.out.println("4. Exit");
    System.out.print("Your oprion is : ");
    int choice = input.nextInt();
    input.nextLine(); // consume the newline character

    switch (choice) {
        case 1:
            // Prompt the user to enter the number of classes to add
                System.out.print("Enter the number of classes to add: ");
                int numClasses = input.nextInt();
                input.nextLine(); // consume the newline character
            // Loop through each class and prompt the user to enter its information
            for (int i = 1; i <= numClasses; i++) {
                System.out.println("Class " + i + ":");
                System.out.print("Enter the class name: ");
                String className = input.nextLine();
                System.out.print("Enter the subject: ");
                String subject = input.nextLine();
                System.out.print("Enter the teacher's name: ");
                String teacher = input.nextLine();
                System.out.print("Enter the room number: ");
                String room = input.nextLine();
                System.out.print("Enter the class time (e.g. 9:00 AM): ");
                String timeString = input.nextLine();
                
                // Create a new Class object and add it to the schedule
                Class newClass = new Class(className, subject, teacher, room, timeString);
                schedule.addClass(newClass);
            }
            break;

        case 2:
            // Prompt the user to enter the name of a class to remove and remove it from the schedule
            System.out.print("Enter the name of a class to remove: ");
            String classToRemove = input.nextLine();
            schedule.removeClass(classToRemove);
            schedule.displaySchedule();
            break;
        case 3:
            schedule.sortSchedule();
            schedule.displaySchedule();
            break;

        case 4:
            // Exit the program
            input.close();
            return;

        default:
            System.out.println("Invalid choice, please try again.");
            break;
    }
}

}
}
