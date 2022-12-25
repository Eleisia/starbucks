package com.starbucks.batch.job;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
@EnableBatchProcessing
@RequiredArgsConstructor
public class TestJobConfig {

    private final JobBuilderFactory jobBuilderFactory; //실행하려고하는 logic 단위
    private final StepBuilderFactory stepBuilderFactory; // job을 나눈것

    @Bean
    public Job testJob() {
        return jobBuilderFactory.get("test") // job 이름 설정
                .start(testStep1()).on("*")
                .to(testStep2())
                .end()
                .build();
    }

    @Bean
    public Step testStep1() {
        return stepBuilderFactory.get("step1") // step의 이름 지정
                .tasklet(((contribution, chunkContext) -> {
                    // 수행 로직
                    log.info("step1의 로그임 ㅋ");
                    return RepeatStatus.FINISHED;
                })).build();
    }

    @Bean
    public Step testStep2() {
        return stepBuilderFactory.get("step1") // step의 이름 지정
                .tasklet(((contribution, chunkContext) -> {
                    // 수행 로직
                    log.info("step2의 로그임 ㅋ");
                    log.info("step2의 로그임 ㅋ");
                    return RepeatStatus.FINISHED;
                })).build();
    }
}
