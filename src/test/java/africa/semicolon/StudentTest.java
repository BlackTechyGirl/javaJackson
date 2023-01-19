package africa.semicolon;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {
    private Student student;

    @BeforeEach
    void setUp() {
        student = Student.builder()
                .id(1L)
                .gender(Gender.OTHERS)
                .dateOfBirth(LocalDate.of(2000, 4, 20))
                .address("312, Herbert Macaulay Way, Sabo-Yaba")
                .firstName("Martins")
                .lastName("Macaulay")
                .school("Fehingbole grammer school, Sabo")
                .build();
    }

//    @Test
//    public void testSerializeStudent(){
//        ObjectMapper objectMapper = new ObjectMapper();
//        try {
//           String jsonObject = objectMapper.writeValue(fos, student);
//
//        }catch (IOException exception){
//            System.err.println(exception.getMessage());
//        }
//    }
    @Test
    public void testSerializeStudentToJson(){
        ObjectMapper objectMapper = new ObjectMapper();
        try{
            String jsonObject = objectMapper.writeValueAsString(student);
            System.out.println(jsonObject);
            assertNotNull(jsonObject);
        }catch (JsonProcessingException exception){
            System.err.println(exception.getMessage());
        }
    }

    @Test
    public void testSerializeStudentFile(){
        ObjectMapper objectMapper = new ObjectMapper();
        try (var fos =
                     new FileOutputStream("C:\\Users\\Admin\\IdeaProjects\\paragonsJacksonExample\\src\\main\\resources\student.json")) {
            objectMapper.writeValue(fos, student);
            Scanner scanner =
                    new Scanner(new FileInputStream("C:\\Users\\Admin\\IdeaProjects\\paragonsJacksonExample\\src\\main\\resources\student.json"));
            String read =scanner.nextLine();
            System.out.println(read);
            assertNotNull(read);
        }catch (IOException exception){
            System.err.println(exception.getMessage());
        }
    }
}