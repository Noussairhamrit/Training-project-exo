package org.exo.training.job;

import org.exoplatform.services.log.ExoLogger;
import org.exoplatform.services.log.Log;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class PeriodicJob implements Job {
    private static final Log LOG = ExoLogger.getLogger(PeriodicJob.class);
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        LOG.warn("######Periodic######## Text Service Periodic Job started");
    }
}
