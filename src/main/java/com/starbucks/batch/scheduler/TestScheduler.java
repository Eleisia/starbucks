package com.starbucks.batch.scheduler;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Component
@RequiredArgsConstructor
public class TestScheduler {
    private final JobLauncher jobLauncher;
    private final Job testJob;

    @SneakyThrows
    @Scheduled(cron = "0/10 * * * * *") // 10초마다 실행
    public void testJobSchedule() {
        Map<String, JobParameter> jobParameterMap = new HashMap<>();
        String dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss"));
        jobParameterMap.put("jobDateTime", new JobParameter(dateTime));
        jobLauncher.run(testJob, new JobParameters(jobParameterMap));
    }
}
