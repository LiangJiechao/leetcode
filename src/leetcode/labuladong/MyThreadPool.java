package leetcode.labuladong;

/**
 * 
 * @author xiaoliang
 * @date 2022/03/03 15:01
 **/
public class MyThreadPool  {



    public static void main(String[] args) {
        ItQiankun daemonThread = new ItQiankun();
        ItQiankun userThread = new ItQiankun();
        daemonThread.setDaemon(true);
        daemonThread.start();
        userThread.start();
        System.out.println(daemonThread.isDaemon());
        System.out.println(userThread.isDaemon());
    }
    static class ItQiankun extends Thread {
        @Override
        public void run() {
            while (true) {
                System.out.println("itqiankun.com网站要运行到天荒地老");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    break;
                }
            }
        }
    }
//
//    private final ThreadPoolExecutor executor = CommonExecutor.buildThreadFirstExecutor("poolName");
//
//
//    public void batchExecuteTest(List<CcecMonPerfLine> ccecMonPerfLineList) {
//        List<AsyncTask<Boolean>> tasks = ccecMonPerfLineList.stream().map(ccecMonPerfLine -> new AsyncTask<Boolean>() {
//            // 返回任务的名称
//            @Override
//            public String taskName() {
//                return ccecMonPerfLine.getClass().getSimpleName();
//            }
//
//            // 执行异步任务
//            @Override
//            public Boolean doExecute() {
//                执行方法
//                return Boolean.TRUE;
//            }
//        }).collect(Collectors.toList());
//        // 提交批量任务
//        CommonExecutor.batchExecuteAsync(
//                tasks,
//                executor,
//                "taskName"
//        );
//    }
//
//    /**
//     * 批量提交异步任务，执行失败可抛出异常或返回异常编码即可 <br>
//     * <p>
//     * 需注意提交的异步任务无法控制事务，一般需容忍产生一些垃圾数据的情况下才能使用异步任务，异步任务执行失败将抛出异常，主线程可回滚事务.
//     * <p>
//     * 异步任务失败后，将取消剩余的任务执行.
//     *
//     * @param tasks    将任务转化为 AsyncTask 批量提交
//     * @param executor 线程池，需自行根据业务场景创建相应的线程池
//     * @return 返回执行结果
//     */
//    public static <T> List<T> batchExecuteAsync(@Nonnull List<AsyncTask<T>> tasks, @Nonnull ThreadPoolExecutor executor, @Nonnull String taskName) {
//        if (CollectionUtils.isEmpty(tasks)) {
//            return Collections.emptyList();
//        }
//
//        int size = tasks.size();
//
//        List<Callable<T>> callables = tasks.stream().map(t -> (Callable<T>) () -> {
//            try {
//                T r = t.doExecute();
//
//                LOGGER.debug("[>>Executor<<] Async task execute success. ThreadName: [{}], BatchTaskName: [{}], SubTaskName: [{}]",
//                        Thread.currentThread().getName(), taskName, t.taskName());
//                return r;
//            } catch (Throwable e) {
//                LOGGER.warn("[>>Executor<<] Async task execute error. ThreadName: [{}], BatchTaskName: [{}], SubTaskName: [{}], exception: {}",
//                        Thread.currentThread().getName(), taskName, t.taskName(), e.getMessage());
//                throw e;
//            }
//        }).collect(Collectors.toList());
//
//        CompletionService<T> cs = new ExecutorCompletionService<>(executor, new LinkedBlockingQueue<>(size));
//        List<Future<T>> futures = new ArrayList<>(size);
//        LOGGER.info("[>>Executor<<] Start async tasks, BatchTaskName: [{}], TaskSize: [{}]", taskName, size);
//
//        for (Callable<T> task : callables) {
//            futures.add(cs.submit(task));
//        }
//
//        List<T> resultList = new ArrayList<>(size);
//        for (int i = 0; i < size; i++) {
//            try {
//                Future<T> future = cs.poll(6, TimeUnit.MINUTES);
//                if (future != null) {
//                    T result = future.get();
//                    resultList.add(result);
//
//                    Object log;
//                    if (result instanceof Collection) {
//                        log = ((Collection<?>) result).size();
//                    } else {
//                        log = result;
//                    }
//                    LOGGER.debug("[>>Executor<<] Async task [{}] - [{}] execute success, result: {}", taskName, i, log == null ? "null" : log);
//                } else {
//                    cancelTask(futures);
//                    LOGGER.error("[>>Executor<<] Async task [{}] - [{}] execute timeout, then cancel other tasks.", taskName, i);
//                    throw new CommonException(BaseConstants.ErrorCode.TIMEOUT);
//                }
//            } catch (ExecutionException e) {
//                LOGGER.warn("[>>Executor<<] Async task [{}] - [{}] execute error, then cancel other tasks.", taskName, i, e);
//                cancelTask(futures);
//                Throwable throwable = e.getCause();
//                if (throwable instanceof CommonException) {
//                    throw (CommonException) throwable;
//                } else if (throwable instanceof DuplicateKeyException) {
//                    throw (DuplicateKeyException) throwable;
//                } else {
//                    throw new CommonException("error.executorError", e.getCause().getMessage());
//                }
//            } catch (InterruptedException e) {
//                cancelTask(futures);
//                Thread.currentThread().interrupt(); // 重置中断标识
//                LOGGER.error("[>>Executor<<] Async task [{}] - [{}] were interrupted.", taskName, i);
//                throw new CommonException(BaseConstants.ErrorCode.ERROR);
//            }
//        }
//        LOGGER.info("[>>Executor<<] Finish async tasks , BatchTaskName: [{}], TaskSize: [{}]", taskName, size);
//        return resultList;
//    }

}
