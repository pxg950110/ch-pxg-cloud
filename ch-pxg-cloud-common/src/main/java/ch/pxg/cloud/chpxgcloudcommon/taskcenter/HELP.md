~帮助文档~
1.定时任务可以自由配置 
    配置后只能执行已经写好的方法 
    设置任务执行时间  
    设置任务什么时候开始执行
    设置任务执行超时时间
    
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-quartz</artifactId>
        </dependency>
        <!--        定时工具quartz-->
        <dependency>
            <groupId>org.quartz-scheduler</groupId>
            <artifactId>quartz</artifactId>
        </dependency>

quartz的持久化中的表信息

　　quartz有两种存储方式，1.存储到内存中，2.存储到 数据库中；下面是数据库中各表的含义

　　qrtz_blob_triggers　　：这张表示存储自己定义的trigger，不是quartz自己提供的trigger

　　qrtz_calendars　　　　：存储Calendar

　　qrtz_cron_triggers　　：存储cronTrigger

　　qrtz_fired_triggers　　：存储触发的Tirgger

　　qrtz_job_details　　　　：存储JobDetail

　　qrtz_locks　　　　　　　：存储程序中非悲观锁的信息

　　qrtz_paused_trigger_grps　　：存储已暂停的Trigger组信息

　　qrtz_scheduler_state　　：存储集群中note实例信息，quartz会定时读取该表的信息判断集群中每个实例的当前状态 

　　qrtz_simple_triggers　　：存储simpleTrigger的信息

　　qrtz_simprop_triggers　　：储存CalendarIntervalTrigger和DailyTimeIntervalTrigger的信息

　　qrtz_triggers　　：存储已配置的trigger信息

定时任务的表单时
秒 分 时 
* * * * * *