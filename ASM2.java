import java.util.ArrayList;
import java.util.Scanner;

public class ASM2 {

    // Lớp đại diện cho sinh viên
    static class Student {
        String fullName; // Họ và tên đầy đủ
        String lastName; // Tên (họ cuối cùng)

        // Hàm khởi tạo nhận vào họ và tên đầy đủ
        public Student(String fullName) {
            this.fullName = fullName;
            // Lấy tên (phần sau cùng của họ và tên)
            this.lastName = fullName.substring(fullName.lastIndexOf(" ") + 1);
        }

        @Override
        public String toString() {
            return "Student Name: " + fullName;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> studentList = new ArrayList<Student>(); // Danh sách để lưu trữ các sinh viên
        int choice;

        do {
            // Hiển thị menu
            System.out.println("\n--- STUDENT MANAGEMENT MENU ---");
            System.out.println("1. Enter student list");
            System.out.println("2. Find students by last name");
            System.out.println("3. Find and edit students by full name");
            System.out.println("4. Exit");
            System.out.print("Select an option (1-4): ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Xử lý ký tự xuống dòng sau khi nhập số

            switch (choice) {
                case 1:
                    // Nhập danh sách sinh viên
                    System.out.print("Enter the number of students: ");
                    int count = scanner.nextInt();
                    scanner.nextLine(); // Xử lý ký tự xuống dòng

                    for (int i = 0; i < count; i++) {
                        System.out.print("Enter full name of student " + (i + 1) + ": ");
                        String fullName = scanner.nextLine();
                        studentList.add(new Student(fullName)); // Thêm sinh viên vào danh sách
                    }
                    System.out.println("Students added successfully.");
                    break;

                case 2:
                    // Tìm sinh viên theo tên
                    System.out.print("Enter the last name to search: ");
                    String searchLastName = scanner.nextLine();
                    System.out.println("Students with the last name '" + searchLastName + "':");
                    for (Student student : studentList) {
                        if (student.lastName.equalsIgnoreCase(searchLastName)) {
                            System.out.println(student); // In ra thông tin sinh viên tìm thấy
                        }
                    }
                    break;

                case 3:
                    // Tìm và chỉnh sửa sinh viên theo họ và tên đầy đủ
                    System.out.print("Enter the full name to search: ");
                    String searchFullName = scanner.nextLine();
                    boolean found = false;

                    for (Student student : studentList) {
                        if (student.fullName.equalsIgnoreCase(searchFullName)) {
                            System.out.println("Student found: " + student);
                            System.out.print("Enter new full name: ");
                            String newFullName = scanner.nextLine();
                            // Cập nhật thông tin sinh viên
                            student.fullName = newFullName;
                            student.lastName = newFullName.substring(newFullName.lastIndexOf(" ") + 1);
                            System.out.println("Student information updated successfully.");
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("No student found with the full name '" + searchFullName + "'.");
                    }
                    break;

                case 4:
                    // Thoát chương trình
                    System.out.println("Program exited. Goodbye!");
                    break;

                default:
                    // Xử lý trường hợp nhập sai lựa chọn
                    System.out.println("Invalid choice. Please select between 1 and 4.");
            }
        } while (choice != 4);

        scanner.close(); // Đóng Scanner để giải phóng tài nguyên
    }
}