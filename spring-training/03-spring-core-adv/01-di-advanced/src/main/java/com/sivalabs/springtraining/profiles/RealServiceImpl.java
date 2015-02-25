/**
 * 
 */
package com.sivalabs.springtraining.profiles;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * @author user
 *
 */
@Component
@Profile("prod")
public class RealServiceImpl implements IService {

}
