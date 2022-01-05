package com.turkcell.app.commandprompt;

import org.csystem.util.commandprompt.CommandPrompt;

public class CommandPromptApp {
    public static void run()
    {
        var cp = new CommandPrompt();
        cp.register(new TurkcellCommands(cp))
                .setPrompt("turkcell")
                .setPromptSuffix(">>")
                .run();
    }
}
