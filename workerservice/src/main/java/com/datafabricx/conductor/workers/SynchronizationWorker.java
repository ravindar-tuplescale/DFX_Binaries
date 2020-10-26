package com.datafabricx.conductor.workers;

import com.netflix.conductor.common.metadata.tasks.Task;
import com.netflix.conductor.common.metadata.tasks.TaskResult;
import com.tuplescale.conductor.workerbuilder.annotation.WorkerConfiguration;
import com.tuplescale.conductor.workerbuilder.annotation.WorkerTask;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@WorkerConfiguration
public class SynchronizationWorker {
	
	
    @WorkerTask(name = "Synchronization")
    public TaskResult worker1(Task task) {
    	
        log.info("Executing Synchronization");
        TaskResult taskResult = new TaskResult(task);
        return getTaskResult(taskResult);
        
    }

    public TaskResult getTaskResult(TaskResult taskResult) {
		// Register the output of the task

		taskResult.getOutputData().put("output", "Synchronization Output");
		taskResult.setStatus(TaskResult.Status.COMPLETED);
        return taskResult;
	}
    
    
}
