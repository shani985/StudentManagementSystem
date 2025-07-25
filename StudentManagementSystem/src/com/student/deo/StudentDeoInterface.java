package com.student.deo;
import com.student.model.Student;
public interface StudentDeoInterface {
    public boolean insertStudent(Student s);
    public boolean delete(int roll);

    public boolean update(int roll,String update, int ch,Student s);
    public void showAllStudent();
    public boolean showStudentBtId(int roll);

}
