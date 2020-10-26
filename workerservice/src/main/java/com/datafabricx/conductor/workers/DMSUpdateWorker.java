package com.datafabricx.conductor.workers;

import com.netflix.conductor.common.metadata.tasks.Task;
import com.netflix.conductor.common.metadata.tasks.TaskResult;
import com.tuplescale.conductor.workerbuilder.annotation.WorkerConfiguration;
import com.tuplescale.conductor.workerbuilder.annotation.WorkerTask;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@WorkerConfiguration
public class DMSUpdateWorker {
	
	
    @WorkerTask(name = "DMSUpdate")
    public TaskResult worker1(Task task) {
    	//Service layer
        log.info("Executing DMSUpdate");
        TaskResult taskResult = new TaskResult(task);
        return getTaskResult(taskResult);
        
    }

    public TaskResult getTaskResult(TaskResult taskResult) {
		// Register the output of the task

		taskResult.getOutputData().put("output", "DMSUpdate Output");
		taskResult.setStatus(TaskResult.Status.COMPLETED);
        return taskResult;
	}
    
    
}
