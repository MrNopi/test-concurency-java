package com.mr.nopi.concurency.service.multitreading.workers;

import com.mr.nopi.concurency.service.domain.Student;

import java.util.List;

public abstract class AbstractWorker extends Thread {
    protected List<Student> students;

    public AbstractWorker(List<Student> students) {
        this.students = students;
    }
    protected Long modifyResults(Long results) {
        if(results + 10 >= 200) {
            return results - 15;
        } else {
            return results + 10;
        }
    }
}
