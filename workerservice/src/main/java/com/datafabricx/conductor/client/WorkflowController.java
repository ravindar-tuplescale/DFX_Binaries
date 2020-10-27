package com.datafabricx.conductor.client;

import com.tuplescale.conductor.client.WorkflowSmartClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class WorkflowController {

    @Autowired
    WorkflowSmartClient workflowSmartClient;

    @PostMapping("/workflow/{name}/{version}")
    public String triggerWorkflow(@RequestParam(value = "name") String workflowName,
                                  @RequestParam(value = "version") int version,
                                  @RequestParam(value = "input") java.util.Map<String, Object> input) {
        return workflowSmartClient.startWorkflow(workflowName, version, input);
    }

    @GetMapping("/workflow/{name}/{version}")
    public String triggerWorkflowWithGet(@PathVariable(value = "name") String workflowName, @PathVariable(value = "version") Integer version) {
        return workflowSmartClient.startWorkflow(workflowName, version, null);
    }

}
