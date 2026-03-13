public class Student{
    public String nachname;
    public String vorname;
    public int geburtsjahr;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return true;
    }

}
