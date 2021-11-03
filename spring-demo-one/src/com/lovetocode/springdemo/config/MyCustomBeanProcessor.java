package com.lovetocode.springdemo.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.util.LinkedList;
import java.util.List;

/**
 * A custom bean processor that will be able to call the destroy() method on prototype-scoped beans.
 * This to remedy the "issue" that Spring will not call the method defined in the XML config under destroy-method
 * for beans having a prototype scope.
 */
public class MyCustomBeanProcessor implements BeanPostProcessor, BeanFactoryAware, DisposableBean {

    private BeanFactory beanFactory;

    private final List<Object> prototypeBeans = new LinkedList<>();

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        // Nothing special to do before init
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        // After init, keep track of all prototype-scoped beans
        // We need to know which ones to call destroy() on later
        if (this.beanFactory.isPrototype(beanName)) {
            synchronized (this.prototypeBeans) {
                this.prototypeBeans.add(bean);
            }
        }

        return bean;
    }

    @Override
    public void destroy() throws Exception {
        // Loop through the prototype-scoped beans and call their destroy() method
        synchronized (this.prototypeBeans) {
            for (var bean : this.prototypeBeans) {
                if (bean instanceof DisposableBean) {
                    var disposableBean = (DisposableBean) bean;

                    try {
                        disposableBean.destroy();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

            this.prototypeBeans.clear();
        }
    }
}
