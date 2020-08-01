package com.shawn.ss.lib.tools;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ResourceBundle;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadPoolHelper {
    private ThreadPoolHelper() {
    }

//    static ResourceBundle threadBundle = ResourceBundle.getBundle("threadPoolConfig");
    public static Logger logger = LoggerFactory.getLogger(ThreadPoolHelper.class);

    public static class CommonThreadFactory implements ThreadFactory {
        private static final AtomicInteger poolNumber = new AtomicInteger(1);
        private final ThreadGroup group;
        private final AtomicInteger threadNumber = new AtomicInteger(1);
        private final String namePrefix;

        CommonThreadFactory() {
            SecurityManager s = System.getSecurityManager();
            group = (s != null) ? s.getThreadGroup() : Thread.currentThread().getThreadGroup();
            namePrefix = "sd-" + poolNumber.getAndIncrement() + "-thread-";
        }

        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(group, r,namePrefix + threadNumber.getAndIncrement(),0);
            if (t.isDaemon()) {
                t.setDaemon(false);
            }
            if (t.getPriority() != Thread.NORM_PRIORITY) {
                t.setPriority(Thread.NORM_PRIORITY);
            }
            t.setUncaughtExceptionHandler(new CommonUncatchExceptionHandler());
            return t;
        }
    }

    public static class CommonUncatchExceptionHandler implements Thread.UncaughtExceptionHandler{

        @Override
        public void uncaughtException(Thread t, Throwable e) {
            logger.error("thread {} has exception:{}",t.getName(), StringHelper.exceptionToString(e));
        }
    }

    public static class CommonThreadPool extends ThreadPoolExecutor {

//        public CommonThreadPool() {
//            super(Integer.parseInt(threadBundle.getString("corePoolSize")),
//                    Integer.parseInt(threadBundle.getString("maximumPoolSize")),
//                    Long.parseLong(threadBundle.getString("keepAliveTime")),
//                    TimeUnit.MILLISECONDS,
//                    new LinkedBlockingQueue<Runnable>(Integer.parseInt(threadBundle.getString("queueSize"))),
//                    new CommonThreadFactory(),
//                    new CommonRejectedExecutionHandler());
//        }

        public CommonThreadPool(int coreSize,int maxSize,int keepAlive,int queueSize) {
            super(coreSize,
                    maxSize,
                    keepAlive,
                    TimeUnit.MILLISECONDS,
                    new LinkedBlockingQueue<Runnable>(queueSize),
                    new CommonThreadFactory(),
                    new CommonRejectedExecutionHandler());

        }

        private static class CommonRejectedExecutionHandler extends DiscardOldestPolicy implements RejectedExecutionHandler {
            @Override
            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                super.rejectedExecution(r, executor);
                logger.info("thread pool executer reject:{}", r.toString() + " @ " + executor.toString());
            }
        }

        @Override
        public Future<?> submit(Runnable task) {
            return super.submit(task);
        }

        @Override
        public void execute(Runnable command) {
            super.execute(command);
        }
    }

//    public static ExecutorService getThreadPool() {
//        return new CommonThreadPool();
//    }

    public static ExecutorService getThreadPool(int coreSize,int maxSize,int keepAlive,int queueSize){
        return new CommonThreadPool(coreSize,maxSize,keepAlive,queueSize);
    }

}
