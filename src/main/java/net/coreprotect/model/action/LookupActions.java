package net.coreprotect.model.action;

import java.util.Collection;

public final class LookupActions {
    public static final int BLOCK_BREAK = 0;
    public static final int BLOCK_PLACE = 1;
    public static final int INTERACTION = 2;
    public static final int ENTITY_KILL = 3;
    public static final int CONTAINER = 4;
    public static final int CHAT = 6;
    public static final int COMMAND = 7;
    public static final int SESSION = 8;
    public static final int USERNAME = 9;
    public static final int SIGN = 10;
    public static final int ITEM = 11;
    public static final int ENTITY_SPAWN = 13;
    /**
     * Lookup-only marker sent with {@link #ENTITY_KILL} for a:death. It matches u: against the
     * player who died instead of the killer. It is never stored in the database.
     */
    public static final int DEATH = 999;

    private LookupActions() {
        throw new IllegalStateException("Model class");
    }

    public static String getActionString(int action) {
        switch (action) {
            case BLOCK_BREAK:
                return "break";
            case BLOCK_PLACE:
                return "place";
            case INTERACTION:
                return "click";
            case ENTITY_KILL:
                return "kill";
            case CONTAINER:
                return "container";
            case CHAT:
                return "chat";
            case COMMAND:
                return "command";
            case SESSION:
                return "session";
            case USERNAME:
                return "username";
            case SIGN:
                return "sign";
            case ITEM:
                return "item";
            case ENTITY_SPAWN:
                return "spawn";
            case DEATH:
                return "death";
            default:
                return "unknown";
        }
    }

    /**
     * a:death can only be combined with a:kill, since it changes which column u: is matched against.
     */
    public static boolean hasIncompatibleDeathAction(Collection<Integer> actions) {
        if (!actions.contains(DEATH)) {
            return false;
        }
        for (Integer action : actions) {
            if (action != ENTITY_KILL && action != DEATH) {
                return true;
            }
        }
        return false;
    }

    public static boolean isInventoryLookup(Collection<Integer> actions) {
        return actions.contains(CONTAINER) && actions.contains(ITEM);
    }
}
