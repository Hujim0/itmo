import dataStructs.*;


import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        String path = "C:\\code\\itmo\\prog\\lab5\\databaseFiles\\test2.xml";
        
//        XmlDatabase<StudyGroup> database = new XmlDatabase<>(path, new StudyGroup());

//        database.beginCommandLoop();
//
        StudyGroup studyGroup = null;
        try {
            studyGroup = new StudyGroup(
                    "Romch",
                    new Coordinates(10,10),
                    10,
                    15,
                    FormOfEducation.FULL_TIME_EDUCATION,
                    Semester.EIGHTH,
                    new Person(
                            "Жук",
                            LocalDate.of(2005, 11,21),
                            Country.JAPAN,new Location(10,23F,"HUI")));
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

//        database.getDatabase().add(studyGroup);

//        database.serializeDatabase();

//        CompositeEntity<StudyGroup> entity = new XmlCompositeEntity<>(StudyGroup.class, "item");
//
//        System.out.println(entity.serialize(0, studyGroup));



        System.out.println();
    }
}