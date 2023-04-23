package com.mr.nopi.concurency.service.multitreading.workers;

import java.util.List;
import com.mr.nopi.concurency.service.domain.Student;

public class EnglishWorker extends AbstractWorker {

    public EnglishWorker(List<Student> students) {
        super(students);
    }

    @Override
    public void run() {
        for (Student s : students) {
            System.out.println("eng = " + s.getEnglishResult());
            s.setEnglishResult(modifyResults(s.getEnglishResult()));
        }
    }
}
