package com.hong.redisApplication.log;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Random;

public class LogReceiver {
    private static final String KEY_WAS_LOG = "was:log";
    private static final String LOG_FILE_NAME_PREFIX = "./waslog";
    private static final LocalDateTime now = LocalDateTime.now();
    private static final int WAITING_TERM = 5000;

    @Autowired
    RedisTemplate<String,Object> redisTemplate;

    /**
     * 레디스 서버에서 로그를 읽어서 파일로 저장한다.
     * 프로그램이 종료되기 전까지 무한히 실행
     */
    public void start() {
        ValueOperations<String, Object> vop = redisTemplate.opsForValue();
        Random random = new Random();
        while (true) {
            writeFile((String)vop.getAndSet(KEY_WAS_LOG, ""));
            try {
                Thread.sleep(random.nextInt(WAITING_TERM));
            }catch (InterruptedException e) {
                // do nothing
            }
        }
    }

    public String getCurrentFileName() {
        return LOG_FILE_NAME_PREFIX + now;
    }

    private void writeFile(String log) {

        try{
            FileWriter writer = new FileWriter(getCurrentFileName(), true);

            writer.write(log);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {;

        }
    }

}
