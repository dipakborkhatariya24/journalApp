package com.dipakinfotech.journalApp.service;

import com.dipakinfotech.journalApp.Scheduler.UserScheduler;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserSchdulerTests {

    @Autowired
    private UserScheduler userScheduler;

    @Test
    public void testFetchUsersAndSendEmail() {
        userScheduler.fetchUsersAndSendEmail();
    }
}
