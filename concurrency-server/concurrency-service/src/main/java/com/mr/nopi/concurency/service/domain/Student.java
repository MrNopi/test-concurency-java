package com.mr.nopi.concurency.service.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name = "student")
public class Student implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "math_result")
    private Long mathResult;
    @Column(name = "english_result")
    private Long englishResult;
    @Column(name = "history_result")
    private Long historyResult;
    @Column(name = "sum")
    private Long sum;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMathResult() {
        return mathResult;
    }

    public void setMathResult(Long mathResult) {
        this.mathResult = mathResult;
    }

    public Long getEnglishResult() {
        return englishResult;
    }

    public void setEnglishResult(Long englishResult) {
        this.englishResult = englishResult;
    }

    public Long getHistoryResult() {
        return historyResult;
    }

    public void setHistoryResult(Long historyResult) {
        this.historyResult = historyResult;
    }

    public Long getSum() {
        return sum;
    }

    public void setSum(Long sum) {
        this.sum = sum;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Student{");
        sb.append("id=").append(id);
        sb.append(", mathResult=").append(mathResult);
        sb.append(", englishResult=").append(englishResult);
        sb.append(", historyResult=").append(historyResult);
        sb.append(", sum=").append(sum);
        sb.append('}');
        return sb.toString();
    }
}
