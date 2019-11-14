# JavaConcurrency
 
线程和锁在并发编程中的作用，类似于柳钉和工字梁在土木工程的作用  
要想构建稳健的并发程序，必须正确地使用线程和锁    
## 1.线程跟进程？   

线程是操作系统能够进行运算调度的最小单位，它是进程的子集，是进程中的实际运作单位    
一个进程可以有很多线程。每个进程都有自己的内存空间，是个实体，可执行代码和唯一进程标识符（PID)   
线程可以异步执行，我们适当使用多线程可以提高运算效率。 
## 2.实现多线程的方法    

a.继承Thread类；<br>
b.实现Runnable接口；<br>
c.实现Callable接口通过FutureTask包装器来创建Thread线程；  
前两种是我所常用的    
Thread本质上也是实现了Runnable接口的一个实例 代表一个线程的实例<br>
Runnable就相当于一个作业，而Thread才是真正的处理线程，我们需要的只是定义这个作业，<br>
然后将作业交给线程去处理，这样就达到了松耦合，也符合面向对象里面组合的使用，另外也<br>
节省了函数开销，继承Thread的同时，不仅拥有了作业的方法run()，还继承了其他所有的方法<br>
start()方法被用来启动新创建的线程，start()内部调用了run()方法<br>
调用start（）并不是立即执行多线程代码 而且该线程为可运行状态 什么时候运行由操作系统决定    
## 3.用户线程和守护线程的区别   

守护线程依赖于创建它的线程，用户线程则不依赖。     
例如 在main线程中创建了一个守护线程，当main方法运行完毕之后，   
守护线程也会随着消亡。而用户线程则不会，用户线程会一直运行直到其运行完毕。  
在JVM中，像垃圾收集器线程就是守护线程   
 
## 4.并发与并行    

并发： 同一时间段，多个任务都在执行 (单位时间内不一定同时执行)；<br>
并行： 单位时间内，多个任务同时执行。<br>  

## 5.线程的状态    

![](img/线程状态.png)
![](img/02.png)
 
## 6.如何停止一个线程？<br>
 1、通过修改共享变量来通知目标线程停止运行   
 2、通过Thread.interrupt方法中断线程    
 3、不提倡的stop()方法  
## 7.线程调度
#### [12306卖票程序实例](https://github.com/JxnuHxh/JavaConcurrency/tree/master/src/system12306)   
wait()：使一个线程处于等待（阻塞）状态，并且释放所持有的对象的锁；<br>
sleep()：使一个正在运行的线程处于睡眠状态，是一个静态方法，调用此方法要处理InterruptedException异常；<br>
notify()：唤醒一个处于等待状态的线程，当然在调用此方法的时候，并不能确切的唤醒<br>
某一个等待状态的线程，而是由JVM确定唤醒哪个线程，而且与优先级无关   
#### [生产者消费者模型](https://github.com/JxnuHxh/JavaConcurrency/tree/master/src/producter)   
notityAll()：唤醒所有处于等待状态的线程，该方法并不是将对象的锁给所有线程，
而是让它们竞争，只有获得锁的线程才能进入就绪状态    
Join():让调用线程合并当前线程 用于实现同步功能 使它们有先后顺序    
#### [join实例](https://github.com/JxnuHxh/JavaConcurrency/tree/master/src/testjoin)      
sleep()来自Thread类，  wait()来自Object类     
操作系统一般采用时间片优先级调度算法来调度线程    
## 8.synchronized和Lock   
#### [lock实现的实例](https://github.com/JxnuHxh/JavaConcurrency/blob/master/src/day16/ReentrantLock5.java)   

