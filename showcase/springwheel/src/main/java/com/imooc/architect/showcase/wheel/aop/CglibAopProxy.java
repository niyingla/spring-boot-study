package com.imooc.architect.showcase.wheel.aop;

import com.imooc.architect.showcase.wheel.aop.advisor.Advisor;
import com.imooc.architect.showcase.wheel.aop.advisor.PointcutAdvisor;
import com.imooc.architect.showcase.wheel.ioc.BeanFactory;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.apache.commons.collections4.CollectionUtils;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class CglibAopProxy {
    private Object target;
    private List<Advisor> matchAdvisors;
    private BeanFactory beanFactory;

    public CglibAopProxy(Object target, List<Advisor> matchAdvisors, BeanFactory beanFactory) {
        this.target = target;
        this.matchAdvisors = matchAdvisors;
        this.beanFactory = beanFactory;
    }
    public Object getProxy(){
        return this.getProxy(target.getClass().getClassLoader());
    }

    public Object getProxy(ClassLoader classLoader) {

        Class<?> superClass = this.target.getClass();
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(superClass);
        enhancer.setInterfaces(this.getClass().getInterfaces());

        enhancer.setCallback(new AopMethodInterceptor(target,matchAdvisors,beanFactory));
        return enhancer.create();

    }
    static class AopMethodInterceptor implements MethodInterceptor {
        private Object target;
        private List<Advisor> matchAdvisors;
        private BeanFactory beanFactory;

        public AopMethodInterceptor(Object target, List<Advisor> matchAdvisors, BeanFactory beanFactory) {
            this.target = target;
            this.matchAdvisors = matchAdvisors;
            this.beanFactory = beanFactory;
        }

        @Override
        public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
            return invoke(target, method, args, matchAdvisors, proxy, beanFactory);
        }

        private Object invoke(Object target, Method method, Object[] args, List<Advisor> matchAdvisors,
                              Object proxy, BeanFactory beanFactory) throws Throwable {
            List<Object> advices = getAdvices(target.getClass(), method, matchAdvisors,
                    beanFactory);
            if (advices == null || advices.size() == 0) {
                return method.invoke(target, args);
            } else {
                AopAdviceChainInvocation chain = new AopAdviceChainInvocation(proxy, target, method, args, advices);
                return chain.invoke();
            }
        }


        private List<Object> getAdvices(Class<?> beanClass, Method method, List<Advisor> matchAdvisors,
                                        BeanFactory beanFactory) throws Throwable {
            if (CollectionUtils.isEmpty(matchAdvisors)) {
                return null;
            }
            List<Object> advices = new ArrayList<>();
            for (Advisor ad : matchAdvisors) {
                if (ad instanceof PointcutAdvisor) {
                    if (((PointcutAdvisor) ad).getPointcut().matchMethod(method, beanClass)) {
                        advices.add(beanFactory.getBean(ad.getAdviceBeanName()));
                    }
                }
            }

            return advices;
        }
    }
}
