package com.mr.nopi.concurency.service.multitreading.workers;

import com.mr.nopi.concurency.service.domain.Student;

import java.util.List;

public class MathWorker extends AbstractWorker {

    public MathWorker(List<Student> students) {
        super(students);
    }

    @Override
    public void run() {
        for (Student s : students) {
            System.out.println("math = " + s.getMathResult());
            s.setMathResult(modifyResults(s.getMathResult()));
        }
    }
}
