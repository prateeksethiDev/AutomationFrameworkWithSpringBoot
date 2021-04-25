package com.test.framework.postprocessor;

import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import com.test.framework.annotations.PageObject;
import com.test.framework.pages.IWebDriverAware;

@Component
public class PageObjectBeanPostProcessor implements BeanPostProcessor {
	
	@Override
    public Object postProcessBeforeInitialization(Object bean, @NonNull String beanName) throws BeansException {
        if (bean.getClass().isAnnotationPresent(PageObject.class) && bean instanceof IWebDriverAware) {
            PageFactory.initElements(((IWebDriverAware) bean).getWebDriver(), bean);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(@NonNull Object bean, @NonNull String beanName) throws BeansException {
        return bean;
}
    
}
