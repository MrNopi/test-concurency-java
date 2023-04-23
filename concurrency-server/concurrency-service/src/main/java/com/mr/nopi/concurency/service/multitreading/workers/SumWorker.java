package com.mr.nopi.concurency.service.multitreading.workers;

import com.mr.nopi.concurency.service.domain.Student;

import java.util.List;

public class SumWorker extends AbstractWorker {
    public SumWorker(List<Student> students) {
        super(students);
    }

    @Override
    public void run() {
        for (Student s : students) {
            s.setSum(s.getMathResult() + s.getEnglishResult() + s.getHistoryResult());
        }
    }
}
