package com.mr.nopi.concurency.service.multitreading.workers;

import java.util.List;
import com.mr.nopi.concurency.service.domain.Student;

public class HistoryWorker extends AbstractWorker {

    public HistoryWorker(List<Student> students) {
        super(students);
    }

    @Override
    public void run() {
        for (Student s : students) {
            System.out.println("his = " + s.getHistoryResult());
            s.setHistoryResult(modifyResults(s.getHistoryResult()));
        }
    }


}
