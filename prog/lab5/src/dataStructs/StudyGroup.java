package dataStructs;
import annotations.BuilderParameter;
import exceptions.NumberOutOfBoundsException;
import exceptions.StringIsEmptyException;
import lombok.*;

import java.lang.reflect.Field;
import java.time.*;

@Data
public class StudyGroup {

    @Setter(AccessLevel.NONE)
    @Getter(AccessLevel.PRIVATE)
    private static int lastId;

    private long id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    @NonNull
    private String name; //Поле не может быть null, Строка не может быть пустой
    @NonNull
    private Coordinates coordinates; //Поле не может быть null
    @NonNull
    private LocalDate creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    @NonNull
    private Integer studentsCount; //Значение поля должно быть больше 0, Поле может быть null

    private long averageMark; //Значение поля должно быть больше 0
    private FormOfEducation formOfEducation; //Поле может быть null
    private Semester semesterEnum; //Поле может быть null
    private Person groupAdmin; //Поле может быть null

    public void setName(String name) throws StringIsEmptyException {
        if (name == null || name.isBlank()) {
            throw new StringIsEmptyException("Имя не может быть пустым!");
        }
        this.name = name;
    }
    public void setAverageMark(long value) throws NumberOutOfBoundsException {
        if (value <= 0) {
            throw new NumberOutOfBoundsException("Средняя оценка должна быть больше нуля!!");
        }
        this.averageMark = value;
    }

    public void setStudentsCount(Integer value) throws NumberOutOfBoundsException {
        if (value == null || value <= 0) {
            throw new NumberOutOfBoundsException("Количество студентов должно быть больше нуля!!");
        }
        studentsCount = value;
    }

    public StudyGroup(String name, Coordinates coordinates, Integer studentsCount, long averageMark, FormOfEducation formOfEducation, Semester semesterEnum, Person groupAdmin) throws StringIsEmptyException, NumberOutOfBoundsException {
        setName(name);
        setCoordinates(coordinates);
        setStudentsCount(studentsCount);
        setAverageMark(averageMark);
        setFormOfEducation(formOfEducation);
        setSemesterEnum(semesterEnum);
        setGroupAdmin(groupAdmin);

        id = lastId++;
    }

    public static StudyGroup build(
            @BuilderParameter("name") String name,
            @BuilderParameter("coordinates") Coordinates coordinates,
            @BuilderParameter("studentsCount") Integer studentsCount,
            @BuilderParameter("averageMark") long averageMark,
            @BuilderParameter("formOfEducation") FormOfEducation formOfEducation,
            @BuilderParameter("semesterEnum") Semester semesterEnum,
            @BuilderParameter("groupAdmin") Person groupAdmin)
            throws NumberOutOfBoundsException, StringIsEmptyException {
        return new StudyGroup(name, coordinates, studentsCount, averageMark, formOfEducation, semesterEnum, groupAdmin);
    }

    private void setId(int id) {
        this.id = id;

        lastId = Math.max(lastId, id);
    }

    public StudyGroup() {
        id = lastId++;
    }

    public String serializeXML(StudyGroup obj) {
        StringBuilder builder = new StringBuilder();

        builder.append("<item>\n");

        for (Field field : this.getClass().getDeclaredFields()) {
            System.out.println(field.getName());
        }

        return builder.toString();
    }

    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder();
        return "";
    }

}




