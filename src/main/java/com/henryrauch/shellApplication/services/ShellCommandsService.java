package com.henryrauch.shellApplication.services;

import com.henryrauch.shellApplication.model.ActivityResponse;
import org.springframework.shell.standard.ShellComponent;


@ShellComponent
public class ShellCommandsService {

    /**
     * Converts an array of ActivityResponse objects into a string representation.
     * Each activity is formatted with its details on a new line.
     *
     * @param activitiesResponse array of ActivityResponse objects to be converted
     * @return a string containing the formatted details of each activity
     */
    public String convertArrayToString(ActivityResponse[] activitiesResponse){
        StringBuilder result = new StringBuilder();

        for (ActivityResponse response : activitiesResponse) {
            result.append("Activity: ").append(response.activity())
                    .append(", Participants: ").append(response.participants())
                    .append(", Type: ").append(response.type())
                    .append("\n");
        }
        return result.toString();
    }

    /**
     * Adapts a single ActivityResponse object into a string representation.
     * Formats the activity details into a single line of text.
     *
     * @param response the ActivityResponse object to be adapted
     * @return a string containing the formatted details of the activity
     */
    public String adaptResponse(ActivityResponse response){
        return "Activity: " + response.activity() + ", " + "Participants: " + response.participants() + ", " + " Type: " + response.type();
    }

}
