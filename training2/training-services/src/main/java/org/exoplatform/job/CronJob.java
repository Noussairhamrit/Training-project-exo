package org.exoplatform.job;

import org.exoplatform.listener.ClientListener;
import org.exoplatform.service.ClientService;
import org.exoplatform.service.IclientService;
import org.exoplatform.services.log.ExoLogger;
import org.exoplatform.services.log.Log;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class CronJob implements Job {
    private static final Log LOG= ExoLogger.getLogger(CronJob.class);
//    private IclientService iclientService;
//
//    public CronJob(IclientService iclientService) {
//        this.iclientService = iclientService;
//    }

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        LOG.warn("######## Cron job  ");
    }
}
