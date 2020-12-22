package com.marcuschiu.testframeworkexampleboot221.annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class FeatureToggleAspect {

    @Around(value="@annotation(featureToggle)")
    public Object featureToggle2(ProceedingJoinPoint joinPoint, FeatureToggle featureToggle) throws Throwable {
        Boolean isAtScheduledInvoked = isAtScheduledInvoked();
        if (isAtScheduledInvoked) {
            return joinPoint.proceed();
        } else {
            return null;
        }
    }

    /**
     * Determines whether join-point was invoked by @Scheduled or not
     * @return
     */
    public Boolean isAtScheduledInvoked() {
        StackTraceElement[] st = Thread.currentThread().getStackTrace();
        String mypackage = "org.springframework.scheduling";
        if (Arrays.stream(st).map(StackTraceElement::getClassName).anyMatch(className -> className.contains(mypackage))) {
            return true;
        } else {
            return false;
        }
    }
}
