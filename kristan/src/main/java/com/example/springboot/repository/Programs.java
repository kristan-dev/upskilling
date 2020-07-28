package com.example.springboot.repository;
import com.example.springboot.model.Program;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Programs {

    Map<String, Program> students = new HashMap<>();

    private void initProgramsRepository() {
        Program program1 = Program.builder()
                .programName("BSCS")
                .programId("000")
                .programDesc("Bachelors of Science in Computer Science")
                .build();
        this.students.put("prog1", program1);

        Program program2 = Program.builder()
                .programName("BSIT")
                .programId("001")
                .programDesc("Bachelors of Science in Information Technology")
                .build();
        this.students.put("prog2", program2);

        Program program3 = Program.builder()
                .programName("MSCS")
                .programId("002")
                .programDesc("Masters of Science in Computer Science")
                .build();
        this.students.put("prog3", program3);
    }

    public Collection<Program> getAllPrograms() {
        initProgramsRepository();
        return this.students.values();
    }

}
