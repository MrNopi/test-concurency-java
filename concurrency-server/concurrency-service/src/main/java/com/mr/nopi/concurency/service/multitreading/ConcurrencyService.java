package com.mr.nopi.concurency.service.multitreading;

import com.mr.nopi.concurency.service.domain.Student;
import com.mr.nopi.concurency.service.multitreading.workers.EnglishWorker;
import com.mr.nopi.concurency.service.multitreading.workers.HistoryWorker;
import com.mr.nopi.concurency.service.multitreading.workers.MathWorker;
import com.mr.nopi.concurency.service.multitreading.workers.SumWorker;
import com.mr.nopi.concurency.service.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ConcurrencyService {
    private final StudentRepository studentRepository;

    private List<Thread> workers = new ArrayList<>();

    public ConcurrencyService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public String concurrencyCalculate() {
        try {
            long startTime = System.nanoTime();
            List<Student> all = studentRepository.findAll();

            workers.add(new EnglishWorker(all));
            workers.add(new MathWorker(all));
            workers.add(new HistoryWorker(all));

            for (Thread t : workers) {
                t.start();
            }

            while (!isAllWorkersDead()) {
                Thread.sleep(1000);
            }

            Thread sumWorker = new SumWorker(all);
            sumWorker.start();
            sumWorker.join();
            studentRepository.saveAll(all);
            workers.clear();
            long endTime = System.nanoTime();
            return ("running time is - " + (endTime - startTime));
        } catch (InterruptedException ignored) {
        }
        return null;
    }

    public String nonConcurrencyCalculate() {
        long startTime = System.nanoTime();
        List<Student> all = studentRepository.findAll();


        studentRepository.saveAll(all.stream()
                    .peek(x -> {
                        x.setEnglishResult(calculateResult(x.getEnglishResult()));
                        x.setMathResult(calculateResult(x.getMathResult()));
                        x.setHistoryResult(calculateResult(x.getHistoryResult()));
                    })
                    .peek(x -> x.setSum(x.getHistoryResult() + x.getMathResult() + x.getEnglishResult()))
                    .collect(Collectors.toList()));

        long endTime = System.nanoTime();
        return("running time is - " + (endTime - startTime));
    }


    private boolean isAllWorkersDead() {
        return this.workers.stream()
                    .parallel()
                    .noneMatch(Thread::isAlive);
    }

    private Long calculateResult(Long results) {
        if (results + 10 >= 200) {
            return results - 15;
        } else {
            return results + 10;
        }
    }
}
