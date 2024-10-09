package ru.naulbimix.crabiumgamemodule.module;

import ru.naulbimix.crabiumgamemodule.*;
import ru.naulbimix.crabiumgamemodule.utils.*;

public class KickReason {

    private String reason, owner;
    private boolean errorForm;
    private int error;

    public KickReason(String reason, String owner, boolean errorForm, int error) {
        this.reason = reason;
        this.owner = owner;
        this.errorForm = errorForm;
        this.error = error;
    }

    public String getReason() {
        String form = this.errorForm ? Main.getInstance().getConfig().getString("messages.kicks.errorForm").replace("$numberError", this.error + "") : Main.getInstance().getConfig().getString("messages.kicks.originalForm");
        String owner = this.owner.replace("$ownerConsole", Main.getInstance().getConfig().getString("messages.kicks.owners.consoleName")).replace("$ownerSystem", Main.getInstance().getConfig().getString("messages.kicks.owners.systemName"));
        form = form.replace("$date", ServerUtils.getDate()).replace("$reason", this.reason).replace("$owner", owner).replace("$helpVk", Main.getInstance().getConfig().getString("messages.url.helpVk"));
        return ServerUtils.s(form);
    }

    public String setKickReason(String reason, String owner) {
        this.reason = reason;
        this.owner = owner;
        this.errorForm = false;
        return getReason();
    }

    public String setKickReason(String reason, String owner, int error) {
        this.reason = reason;
        this.owner = owner;
        this.errorForm = true;
        this.error = error;
        return getReason();
    }
}