synchronized关键字 表示对某个对象加锁 既有可见性 又有原子性    
读写都应该加锁  不然可能会出现脏读 但是会影响性能 [银行业务实例](https://github.com/JxnuHxh/JavaConcurrency/blob/master/src/account/Account.java)    
同步方法可以和非同步方法同时被调用,一个同步方法可以调用另一个同步方法 [调用实例](https://github.com/JxnuHxh/JavaConcurrency/blob/master/src/day06/T.java)   
一个线程已经拥有某个对象的锁，再次申请的时候仍然会得到该对象的锁,也就是说synchronized获得的锁是   
可重入的(线程可以进入任何一个它已经拥有的锁所同步着的代码块)   
主要相同点：Lock能完成Synchronized所实现的所有功能。   
主要不同点：Lock有比Synchronized更精确的线程予以和更好的性能。 lock可以锁任意地方的代码块   
Synchronized会自动释放锁，但是Lock一定要求我们手工释放，并且必须在finally从句中释放。   

## 9.synchronized和volatile   
#### [volatile的小Demo](https://github.com/JxnuHxh/JavaConcurrency/blob/master/src/day08/T.java)  
volatile修饰的是变量 synchronized修饰的是类和方法
volatile 关键字，使一个变量在多个线程间可见 但是并不能保证多个线程  
共同修改running变量时所带来的不一致问题，也就是说volatile不能替代synchronized   
可以说volatile是一种稍弱的同步机制 用来确保将变量的更新操作通知到其他线程  
访问volatile变量时不会执行加锁操作，因此也不会使执行线程阻塞，   
volatile变量是一种比synchronized关键字更轻量级的同步机制   
加锁机制既可以确保可见性又可以确保原子性，而volatile变量只能确保可见性   

## 10.什么是线程安全？举例说明   
如果每次运行结果和单线程运行结果一样，而且其他变量结果的值和预期效果也是一样的
就是线程安全的   
例同步容器类:    
ArrayList和Vector有什么区别？HashMap和HashTable有什么区别？StringBuilder和   
StringBuffer有什么区别？这些都是Java面试中常见的基础问题。面对这样的问题，回答是：    
ArrayList是非线程安全的，Vector是线程安全的；HashMap是非线程安全的，HashTable是线程安全的   
StringBuilder是非线程安全的，StringBuffer是线程安全的    
## 11.线程内抛出异常 
#### [异常抛出锁](https://github.com/JxnuHxh/JavaConcurrency/blob/master/src/day07/T.java)      
 程序在执行的过程中，如果出现异常，默认情况锁会被释放<br>所以，在并发处理的过程中，   
 有异常要多加小心，不然可能会发生不一致的情况<br> 比如在一个web app处理过程中，   
 多个servlet线程共同访问同一个资源，这时异常情况处理不合适，在一个线程中抛出异常，   
 其他线程就会进入同步代码区，有可能会访问到异常产生时数据。因此要非常小心的处理同步业务逻辑中的异常    
 ## 12.什么是线程池，为什么要用它    
 是一组同步工作的资源池，与工作队列密切相关的，可以减少线程创建和销毁的开销
 不会犹豫等待创建线程而延迟任务的执行，从而提高了响应性    
 线程的创建要花费昂贵的资源和时间 如果任务来了才创建线程 响应时间会变长   
 newFixedThreadPool：[创建一个固定长度的线程池](https://github.com/JxnuHxh/JavaConcurrency/blob/master/src/threadpool/T_ThreadPool.java)；     
 ExecutorService executorService = Executors.newFixedThreadPool(1);   
 newCachedThreadPool：创建一个可缓存的线程池；   
 newSingleThreadExecutor：[是一个单线程的Executor，它创建单个工作者线程来执行任务](https://github.com/JxnuHxh/JavaConcurrency/blob/master/src/threadpool/T_SingleThreadPool.java)       
 newScheduleThreadPool：[创建一个固定长度的线程池，而且以延迟或定时的方式来执行任务](https://github.com/JxnuHxh/JavaConcurrency/blob/master/src/threadpool/T_ScheduledPool.java)。      
 ## 13.什么是死锁！ 如何避免死锁？
 ![死锁](img/02.jpeg)    
 死锁是指两个或两个以上的进程在执行过程中，因争夺资源而造成的一种互相等待的现象，  
 若无外力作用,它们都将无法推进下去,会让你的程序挂起无法完成任务   
 死锁的四个条件:    
a. 互斥条件：一个资源每次只能被一个进程使用。<br>
b. 请求与保持条件：一个进程因请求资源而阻塞时，对已获得的资源保持不放。<br>
c. 不剥夺条件：进程已获得的资源，在末使用完之前，不能强行剥夺。<br>
d. 循环等待条件：若干进程之间形成一种头尾相接的循环等待资源关系<br>
避免死锁最简单的方法就是阻止循环等待条件，将系统中所有的资源设置标志位、排序，<br>
规定所有的进程申请资源必须以一定的顺序（升序或降序）做操作来避免死锁<br>
#### [哲学家吃饭问题](https://github.com/JxnuHxh/JavaConcurrency/tree/master/src/philosopher)
## 14.活锁与死锁的区别<br>
活锁和死锁的主要区别是前者进程的状态可以改变但是却不能继续执行。    
就像两个过于礼貌的人在半路上面对面地相遇：他们彼此都让出对方的路，   
然而又在另一条路上相遇了。因此他们就这样反复地避让下去    
## 15.不要以字符串常量作为锁定对象    
比如你用到了一个类库，在该类库中代码锁定了字符串“Hello”，但是你读不到源码，  
所以你在自己的代码中也锁定了"Hello",这时候就有可能发生非常诡异的死锁阻塞，  
因为你的程序和你用到的类库不经意间使用了同一把锁
## 16.AtomicInteger   
解决同样的问题的更高效的方法，使用AtomXXX类   
AtomXXX类本身方法都是原子性的，但不能保证多个方法连续调用是原子性的    



                  