package com.sivalabs.springtraining.profiles;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("dev")
public class MockServiceImpl implements IService {

}
