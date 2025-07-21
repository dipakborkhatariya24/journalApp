package com.dipakinfotech.journalApp.service;

import com.dipakinfotech.journalApp.entity.User;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

public class UserArgumentProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
        return Stream.of(
                //Arguments.of(User.builder().userName("krish").password("krish").build()),
                Arguments.of(User.builder().userName("diploma").password("diploma").build())
        );
    }
}
