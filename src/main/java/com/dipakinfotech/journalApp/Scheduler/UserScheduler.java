package com.dipakinfotech.journalApp.Scheduler;

import com.dipakinfotech.journalApp.Repository.UserRepositoryImpl;
import com.dipakinfotech.journalApp.cache.AppCache;
import com.dipakinfotech.journalApp.entity.JournalEntry;
import com.dipakinfotech.journalApp.entity.User;
import com.dipakinfotech.journalApp.enums.Sentiment;
//import com.dipakinfotech.journalApp.model.SentimentData;
import com.dipakinfotech.journalApp.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class UserScheduler {

    @Autowired
    private UserRepositoryImpl userRepository;

    @Autowired
    private EmailService emailService;

    @Autowired
    private AppCache appCache;

//    @Autowired
//    private KafkaTemplate<String, SentimentData> kafkaTemplate;

    @Scheduled(cron = "0 0 9 ? * SUN")

    public void fetchUsersAndSendEmail() {
        List<User> users = userRepository.getUserForSA();
        for (User user : users) {
            List<JournalEntry> journalEntries = user.getJournalEntries();

            List<Sentiment> sentiments = journalEntries.stream().filter(x -> x.getDate().isAfter(LocalDateTime.now().minus(7, ChronoUnit.DAYS))).map(x -> x.getSentiment()).collect(Collectors.toList());

            Map<Sentiment, Integer> sentimentCounts = new HashMap<>();
            for (Sentiment sentiment : sentiments) {
                if (sentiment != null) {
                    sentimentCounts.put(sentiment, sentimentCounts.getOrDefault(sentiment, 0) + 1);
                }
            }

            Sentiment mostFrequentSentiment = null;
            int maxCount = 0;
            for (Map.Entry<Sentiment, Integer> entry : sentimentCounts.entrySet()) {
                if (entry.getValue() > maxCount) {
                    maxCount = entry.getValue();
                    mostFrequentSentiment = entry.getKey();
                }
            }

            if (mostFrequentSentiment != null) {
                emailService.sendEmail(user.getEmail(), "Sentiment for last 7 days ", mostFrequentSentiment.toString());
//                SentimentData sentimentData = SentimentData.builder().email(user.getEmail())
//                        .sentiment("Sentiment for last 7 days " + mostFrequentSentiment).build();
//                try {
//                    kafkaTemplate.send("Weekly-sentiments", sentimentData.getEmail(), sentimentData);
//                } catch (Exception e) {
//                    emailService.sendEmail(sentimentData.getEmail(), "sentiment for previous week", sentimentData.getSentiment());
//                }

            }
        }
    }

    @Scheduled(cron = "0 0/10 * ? * *")
    public void clearAppCache() {
        appCache.init();
    }
}
