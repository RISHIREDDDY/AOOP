// Interface for student management
public interface StudentManagement {
    void addStudent(Student student);
    void removeStudent(String studentId);
    Student getStudent(String studentId);
}

// Interface for course management
public interface CourseManagement {
    void addCourse(Course course);
    void removeCourse(String courseId);
    Course getCourse(String courseId);
}

// Interface for enrollment management
public interface EnrollmentManagement {
    void enrollStudent(String studentId, String courseId);
    void unenrollStudent(String studentId, String courseId);
}

// Student class
import java.util.ArrayList;
import java.util.List;

public class Student {
    private String id;
    private String name;
    private List<String> enrolledCourses;

    public Student(String id, String name) {
        this.id = id;
        this.name = name;
        this.enrolledCourses = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<String> getEnrolledCourses() {
        return enrolledCourses;
    }

    public void enrollCourse(String courseId) {
        enrolledCourses.add(courseId);
    }

    public void unenrollCourse(String courseId) {
        enrolledCourses.remove(courseId);
    }
}

// Course class
import java.util.ArrayList;
import java.util.List;

public class Course {
    private String id;
    private String name;
    private List<String> enrolledStudents;

    public Course(String id, String name) {
        this.id = id;
        this.name = name;
        this.enrolledStudents = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<String> getEnrolledStudents() {
        return enrolledStudents;
    }

    public void enrollStudent(String studentId) {
        enrolledStudents.add(studentId);
    }

    public void unenrollStudent(String studentId) {
        enrolledStudents.remove(studentId);
    }
}

// Implementation of StudentManagement
import java.util.HashMap;
import java.util.Map;

public class StudentManagementImpl implements StudentManagement {
    private Map<String, Student> students = new HashMap<>();

    @Override
    public void addStudent(Student student) {
        students.put(student.getId(), student);
    }

    @Override
    public void removeStudent(String studentId) {
        students.remove(studentId);
    }

    @Override
    public Student getStudent(String studentId) {
        return students.get(studentId);
    }
}

// Implementation of CourseManagement
import java.util.HashMap;
import java.util.Map;

public class CourseManagementImpl implements CourseManagement {
    private Map<String, Course> courses = new HashMap<>();

    @Override
    public void addCourse(Course course) {
        courses.put(course.getId(), course);
    }

    @Override
    public void removeCourse(String courseId) {
        courses.remove(courseId);
    }

    @Override
    public Course getCourse(String courseId) {
        return courses.get(courseId);
    }
}

// Implementation of EnrollmentManagement
public class EnrollmentManagementImpl implements EnrollmentManagement {
    private StudentManagement studentManagement;
    private CourseManagement courseManagement;

    public EnrollmentManagementImpl(StudentManagement studentManagement, CourseManagement courseManagement) {
        this.studentManagement = studentManagement;
        this.courseManagement = courseManagement;
    }

    @Override
    public void enrollStudent(String studentId, String courseId) {
        Student student = studentManagement.getStudent(studentId);
        Course course = courseManagement.getCourse(courseId);
        if (student != null && course != null) {
            student.enrollCourse(courseId);
            course.enrollStudent(studentId);
        }
    }

    @Override
    public void unenrollStudent(String studentId, String courseId) {
        Student student = studentManagement.getStudent(studentId);
        Course course = courseManagement.getCourse(courseId);
        if (student != null && course != null) {
            student.unenrollCourse(courseId);
            course.unenrollStudent(studentId);
        }
    }
}

// Main application class
public class Main {
    public static void main(String[] args) {
        StudentManagement studentManagement = new StudentManagementImpl();
        CourseManagement courseManagement = new CourseManagementImpl();
        EnrollmentManagement enrollmentManagement = new EnrollmentManagementImpl(studentManagement, courseManagement);

        Student student1 = new Student("S001", "John Doe");
        Student student2 = new Student("S002", "Jane Smith");

        Course course1 = new Course("C001", "Mathematics");
        Course course2 = new Course("C002", "Science");

        studentManagement.addStudent(student1);
        studentManagement.addStudent(student2);

        courseManagement.addCourse(course1);
        courseManagement.addCourse(course2);

        enrollmentManagement.enrollStudent("S001", "C001");
        enrollmentManagement.enrollStudent("S002", "C002");

        System.out.println("Enrolled Courses for John Doe: " + student1.getEnrolledCourses());
        System.out.println("Enrolled Students in Mathematics: " + course1.getEnrolledStudents());
    }
}
